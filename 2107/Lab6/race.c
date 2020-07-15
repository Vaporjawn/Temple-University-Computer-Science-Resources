/* CIS2107 Section 4 Lab 6 "Race"
   Christopher Scott 
   "A program to simulate a race between a tortoise and a hare"
*/
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <unistd.h>

int generateNum(void);
void advancePositions(unsigned int *const t, unsigned int *const h);
void printPositions(unsigned int *const t, unsigned int *const h);

int main(){
    unsigned int tortoise, hare;
    tortoise = hare = 1;
    unsigned int *const tptr = &tortoise;
    unsigned int *const hptr = &hare;
    
    puts("ON YOUR MARK, GET SET");    
    puts("BANG !!!!\nAND THEY'RE OFF !!!!!");

    while(tortoise < 70 && hare < 70){
        advancePositions(tptr, hptr);
        printPositions(tptr, hptr);
        sleep(1);
    }

    if(tortoise >= 70 && hare >= 70)
        puts("It's a tie!");
    else if(tortoise >= 70)
        puts("TORTOISE WINS!!! YAY!!!");
    else
        puts("HARE WINS. YUCK");

    return 0;
}
// generate a random number between 1 and 10, inclusive
int generateNum(void){
    srand(time(NULL));
    return (rand() % 10 + 1);
}

// advance the positions of the tortoise and hare based on a random movement
void advancePositions(unsigned int *const t, unsigned int *const h){
    // move tortoise
    int move = generateNum();
    if(move >= 1 && move <= 5) // fast plod (50%)
        *t += 3;
    else if(move >= 6 && move <= 8) // slow plod (30%)
        *t += 1;
    else{ // slip
        if(*t > 6)
            *t -= 6;
        else
            *t = 1;
    }
    // move hare
    move = generateNum();
    if(move == 1 || move == 2) // big hop
        *h += 9;
    else if( move == 3){ // big slip
        if(*h > 12)
          *h -= 12;
        else
          *h = 1;
    }
    else if(move >= 4 && move <=6) // small hop
        *h += 1;
    else if(move == 7 || move == 8){ // small slip
        if(*h > 2)
            *h -= 2;
        else
            *h = 1;
   }
   // don't need to do anything for sleep
}

// print out the current positions on the race course
void printPositions(unsigned int *const t, unsigned int *const h){
    for(size_t i = 1; i < 71; i++){
        if(i == *t && i == *h)
            printf("%s", "OUCH!!!");
        else if(i == *t)
            printf("%s", "T");
        else if(i == *h)
            printf("%s", "H");
        else
            putchar(' ');
     }
     putchar('\n');
} 
    

