package org.tof.example;

import com.sun.jna.Native;

import java.nio.ByteBuffer;

public class LibDivsufsortNative {
    static {
        Native.register("divsufsort");
    }

    public static native int divsufsort(byte[] inputArray, int[] outputArray, int arraySize);

    public static native int divsufsort(ByteBuffer inputByteBuffer, ByteBuffer outputByteBuffer, int arraySize);

}
