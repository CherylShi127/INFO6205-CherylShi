package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.function.Supplier;

public class InsertionSortBenchmark {
    final static LazyLogger logger = new LazyLogger(InsertionSortBenchmark.class);

    public InsertionSortBenchmark() {
    }

    private void sortIntegerByInsertionSort(int n) {
        Random random = new Random();
        final Supplier<Integer[]> integersSupplier1 = () -> {
            Integer[] result1 = (Integer[]) Array.newInstance(Integer.class, n);
            for (int i = 0; i < n; i++) result1[i] = random.nextInt();
            return result1;
        };
        double t1 = new Benchmark_Timer<Integer[]>(
                "integerArrayInsertionsorter",
                null,
                InsertionSort::sort,
                null
        ).runFromSupplier(integersSupplier1, 100);
        System.out.println("Sorting Random Array, N = " + n + " the average milliseconds per repetition is: " + t1);
//        for (TimeLogger timeLogger : timeLoggersLinearithmic) timeLogger.log(t1, n);

        //generate an ordered array
        final Supplier<Integer[]> integersSupplier2 = () -> {
            Integer[] result2 = (Integer[]) Array.newInstance(Integer.class, n);
            int init = random.nextInt();
            for (int i = 0; i < n; i++) result2[i] = init + i;
            return result2;
        };
        double t2 = new Benchmark_Timer<Integer[]>(
                "integerArrayInsertionsorter",
                null,
                InsertionSort::sort,
                null
        ).runFromSupplier(integersSupplier2, 100);
        System.out.println("Sorting Ordered Array, N = " + n + " the average milliseconds per repetition is: " + t2);

        //generate a half-ordered array
        final Supplier<Integer[]> integersSupplier3 = () -> {
            Integer[] result3 = (Integer[]) Array.newInstance(Integer.class, n);
            for (int i = 0; i < n/2; i++) result3[i] = random.nextInt();
            for (int i = n/2; i < n; i++) result3[i] = i;
            return result3;
        };
        double t3 = new Benchmark_Timer<Integer[]>(
                "integerArrayInsertionsorter",
                null,
                InsertionSort::sort,
                null
        ).runFromSupplier(integersSupplier3, 100);
        System.out.println("Sorting Half Ordered Array, N = " + n + " the average milliseconds per repetition is: " + t3);

        //generate reverse array
        final Supplier<Integer[]> integersSupplier4 = () -> {
            Integer[] result4 = (Integer[]) Array.newInstance(Integer.class, n);
            int init = random.nextInt();
            for (int i = 0; i < n; i++) result4[i] = n - i + init;
            return result4;
        };
        double t4 = new Benchmark_Timer<Integer[]>(
                "integerArrayInsertionsorter",
                null,
                InsertionSort::sort,
                null
        ).runFromSupplier(integersSupplier4, 100);
        System.out.println("Sorting Reverse Ordered Array, N = " + n + " the average milliseconds per repetition is: " + t4);


    }


    public static void main(String[] args) {
        logger.info("InsertionSortBenchmark.main:");
        InsertionSortBenchmark benchmark = new InsertionSortBenchmark();
        benchmark.sortIntegerByInsertionSort(100);
        benchmark.sortIntegerByInsertionSort(200);
        benchmark.sortIntegerByInsertionSort(400);
        benchmark.sortIntegerByInsertionSort(800);
        benchmark.sortIntegerByInsertionSort(1600);
    }



}
