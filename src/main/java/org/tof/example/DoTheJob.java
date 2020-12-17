package org.tof.example;

import com.sun.jna.Native;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class DoTheJob {

    static native String doTheJobNative();

    static native int doTheJobArrayNative(byte[] inputArray, int[] outputArray, int arraySize);

    static native int doTheJobByteBufferNative(ByteBuffer inputByteBuffer, ByteBuffer outputByteBuffer, int arraySize);

    static {
        Native.register("dothejob");
    }
}
