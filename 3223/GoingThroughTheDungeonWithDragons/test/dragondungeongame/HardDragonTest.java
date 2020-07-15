/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragondungeongame;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Shannon
 */
public class HardDragonTest {
    
HardDragon hard;
Player player;
WordGame wg;
    DragonFight df = new DragonFight();

    
    @Before
    public void setup() {
        hard = new HardDragon("hard");
        player = new Player("player");
        wg = new WordGame("hard");
    }
    
    //test to see if the player takes damage
    @Test
    public void getHit() {
        int health, hit, hitHealth; 
        
        health = player.health;
        hit = hard.attack(-1);
        hitHealth = health - hit;
        
        assertTrue(health > hitHealth);        
    }
    
    //checks to see if no damage is taken on a missed roll
    @Test
    public void miss(){
        int health, hit, hitHealth; 
        
        health = player.health;
        hit = hard.attack(player.defense + health);
        hitHealth = health - hit;
        System.out.println(hitHealth);
        assertTrue(health == hitHealth); 
    }
    
    //if won word game, friend flag set to true
    @Test
    public void weFriends(){
        boolean test;
        
        hard.befriend(true, player);
        test = hard.friend;
        
        assertEquals(test, true);
    }
       
}
