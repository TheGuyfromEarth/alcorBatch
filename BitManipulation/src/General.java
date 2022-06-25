/*

// Number System - Decimal, Binary

// Decimal (base 10)
// Binary (base 2)

// Representation of the Number

a) Decimal -> 120 ->  1*10^2+2*10^1+0*10^0 = 100 + 20 + 0 = 120
b) Binary -> 1011 -> 1*2^3 + 0*2^2 + 1*2^1 + 1*2^0 =  8 + 0 + 2 + 1 = 11


Some basic binary Numbers

0   -   00
1   -   01
2   -   10
3   -   11
4   -  100
5   -  101
6   -  110
7   -  111
8   - 1000
9   - 1001
10  - 1010
11  - 1011
12  - 1100
13  - 1101
14 -  1110
15 -  1111


// Bitwise Operators

Truth Table

a   b   a&b     a|b     a^b
0   0   0       0       0
0   1   0       1       1
1   0   0       1       1
1   1   1       1       0


Shift Left Operator: (Multiply by 2 Operator)

Ex: 2 << 1 => 4

    2 ->   10
   4  ->   100

Ex: 5 << 2 => 20

    5 ->   101
   20 -> 10100


Shift Right Operator: (Divide by 2 Operator)

Ex: 4 >> 0 => 4

    4 ->  100

Ex: 32 >> 3 => 4

    32 =>  100000
    4  =>   100


Unary Not Operator (~):

Ex : 12

    12 ->  1100
        -> 0011


Terminology:

a) Set -> If the value of bit is 1
b) Clear or Unset -> If the value of bit is 0
c) LSB -> Least Significant Bit -> 0th bit
d) MSB -> Most Significant Bit -> 1st bit from the left


// Properties of XOR
a) num^num = 0
b) num^0 = num


// 2's Complement
a) Invert the bits
b) add 1

// 1. No of bits required to completely represent any number, n (Binary System) = log(n) + 1      (base 2)
// 2. No of digits required to completely represent any number, n (Decimal System) = log(n) + 1      (base 10)

// Brian Kernighan's Algo
-> n & (n-1)


 */