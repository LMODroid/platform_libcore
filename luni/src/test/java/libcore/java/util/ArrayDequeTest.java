/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package libcore.java.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class ArrayDequeTest {

    @Test
    public void forEach_shouldThrowNPE_whenNullConsumer() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        assertThrows(NullPointerException.class, () -> deque.forEach(null));
    }

    @Test
    public void forEach_emptyDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        List<Integer> actual = new ArrayList<>();

        deque.forEach(actual::add);

        assertTrue(actual.isEmpty());
    }

    @Test
    public void forEach_nonEmptyDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        deque.add(10);
        deque.add(20);
        deque.addFirst(0);

        List<Integer> actual = new ArrayList<>();

        deque.forEach(actual::add);

        assertEquals(List.of(0, 10, 20), actual);
    }


}
