/*
Max Bugay
Lower Level Programming

Purpose: Calculate the Euclidean Distance between two points in a 3D Plane without the default c pow() and sqrt() functions.
*/

#include<stdio.h>

float r, s, x1, y1, z1, x2, y2, z2, distance, sum;
float squareRoot(float n)
{
  if (n == 0) //squareRoot of 0 is 0
  {
    return 0;
  }
  float root = n;
  float num = 1;
  float dec = 0.001;
  while (root - num > dec) //Newton's Method
  {
    root = (root + num)/2;
    num = n/root;
  }
  return root;
}
int Power(int n, int p)
{
  int i;
  int num = 1;
  for (i = 0; i < p; ++i) { //Multiplies by itself until it hits power value
    num *= n;
  }
  return num;
}
int main()
{
  x1 = 1;
  y1 = 2;
  z1 = 3;
  x2 = 4;
  y2 = 5;
  z2 = 6;
  sum = ((Power(x1-x2, 2))+(Power(y1-y2, 2))+(Power(z1-z2, 2)));
  distance = squareRoot(sum);
  printf("The distance between points (%0.3f, %0.3f, %0.3f) and (%0.3f, %0.3f, %0.3f) is %0.3f.\n", x1, y1, z1, x2, y2, z2, distance);
}
