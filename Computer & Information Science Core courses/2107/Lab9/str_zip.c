/* CIS2107 Lab9 Sec. 04
   "str_zip"
   Christopher Scott
*/
#include "my_string.h"
#include <stdlib.h>

//  Returns a new string with alternating letters from each of the argument strings
//  User has resposibility to free the dynamically allocated memory
char *str_zip(char *s1, char *s2){
    int s1_len = 0;
    int s2_len = 0;
    // count the lengths of the strings
    for(; *(s1 + s1_len) != '\0'; s1_len++);
    for(; *(s2 + s2_len) != '\0'; s2_len++);

    if(s1_len == 0 && s2_len == 0)
        return NULL;
    else if(s1_len == 0 && s2_len != 0)
        return s2;
    else if(s1_len != 0 && s2_len == 0)
        return s1;
    else{
        char *newString = NULL;
        if((newString = (char *) malloc(sizeof(char) *(s1_len + s2_len))) == NULL)
            return newString;
        int i = 0;
        if(s1_len == s2_len){ // strings are same length, alternate letters from each
            for(; i < s1_len + s2_len; i++)
                newString[i] = (i %2 == 0) ? *s1++ : *s2++;
        }
        else if( s1_len < s2_len){  // s1 is shorter, alternate letters than use the remaining from s2
            for(; i < s1_len * 2; i++)
                newString[i] = (i % 2 == 0) ? *s1++ : *s2++;
            for(; *s2 != '\0'; i++)
                newString[i] = *s2++;
        }
        else{  // s2 is shorter, alternate letters tahn use the remaining from s1
            for(; i < s2_len * 2; i++)
                newString[i] = (i % 2 == 0) ? *s1++ : *s2++;
            for(; *s1 != '\0'; i++)
                newString[i] = *s1++;
        }
        newString[i] = '\0';
        return newString;
     }
}           
