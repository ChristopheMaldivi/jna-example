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
}
