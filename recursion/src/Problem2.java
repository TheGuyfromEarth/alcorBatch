// Write a java program that finds a to the power of b.
// Example: I/P -> a = 2, b = 3 (assume b>=0)
// O/P -> 8

public class Problem2 {

    public static void main(String[] args) {
        System.out.println(pow(4,3));
    }

    public static int pow(int a, int b){
        if(b == 0)
            return 1;

        return pow(a,b-1)*a;
    }
}

// 2^3 = 2*2*2

// Leap Of Faith






