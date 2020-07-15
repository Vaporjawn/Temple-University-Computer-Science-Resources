/* CIS2107 Lab9 Sec. 04
   "str_chop_all"
   Christopher Scott
*/
#include "my_string.h"
#include <stdlib.h>

// returns an array of tokens split from s using delimiter c
char **str_chop_all(char *s, char c){
    char *t = s;
    char buffer[100];
    char **tokens = NULL;
    int count = 0;
    
    for(; *t != '\0'; t++){ // count occurrences of delimiter
        if(*t == c)
            count++;
    }
    if(count == 0)
        return tokens;

    if((tokens = (char **)malloc(sizeof(char*) * (count + 2))) == NULL)
        return tokens;
    char **temp = tokens;
    while(*s != '\0'){
        int len = 0;
        while(*s != c && *s != '\0') // add characters to buffer until delimiter or end of string
            buffer[len++] = *s++;
        buffer[len] = '\0';
        len = 0;
        if((*temp = (char *)malloc(sizeof(char*))) == NULL){
            tokens = NULL;
            return tokens;
        }
        for(int i = 0; (*(*temp + i) = *(buffer + i)) != '\0'; i++); // copy buffer into temp
        temp++;
        if(*s != '\0')
            s++; // skip delim if not end of string
    }
    *temp = NULL;
    return tokens;
}
