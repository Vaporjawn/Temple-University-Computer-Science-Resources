#include <stdio.h>

void main (){
   
   int i ; 
   i = 5 ; 
   int *ip = &i; 

  printf("i has  value %d and the address of i is 0x%x \n ",i,&i ); 
  printf("pointer ip has value of 0x%x\n",ip ); 
  printf("pointer is at address 0x%x itself\n", &ip); 

  printf("------------------------------\n"); 

  int a[7] ;
  int j; 
  for (j =0; j<7 ; j++ ) a[j]= j*10; 
  ip = a; 
  printf("ip new value is 0x%x\n", ip) ;
  printf("array a address is 0x%x\n", a); 

  printf("the third element is 0x%d\n", *(ip+2) ); 

  ip +=2 ; 
  printf("ip new value is 0x%x\n", ip) ;


}
