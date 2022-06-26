// Given an array where each number is repeating k times, except one. Find the number.
// Ex: arr = {4,4,9,9,2,4,9};

import java.util.Arrays;

public class NonDuplicateNumberComingKTimes {

    public static void main(String[] args) {
        int[] arr = {3, 9, 3, 9, 15, 9, 3, 3, 9};
        int k = 4;

        int[] ctArr = new int[31];

        int bit = 0;
        for (int num : arr) {
            for (int i = 30; i >= 0; i--) {
                bit = ((num >> i) & 1);
                ctArr[i] += bit;
            }
        }

        for (int i = 0; i < ctArr.length; i++) {
            ctArr[i] = ctArr[i] % k;
        }

        int num = 0;
        for (int i = 0; i < ctArr.length; i++) {
            num += ctArr[i] * Math.pow(2, i);
        }

        System.out.println(num);
    }
}
