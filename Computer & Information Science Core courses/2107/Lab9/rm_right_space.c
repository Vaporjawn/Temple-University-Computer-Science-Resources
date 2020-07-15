/* CIS2107 Lab9 Sec. 04
   "rm_right_space"
   Christopher Scott
*/
#include "my_string.h"
#include <ctype.h>

void rm_right_space(char *s){
    int count = 0;
    // Count letters
    for(; *(s + count) != '\0'; count++);

     --count; // *(s + count) is currently pointing at '\0', so decrement

    while(isspace(*(s + count))){
        --count;
    }
    *(s + count + 1) = '\0';
    return;
}






