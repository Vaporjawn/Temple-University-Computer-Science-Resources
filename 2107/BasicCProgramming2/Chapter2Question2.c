/*
Max Bugay
Lower Level Programming

Purpose: Receive an IP address in form of an unsigned int as the input parameter and return the class of that IP address as a character.
*/

#include <stdio.h>
char getIPClass(unsigned ip)
{
    unsigned char firstEightBits;
    char class;
    firstEightBits = (ip >> 24) & 0xFF; //get firstEightBits
    printf("firstEightBits: %d\n", firstEightBits);
    if(firstEightBits>=0 && firstEightBits<=127)   //checks for class a
      class = 'A';
    if(firstEightBits>=128 && firstEightBits<=191) //checks for class b
      class = 'B';
    if(firstEightBits>=192 && firstEightBits<=223) //checks for class c
      class = 'C';
    if(firstEightBits>=224 && firstEightBits<=239) //checks for class d
      class = 'D';
    if(firstEightBits>=240 && firstEightBits<=255) //checks for class e
      class = 'E';
    return class;
}
int main()
{
  unsigned x = 0xB6182D22;
  char ipClass = getIPClass(x);
  printf("Ip Address Class: %c\n", ipClass);
}
