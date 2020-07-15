/* CIS2107 Lab9 Sec. 04
   "pad"
   Christopher Scott
*/
#include "my_string.h"
#include <stdlib.h>

// Returns a new string padded with spaces so the length is an even multiple of d
char *pad(char *s, int d){
    char *ptr = NULL;
    int s_len = 0;

    if(s == NULL)
        return ptr;
    else
        for(; *(s + s_len) != '\0'; s_len++);
    if(s_len % d == 0){ // string length is  a multiple of d
        if((ptr = (char *) malloc(sizeof(char) * s_len)) == NULL)
            return ptr;
        for(int i = 0; (*(ptr + i) = *(s + i)) != '\0'; i++);  // copy s to ptr
        *(ptr + s_len) = '\0';
        return ptr;
    }
    else{
        int pad = s_len % d;
        if((ptr = (char *) malloc(sizeof(char) * (s_len + pad))) == NULL)
            return ptr;
        for(int i = 0; i < s_len + pad; i++){
            if(i < s_len)
                *(ptr + i) = *(s + i);  // copy base string
            else
                *(ptr + i) = ' ';  // pad with spaces
        }
        *(ptr + (s_len + pad)) = '\0';
        return ptr;
    }
    return ptr; // Should not get here, will return null
}
