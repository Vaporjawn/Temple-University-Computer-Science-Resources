/* CIS2107 Lab9 Sec. 04
   "rm_empties"
   Christopher Scott
*/

#include "my_string.h"

// removes any empty strings from the array
void rm_empties(char **words){
    char **temp = words;
    size_t len = 0;

    for(; *(temp + len) != NULL; len++); // count number of words

    char *nonEmpty[len];
    int num = 0;
    
    // copy non empty strings into array
    while(*temp != NULL){
        if(**temp != '\0'){
            nonEmpty[num] = *temp;
            num++;
        }
        temp++;
    }
    temp = words; // set temp to location of words
    for(size_t i = 0; i < num; i++){
        *temp = nonEmpty[i];
        temp++;
    }
    *temp = NULL; // terminate
}
        
