// kadane's algorithm

//  10  4  -1  10  -22 -2  8  10  -12  -12  19  5  1  -12  9

/*
maxSum = 25    19,5,1

currSum = 22   19,5,1,-12,9
 */

public class MaxValueSubArray {

    public static void main(String[] args) {

        int[] arr = {10, 4, -1, 10, -22, -2, 8, 10, -12, -12, 19, 5, 1, -12, 9};

        int maxSum = arr[0];
        int currSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (currSum >= 0) {
                currSum += arr[i];
            } else {
                currSum = arr[i];
            }

            if (currSum > maxSum)
                maxSum = currSum;
        }

        System.out.println(maxSum);
    }

}
