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

public class BossDragonTest {

    BossDragon boss;
    Player player;
    DragonFight df = new DragonFight();
    
    @Before
    public void setup() {
        boss = new BossDragon("boss", 1);
        player = new Player("player");
    }
    
    //test to see if the player takes damage
    @Test
    public void getHit() {
        int health, hit, hitHealth; 
        
        health = player.health;
        hit = boss.attack(-1);
        hitHealth = health - hit;
        
        assertTrue(health > hitHealth);        
    }
    
    //checks to see if no damage is taken on a missed roll
    @Test
    public void miss(){
        int health, hit, hitHealth; 
        
        health = player.health;
        hit = boss.attack(player.defense + health);
        hitHealth = health - hit;
        System.out.println(hitHealth);
        assertTrue(health == hitHealth); 
    }
    
    //if friends with another dragon, defeatable flag set to true
    @Test
    public void isDefeatable(){
        int d = boss.dragonsDefeated;
        System.out.println(d);
        assertTrue(d > 0);
    }
    
}
