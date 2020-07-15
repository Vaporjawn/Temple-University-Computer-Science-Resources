/* CIS2107 Lab9 Sec. 04
   "take_last"
    Christopher Scott
*/
#include "my_string.h"

// Modifies s to consist of the last n characters
void take_last(char *s, int n){
    int s_len = 0;
    for(; *(s + s_len) != '\0'; s_len ++); // Count length of s
    if(n > s_len) // String should remain unchanged
        return;
    for(int i = 0; n >= 0; n--, i++)
       *(s + i) = *(s + (s_len - n));
    return;
}
        
