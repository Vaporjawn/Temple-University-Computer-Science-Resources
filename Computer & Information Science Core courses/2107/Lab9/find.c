/* CIS2107 Lab9 Sec. 04
   "find"
   Christopher Scott
*/
#include "my_string.h"

// returns the index of the first instance of character n in string h, or -1 if not found
int find(char *h, char *n){
    int i = 0;
    int loc = -1;
    for(;*(h + i) != '\0'; i++){
        if(*(h + i) == *n){  // current character matches first from substring
            loc = i;
            for(int j = 1; *(n+j) != '\0'; j++){ // check the remainder of substring
                if(*(h + i + j) != *(n + j))
                    loc = -1;
            }
            if(loc == i) // if loc still == i, then substring is found
                return loc;
        }
    }
    return loc;
}
