/* CIS2107 Section 4 Lab 3 "ATM"
   Christopher Scott 9/13/19
   "A program to implement the functions of an ATM"
   Note: Limits and balances are declared as floats in the spirit that 
   currency is a fractional quantity, despite all transactions being conducted using whole numbers.

*/
#include <stdio.h>
#include <stdlib.h>

#define PIN 3014
#define LOCKOUT 3
#define TRANERROR -1

void checkBalance(float balance);
void withdrawal(float *, float *);
void deposit(float *, float *);
void quit(int, int);

int main(void){
    float withLimit = 1000;
    float *wL; 
    wL = &withLimit;
    float depLimit = 10000;
    float *dL;
    dL = &depLimit;
    float balance = 5000;
    float *b;
    b = &balance;
    unsigned int pin = 0; 
    unsigned int access = 0;
    unsigned int tries = 0;
    unsigned int t = 0;    

    // Begin Welcome Screen
    puts("\nWelcome to the ATM!\n");
    while(tries < LOCKOUT) //User has 3 tries to enter the correct pin
    {
       printf("%s", "Please enter your pin: \n");
       scanf("%u", &pin);
       if(pin == PIN)
       {
           printf("%s", "Access Granted\n");
           access = 1; 
           break;
       }
       else
       {
           printf("Incorrect pin, %d tries remaining\n", (LOCKOUT - ++tries));
       }
    }
    if(pin != PIN && tries >= LOCKOUT) // User has entered the incorrect pin too many times
        quit(2, t); // Quit with error message 2

    // Main Menu loop
    while(access)
    {
        printf("%s", "\n\tPress a number on the keypad to select a function\n"); 
        printf("%s", "\n\t------Main Menu------\n");
        printf("\t1%21s", "Check Balance\n");
        printf("\t2%21s", "Cash Withdrawal\n");
        printf("\t3%21s", "Cash Deposit\n");
        printf("\t4%21s", "Quit\n");
        printf("%s", ": \n");

        unsigned int choice;
        scanf("%u", &choice);
        
        switch(choice){
            case(1):
                checkBalance(balance);
                t++;
                break;
            case(2):
                withdrawal(b, wL);
                t++;
                break;
            case(3):
                deposit(b, dL);
                t++;
                break;
            case(4):
                quit(0, t);
            default:
                quit(1, t);
                break;
       }
    }    
}

// Exit the program, giving a message based on the exit condition
// Transaction amt of -1 indicates a fatal error coming from withdrawal() or deposit()
void quit(int code, int t){
    switch(code){
        case(0):
            printf("%s", "\nThank you for using the ATM\n");
            printf("%d transactions completed\n", t);
            exit(0);
            break;          
        case(1): default:
            printf("%s", "\n Something went wrong.\nThank you for using the ATM\n");
            printf("%d transactions completed/n", t);
            exit(1);
            break;
        case(2):
            printf("%s", "\n Incorrect pin entered too many times\n");
            exit(1);
            break;
        case(3):
            printf("%s", "\n Amount can not be validated\n");
            exit(1);
            break;
        case(4):
            printf("%s", "\n Daily limit for this transaction is exceeded\n");
            exit(1);
            break;
    }
}
// Print the user's balance
void checkBalance(float balance)
{
    printf("Your balance is: %.2f\n", balance);
}

// Withdrawl an amount from the user's balance 
void withdrawal(float *b, float *wL)
{
    int amt = 0;
    unsigned int tries = 0;
    unsigned int res;
    if(*wL <= 0) // daily transaction limit exceeded
        quit(4, TRANERROR);
    printf("%s", "\tYou can withdrawal up to $1000/day\n");
    do
    {
        printf("%s", "\tEnter withdrawal amount in $20 increments: ");
        scanf("%d", &amt);       
        if( amt > 0 && amt % 20 == 0 && amt < *b) // input is valid
        {
            printf("%s", "\n\tProcessing transaction...\n");
            break;
        }

        // test specific cases and give appropriate error messages
        else if (amt <= 0)
        {
            printf("%s", "\n\tThat is not a valid withdrawal amount\n");
        }
        else if (amt % 20 != 0)
        {
            printf("%s", "\n\tWithdrawal amount must be in $20 increments\n");
        }
        else if(amt > *b)
        {    
            printf("%s", "\n\tWithdrawal amount cannot exceed balance\n");
        }
        tries++;

    } while (tries < LOCKOUT); // 3 tries
        
    
    if( tries >= LOCKOUT)  // Too many invalid inputs, quit the program
        quit(3, TRANERROR);
    
    if(*wL >= amt)
    {
        *wL -= amt; // decrease the daily withdrawal limit
        *b -= amt; // decrease balance by amt
        printf("%s", "\tWould you like a receipt(1 = yes, 2 = no)\n");
        scanf("%u", &res);
        if(res == 1)
            printf("%s", "\n\tPrinting receipt...\n");
        printf("%s", "\tReturning to main menu\n");
    }
    else if (*wL < amt)
        printf("%s", "\tThis transaction exceeds the daily limit, returning to main menu\n");
    else
        printf("%s", "\tThat is not a valid amount, returning to main menu\n");
}

// Deposit an amount into the user's balance
void deposit(float *b, float *dL)
{
    int amt = 0;
    unsigned int tries = 0;
    unsigned int res;
    int valid;
    if(*dL <= 0) // daily transaction limit exceeded
        quit(4, TRANERROR);
    printf("%s", "\tYou can deposit up to $10000/day\n");
    do
    {     
        printf("%s", "\tEnter deposit amount: ");
        scanf("%d", &amt);
        if( amt > 0 && amt <= *dL) // input is valid
        {
            printf("%s", "\n\tProcessing transaction...\n");           
            break;
        }
        else if(amt <= 0)
        {
            printf("%s", "\n\tThat is not a valid amount.\n");
        }
        else if(amt > *dL)
        {
            printf("%s", "\n\tDeposit exceeds daily limit\n");
        }
        tries++;

    } while(tries < LOCKOUT); // 3 tries

    if(tries >= LOCKOUT) // Too many invalid inputs, quit the program
        quit(3, TRANERROR);
    
    if(amt > *dL)
        printf("%s", "\tThis transaction exceeds the daily limit, returning to main menu\n");
    else if(amt <= *dL) 
    {
        *dL -= amt; // decrease the daily deposit limit
        *b += amt; // increase balance by amt
        printf("%s", "Would you like a receipt(1 = yes, 2 = no)\n");
        scanf("%u", &res);
        if(res == 1)
            printf("%s", "\n\tPrinting receipt...\n");
        printf("%s", "\tReturning to main menu\n");
    }
    else
        printf("%s", "\tThat is not a valid amount, returning to main menu\n");
}
