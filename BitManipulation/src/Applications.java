public class Applications {

    public static void main(String[] args) {

        // if the given number is even or odd
        int a = 1011;

        // a = 1010
        // b = 0001

        // a&b = 0 (Even)

        // Ex: a = 5 => 101
        // a&b = 1 (Odd)

        if((a&1)==0)
            System.out.println("Even");
        else
            System.out.println("Odd");


        // Check if the ith bit is Set or Unset
        // Ex: a = 1101,  i = 2
        // 1101 & 0001

        // ((a >> i) & 1)
        int b = 13;
        int i = 1;

        if(((b>>i)&1)==1)
            System.out.println("Set");
        else
            System.out.println("Unset");

        // Set the ith bit
        // Unset the ith bit
        // toggle the ith bit
    }
}
