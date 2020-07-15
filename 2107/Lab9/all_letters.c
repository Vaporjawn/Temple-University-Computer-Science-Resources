/* CIS2107 Lab9 Sec. 04
   "all_letters"
   Christopher Scott
*/
#include "my_string.h"
#include <ctype.h>

// Determines if a string only has alphabet characters
int all_letters(char *s){
    while(*s != '\0'){
        if(!(isalpha(*s)))
            return 0;
        s++;
    }
    return 1;
}
