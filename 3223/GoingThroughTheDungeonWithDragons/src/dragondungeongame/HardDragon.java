/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragondungeongame;

import javax.swing.JPanel;

/**
 *
 * @author Me
 */
public class HardDragon extends Dragon {

    boolean defeated = false;
    boolean friend = false;

    public HardDragon(String dname) {
        super(dname);
        this.health = 40;
        this.attackPower = 17;
        this.defense = 17;
        this.Difficulty = 3;
    }

    @Override
    public int attack(int playerDefense) {

        int hit;
        int attackNum = rand.nextInt(25) + 17;

        if (attackNum > playerDefense) {
            hit = attackNum - playerDefense;

        } else {
            hit = 0;
        }

        return hit;
    }

    @Override
    public void defeated() {
        if (health == 0) {
            defeated = true;
            System.out.println("The dragon has been defeated!");
        }
    }

    @Override
    public void befriend(boolean won, Player player) {
        if (won == true) {
            friend = true;
            player.attackPower = player.attackPower + 20;
            player.health = player.health + 15;
        }
    }
}
