#include <stdio.h>

int main() {
    int c;
    long count = 0;
    int digits = 0;
    int letters = 0;
    int words = 0;
    int other = 0;
    int space = 0;

    while ((c = getchar()) != EOF) {
        if (c >= '0' && c <= '9')
        {
          ++digits;
        }
        else if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
        {
          ++letters;
        }
        else if (c == ' ' || c == '\n' || c == '\t')
        {
          ++words;
        }
        else
          ++other;
    }
    count = digits + letters + words + other;

    printf("The number of digits counted is %d \n", digits);
    printf("The number of letters counted is %d \n", letters);
    printf("The number of words counted is %d \n", words);
    printf("The number of characters counted is %d \n", count);
}
