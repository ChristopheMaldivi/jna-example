package org.tof.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class DoTheJobTest {

    @Test
    @DisplayName("native function call returns 'it works'")
    void native_function_call_returns() {
        // when
        final String returnedValue = (new DoTheJob()).doTheJob();

        // then
        then(returnedValue).isEqualTo("it works");
    }

    @Test
    @DisplayName("native function call returns correct output Array")
    void native_function_call_returns_output_Array() {
        // given
        byte[] inputArray = { 1, 2, 3, 4, 5 };
        int arraySize = inputArray.length;
        int[] outputArray = new int[arraySize];
        // when
        final int returnedValue = (new DoTheJob()).doTheJobArray(inputArray, outputArray, arraySize);

        // then
        then(returnedValue).isEqualTo(arraySize);
        then(outputArray).isEqualTo(new int[]{2, 4, 6, 8, 10});
    }

}
