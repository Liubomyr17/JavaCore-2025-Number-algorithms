package com.company;

/*

2025 Number algorithms
The number S consists of M digits, for example, S = 370 and M (number of digits) = 3
Implement the logic of the getNumbers method, which among integers is less than N (long)
find all numbers that satisfy the following criterion:
the number S is equal to the sum of its digits erected in M ​​degree
getNumbers must return all such numbers in ascending order.
Example of the number you are looking for:
370 = 3 * 3 * 3 + 7 * 7 * 7 + 0 * 0 * 0
8208 = 8 * 8 * 8 * 8 + 2 * 2 * 2 * 2 + 0 * 0 * 0 * 0 + 8 * 8 * 8 * 8
Execution takes 10 seconds and 50 MB of memory.

Requirements:
1. In the Solution class, the getNumbers method with one parameter of type long must be present.
2. The getNumbers method must be public.
3. The getNumbers method must be static.
4. The getNumbers method must return an array of numbers that satisfy the task condition.



 */

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;




public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        LinkedList<Long> list = new LinkedList<>();

        // Создаем и инициализируем массив степененй
        long[][] mult = new long[10][19];
        for (int i = 0; i < mult.length; i++) {
            for (int j = 0; j < mult[i].length; j++) {
                long tmp = i;
                int degree = j;
                while (degree-- > 0) {
                    tmp *= i;
                }
                mult[i][j] = tmp;
            }
        }

        byte bitness_start = 1;
        long length = 10;

        for (long i = 1; i <= N; i++) {
            long tmp = i;
            long res = 0;

            do {
                res += mult[(int)tmp % 10][bitness_start - 1];
                tmp /= 10;
            } while (tmp != 0);

            if (res == i) {
                list.add(i);
            }

            if (i == length) {
                length *= 10;
                bitness_start++;
            }
        }

        result = new long[list.size()];
        int i = 0;
        for (Long value : list) {
            result[i++] = value;
        }        return result;
    }

    public static void main(String[] args) {
        Long t0 = System.currentTimeMillis();
        long[] numbers = getNumbers(Integer.MAX_VALUE);
//        long[] numbers = getNumbers(146511208);
//        int[] numbers = getNumbers(100);
        Long t1 = System.currentTimeMillis();
        System.out.println("time: " + (t1 - t0) / 1000d + " sec");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        System.out.println(Arrays.toString(numbers));
    }
}
