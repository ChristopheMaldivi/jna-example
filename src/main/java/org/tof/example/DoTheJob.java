package org.tof.example;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class DoTheJob {

    public interface NativeLibraryInterface extends Library {
        // library name:
        // - linux: 'libdothejob.so'
        // - mac: 'libdothejob.dylib'
        NativeLibraryInterface nativeLib = Native.load("dothejob", NativeLibraryInterface.class);

        String doTheJobNative();
        int doTheJobArrayNative(byte[] inputArray, int[] outputArray, int arraySize);
    }

    String doTheJob() {
        return NativeLibraryInterface.nativeLib.doTheJobNative();
    }

    int doTheJobArray(byte[] inputArray, int[] outputArray, int arraySize) {
        return NativeLibraryInterface.nativeLib.doTheJobArrayNative(inputArray, outputArray, arraySize);
    }
}
