/*
Max Bugay
Lower Level Programming

Purpose: Increment through an inputted array and print the prime number of it.
*/

#include<stdio.h>

int main()
{
  int i, j, count, n;
  printf("What is the highest value of the array?");
  scanf("%d", &n);
  int array[n];
  for (i = 0; i < n; i++) //Generates array
  {
    array[i] = i;
  }
  printf("Prime Numbers from 0 to %d: ", n);
  for (i = 0; i < n; i++) //Increments through array for all values
  {
    count = 0;
    for(j = 2; j < array[i]; j++) //Increments through array for prime values
    {
      if(array[i] % j == 0) //Checks prime values
      {
        count = 1;
        break;
      }
    }
    if(count == 0 && array[i] > 1)
      printf("%d ", array[i]);
  }
}
