/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
* @author Vera Y. Petrashkova
* @version $Revision$
*/

package org.apache.harmony.security.tests.java.security;

import java.security.GeneralSecurityException;

import junit.framework.TestCase;

/**
 * Tests for <code>GeneralSecurityException</code> class constructors and
 * methods.
 *
 */
public class GeneralSecurityExceptionTest extends TestCase {

    private static String[] msgs = {
            "",
            "Check new message",
            "Check new message Check new message Check new message Check new message Check new message" };

    private static Throwable tCause = new Throwable("Throwable for exception");

    /**
     * Test for <code>GeneralSecurityException()</code> constructor Assertion:
     * constructs GeneralSecurityException with no detail message
     */
    public void testGeneralSecurityException01() {
        GeneralSecurityException tE = new GeneralSecurityException();
        assertNull("getMessage() must return null.", tE.getMessage());
        assertNull("getCause() must return null", tE.getCause());
    }

    /**
     * Test for <code>GeneralSecurityException(String)</code> constructor
     * Assertion: constructs GeneralSecurityException with detail message msg.
     * Parameter <code>msg</code> is not null.
     */
    public void testGeneralSecurityException02() {
        GeneralSecurityException tE;
        for (int i = 0; i < msgs.length; i++) {
            tE = new GeneralSecurityException(msgs[i]);
            assertEquals("getMessage() must return: ".concat(msgs[i]), tE
                    .getMessage(), msgs[i]);
            assertNull("getCause() must return null", tE.getCause());
        }
    }

    /**
     * Test for <code>GeneralSecurityException(String)</code> constructor
     * Assertion: constructs GeneralSecurityException when <code>msg</code> is
     * null
     */
    public void testGeneralSecurityException03() {
        String msg = null;
        GeneralSecurityException tE = new GeneralSecurityException(msg);
        assertNull("getMessage() must return null.", tE.getMessage());
        assertNull("getCause() must return null", tE.getCause());
    }

    /**
     * Test for <code>GeneralSecurityException(Throwable)</code> constructor
     * Assertion: constructs GeneralSecurityException when <code>cause</code>
     * is null
     */
    public void testGeneralSecurityException04() {
        Throwable cause = null;
        GeneralSecurityException tE = new GeneralSecurityException(cause);
        assertNull("getMessage() must return null.", tE.getMessage());
        assertNull("getCause() must return null", tE.getCause());
    }

    /**
     * Test for <code>GeneralSecurityException(Throwable)</code> constructor
     * Assertion: constructs GeneralSecurityException when <code>cause</code>
     * is not null
     */
    public void testGeneralSecurityException05() {
        GeneralSecurityException tE = new GeneralSecurityException(tCause);
        if (tE.getMessage() != null) {
            String toS = tCause.toString();
            String getM = tE.getMessage();
            assertTrue("getMessage() should contain ".concat(toS), (getM
                    .indexOf(toS) != -1));
        }
        assertNotNull("getCause() must not return null", tE.getCause());
        assertEquals("getCause() must return ".concat(tCause.toString()), tE
                .getCause(), tCause);
    }

    /**
     * Test for <code>GeneralSecurityException(String, Throwable)</code>
     * constructor Assertion: constructs GeneralSecurityException when
     * <code>cause</code> is null <code>msg</code> is null
     */
    public void testGeneralSecurityException06() {
        GeneralSecurityException tE = new GeneralSecurityException(null, null);
        assertNull("getMessage() must return null", tE.getMessage());
        assertNull("getCause() must return null", tE.getCause());
    }

    /**
     * Test for <code>GeneralSecurityException(String, Throwable)</code>
     * constructor Assertion: constructs GeneralSecurityException when
     * <code>cause</code> is null <code>msg</code> is not null
     */
    public void testGeneralSecurityException07() {
        GeneralSecurityException tE;
        for (int i = 0; i < msgs.length; i++) {
            tE = new GeneralSecurityException(msgs[i], null);
            assertEquals("getMessage() must return: ".concat(msgs[i]), tE
                    .getMessage(), msgs[i]);
            assertNull("getCause() must return null", tE.getCause());
        }
    }

    /**
     * Test for <code>GeneralSecurityException(String, Throwable)</code>
     * constructor Assertion: constructs GeneralSecurityException when
     * <code>cause</code> is not null <code>msg</code> is null
     */
    public void testGeneralSecurityException08() {
        GeneralSecurityException tE = new GeneralSecurityException(null, tCause);
        if (tE.getMessage() != null) {
            String toS = tCause.toString();
            String getM = tE.getMessage();
            assertTrue("getMessage() must should ".concat(toS), (getM
                    .indexOf(toS) != -1));
        }
        assertNotNull("getCause() must not return null", tE.getCause());
        assertEquals("getCause() must return ".concat(tCause.toString()), tE
                .getCause(), tCause);
    }

    /**
     * Test for <code>GeneralSecurityException(String, Throwable)</code>
     * constructor Assertion: constructs GeneralSecurityException when
     * <code>cause</code> is not null <code>msg</code> is not null
     */
    public void testGeneralSecurityException09() {
        GeneralSecurityException tE;
        for (int i = 0; i < msgs.length; i++) {
            tE = new GeneralSecurityException(msgs[i], tCause);
            String getM = tE.getMessage();
            String toS = tCause.toString();
            if (msgs[i].length() > 0) {
                assertTrue("getMessage() must contain ".concat(msgs[i]), getM
                        .indexOf(msgs[i]) != -1);
                if (!getM.equals(msgs[i])) {
                    assertTrue("getMessage() should contain ".concat(toS), getM
                            .indexOf(toS) != -1);
                }
            }
            assertNotNull("getCause() must not return null", tE.getCause());
            assertEquals("getCause() must return ".concat(tCause.toString()),
                    tE.getCause(), tCause);
        }
    }
}
