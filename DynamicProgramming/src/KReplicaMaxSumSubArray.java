// Given arr, k (Replica Factor)

// Ex: arr = {2,5,-1,10,4} ; k = 2

// arr -> {2,5,-1,10,4,2,5,-1,10,4};

public class KReplicaMaxSumSubArray {

    public static void main(String[] args) {

        int[] arr = {2, 3, -3, 1};
        int k = 2;

        int maxSum = 0;
        int sum = 0;

        for (int i : arr)
            sum += i;

        if (k == 1)
            maxSum = kadane(arr);
        else if (sum < 0) {
            maxSum = kadaneForTwo(arr);
        } else {
            maxSum = kadaneForTwo(arr) + (k - 2) * sum;
        }

        System.out.println(maxSum);
    }

    private static int kadane(int[] arr) {
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
        return maxSum;
    }

    private static int kadaneForTwo(int[] arr) {

        int[] newArr = new int[arr.length * 2];

        for (int i = 0; i < arr.length; i++)
            newArr[i] = arr[i];

        for (int i = 0; i < arr.length; i++)
            newArr[i + arr.length] = arr[i];

        return kadane(newArr);
    }
}
