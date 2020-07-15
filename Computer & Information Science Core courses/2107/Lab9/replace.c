/* CIS2107 Lab9 Sec. 04
   "replace"
   Christopher Scott
*/

#include "my_string.h"
#include <stdlib.h>

// returns a copy of string s with all instances of string pat replaced with string rep
char *replace(char *s, char *pat, char *rep){
    char *t = s;
    char *ptr = NULL;
    int loc;
    size_t s_len = 0;
    size_t pat_len = 0;
    size_t rep_len = 0;
    int num_pat =0;

    // count string lengths
    for(; *(t + s_len) != '\0'; s_len++);
    for(; *(pat + pat_len) != '\0'; pat_len++);
    for(; *(rep + rep_len) != '\0'; rep_len++);

    // count the number of occurences of pat in s
    while((loc = find(t, pat)) != -1){
        num_pat++;
        t += loc + pat_len;
    }
    
    if( num_pat != 0){
        if((ptr = (char *)malloc(sizeof(char) * (s_len - (num_pat * pat_len) + (num_pat * rep_len)))) == NULL)
            return ptr;
    }
    else
        return ptr;
    // copy string and replace pat with rep
    t = s;
    char *start = ptr;
    while(*t != '\0'){
       if(*t == *pat){
           int isPat = 1;
           for(int i = 1; i < pat_len; i++){ // check if is occurence of pat
               if(*(t + i) != *(pat + i))
                   isPat = 0;
           }
           if(isPat){
               for(int i = 0; *(rep + i) != '\0'; i++, ptr++)
                   *ptr = *(rep + i);
               t += pat_len;
           }
           else
               *ptr++ = *t++;
       }
       else
           *ptr++ = *t++; 
    }
    // terminate ptr
    *ptr = '\0';
    ptr = start; // reset pointer to beginning
    return ptr;
}
