// Given an array with numbers, where each number will have its duplicate in the array, except one. Find that no.

// Ex: arr = {4,7,9,9,2,7,4};
// O/P = 2

public class NonDuplicateNumber {
    public static void main(String[] args) {

        int[] arr = {4,7,9,9,2,7,4};
        int res = 0;

        for(int i=0;i< arr.length;i++)
            res = res^arr[i];

        System.out.println(res);
    }
}
