import java.util.*;

// sudoku solver

public class NPermutations {

    public static List<String> numList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        char[] arr = new char[n];

        String str = "";
        while(n!=0){
            str += n;
            n--;
        }

        nPermutations(str,0,str.length()-1);

        Collections.sort(numList);

        System.out.println(numList.get(k-1));
    }

    public static void nPermutations(String str, int l, int r) {

        // base condition
        if (l == r) {
            numList.add(str);
            return;
        }

        for(int i = l; i<=r; i++){
            str = swap(str,l,i);
            nPermutations(str,l+1,r); // recursive call
            str = swap(str,l,i); // backtracking
        }
    }

    private static String swap(String str, int i, int j) {

        if(i == j)
            return str;

        String first = str.substring(0, i);
        String middle = str.substring(i + 1, j);
        String last = str.substring(j + 1);

        return first + str.charAt(j) + middle + str.charAt(i) + last;
    }
}
