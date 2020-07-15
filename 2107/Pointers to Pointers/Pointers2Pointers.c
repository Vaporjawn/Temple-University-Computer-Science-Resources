//Max Bugay
//Lower Level Programming
//Purpose: Perform a matrix multiplication using pointers to pointers with random numbers.

#include<stdio.h>
#include<stdlib.h>

float randNum() { //random number generator
  return ((float) rand()/(float) (RAND_MAX)) * 5;
}

int main(int argc, char **argv)
{
  int m, n, p; //m, n, p arguments
  m = atoi(argv[1]);
  n = atoi(argv[2]);
  p = atoi(argv[3]);
  int i, j, k, result = 0;

  float **matrix1 = (float **)malloc(m*sizeof(float *)); //allocate size for m*n
  for (i = 0; i < m; i++)
  {
    matrix1[i] = (float *)malloc(n*sizeof(float));
  }
  float **matrix2 = (float *)malloc(n*sizeof(float *)); //allocate size for n*p
  for (i = 0; i < n; i++)
  {
    matrix2[i] = (float *)malloc(p*sizeof(float));
  }
  float **matrixMult = (float *)malloc(m*sizeof(float *)); //allocate size for multiplied matrix
  for (i = 0; i < m; i++)
  {
    matrixMult[i] = (float *)malloc(p*sizeof(float));
  }

  for(i = 0; i < m; i++) //fill matrix1 with random numbers
  {
    for(j = 0; j < n; j++)
    {
      *(*(matrix1 + i) + j) = randNum();
    }
  }

  for (i = 0; i < m; i++) //fill matrix 2 with random numbers
  {
    for (j = 0; j < n; j++)
    {
      *(*(matrix2 + i) + j) = randNum();
    }
  }
  for (i = 0; i < m; i++) //multiply matrices
  {
    for (j = 0; j < p; j++)
    {
      for (k = 0; k < n; k++)
      {
        result = result + (*(*matrix1 + i) + k) * (*(*matrix2 + k) + j);
      }
      *(*(matrixMult + i) + j) = result;
      result = 0;
    }
  }
  for (i = 0; i < m; i++) //print result
  {
    for (j = 0; j < p; j++)
    {
      printf("%f \t", *(*(matrixMult + i) + j));
    }
    printf("\n");
  }
}
