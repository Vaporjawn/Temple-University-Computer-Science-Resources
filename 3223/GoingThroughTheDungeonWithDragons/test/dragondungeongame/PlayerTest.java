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
public class PlayerTest {
    
Player player;
EasyDragon easy;
    DragonFight df = new DragonFight();

    
    @Before
    public void setup() {
        player = new Player("player");
        easy = new EasyDragon("easy");
    }
    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Player instance = player;
        String expResult = "player";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHealth method, of class Player.
     */
    @Test
    public void testGetHealth() {
        System.out.println("getHealth");
        Player instance = player;
        int expResult = player.health;
        int result = instance.getHealth();
        assertEquals(expResult, result);
    }

    /**
     * Test of attack method, of class Player.
     */
    @Test
    public void testAttack() {
        System.out.println("attack");
        int before = easy.health;
        int hit = player.attack(easy.defense);
        int after = before - hit;
        assertTrue(before > after);
    }
    
    //if player won the word game, attack was increased
    @Test
    public void damageTaken(){
        int before = player.health;
        player.takeDamage(15);
        int after = player.health;
        assertTrue(before > after);
    }    
    
   @Test
   public void isDead(){
       boolean test = player.isAlive;
       player.setDeath();
       boolean test2 = player.isAlive;
       assertTrue(test != test2);
   }
}
