/*
Max Bugay
Lower Level Programming

Purpose: Return 1 when any odd bit of x equals 1; 0 otherwise.
*/
#include <stdio.h>
int main()
{
  unsigned input;
  printf("Enter integer ");
  scanf("%u", &input);
  printf("%d\n",oddBits(input));
}
int oddBits(unsigned x) //Checks for odd Bits
{
  return (x & 0x55555555) && 1; //01010101010101010101010101010101
}
