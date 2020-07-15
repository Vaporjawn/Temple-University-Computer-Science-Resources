/*
Max Bugay
Lower Level Programming

Purpose: For floating-point number f, this function computes −f . Basically change the sign of f. If f is NaN,
your function should simply return f, i.e., not change in sign bit.
*/
#include <stdio.h>

typedef unsigned float_bits;

float_bits float_negate(float_bits num)
{
    unsigned sign = num >> 31;
    unsigned exp  = num >> 23 & 0xFF;
    unsigned frac = num & 0x7FFFFF;

    if (exp == 0xFF & frac != 0) // Checks if NaN
        return num;

    return (sign << 31) | (num & 0x7FFFFFFF);
}

int main(int argc, char **argv)
{
    printf("%.8X\n", float_negate(0xAABBCCDD));
    printf("%.8X\n", float_negate(0x12345678));
    printf("%.8X\n", float_negate(0x87654321));
}
