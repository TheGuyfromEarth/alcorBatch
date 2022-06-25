public class Applications1 {

    public static void main(String[] args) {
        // swapping two numbers
        int x = 10;
        int y = 5;

        x = (x ^ y); // 10^5
        y = (x ^ y); // (10^5)^5 = 10^(5^5) = 10
        x = (x ^ y); // (10^5)^10 = (10^10)^5 = 5

//        System.out.println("x: " + x);
//        System.out.println("y: " + y);


        // printing the binary of a decimal number
        int num = 15;
//        System.out.println(Integer.toBinaryString(num));
        for (int i = 3; i >= 0; i--) {
//            System.out.print((num >> i) & 1);
        }

        // print the first n powers of 2
//        int n = 5;
//        for (int i = 0; i < n; i++)
//            System.out.println(1 << i);

        // return true if the given number is in the form 2^n, else return false
        int number = 17;
        int count = 0;
        int ptr = 30;

        while(ptr>=0){
            if(((number>>ptr)&1) == 1)
                count++;
            ptr--;
        }
//        System.out.println(count);

        if((number & (number-1)) == 0)
            System.out.println("true");
        else
            System.out.println("false");

        // count number of set bits
        int numb = 14;
        int ct = 0;
        while(numb!=0){
            numb = (numb&(numb-1)); // kernighan's algorithm
            ct++;
        }
        System.out.println(ct);
    }
}