/*
Max Bugay
Lower Level Programming

Purpose: Cast an int to float using bit level operations.
*/

#include <stdio.h>
#include <stdlib.h>

#define TMin 0x80000000
typedef unsigned float_bits;

union repr {
    float f;
    unsigned u;
};

unsigned f2u(float f)
{
    union repr r;
    r.f = f;

    return r.u;
}

float u2f(unsigned u) {
    union repr r;
    r.u= u;

    return r.f;
}

// TBC
float_bits myi2f(int i)
{
      unsigned sign;
      unsigned exp;
      unsigned frac;
      unsigned lastbit;
      sign = i >> 31;
      if (i == TMin)  //i = smallest
      {
          exp = 158;
          frac = 0;
      }
      else if (i == 0)  //i = zero
      {
          exp = 0;
          frac = 0;
      }
      else
      {
          if (sign)  //check for negative i
              frac = (~i + 1) << 1;
          else
              frac = i << 1;
          exp = 0;
          while (!(frac & 0x80000000))
          {
              exp++;
              frac <<= 1;
          }
          exp = 157 - exp;
          lastbit = ((frac >> 8) & 1);
          if (!lastbit)  //rounds last bit to 0
          {
              if ((frac & 0xff) == 0x80 || !((frac & 0xff) & 0x80))  //discard bits closer to 0
                  frac = ((frac << 1) >> 9);
              else
                  frac = ((frac << 1) >> 9) + 1;
          }
          else  //rounds last bit to 1
          {
              if ((frac & 0xff) == 0x80 || ((frac & 0xff) & 0x80))  //discard bits closer to 1
              {
                  frac = ((frac << 1) >> 9) + 1;
                  if (frac & 0x800000)
                  {
                      exp++;
                      frac = 0;
                  }
              }
              else
                  frac = ((frac << 1) >> 9);
          }
      }
      return ((sign << 31) | (exp << 23) | frac);
}

int main()
{
    unsigned i;
    unsigned sysconv;
    float_bits our;

    for (i = 100; i<110 ; i++) {
	       sysconv = f2u( (float) ((int) i) );
	       our = myi2f((int) i);
	       printf("Original int is %d\n", i);
         printf("Our conversion is %f\n", u2f(our)) ;
         printf("Sys conversion in hex is %x and our conversion in hex is  %x\n",sysconv, our);
	       if ( sysconv != our ) {
	           printf(" Mismatch:\n"
		           "original int %08X --> sys %08X , ours %08X\n",
		             i, sysconv, our);
	                exit(1);
         }
    }
    printf("Success Test\n");
    return 0;
}
