package org.tof.example;

import com.sun.jna.Native;

public class LibDivsufsortNative {
    static {
        Native.register("divsufsort");
    }

    public static native int divsufsort(byte[] inputArray, int[] outputArray, int arraySize);
}
