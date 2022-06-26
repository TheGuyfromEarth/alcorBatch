// Given ch = A , res = a
// Given ch = q , res = Q

public class LowerCaseToUpperCase {

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString('A'));
//        System.out.println(Integer.toBinaryString('B'));
//        System.out.println(Integer.toBinaryString('C'));
//        System.out.println(Integer.toBinaryString('D'));
//        System.out.println(Integer.toBinaryString('Z'));
//        System.out.println("*************");
//        System.out.println(Integer.toBinaryString('a'));
//        System.out.println(Integer.toBinaryString('b'));
//        System.out.println(Integer.toBinaryString('c'));
//        System.out.println(Integer.toBinaryString('d'));
//        System.out.println(Integer.toBinaryString('z'));

        // From uppercase to Lowercase
        char ch = 'A';
//        int mask = 1 << 5; // 100000
//
//        char res = (char) (ch | mask);
        char res = (char) (ch | ' ');
        System.out.println(res);

        // From Lowercase to Uppercase
        ch = 'z';
//        int mask = (~(1<<5));
//        res = (char)(ch & mask);
        res = (char) (ch & '_');
        System.out.println(res);

    }
}
