package org.tof.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.util.stream.IntStream;

import static org.assertj.core.api.BDDAssertions.then;

public class LibDivsufsortTest {

    @Test
    @DisplayName("compute suffix array indices with native library")
    void compute_suffix_array_indices_with_native_library() {
        // given
        byte[] inputArray = "abracadabra".getBytes();
        int arraySize = inputArray.length;
        int[] outputArray = new int[arraySize];

        // when
        int index = LibDivsufsortNative.divsufsort(inputArray, outputArray, arraySize);

        // then
        then(index).isEqualTo(0);
        then(outputArray).isEqualTo(new int[]{10, 7, 0, 3, 5, 8, 1, 4, 6, 9, 2});
    }

    @Test
    @DisplayName("compute suffix array indices with native library and Byte Buffer")
    void compute_suffix_array_indices_with_native_library_and_Byte_Buffer() {
        // given
        int arraySize = 11;
        ByteBuffer inputByteBuffer = ByteBuffer.allocateDirect(arraySize);
        inputByteBuffer.put("abracadabra".getBytes());
        ByteBuffer outputByteBuffer = ByteBuffer.allocateDirect(arraySize * Integer.BYTES);

        // when
        int index = LibDivsufsortNative.divsufsort(inputByteBuffer, outputByteBuffer, arraySize);

        // then
        then(index).isEqualTo(0);
        int[] outputCopyOnJavaHeap = new int[arraySize];
        outputByteBuffer.asIntBuffer().get(outputCopyOnJavaHeap);
        IntStream.range(0, outputCopyOnJavaHeap.length).forEach(i -> outputCopyOnJavaHeap[i] = Integer.reverseBytes(outputCopyOnJavaHeap[i]));
        then(outputCopyOnJavaHeap).isEqualTo(new int[]{10, 7, 0, 3, 5, 8, 1, 4, 6, 9, 2});
    }
}
