package org.tof.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
