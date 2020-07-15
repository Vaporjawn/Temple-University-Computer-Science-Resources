/* CIS2107 Lab 9 Sec. 04
   "ptr_to"
   Christopher Scott
*/
#include "my_string.h"

// returns a pointer to the first instance of substring n in string h, or null if not found
char *ptr_to(char *h, char *n){ 
    char *ptr = NULL;
    char *t = h;
    for(; *t != '\0'; t++){
        if(*t == *n){  // current character matches first from substring
            ptr = t;
            for(int j = 1; *(n+j) != '\0'; j++){ // check the remainder of substring
                if(*(t + j) != *(n + j)){
                    ptr = NULL;
                    break;
                }
            }
        }
        if(ptr != NULL) // substring is found, exit early
            return ptr;
    }
    return ptr;
}
