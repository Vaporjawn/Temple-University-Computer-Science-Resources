#include<stdio.h>

int main()
{
  double dec = 1.5;
  int num = 1;
  char ch = 'A';
  int *dp = &dec;
  int *ip = &num;
  int *cp = &ch;
  printf("Double Address: 0x%x Double Value %f: Double Size %lu: ", &dec, dec, sizeof(dec));
  printf("Int Address: 0x%x Int Value %d: Int Size %lu: ", &num, num, sizeof(dec));
  printf("Char Address: 0x%x Char Value %c: Char Size %lu: ", &ch, ch, sizeof(dec));
}
