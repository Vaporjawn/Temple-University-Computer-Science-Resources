/* CIS2107 Lab9 Sec. 04
   "str_cmp_ign_case"
   Christopher Scott
*/
#include "my_string.h"

// Compares s1 and s2 ignoring case. Returns 0 if equal, positive if s1 > s2, or negative if s1 < s2.
int strcmp_ign_case(char *s1, char *s2){
    int diff;
    while(*s1 != '\0' && *s2 != '\0'){
        diff = *s1 -*s2;
        switch(diff){
        case 0: case 32: case -32: // letters are equal, move to next 
            s1++;
            s2++;
            break;
        default:
            return diff;
        }
    }
    if(*s1 == '\0' && *s2 != '\0') // s2 is longer than s1, otherwise equal
        return -1;  
    else if(*s1 != '\0' && *s2 == '\0') //s1 is longer than s2, otherwise equal
        return 1;
    else // equal
        return 0;
}
