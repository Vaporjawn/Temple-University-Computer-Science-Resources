#include <stdio.h>
#include <stdlib.h>

void copyStr (char *s, char *t)
{
  while ((*s++=*t++)!= '\0');
}

int main() {

  char *t = "12345";
  char *s = "";

  copyStr(&s, &t);

  printf("string is %s\n", s);

}
