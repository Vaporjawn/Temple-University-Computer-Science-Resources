/*
 * Name:	Christopher Scott
 * Section:     04 
 * Date:	10/22/2019 	
 * Lab:  	CIS2107_Lab08_Manual 
 * Goal: 	To design and implement functions to process characters and strings.
 */


#include <stdio.h>
#include <memory.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

//functions
void * upperLower(const char * s);
int convertStrtoInt(const char *s1, const char *s2, const char *s3, const char *s4);
float convertStrtoFloat(const char *s1, const char *s2, const char *s3, const char *s4);
void compareStr(const char *s1, const char *s2);
void comparePartialStr(const char *s1, const char *s2, int n);
void randomize(void);
int tokenizeTelNum(char *num);
void reverse(char *text);
int countSubstr (char * line, char * sub);
int countChar (char * line, char c);
int countWords(char *string);
void countAlpha(char *string);
void startsWithB(char *string[],int size);
void endsWithed(char *string[], int size);

int main() {

    //random generator
    srand(time(NULL));

    //test for upperLower
    const char test[] = "This iS A Test";
    upperLower(test);

    //test for convertStrtoInt
    printf("\n\nThe sum of 4 strings is: %d", convertStrtoInt("3", "4", "5", "6"));

    //test for convertStrtoFloat
    printf("\n\nThe sum of 4 strings is: %.2f", convertStrtoFloat("3.5", "4.5", "5.5", "6.5"));

    //test for compareStr
    compareStr("Test1", "Test2");

    //test for comparePartialStr
    comparePartialStr("Test1", "Test2", 4);

    //test for randomize
    randomize();

    //test for tokenize number
    char str[] = "(267) 436-6281";
    tokenizeTelNum(str);

    //test for reverse
    char line[] = "Hello world";
    reverse(line);

    //test for countSubstr
    char *line1 = "helloworldworld";
    char *substring = "world";
    printf("\n\nNumber of Substrings %s inside %s: %d\n", substring, line1, countSubstr(line1, substring));

    //test for countChar
    char w = 'w';
    printf("\nNumber of character %c inside %s: %d\n", w, line1, countChar(line1, w));

    //test for countAlpha
    char str1[] = "Hello it's me.";
    countAlpha(str1);

    //test for countWords
    char countstring[] = "hello world!";
    printf("\n\nNumber of words in string is: %d\n", countWords(countstring));

    //test for startsWithB
    char *series[] = {"bored", "hello", "Brother", "manual", "bothered"};
    int size = sizeof(series) / sizeof(series[0]);
    startsWithB(series, size);

    //test for endsWithed
    endsWithed(series, size);

}

// 1.(Displaying Strings in Uppercase and Lowercase) 
// Print a string in upper case and lower case
void * upperLower (const char * s) {
    char retString[100];
    size_t len = strlen(s);
    for(size_t i = 0; i < len; i++){
        retString[i] = toupper(s[i]);
    }
    retString[len] = '\0';
    printf("%s ", retString);
    for(size_t i = 0; i < len; i++){
        retString[i] = tolower(s[i]);
    }
    retString[len] = '\0';
    printf("%s\n", retString);
    return NULL;
    
}

// 2.(Converting Strings to Integers for Calculations) 
// Convert 4 strings to ints and return the sum
int convertStrtoInt(const char *s1, const char *s2, const char *s3, const char *s4) {
    int sum = 0;
    const char *strings[4] = {s1, s2, s3, s4};
    for(size_t i = 0; i < 4; i++){
        sum += atoi(strings[i]);
    }
    return sum;
}

//3.(Converting Strings to Floating Point for Calculations) 
// Convert 4 strings to floats and return the sum
float convertStrtoFloat(const char *s1, const char *s2, const char *s3, const char *s4) {
   float sum = 0;
   const char *strings[4] = {s1, s2, s3, s4};
   for(size_t i = 0; i < 4; i++){
       sum += atof(strings[i]);
   }
   return sum;
}

//4.(Comparing Strings) 
// Print the comparison of two strings
void compareStr(const char *s1, const char *s2) {
    int result = strcmp(s1, s2);
    if(result < 0)
        printf("\n%s <  %s\n", s1, s2);
	else if(result > 0)
        printf("\n%s > %s\n", s1, s2);
    else
        printf("\n%s = %s\n", s1, s2);

}

//5.(Comparing Portions of Strings) 
// Print the comparison of the first n characters of two strings
void comparePartialStr(const char *s1, const char *s2, int n) {
    int result = strncmp(s1, s2, n);
    if(result < 0)
        printf("\nComparison of first %d characters: %s < %s\n", n, s1, s2);
    else if(result > 0)
        printf("\nComparison of first %d characters: %s > %s\n", n, s1, s2);
    else
        printf("\nComparison of first %d characters: %s = %s\n", n, s1, s2);
}

//6.(Random Sentences) 
void randomize(void) {
   char *article[] = {"the", "a", "one", "some", "any"};
   char *noun[] = {"boy", "girl", "dog", "town", "car"};
   char *verb[] = {"drove", "jumped", "ran", "walked", "skipped"};
   char *preposition[] = {"to", "from", "over", "under", "on"};
   char sentence[50];
   // order is article + noun + verb + preposition + article + noun
   char *choice = NULL; 

   puts("");
   for(size_t i = 0; i < 20; i++){ 
       size_t loc = 0;
       sentence[0] = '\0';
       
       // Start with an article
       choice = article[rand() % (sizeof(article)/sizeof(char *))]; // random choice from array
       strcat(sentence, choice); // concatenate new word with the rest of sentence
       loc += strlen(choice); // move string index
       sentence[loc] = ' '; // add space between words
       sentence[loc + 1] = '\0'; // terminate the new resulting string

       // noun
       choice = noun[rand() % (sizeof(noun)/sizeof(char *))];
       strcat(sentence, choice);
       loc += 1 + strlen(choice);
       sentence[loc] = ' ';
       sentence[loc+1] = '\0'; 

       // verb
       choice = verb[rand() % (sizeof(verb)/sizeof(char *))];
       strcat(sentence, choice);
       loc += 1 + strlen(choice);
       sentence[loc] = ' ';
       sentence[loc+1] = '\0';
       
       // preposition
       choice = preposition[rand() % (sizeof(preposition)/sizeof(char *))];
       strcat(sentence, choice);
       loc += 1 + strlen(choice);
       sentence[loc] = ' ';
       sentence[loc+1] = '\0';
       
       // article
       choice = article[rand() % (sizeof(article)/sizeof(char *))];
       strcat(sentence, choice);
       loc += 1 + strlen(choice);
       sentence[loc] = ' ';
       sentence[loc+1] = '\0';

       // noun
       choice = noun[rand() % (sizeof(noun)/sizeof(char *))];
       strcat(sentence, choice);
       loc += 1 + strlen(choice);
       sentence[loc] = '.';
       sentence[loc+1] = '\0';

       sentence[0] = toupper(sentence[0]);
       puts(sentence);
   }

}

//7.(Tokenizing Telephone Numbers) 
// Tokenize a telephone number in the format (484)-555-1234
int tokenizeTelNum(char *num) {
    char *ptr;
    char *area = strtok(num, "()-");
    char *first3 = strtok(NULL, "()-");
    char *last4 = strtok(NULL, "()-");
    printf("\n%d %li\n", atoi(area), strtol(strcat(first3, last4), &ptr , 10));
}

//8.(Displaying a Sentence with Its Words Reversed) 
// Tokenize a string and print the words in reverse order
void reverse(char *text) {
    char *sentence[100]; //create stack to hold tokens
    size_t sentPtr = 0;
    char *word = strtok(text, " ,.!?-");
    sentence[sentPtr] = word;
    sentPtr++;
    while((word = strtok(NULL, " ,.!?-")) != NULL){ // grab tokens until NULL
        sentence[sentPtr] = word;
        sentPtr++;
    }
    puts("");
    while(sentPtr >= 0 && sentence[--sentPtr] != NULL){
       printf("%s ", sentence[sentPtr]);
    }
    puts("");

}

//9.(Counting the Occurrences of a Substring) 
// Count the occurrences of a specified substring in a string
int countSubstr (char * line, char * sub) {
  int count = 0;
  char *ptr = NULL;
  while((ptr = strstr(line, sub)) != NULL){
      line = ptr + sizeof(*sub); // move line to point after sub to search through the rest of the string
      count++;
  }
  return count;
}

//10.(Counting the Occurrences of a Character) 
// Count the number of occurrences of a specified character in the string
int countChar (char *line, char c) {
    int count = 0;
    char *ptr = NULL;
    while((ptr = strchr(line, c)) != NULL){
        line = ptr + sizeof(c); // move line to search through the rest of string
        count++;
    } 
    return count;
}


//11.(Counting the Letters of the Alphabet in a String) 
// Count each occurrence of a letter in the alphabet, ignoring case
void countAlpha(char *string) {
    unsigned int counts[26] = {0}; // Initialize all elements to 0
    // Loop through Uppercase
    for(char i = 'A'; i <= 'Z'; i++)
        counts[i - 'A'] += countChar(string, i);
    // Loop through Lowercase
    for(char i = 'a'; i <= 'z'; i++)
        counts[i - 'a'] += countChar(string, i);
 
    // Print tabular output
    for(char i = 'A'; i <= 'Z'; i++)
        printf("%c,%c | %u\n", i, i + 32, counts[i -'A']);
}

//12.(Counting the Number of Words in a String) 
// Tokenize a string and cound the number of words
int countWords(char *string) {
    int count = 0;
    char *ptr = NULL;
    ptr = strtok(string, " \n");
    if(ptr != NULL) // Check that there is at least 1 token
        count++;  
    while((ptr = strtok(NULL, " \n")) != NULL)
        count++; 
    return count;
}

//13.(Strings Starting with "b") 
// Print out strings in an array starting with b or B
void startsWithB(char *string[], int size) {
    for(size_t i = 0; i < size; i++){
        if(*string[i] == 'b' || *string[i] == 'B')
            printf("%s ", string[i]);
    }
    puts("");
}

//14.(Strings Ending with "ed") 
// Print out strings in an array ending with "ed"
void endsWithed(char *string[], int size) {
    int len = 0;
    for(size_t i = 0; i < size; i++){
         len = strlen(string[i]);
         // if second to last character = 'e' and last character = 'd'
         if( *(string[i] + (len - 1)) == 'd' && *(string[i] + (len - 2)) == 'e')
             printf("%s ", string[i]);
    } 
    puts("");
}
