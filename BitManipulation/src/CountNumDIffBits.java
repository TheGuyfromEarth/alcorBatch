// Given two numbers, find total number of different bits place wise.
// Ex: int num1 = 10, num2 = 12
// 10 ->  1010
// 12 ->  1100
// o/p = 2

public class CountNumDIffBits {

    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 12;

        int res = (num1^num2);

        int ct = 0;
        while(res!=0){
            res &=(res-1);
            ct++;
        }
        System.out.println("Total no of diff bits: "+ct);
    }
}
