/*
Max Bugay
Lower Level Programming

Purpose: Print the values and corresponding ASCII values from 33 to 126. 
*/

#include <stdio.h>

int main()
{
    int i = 33;
    while (i <= 126)
    {
        char c = i; //Gets ASCII value of i
        printf("%d ", i);
        printf("%c \n", c);
        ++i;
    }
}
