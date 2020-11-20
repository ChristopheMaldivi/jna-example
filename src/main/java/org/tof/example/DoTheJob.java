package org.tof.example;

import com.sun.jna.Native;

public class DoTheJob {

    private static native String doTheJobNative();

    private static native int doTheJobArrayNative(byte[] inputArray, int[] outputArray, int arraySize);

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
