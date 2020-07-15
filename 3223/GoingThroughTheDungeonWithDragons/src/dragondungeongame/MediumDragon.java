package dragondungeongame;

/**
 *
 * @author Me
 */

import java.util.Random;
import javax.swing.JPanel;

public class MediumDragon extends Dragon {
    
    boolean defeated = false;
    boolean friend = false;
    
    Random rand = new Random();

    public MediumDragon(String dname) {
        super(dname);
        this.health = 25;
        this.attackPower = 10;
        this.defense = 10;
        this.Difficulty = 2;
    }
    
    @Override
    public int attack(int playerDefense) {
              
     int hit;        
        int attackNum = rand.nextInt(17)+10;
        
        if(attackNum > playerDefense){
            hit = attackNum - playerDefense;
            
        }
        else{
            hit = 0;
        }
        
        return hit;
    }
    
    @Override
    public void defeated(){
        if (health == 0){
            defeated = true;
            System.out.println("The dragon has been defeated!");
        }
    } 
    
    @Override
    public void befriend(boolean won, Player player){
        if (won == true){
            friend = true;
            player.attackPower = player.attackPower+10;
        }
    }
}
