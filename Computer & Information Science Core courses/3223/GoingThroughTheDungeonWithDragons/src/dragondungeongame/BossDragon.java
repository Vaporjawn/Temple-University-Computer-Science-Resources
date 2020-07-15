/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragondungeongame;

/**
 *
 * @author Me
 */

import java.util.Random;
import javax.swing.JPanel;

public class BossDragon extends Dragon{
    
    boolean defeated = false;
    boolean defeatable = false;
    int dragonsDefeated;

    public BossDragon(String dname, int dragonsDefeated) {
        super(dname);
        this.health = 75;
        this.attackPower = 30;
        this.defense = 25;
        this.dragonsDefeated = dragonsDefeated;
        this.Difficulty = 4;
    }
    
    @Override
    public void defeated(){
        if(health<1){
            defeated = true;
        }
        if (health == 0){
            System.out.println("The dragon has been defeated!");
        }
    }
    
    @Override
    public int attack(int playerDefense) {
              
     int hit;        
        int attackNum = rand.nextInt(50)+30;
        
        if(attackNum > playerDefense){
            hit = attackNum - playerDefense;
            
        }
        else{
            hit = 0;
        }
        
        return hit;

    }
    
    public void checkFriend(boolean flagged){
        if (flagged){
            defeatable = true;
            System.out.println("I deem you worthy, traveller");
        } else {
            System.out.println("You're unworthy of my time, perish.");
        }
    }
}
