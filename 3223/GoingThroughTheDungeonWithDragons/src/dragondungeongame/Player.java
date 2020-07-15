package dragondungeongame;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Shannon
 */
public class Player implements Character {

    public String name;
    public int health = 100;
    public int attackPower = 5;
    public int defense = 5;
    public Random rand = new Random();
    public boolean isAlive = true;
    public boolean friend = false;

    private static int x = 35/2;
    private static int y = 0;
    private static Image front = new ImageIcon("images/Sprites/sprite1.png").getImage();
    private static Image front1 = new ImageIcon("images/Sprites/sprite2.png").getImage();
    private static Image front2 = new ImageIcon("images/Sprites/sprite3.png").getImage();
    private static Image right = new ImageIcon("images/Sprites/sprite4.png").getImage();
    private static Image right1 = new ImageIcon("images/Sprites/sprite5.png").getImage();
    private static Image left = new ImageIcon("images/Sprites/sprite6.png").getImage();
    private static Image left1 = new ImageIcon("images/Sprites/sprite7.png").getImage();

    public Player(String name) {
        this.name = name;

    }


    public void greeting() {
        if (health < 0) {
            health = 0;
        }
        System.out.println("\n\n" + name + "! Your health is " + health + " \n Your power is " + attackPower
                + " \n Your defense is " + defense);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setDeath() {
        isAlive = false;
        health = 0;
        System.out.println("\n\nThe dragon has killed you.");

    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return attackPower;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int attack(int Defense) {
        int hit;
        int attackNum = rand.nextInt(this.attackPower + 10) + this.attackPower;

        if (attackNum > Defense) {
            hit = attackNum - Defense;

        } else {
            hit = 0;
        }

        return hit;
    }

    @Override
    public void takeDamage(int damage) {
        health = health - damage;
        if (health < 1) {
            isAlive = false;
        }
    }
    
 

    public static void setX(int i) {
        x = x - i;
    }

    public static int getX() {
        return x;
    }
       
    public static int getY() {
        return y;
    }
    
    public static Image getImage() {
        return front;
    }

}
