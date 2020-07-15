/* CIS2107 Section 4 Lab 5 "2D Arrays Processing - Arrays2D"
   Christopher Scott
   "A collection of functions to perform operations on two-dimensional arrays"
*/


#include <stdio.h>
#include <stdlib.h>


int max( int rows, int cols, int[rows][cols]);
int rowSum(int rows, int cols, int[rows][cols], int);
int columnSum(int rows, int cols, int[rows][cols], int);
int isSquare(int, int);
void displayOutputs(int rows, int cols, int[rows][cols]);

void main(){
    int rows, cols;

    // Get array size
    printf("%s", "Let's create a 2Dim array!\n");
    printf("%s", "\n\tHow many rows? ");
    scanf("%d", &rows);
    printf("%s", "\tHow many columns? ");
    scanf("%d", &cols);

    puts("");

    // Get array values from user
    int test[rows][cols];
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
            printf( "\tenter [%u][%u]: ", i, j);
            scanf("%d", &test[i][j]);
        }
    }

    puts("");   
    
    // output row sums
    for(size_t i = 0; i < rows; i++){
        printf("Sum of row %u = %d\n", (i + 1),  rowSum(rows, cols, test, i));
    }

    puts("");
    
    // output column sums
    for(size_t i = 0; i < cols; i++){
        printf("Sum of column %u = %d\n", i + 1, columnSum(rows, cols, test, i));
    }

    puts("");

    printf("Maximum value is %d\n", max(rows, cols, test));

    puts("");

    if(isSquare(rows, cols))
        printf("%s", "This is a square array.\n");
    else
        printf("%s", "This is not a square array.\n");

    puts("");
    printf("%s", "Here is your 2Dim array:\n");

    displayOutputs(rows, cols, test);
    puts("");
}

// return the maximum value in the array
int max(int rows, int cols, int A[][cols]){
    int max = A[0][0];
    for(size_t i = 0; i < rows; i++)
    {
        for(size_t j = 0; j < cols; j++)
        {
            if(A[i][j] > max)
                max = A[i][j];
        }
    }
    return max;
}

// Sum the values in a specified row
int rowSum(int rows, int cols, int A[][cols], int rowToSum){
    int sum = 0;
    for(size_t i = 0; i < cols; i++)
        sum += A[rowToSum][i];
    return sum;
}

// Sum the values in a specified column
int columnSum(int rows, int cols, int A[][cols], int colToSum){
    int sum = 0;
    for(size_t i = 0; i < rows; i++)
       sum += A[i][colToSum];
    return sum;
}

// Determine if the array is square
int isSquare(int rowsize, int colsize){
    return rowsize == colsize;
}

// Print the array
void displayOutputs(int rows, int cols, int A[][cols]){
    for(size_t i = 0; i < rows; i++)
    {
        printf("%s", "[");
        for(size_t j = 0; j < cols; j++)
        {
            if(j < cols - 1)
               printf("%d, ", A[i][j]);
            else
               printf("%d", A[i][j]);
        }
        printf("%s", "]\n");
    }
}
