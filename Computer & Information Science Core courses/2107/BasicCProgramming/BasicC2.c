/*
Max Bugay
Lower Level Programming

Purpose: Convert a string or array of characters to a double floating point value. . 
*/

#include<stdio.h>

double convertFloat(char s[])
{
  int length = 0, n = 0, i = 0, sign = 1;
  float f = 1.00 , dp = 0.00;

  if (s[0] == '-') //Checks if negative value
  {
    ++i;
    sign = -1;
  }

  while(s[length]) //Generates length of array
  {
      length++;
  }

  if(!length) //Returns 0 if empty
  {
    return 0;
  }

  while(i < length && s[i] != '.') //Get numeric values of string and assigns to n
  {
    n = 10 * n + (s[i++] - '0');
  }

  if(i == length) //Stops incrementation
  {
    return n;
  }

  i++; //Incrementation

  while(i < length) //Gets decimal point of string and assigns to dp
  {
    f *= 0.1;
    dp += f * (s[i++] -'0');
  }

  return sign*(dp + n); //Returns value and sign of it
}
int main()
{
  char ch1[] = "1.34";
  float conversion1 = convertFloat(ch1);
  printf("%0f\n", conversion1);
  char ch2[] = "-1.4554";
  float conversion2 = convertFloat(ch2);
  printf("%0f\n", conversion2);
  char ch3[] = "6";
  float conversion3 = convertFloat(ch3);
  printf("%0f\n", conversion3);
}
