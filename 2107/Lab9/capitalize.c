/* CIS2107 Lab9 Sec. 04
   "capitalize"
   Christopher Scott
*/
#include "my_string.h"
#include <ctype.h>

// Capitalizes the first letter of each word in a string
void capitalize(char *s){
    int inWord = 0;
    while(*s != '\0'){
        if( !inWord && isalpha(*s)){
            if(islower(*s))
               *s -= 32; // convert to uppercase
            inWord = 1;
        }
        else if(inWord){
            if(isspace(*s) || ispunct(*s))
                inWord = 0;
            if(isupper(*s))
                *s += 32; // convert to lowercase
        }
        s++;
    }
}
