/* CIS2107 Section 4 Lab 4 "Processing1DArrays"
   Christopher Scott
   "A collection of functions for performing operations on arrays"
*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void fillArray(int[], int, int, int);
int findWithRange(int[], int, int);
void reverseArray(int[], int);
void reverseArrayInRange(int[], int, int, int);
int findSequence(int[], int);
void printArray(int[], int, int);

int main(void)
{
    int test[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    printf("%s", "Testing fillArray() with args(size = 40, low = 20, high = 80)...\n");
    int test2[40];
    fillArray(test2, 40, 20, 80);
    printArray(test2, 40, 10);

    puts("");
    printf("%s", "Testing reverseArray()...\n");
    printf("%s", "\tBefore:\n");
    printArray(test, 20, 10);
    reverseArray(test, 20);
    printf("%s","\tAfter:\n");
    printArray(test, 20, 10);

    puts("");
    int test3[] = {10, 20, 60, 30, 50};
    printf("%s", "Testing findWithRange() on {10, 20, 60, 30, 50} with args(low = 1, high = 3)...\n");
    printf("\tLargest element is: %d\n", findWithRange(test3, 1, 3));
    
    puts("");
    reverseArray(test, 20);
    printf("%s", "Testing reverseArrayInRange() on {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20} with args(low = 3, high = 7)...\n");
    printf("%s", "\tBefore:\n");
    printArray(test, 20, 10);
    reverseArrayInRange(test, 20, 3, 7);
    printf("%s", "\tAfter:\n");
    printArray(test, 20, 10); 

    puts("");
    printf("%s", "Testing findSequence()...\n");
    printArray(test, 20, 10);
    findSequence(test, 20);

}

// fill an array with random integers in range from low to high, inclusive
void fillArray(int A[], int size, int low, int high)
{
   srand(time(NULL));  // seed rand()
   for(int i = 0; i < size; i++)
       A[i] = rand() % (high - low + 1) + low;
}

// finds the largest element in an array within the specified range(low to high, inclusive)
int findWithRange(int A[], int low, int high)
{   
    int max = A[low++];
    for(;low <= high; low++)
    {
        if(max < A[low])
            max = A[low];
        
    }
    return max; 
}
// reverses an array in place
void reverseArray(int A[], int size)
{
    int temp;
    unsigned int i = 0;
    size--;
    while(i < size) // until indices cross, swap kth and n-kth element
    {
        temp = A[i];
        A[i++] = A[size];
        A[size--] = temp;
    }
} 
// reverses in place the elements of an array within a specified range(low to high, inclusive)
void reverseArrayInRange(int A[], int size, int low, int high)
{
    if(high > size) // handle error if high bound is greater than the array size
    {
        printf("%s", "Error in reverseArrayInRange: high > size\n");
        exit(1);
    }
    if(low > high) // handle error if low bound is greater than high bound
    {
        printf("%s", "Error in reverseArrayInRange: low > high\n");
        exit(1);
    }
    int temp;
    high--;
    while(low < high)
    {
        temp = A[low];
        A[low++] = A[high];
        A[high--] = temp;
    }
}
// Asks the user to input a sequence of two values and searches for them in the array
int findSequence(int A[], int size)
{
    int num1, num2;
    int loc = -1;
    printf("%s", "Enter two numbers: ");
    scanf("%d %d", &num1, &num2);
//    printf("\nSearching for %d and %d\n", num1, num2);
    for(size_t i = 0; i < size - 1; i++)
    {
//        printf("\nA[%u]: %d, A[%u]: %d\n", i, A[i], i + 1, A[i+1]);
        if(A[i] == num1 && A[i+1] == num2)
        {
            loc = i;
//           printf("\nSequence found at index %d\n", loc);
            break;
        }
    }
    if(loc != -1)
    {
        printf("\nSequence found at index %u\n", loc);
        return loc;
    }
    else
    {
       printf("%s", "Sequence not found\n");
       return loc;
    }
}

// function to format array printing into a number of columns
void printArray(int A[], int size, int numCol)
{
    printf("%s", "\t");
    for(int i = 0; i < size; i++){
        printf("%4d", A[i]);
        if((i+ 1) % numCol == 0)
            printf("%s", "\n\t");
    }
    puts("");
}

