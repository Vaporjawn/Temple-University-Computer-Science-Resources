#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <string.h>

struct Person {
    char *name;
    int age;
    int height;
    int weight;
};

/* complete this function, which initialize the fileds of the struct, and return a pointer to the initialzied struct */
struct Person *Person_create(char *name, int age, int height, int weight)
{
    struct Person *who = malloc(sizeof(struct Person));
    assert(who != NULL);
    who->name = name;
    who->age = age;
    who->height = height;
    who->weight = weight;

    return who;
}

/* complete this function, which free memory that was allocated for a struct*/

void Person_destroy(struct Person *who)
{
    assert(who != NULL);
    free(who);


}
/* complete this function, which print the value of member of struct for the input argument */

void Person_print(struct Person *who)
{
  printf("Name: %s \n", who->name);
  printf("Age: %d \n", who->age);
  printf("Height: %d \n", who->height);
  printf("Weight: %d \n", who->weight);
}
/* complete this function, which change the value of filed member of the struct to the value of newName */
void Change_name (struct Person *who, char * newName){
  who->name = newName;
}


int main(int argc, char *argv[])
{
    // make two people structures
    struct Person *joe = Person_create(
            "Joe Alex", 32, 64, 140);

    struct Person *frank = Person_create(
            "Frank Blank", 20, 72, 180);

    // print them out and where they are in memory
    printf("Joe is at memory location %p:\n", joe);
    Person_print(joe);

    printf("Frank is at memory location %p:\n", frank);
    Person_print(frank);

    // make changes in filed of goe's struct print them again
    joe->age += 20;
    joe->height -= 2;
    joe->weight += 40;
    Change_name(joe, "Jack The third Junior Smith Benedickt");
    Person_print(joe);


    // destroy them both so we clean up
    Person_destroy(joe);
    Person_destroy(frank);

    return 0;
}
