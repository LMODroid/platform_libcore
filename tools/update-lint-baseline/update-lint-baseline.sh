#!/bin/bash
#
# Copyright (C) 2021 The Android Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# This script is a temporary workaround for updating the
# libcore/lint-baseline.xml file to avoid merge conflicts
# (b/208656169).

if [ -z "${ANDROID_BUILD_TOP}" ] ; then
  echo "This script needs to be run after sourcing build/envsetup.sh."
  exit 1
fi

if [ -z "${TARGET_PRODUCT}" ] ; then
  echo "This script needs to be run after selecting a build target (lunch)."
  exit 1
fi

SCRIPT_DIR=$(cd $(dirname "${BASH_SOURCE[0]}") && pwd)
LIBCORE_BASELINE="${ANDROID_BUILD_TOP}/libcore/lint-baseline.xml"
NEW_BASELINE="out/soong/.intermediates/libcore/core-all/android_common/lint/lint-baseline.xml"

# The patch file comes from go/mainline-newapi
PATCH_FILE="$SCRIPT_DIR/build.soong.patch"

# Check if it looks like the patch required has already been applied.
cd "$ANDROID_BUILD_TOP/build/soong"
if git diff-index --quiet HEAD ; then
  echo "Applying $PATCH_FILE to build/soong."
  git apply "$PATCH_FILE"
else
  echo "Assuming $PATCH_FILE is already applied (hit ctrl-C if this is not the case)."
fi
cd "$ANDROID_BUILD_TOP"

echo "Re-generating baseline files."

# Remove LIBCORE_BASELINE file if it exists to trigger generating a
# new one in the out/ directory.
if [ -f "${LIBCORE_BASELINE}" ]; then
  rm "${LIBCORE_BASELINE}"
fi

if [ -f "${NEW_BASELINE}" ]; then
  rm "${NEW_BASELINE}"
fi

# The build fails when generating the new baseline file so we ignore
# the error and check if the output file exists. This is why this script
# is a temporary kludge. No sensible person would choose to do this.
build/soong/soong_ui.bash --build-mode --all-modules --dir="$PWD" "${NEW_BASELINE}"
if [ ! -f "${NEW_BASELINE}" ] ; then
  echo "Failed to generate ${NEW_BASELINE}"
  exit 1
fi

# Generate suppressions at API Level 33
sed -e '3i\' -e '<!-- generated by libcore/tools/update-lint-baseline/update-lint-baseline.sh -->' \
    -e 's/level 32/level 33/' -e '/issues>/ {d;q}' "${NEW_BASELINE}" > "${LIBCORE_BASELINE}"

# Add comment explaining the two halves of this file.
cat<<MIDWAY >> "${LIBCORE_BASELINE}"
    <!-- TODO(b/205570605): The following repeats all the issues above, but with
         required API level 32 instead of 33 in the messages. This happens in
         unbundled Mainline builds, e.g.
         m TARGET_PRODUCT=mainline_modules_arm TARGET_BUILD_APPS=com.android.art TARGET_BUILD_UNBUNDLED=true lint-check
    -->
MIDWAY

# Generate suppressions at API Level 32
sed -e '0,/<issues/ d' "${NEW_BASELINE}" >> "${LIBCORE_BASELINE}"

cat <<EPILOGUE
Updated baseline generated.

You will likely want to perform the following steps next:

  # Remove soong patch added by this script
  git -C $ANDROID_BUILD_TOP/build/soong co -- .

  # Commit the updated lint-baseline.xml file
  git -C $ANDROID_BUILD_TOP/libcore commit -a lint-baseline.xml

EPILOGUE
