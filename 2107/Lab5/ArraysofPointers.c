/* CIS2107 Section 4 Lab 5 "ArraysofPointers"
   Christopher Scott
   "Create a menu driven interface that accesses functions via an array of function pointers"
*/
#include <stdio.h>
#include <stdlib.h>

void printArray(size_t rows, size_t cols, float[rows][cols]);
void findMin(size_t rows, size_t cols, float[rows][cols]);
void findMax(size_t rows, size_t cols, float[rows][cols]);
void printAvg(size_t rows, size_t cols, float[rows][cols]);


int main(){
    const size_t rows;
    const size_t cols;
    size_t choice;

    puts("");
    
    // Get user input on number of rows and columns
    printf("%s", "How many students? ");
    scanf("%u", &rows);
    printf("%s", "How many grades for each student? ");
    scanf("%u", &cols);

    float grades[rows][cols]; // declare array after values for rows and cols set

    // Fill array with user input values
    for(size_t i = 0; i < rows; i++){
        for(size_t j = 0; j < cols; j++){
            printf("\tEnter score %u for student %u: ", j + 1, i + 1);
            scanf("%f", &grades[i][j]);
        }
        puts("");
    }

    // declare array of functions
    void (*processGrades[4])(size_t rows, size_t cols, float[rows][cols]) = {printArray, findMin, findMax, printAvg};


    do {  // Print the menu until a 4 (or something else outside the range of array indices) is entered
        puts("");
        printf("%s", "Enter a choice:\n");
        printf("%s", "\t0 Print the array of grades\n");
        printf("%s", "\t1 Find the minimum grade\n");
        printf("%s", "\t2 Find the maximum grade\n");
        printf("%s", "\t3 Print the average on all tests for each student\n");
        printf("%s", "\t4 End Program\n"); 
        scanf("%u", &choice);
        puts("");
        if(choice >= 0 && choice <= 3) // error handling for user input that does not correspond to an array index
            (*processGrades[choice])(rows, cols, grades);
    } while(choice >=0 && choice <=3);

    
    printf("%s", "Exiting Program...\nGoodbye!\n");
}

// Print the array row by row, after student number
void printArray(size_t rows, size_t cols, float scores[rows][cols]){
    for(size_t i = 0; i < rows; i++){
        printf("\tStudent %u: ", i + 1);
        for(size_t j = 0; j < cols; j++){
            if(j < cols-1)
                printf("%6.2f, ", scores[i][j]);
            else
                printf("%6.2f", scores[i][j]);
        }
        puts("");
    }
}

// Finds the minimum score in the whole array
void findMin(size_t rows, size_t cols, float scores[rows][cols]){
    float min = scores[0][0];
    for(size_t i = 0; i < rows; i++){
        for(size_t j = 0; j < cols; j++){
            if(scores[i][j] < min)
                min = scores[i][j];
        }
    }
    printf("\tThe minimum score is: %.2f\n", min);
}

// Finds the maximum score in the whole array
void findMax(size_t rows, size_t cols, float scores[rows][cols]){
    float max = scores[0][0];
    for(size_t i = 0; i < rows; i++){
        for(size_t j = 0; j < cols; j++){
            if(scores[i][j] > max)
                max = scores[i][j];
        }
    }
    printf("\tThe maximum score is: %.2f\n", max);
}

// Prints the average score for each student
void printAvg(size_t rows, size_t cols, float scores[rows][cols]){
    float sum = 0;
    for(size_t i = 0; i < rows; i++){
        for(size_t j = 0; j < cols; j++){
            sum += scores[i][j];
        }
        printf("\tThe average score for student %u is: %.2f\n", i + 1, sum / cols);
        sum = 0;
    }
}




 
