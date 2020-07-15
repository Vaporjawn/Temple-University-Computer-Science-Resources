/*
Max Bugay
Lower Level Programming

Purpose: Add the first and last digit of an inputted integer.
*/

#include <stdio.h>

int main()
{
    int num, sum = 0;
    printf("Enter in a number: ");
    scanf("%d", &num);

    if(num > 10) //Gets first digit (Right-Most Digit)
    {
      sum += num % 10;
    }

    while (num >= 10) //Gets last digit (Left-Most Digit)
    {
      num = num / 10;
    }

    sum += num; //Adds first and last digit

    printf("The value of first digit and the last digit added together are %d\n", sum);
}
