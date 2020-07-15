/* CIS2107 Lab 9 Sec. 04
   "str_connect"
   Christopher Scott
*/

#include "my_string.h"
#include <stdlib.h>

// Returns a string with the first n strings in array strs concatenated with separator c between
char *str_connect(char **strs, int n, char c){
    size_t lens[n];
    size_t total_len = 0;
    char *ptr = NULL;
    
    // calculate lengths of the first n strings
    for(size_t i = 0; i < n; i++){
//        printf("%s\n", strs[i]);
        lens[i] = 0;
        for(; *(strs[i] + lens[i]) != '\0'; lens[i]++);
    }
    
    for(size_t i = 0; i < n; i++) // sum all lengths
        total_len += lens[i];
    
    if((ptr = (char *)malloc(sizeof(char) * (total_len + (n - 1)))) == NULL)
        return ptr;
    char *t = ptr;
    // Copy n strings and separators into ptr
    for(size_t i = 0; i < n; i++){ 
        while(*strs[i] != '\0')
            *t++ = *strs[i]++;
        if(i < n - 1)
            *t++ = c;    
    }
    *t = '\0';
    return ptr;
}
