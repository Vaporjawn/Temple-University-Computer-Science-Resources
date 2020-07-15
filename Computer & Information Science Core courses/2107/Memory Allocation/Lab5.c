//Max Bugay
//Lower Level Programming
//Lab 5

#include <stdio.h>
#include <stdlib.h>

int main()
{
  char *cp;
  char c;
  int i = 0;
  cp = (char*) malloc(sizeof(char)*26); //Allocate size for alphabet
  for (c = 'a'; c <= 'z'; ++c)
  {
    *cp = c;
    printf("%c ", *cp);
    ++cp;
    ++i;
  }
  cp -= i;
  free(cp);
  cp = (char*) malloc(sizeof(char)*10); //Allocate size for 0 to 9
  for (c = '0'; c <= '9'; ++c)
  {
    *cp = c;
    printf("%c ", *cp);
    ++cp;
  }
}
