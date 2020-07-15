/* Christopher Scott 9-3-19
   CIS 2017 Lab 2 Paycheck
   "A program to calculate the paycheck of a a Temple employee
    and print to the terminal"
*/

#include <stdio.h>
#include <stdlib.h>

int main(void){
    int empNum;
    float hourlySalary, weeklyTime, ot, regPay, otPay;

    // Ask user for information and validate input
    puts("\nWelcome to \"TEMPLE HUMAN RESOURCES\"\n");
    printf("%s", "\tEnter Employee Number: ");
    scanf("%d", &empNum);
    if(empNum <= 0)
    {
        puts("\n\tThat is not a valid Employee Number.\n\tPlease run the program again\n");
        puts("Thank you for using \"TEMPLE HUMAN RESOURCES\"\n");
        exit(1);
    }

    printf("%s", "\tEnter Hourly Salary: ");
    scanf("%f", &hourlySalary);
    if(hourlySalary <= 0)
    {
        puts("\n\tThat is not a valid hourly salary amount.\n\tPlease run the program again\n");
        puts("Thank you for using \"TEMPLE HUMAN RESOURCES\"\n");
        exit(1);
    }

    printf("%s","\tEnter Weekly Time: ");
    scanf("%f", &weeklyTime);
    if(weeklyTime <= 0)
    {
        puts("\n\tThat is not a weekly time.\n\tPlease run the program again\n");
        puts("Thank you for using \"TEMPLE HUMAN RESOURCES\"\n");
        exit(1);
    }

    // Calculate regular pay and ot pay
    if(weeklyTime > 40.0)
    {
        ot = weeklyTime - 40.0;
    }
    regPay = (weeklyTime - ot)* hourlySalary;
    otPay = 1.5 * ot * hourlySalary;

    // Print out the paycheck
    puts("\t==============================");
    printf("\tEmployee #: %d\n", empNum);
    printf("\tHourly Salary: $%0.2f\n", hourlySalary);
    printf("\tWeekly Time: %0.2f\n", weeklyTime);
    printf("\tRegular Pay: $%0.2f\n", regPay);
    printf("\tOvertime Pay: $%0.2f\n", otPay);
    printf("\tNet Pay: $%0.2f\n", otPay + regPay);
    puts("\t==============================");
    puts("Thank you for using \"TEMPLE HUMAN RESOURCES\"\n");

    exit(0);
}

