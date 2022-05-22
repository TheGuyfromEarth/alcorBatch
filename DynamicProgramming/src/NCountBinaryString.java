// Given a value of N, then we need to tell the total possible cases of
// creating binary strings of length N where given that two adjacent positions
// can never be 0.

// Ex: N = 4
// O/P -> 8

// 1111
// 1010
// 1110
// 1101
// 1011
// 0111
// 0101
// 0110

public class NCountBinaryString {

    public static void main(String[] args) {

        int N = 4;
//        System.out.println(NCountStrings(N));
        System.out.println(NCountBinaryStrings(N));
    }

    private static int NCountStrings(int N) {

        int[] dp0 = new int[N + 1];
        int[] dp1 = new int[N + 1];

        dp0[1] = dp1[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp0[i] = dp1[i - 1];
            dp1[i] = dp0[i - 1] + dp1[i - 1];
        }

        return dp0[N] + dp1[N];
    }

    // without dp array (using dp variables)
    private static int NCountBinaryStrings(int N) {

        // initial values for length 1
        int olddp0 = 1;
        int olddp1 = 1;

        int newdp0 = olddp0;
        int newdp1 = olddp1;

        for (int i = 2; i <= N; i++) {
            newdp0 = olddp1;
            newdp1 = olddp1 + olddp0;

            olddp0 = newdp0;
            olddp1 = newdp1;
        }
        return newdp0 + newdp1;
    }
}
