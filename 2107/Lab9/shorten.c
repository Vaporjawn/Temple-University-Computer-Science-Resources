/* CIS2107 Lab9 Sec. 04
   "shorten"
   Christopher Scott
*/
#include "my_string.h"

void shorten(char *s, int new_len){
    for(int count = 0; count < new_len && *s != '\0'; count++, s++)
        ;
    if(*s != '\0') // s is longer than new_len
        *s = '\0';
    return;
}
