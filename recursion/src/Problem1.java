// Write a java program which provides the sum of first n natural numbers.
// I/P -> n = 5
// O/P -> sum = 15 (1+2+3+4+5)

public class Problem1 {

    public static void main(String[] args) {
        int n = 3;
//        int sum = 0;
//
//        for(int i = 1; i<=n; i++){
//            sum += i;
//        }
//        System.out.println(sum);
        System.out.println(sum(n));
    }

    public static int sum(int n){
        if(n == 1)
            return 1;

        return sum(n-1)+n;
    }
}

// sum(5) = sum(4) + 5
// sum(n) = sum(n-1) + n

/*
sum(3) = 3 + 3 = 6
sum(2) = 1 + 2 = 3
sum(1) = 1
 */


// Iterative way
// Recursive way

// 3 steps in recursion:
// 1) A separate function
// 2) Base Condition
// 3) Recursive Equation

