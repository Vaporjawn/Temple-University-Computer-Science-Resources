/* CIS2107 Lab9 Sec. 04
   "dedup"
   Christopher Scott
*/
#include "my_string.h"
#include <stdlib.h>

#define ASCII 128 

// Returns a string of the unique characters in s
char *dedup(char *s){
    int s_len = 0;
    int index = 0;
    int counts[ASCII] = {0}; // keep track of how many times each character has been seen

    for(; *(s + s_len) != '\0'; s_len++);

    char *ptr = NULL;
    if((ptr = (char *) malloc(sizeof(char) * s_len)) == NULL)  // Allocate memory assuming every character in s is unique
        return ptr;
    while(*s != '\0'){
        if(counts[*s] == 0){ // *s has not been seen before
            *(ptr + index++) = *s;
            counts[*s]++;
        }
        s++;
    }
    *(ptr + index) = '\0';
    return ptr;
}
