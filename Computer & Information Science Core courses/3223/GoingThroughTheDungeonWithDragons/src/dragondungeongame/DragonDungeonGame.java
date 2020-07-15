package dragondungeongame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.util.LinkedList;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DragonDungeonGame {
    
    static StartPage startPage;
    static JFrame frame = new JFrame();
    static boolean finalWin = false;
    Maze maze;
    static DragonFight df = new DragonFight();

    public DragonDungeonGame() {
        // a 9 rows x 10 columns maze
        maze = new Maze(9, 10);

    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

  
        startPage = new StartPage();
        startPage.setVisible(true);
        

        //run();
    }

    /*public static void run() {
        Player Jessica = new Player("Jessica");

        while (Jessica.isAlive && !finalWin) {

            EasyDragon ed = new EasyDragon("Shannon", df);

            while (ed.health > 0) {
                if (ed.greeting()) {
                    Jessica.greeting();
                    int damage = Jessica.attack(ed.defense);
                    ed.takeDamage(damage);
                    ed.defeated();
                    if (ed.defeated) {
                        break;
                    }
                    int dragdamage = ed.attack(Jessica.defense);
                    Jessica.takeDamage(dragdamage);
                    if (!Jessica.isAlive) {
                        break;
                    }
                    ed.greeting();
                } else {
                    Jessica.setDeath();
                    break;
                }
            }

            if (!Jessica.isAlive) {
                break;
            }

            ed.getTreasure();
            ed.tType.PowerUp(Jessica, ed);
            Jessica.greeting();

            WordGame wg = new WordGame("easy");
            boolean eFriend = wg.Game();
            ed.befriend(eFriend, Jessica);

            Jessica.greeting();

            MediumDragon md = new MediumDragon("Alan", df);
            while (md.health > 0) {

                if (md.greeting()) {
                    Jessica.greeting();
                    int damage = Jessica.attack(md.defense);
                    md.takeDamage(damage);
                    md.defeated();
                    if (md.defeated) {
                        break;
                    }
                    int dragdamage = md.attack(Jessica.defense);
                    Jessica.takeDamage(dragdamage);
                    if (!Jessica.isAlive) {
                        break;
                    }
                } else {
                    Jessica.setDeath();
                    break;
                }
            }

            if (!Jessica.isAlive) {
                break;
            }

            md.getTreasure();
            md.tType.PowerUp(Jessica, md);
            Jessica.greeting();

            WordGame wg2 = new WordGame("medium");
            boolean mFriend = wg2.Game();
            md.befriend(mFriend, Jessica);

            Jessica.greeting();

            HardDragon hd = new HardDragon("Rita", df);
            while (hd.health > 0) {

                if (hd.greeting()) {
                    Jessica.greeting();
                    int damage = Jessica.attack(hd.defense);
                    hd.takeDamage(damage);
                    hd.defeated();
                    if (hd.defeated) {
                        break;
                    }
                    int dragdamage = hd.attack(Jessica.defense);
                    Jessica.takeDamage(dragdamage);
                    if (!Jessica.isAlive) {
                        break;
                    }
                } else {
                    Jessica.setDeath();
                    break;
                }
            }

            if (!Jessica.isAlive) {
                break;
            }

            hd.getTreasure();
            hd.tType.PowerUp(Jessica, hd);
            Jessica.greeting();

            WordGame wg3 = new WordGame("hard");
            boolean hFriend = wg3.Game();
            hd.befriend(hFriend, Jessica);

            Jessica.greeting();

            if (ed.friend || md.friend || hd.friend) {
                BossDragon bd = new BossDragon("Software Design", df, 1);
                while (bd.health > 0) {

                    if (bd.greeting() && bd.health > 0) {
                        Jessica.greeting();
                        int damage = Jessica.attack(bd.defense);
                        bd.takeDamage(damage);
                        bd.defeated();
                        if (bd.defeated) {
                            break;
                        }
                        int dragdamage = bd.attack(Jessica.defense);
                        Jessica.takeDamage(dragdamage);
                        if (!Jessica.isAlive) {
                            break;
                        }
                    } else {
                        Jessica.setDeath();
                        break;
                    }
                }
                finalWin = bd.defeated;
            } else {
                System.out.println("\nYou are not worthy to fight me, the BO$$ dragon.");
                Jessica.setDeath();
            }

            if (!Jessica.isAlive) {
                break;
            }

        }

        if (finalWin) {
            System.out.println("Congrats! YOu have defeated the Bo$$ Dragon!!!");
        }

        if (Jessica.health < 1) {

            System.out.println("You have lost");

        } else {
            System.out.println("Congrast! You have won!");
        }
    }*/

}
