package org.tof.example;

import com.sun.jna.Native;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class DoTheJob {

    private static native String doTheJobNative();

    private static native int doTheJobArrayNative(byte[] inputArray, int[] outputArray, int arraySize);
    static native int doTheJobByteBufferNative(ByteBuffer inputByteBuffer, ByteBuffer outputByteBuffer, int arraySize);

    static {
        Native.register("dothejob");
    }

    String doTheJob() {
        return doTheJobNative();
    }

    int doTheJobArray(byte[] inputArray, int[] outputArray, int arraySize) {
        return doTheJobArrayNative(inputArray, outputArray, arraySize);
    }
}
