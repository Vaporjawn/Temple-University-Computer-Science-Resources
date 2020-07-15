/* CIS2107 Lab 9 Sec. 04
   "len_diff"
   Christopher Scott
*/
// Returns the length of s1 - the length of s2
int len_diff(char *s1, char *s2){
    int s1_len = 0;
    int s2_len = 0;
    for(; *s1 != '\0'; s1++, s1_len++);
    for(; *s2 != '\0'; s2++, s2_len++);
    return s1_len - s2_len;
}
