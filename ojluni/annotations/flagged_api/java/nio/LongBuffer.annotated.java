/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

// -- This file was mechanically generated: Do not edit! -- //
// Android-note: This file is generated by ojluni/src/tools/gensrc_android.sh.


package java.nio;

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class LongBuffer extends java.nio.Buffer implements java.lang.Comparable<java.nio.LongBuffer> {

LongBuffer(int mark, int pos, int lim, int cap) { throw new RuntimeException("Stub!"); }

public static java.nio.LongBuffer allocate(int capacity) { throw new RuntimeException("Stub!"); }

public static java.nio.LongBuffer wrap(long[] array, int offset, int length) { throw new RuntimeException("Stub!"); }

public static java.nio.LongBuffer wrap(long[] array) { throw new RuntimeException("Stub!"); }

public abstract java.nio.LongBuffer slice();

public abstract java.nio.LongBuffer slice(int index, int length);

public abstract java.nio.LongBuffer duplicate();

public abstract java.nio.LongBuffer asReadOnlyBuffer();

public abstract long get();

public abstract java.nio.LongBuffer put(long l);

public abstract long get(int index);

public abstract java.nio.LongBuffer put(int index, long l);

public java.nio.LongBuffer get(long[] dst, int offset, int length) { throw new RuntimeException("Stub!"); }

public java.nio.LongBuffer get(long[] dst) { throw new RuntimeException("Stub!"); }

@android.annotation.FlaggedApi(com.android.libcore.Flags.FLAG_V_APIS)
public java.nio.LongBuffer get(int index, long[] dst, int offset, int length) { throw new RuntimeException("Stub!"); }

@android.annotation.FlaggedApi(com.android.libcore.Flags.FLAG_V_APIS)
public java.nio.LongBuffer get(int index, long[] dst) { throw new RuntimeException("Stub!"); }

public java.nio.LongBuffer put(java.nio.LongBuffer src) { throw new RuntimeException("Stub!"); }

@android.annotation.FlaggedApi(com.android.libcore.Flags.FLAG_V_APIS)
public java.nio.LongBuffer put(int index, java.nio.LongBuffer src, int offset, int length) { throw new RuntimeException("Stub!"); }

public java.nio.LongBuffer put(long[] src, int offset, int length) { throw new RuntimeException("Stub!"); }

public final java.nio.LongBuffer put(long[] src) { throw new RuntimeException("Stub!"); }

@android.annotation.FlaggedApi(com.android.libcore.Flags.FLAG_V_APIS)
public java.nio.LongBuffer put(int index, long[] src, int offset, int length) { throw new RuntimeException("Stub!"); }

@android.annotation.FlaggedApi(com.android.libcore.Flags.FLAG_V_APIS)
public java.nio.LongBuffer put(int index, long[] src) { throw new RuntimeException("Stub!"); }

public final boolean hasArray() { throw new RuntimeException("Stub!"); }

public final long[] array() { throw new RuntimeException("Stub!"); }

public final int arrayOffset() { throw new RuntimeException("Stub!"); }

public java.nio.Buffer position(int newPosition) { throw new RuntimeException("Stub!"); }

public java.nio.Buffer limit(int newLimit) { throw new RuntimeException("Stub!"); }

public java.nio.Buffer mark() { throw new RuntimeException("Stub!"); }

public java.nio.Buffer reset() { throw new RuntimeException("Stub!"); }

public java.nio.Buffer clear() { throw new RuntimeException("Stub!"); }

public java.nio.Buffer flip() { throw new RuntimeException("Stub!"); }

public java.nio.Buffer rewind() { throw new RuntimeException("Stub!"); }

public abstract java.nio.LongBuffer compact();

public abstract boolean isDirect();

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object ob) { throw new RuntimeException("Stub!"); }

public int compareTo(java.nio.LongBuffer that) { throw new RuntimeException("Stub!"); }

public int mismatch(java.nio.LongBuffer that) { throw new RuntimeException("Stub!"); }

public abstract java.nio.ByteOrder order();
}

