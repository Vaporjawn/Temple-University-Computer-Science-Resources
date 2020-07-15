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
public class TreasureTest {
    
    Player player;
    EasyDragon easy;
    Treasure sleep, food, treasure;
    DragonFight df = new DragonFight();

    @Before
    public void setup() {
        player = new Player("player");
        easy = new EasyDragon("easy");
        sleep = new Treasure("sleep");
        food = new Treasure("food");
        treasure = new Treasure("treasure");
    }

    //sleep improves your health by 10
    @Test
    public void sleepImprovesHealth(){
        int health, augmentedHealth;
        health = player.health + 10;
        
        sleep.PowerUp(player, easy);
        
        augmentedHealth = player.health;
        
        assertEquals(health, augmentedHealth);
    }
    
    //food helps by fifteen
    @Test
    public void foodImprovesHealth(){
        int health, augmentedHealth;
        health = player.health + 15;
        
        food.PowerUp(player, easy);
        
        augmentedHealth = player.health;
        
        assertEquals(health, augmentedHealth);
    }
   
    //treasure helps attack by 10
    @Test
    public void treasureImprovesAttack(){
        int attack, augmentedAttack;
        attack = player.attackPower + 10;
        
        treasure.PowerUp(player, easy);
        
        augmentedAttack = player.attackPower;
        
        assertEquals(attack, augmentedAttack);
    }
    
    @Test
    public void treasureImprovesDefense(){
        int defense, augmentedDefense;
        defense = player.defense + easy.Difficulty * 5;
        
        treasure.PowerUp(player, easy);
        
        augmentedDefense = player.defense;
        
        assertEquals(defense, augmentedDefense);
    }
   
}
