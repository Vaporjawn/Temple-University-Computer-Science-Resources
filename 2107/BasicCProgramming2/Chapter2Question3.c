/*
Max Bugay
Lower Level Programming

Purpose: Generate the bit patterns that follow, where ak represents k repetitions of symbol a
*/
#include<stdio.h>
int main()
{
  int input, input1, input2;
  printf("What is the bit length?\n");
  scanf("%d", &input);
  printf("What is the value of k?\n");
  scanf("%d", &input1);
  printf("What is the value of j?\n");
  scanf("%d", &input2);
  if (sizeof(int) << 3)
  {
    int w = input, k = input1, j = input2;
    int a = ((1 << w) - 1) - ((1 << k) - 1);
    int b = (((1 << k + j) - 1) - ((1 << j) - 1));
    printf("Bit Pattern A equals %d\n", a);
    printf("Bit Pattern B equals %d\n", b);
  }
}
