/*
  CIS 2107 Section 4 
  Lab 2 Revenue
  Christopher Scott 9-6-19
  "A program to calculate the revenue from a sale based on the unit price
  and quantity of a product input by the user."
*/
#include <stdio.h>
#include <stdlib.h>

int main()
{
    float itemPrice, discount, cost;
    int quantity;

    puts("\nWelcome to \"Temple\" store\n");

    // Get user input and validate
    printf("%s", "\tEnter item price: ");
    scanf("%f", &itemPrice);

    if(itemPrice <= 0)
    {
        printf("%s", "\n\tThis is not a valid item price.\n");  
        printf("%s", "\tPlease run the program again\n");
        puts("\nThank You for using the \"Temple\" store");
        exit(1);
    }

    printf("%s", "\tEnter quantity: ");
    scanf("%d", &quantity);
    if(quantity <= 0)
    {
        printf("%s", "\n\tThis is not a valid quantity order.\n"); 
        printf("%s", "\tPlease run the program again\n");
        puts("\nThank You for using the \"Temple\" store");
        exit(1);
    }

    // Calculate discount and cost
        if(quantity >= 150)
            discount = 0.25;
        else if (quantity >= 100 && quantity <= 149)
            discount = 0.15;
        else if (quantity >= 50 && quantity <= 99)
            discount = 0.1;
        else
            discount = 0.0;

    cost = itemPrice * quantity;

    // Print output
    printf("\tThe item price is: $%.2f\n", itemPrice);
    printf("\tThe order is: %d item(s)\n", quantity);
    printf("\tThe cost is: $%.2f\n", cost);
    printf("\tThe discount is: %.1f\%%\n", discount * 100);
    printf("\tThe discount amount is: $%.2f\n", cost * discount);
    printf("\tThe total is: $%.2f\n", cost - (cost * discount));
    puts("\nThank you for using the \"Temple\" store");
    exit(0);
}

