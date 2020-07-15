/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragondungeongame;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javax.swing.JPanel;

/**
 *
 * @author Me
 */
public class EasyDragon extends Dragon {

    boolean defeated = false;
    boolean friend = false;
   // ByteArrayOutputStream baos;
    //PrintStream ps;
    //PrintStream old;

    public EasyDragon(String dname) {
        super(dname);
        this.health = 10;
        this.attackPower = 5;
        this.defense = 6;
        this.Difficulty = 1;

       // baos = new ByteArrayOutputStream();
        //ps = new PrintStream(baos);
       // old = System.out;
       // System.setOut(ps);
    }

    @Override
    public int attack(int playerDefense) {

        int hit;
        int attackNum = rand.nextInt(10) + 5;

        if (attackNum > playerDefense) {
            hit = attackNum - playerDefense;

        } else {
            hit = 0;
        }

        return hit;
    }

    //when you take this boolean use dragon.defeated as the variable
    @Override
    public void defeated() {
        if (health == 0) {
            defeated = true;
            System.out.println("The dragon has been defeated!");
           // jp.displayText(baos.toString());
        }
    }

    @Override
    public void befriend(boolean won, Player player) {
        if (won == true) {
            friend = true;
            player.attackPower = player.attackPower + 5;
        }
    }
}
