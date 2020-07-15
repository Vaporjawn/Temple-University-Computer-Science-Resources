/* CIS2107 Lab9 Sec. 04
   "rm_space"
   Christopher Scott
*/
// remove whitespace from the beginning and end of the string
#include "my_string.h"

void rm_space(char *s){
    rm_left_space(s);
    rm_right_space(s);
}
