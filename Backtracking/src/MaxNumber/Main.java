package MaxNumber;

public class Main {

    public static String max = "";

    public static void main(String[] args) {
        String str = "254";
        int k = 1;
        maxString(str, k);
        System.out.println(max);
    }

    public static void maxString(String str, int k) {
        if (str.compareTo(max) > 0)
            max = str;

        // base condition
        if (k == 0) {
//            System.out.println(str);
            return;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {

                if (str.charAt(j) > str.charAt(i)) {
                    str = swap(str, i, j);
                    maxString(str, k - 1); // recursive call
                    str = swap(str, i, j); // backtracking
                }

            }
        }

    }

    private static String swap(String str, int i, int j) {
        String first = str.substring(0, i);
        String middle = str.substring(i + 1, j);
        String last = str.substring(j + 1);

        return first + str.charAt(j) + middle + str.charAt(i) + last;
    }

}
