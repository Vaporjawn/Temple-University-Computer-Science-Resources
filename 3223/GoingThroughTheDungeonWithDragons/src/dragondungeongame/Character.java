package dragondungeongame;
/**
 *
 * @author Shannon
 * possible that we need an interface higher than dragon which holds both
 * the player character and the dragon because their attack and defense will
 * probably work similarly to each others sike definitely though 
 * we cant go back on the class diagram
 * ah maybe we want dragon to be a class? dragon and player are each classes
 * that implement the sprite? character? interface
 * sprite controls
 */
public interface Character {
    //name
    //will return the name of the dragon
    public String getName();
    
    public int getHealth();
          
    public int getAttack();
    public int getDefense();
    
    public void takeDamage(int damage);
    //attack //player may take what is returned from here into a damage thing
    //might want to have it initially take the multiplier and attack will have a
    //set amount and powermult multiplies it and amplifies the hit
    //roll random to see if it hits like dd maybe?
    //on each attack the player rolls and if its above a certain amount they hit
    //otherwise they miss the dragons defense thing will take this amount
    public int attack(int Defense);
    //defense//will return int that is the damage done after the dragons defense
    //and the rolled number is put into play //defense int called guard
    //if else for hit, must be above
    //maybe if player picks up certain items it can add a roll to hit to their
    //attack or a roll to hit to their defense, like after the roll its a plus
    //if player has this then they get a plus bonus, that could be a test   
}
