package org.tof.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        byte[] inputArray = {1, 2, 3, 4, 5};
        int arraySize = inputArray.length;
        int[] outputArray = new int[arraySize];
        // when
        final int returnedValue = (new DoTheJob()).doTheJobArray(inputArray, outputArray, arraySize);

        // then
        then(returnedValue).isEqualTo(arraySize);
        then(outputArray).isEqualTo(new int[]{2, 4, 6, 8, 10});
    }


    @Test
    @DisplayName("check JNA call performance")
    void check_perf() {
        // given
        byte[] inputArray = {1};
        int arraySize = inputArray.length;
        int[] outputArray = new int[arraySize];

        List<Long> durations = new ArrayList<>();

        // when
        IntStream.range(0, 50).forEach(notUsed -> {
            // when
            Instant t0 = Instant.now();
            final int returnedValue = (new DoTheJob()).doTheJobArray(inputArray, outputArray, arraySize);
            Instant t1 = Instant.now();
            durations.add(diffMicro(t0, t1));

            // then
            then(returnedValue).isEqualTo(arraySize);
            then(outputArray).isEqualTo(new int[]{2});
        });

        // then
        final LongSummaryStatistics rawStatistics = durations.stream().collect(LongSummaryStatistics::new, LongSummaryStatistics::accept, LongSummaryStatistics::combine);
        System.out.println("raw: " + rawStatistics);
        System.out.println("standard deviation: " + calculateSD(durations));
        final List<Long> withoutMinAndMax = durations.stream()
            .filter(duration -> duration > rawStatistics.getMin() && duration < rawStatistics.getMax())
            .collect(Collectors.toList());
        final LongSummaryStatistics statisticsWithoutMaxAndMin = withoutMinAndMax.stream()
            .collect(LongSummaryStatistics::new, LongSummaryStatistics::accept, LongSummaryStatistics::combine);
        System.out.println("without min and max:" + statisticsWithoutMaxAndMin);
        System.out.println("standard deviation: " + calculateSD(withoutMinAndMax));

        durations.forEach(duration -> System.out.println("duration: " + duration));
    }

    private static long diffMicro(Instant t0, Instant t1) {
        Instant diff = t1.minusSeconds(t0.getEpochSecond());
        diff = diff.minusNanos(t0.getNano());
        return diff.getEpochSecond() * 1000 * 1000 + diff.getNano() / 1000;
    }

    private static double calculateSD(List<Long> array) {
        double standardDeviation = 0.0;

        double sum = array.stream().mapToLong(val -> val).sum();
        double mean = sum / array.size();

        for (double val : array) {
            standardDeviation += Math.pow(val - mean, 2);
        }

        return Math.sqrt(standardDeviation / array.size());
    }
}
