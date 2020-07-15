/* CIS2107 Lab9 Sec. 04
   "diff"
    Christopher Scott
*/
#include "my_string.h"

// returns the number of positions in which s1 and s2 differ
int diff(char *s1, char *s2){
    int count = 0;
    while(*s1 != '\0' && *s2 != '\0'){
        if(*s1 != *s2)
            count++;
        s1++;
        s2++;
    }
    // test if the strings were the same length and add any extra letters to count
    if(*s1 == '\0' && *s2 == '\0')
        return count;
    // if s1 is longer, add extra letters
    else if(*s1 != '\0'){
        while(*s1++ != '\0')
            count++;
        return count;
    }
    // s2 is longer, add extra letters
    else{
        while(*s2++ != '\0')
            count++;
        return count;
    }
}
