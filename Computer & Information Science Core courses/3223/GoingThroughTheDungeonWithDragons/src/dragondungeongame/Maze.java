package dragondungeongame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
//import javax.swing.Timer;

public class Maze extends JFrame implements ActionListener {

    private final int DEFAULTCHAMBERSIZE = 35;

    //
    private int[][] theMaze;    // the maze, containing chambers
    private JPanel mazePanel;
    private Container cp;
    private long count;
    int chamberSize;
    boolean finalWin = false;

    int dx = 0, dy = 0;
    int velx = 0, vely = 0;

    // -------------------------------------------------------------------------
    // inner class MyPanel
    // -------------------------------------------------------------------------
    private class MyPanel extends JPanel implements KeyListener, ActionListener {

        ArrayList<Line2D> rightlinelist;
        ArrayList<Line2D> leftlinelist;
        ArrayList<Line2D> uplinelist;
        ArrayList<Line2D> downlinelist;

        BufferedImage img, img2 = null, east = null, west = null, north = null, south = null;
        Timer t;
        Image front = new ImageIcon("images/Sprites/sprite1.png").getImage();
        Image front1 = new ImageIcon("images/Sprites/sprite2.png").getImage();
        Image front2 = new ImageIcon("images/Sprites/sprite3.png").getImage();
        Image right = new ImageIcon("images/Sprites/sprite4.png").getImage();
        Image right1 = new ImageIcon("images/Sprites/sprite5.png").getImage();
        Image left = new ImageIcon("images/Sprites/sprite6.png").getImage();
        Image left1 = new ImageIcon("images/Sprites/sprite7.png").getImage();
        Line2D l1, l2, l3, l4;

        Image image = front;

        boolean first = false;
        Rectangle r = new Rectangle(dx, dy, 70, 70);
        Rectangle r2 = new Rectangle(70 * (10 - 1), 70 * (9 - 1), 35 * 2, 35 * 2);

        int move = DEFAULTCHAMBERSIZE * 2;

        public MyPanel() {
            t = new Timer(250, this);

            int noRows = theMaze.length;
            int noColumns = theMaze[0].length;

            chamberSize = DEFAULTCHAMBERSIZE;
            if (Math.max(noRows, noColumns) < 100) {
                chamberSize = DEFAULTCHAMBERSIZE * 2;
            } else if (Math.max(noRows, noColumns) > 200) {
                chamberSize = DEFAULTCHAMBERSIZE / 2;
            }

            t.start();
            rightlinelist = new ArrayList<>();
            leftlinelist = new ArrayList<>();
            uplinelist = new ArrayList<>();
            downlinelist = new ArrayList<>();

            setPreferredSize(new Dimension(noColumns * chamberSize, noRows * chamberSize));
            addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int noRows = theMaze.length;
            int noColumns = theMaze[0].length;
            Color color;

            try {
                img = ImageIO.read(new File("images/DungeonWall1.jpg"));
                img2 = ImageIO.read(new File("images/DungeonWall2.jpg"));

            } catch (IOException ex) {
                Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (int r = 0; r < noRows; r++) {
                for (int c = 0; c < noColumns; c++) {

                    int w = theMaze[r][c];
                    int posX = c * chamberSize;
                    int posY = r * chamberSize;

                    if ((w & 0x20) != 0) {
                        color = Color.GREEN;
                    } // the exit
                    else if ((w & 0x10) != 0) {
                        color = Color.RED;
                    } // path
                    else {
                        color = Color.ORANGE;
                    }

                    if (color == Color.ORANGE) {
                        g.drawImage(img2, posX, posY, chamberSize, chamberSize, this);
                    } else if (color == Color.GREEN) {
                        g.drawImage(img2, posX, posY, chamberSize, chamberSize, this);
                    } else {
                        g.setColor(color);
                        g.fillRect(posX, posY, chamberSize, chamberSize);
                    }

                    // the walls
                    g.setColor(Color.WHITE);
                    Graphics2D g2 = (Graphics2D) g;

                    int cs = chamberSize - 1;

                    if ((w & 1) == 1) {
                        //g2.drawLine(posX, posY, posX + cs, posY);
                        l1 = new Line2D.Double(posX, posY, posX + cs, posY);
                        downlinelist.add(l1);
                        g2.draw(l1);
                    }

                    if ((w & 2) == 2) {
                        //g2.drawLine(posX, posY, posX, posY + cs);
                        l2 = new Line2D.Double(posX, posY, posX, posY + cs);
                        leftlinelist.add(l2);
                        g2.draw(l2);
                    }

                    if ((w & 4) == 4) {
                        //g2.drawLine(posX, posY + cs, posX + cs, posY + cs);
                        l3 = new Line2D.Double(posX, posY + cs, posX + cs, posY + cs);
                        uplinelist.add(l3);
                        g2.draw(l3);

                    }

                    if ((w & 8) == 8) {
                        //g2.drawLine(posX + cs, posY, posX + cs, posY + cs);
                        l4 = new Line2D.Double(posX + cs, posY, posX + cs, posY + cs);
                        g2.draw(l4);
                        rightlinelist.add(l4);

                    }
                }
            }

            Graphics2D g3 = (Graphics2D) g;

            r.setBounds(dx, dy, 70, 70);
            g.drawImage(image, dx, dy, this);
            g3.setColor(Color.GREEN);
            g3.draw(r);
            g3.setColor(Color.RED);
            g3.draw(r2);

            //System.out.println("Image pos dx: " + dx + "\nImage pos dy: " + dy);
        }

        public void actionPerformed(ActionEvent e) {
            dx = dx + velx;
            dy = dy + vely;
            repaint();
        }

        public void up() {
            //System.out.println("Checking UP move for: posX: " + dx + " posY: " + (dy - move));
            if (!thereIsAWall(dx, dy, 0)) {
                vely = -move;
                velx = 0;
            }
        }

        public void down() {
            //System.out.println("Checking DOWN move for: posX: " + dx + " posY: " + (dy + move));

            if (!thereIsAWall(dx, dy, 1)) {
                vely = move;
                velx = 0;
            }
        }

        public void left() {
            //System.out.println("Checking LEFT move for: posX: " + (dx - move) + " posY: " + dy);

            if (!thereIsAWall(dx, dy, 2)) {

                vely = 0;
                velx = -move;
            }
        }

        public void right() {
            //System.out.println("Checking RIGHT move for: posX: " + (dx + move) + " posY: " + dy);

            if (!thereIsAWall(dx, dy, 3)) {
                vely = 0;
                velx = move;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_UP) {

//                if (!checkForWall(dx, dy, 0)) {
//                    up();
//                }
                up();

                image = front2;
            }

            if (key == KeyEvent.VK_DOWN) {

//                if ((!checkForWall(dx, dy, 1))) {
//                    down();
//                }
                down();
                image = front1;
            }

            if (key == KeyEvent.VK_LEFT) {

//                if (!checkForWall(dx, dy, 2)) {
//                    left();
//                }
                left();
                image = left;
            }

            if (key == KeyEvent.VK_RIGHT) {
//                if ((!checkForWall(dx, dy, 3))) {
//                    right();
//                }
                right();
                image = right;
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_UP) {
                image = front1;
            }

            if (key == KeyEvent.VK_DOWN) {
                image = front2;
            }

            if (key == KeyEvent.VK_LEFT) {
                image = left1;
            }

            if (key == KeyEvent.VK_RIGHT) {
                image = right1;
            }
            
            if(getToExit(dx, dy)){
                //setVisible(false);
            }
            velx = 0;
            vely = 0;

            dx = r.getBounds().x;
            dy = r.getBounds().y;
            //System.out.println("pos x: " + dx + " pos y: " + dy);
            //System.out.println("------------------------------");

            repaint();

        }

        public boolean getToExit(int x, int y) {
            if (r.intersects(r2)) {
                System.out.println("Reached exit!");
                runGame(finalWin);
                return true;
            }
            return false;
        }

        public boolean thereIsAWall(int x, int y, int dir) {
            int noRows = theMaze.length;
            int noColumns = theMaze[0].length;
            /*
            System.out.println("At position: ");
            System.out.println("pos x: " + dx / 70 + " pos y: " + dy / 70);
            System.out.println("-------------------");
            System.out.println("Checking for: ");
            System.out.println("pos x: " + x / 70 + " pos y: " + y / 70);
            */
            for (int r = 0; r < noRows; r++) {
                for (int c = 0; c < noColumns; c++) {
                    if (c == (x / 70) && r == (y / 70)) {
                        if (dir == 0) {
                            //System.out.println("Going north: " + hasNorthWall(r, c));
                            return hasNorthWall(r, c);
                        } else if (dir == 1) {
                            //System.out.println("Going south: " + hasSouthWall(r, c));
                            return hasSouthWall(r, c);
                        } else if (dir == 2) {
                            //System.out.println("Going west: " + hasWestWall(r, c));

                            return hasWestWall(r, c);
                        } else {
                            //System.out.println("Going east: " + hasEastWall(r, c));

                            return hasEastWall(r, c);
                        }
                    }
                }
            }

            return false;

        }

    }
    // -------------------------------------------------------------------------

    // -------------------------
    // Constructor
    // -------------------------
    public Maze(int r, int c) {
        super("The Maze");
        //t.start();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        JButton b1 = new JButton("New Maze");
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        cp.add(b1, BorderLayout.SOUTH);

        generate(r, c);  // generate maze, draw it on panel, pack

        setVisible(true);
    }

    public int getMazeData(int r, int c) {
        return (theMaze[r][c]);
    }

    public boolean hasNorthWall(int r, int c) {
        return ((getMazeData(r, c) & 1) != 0);
    }

    public boolean hasWestWall(int r, int c) {
        return ((getMazeData(r, c) & 2) != 0);
    }

    public boolean hasSouthWall(int r, int c) {
        return ((getMazeData(r, c) & 4) != 0);
    }

    public boolean hasEastWall(int r, int c) {
        return ((getMazeData(r, c) & 8) != 0);
    }

    public boolean isExit(int r, int c) {
        return ((getMazeData(r, c) & 32) != 0);
    }

    // -------------------------
    // Maze Generation Entry
    // -------------------------
    public boolean generate(int rows, int columns) {
        // initialize: all walls up, path=false => 0x0f
        theMaze = new int[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                theMaze[r][c] = 0x0f;
            }
        }

        // pick a start point
        int startR = (int) Math.floor(Math.random() * rows);
        int startC = (int) Math.floor(Math.random() * rows);
        count = 0;

        // and generate
        boolean done = false;
        try {
            generateRec(startR, startC, 0);
            // set exit point to 0,0
            theMaze[0][0] |= 0x20;      // 0x20: exit
            mazePanel = new MyPanel();      // create and add new panel
            done = true;
        } catch (Exception er) {
            mazePanel = new JPanel();
            mazePanel.setPreferredSize(new Dimension(500, 300));
            mazePanel.add(new Label("Sorry, size is too big: Stack Overflow"));
            done = false;
        } finally {
            // add panel to frame
            if (mazePanel != null) {
                cp.remove(mazePanel);
            }
            cp.add(mazePanel, BorderLayout.CENTER);
            pack();
            repaint();
        }

        return false;
    }

    // -------------------------
    // Recursive Maze Generation
    // -------------------------
    private void generateRec(int r, int c, int direction) {
        // tear down wall towards source direction
        switch (direction) {
            case 1:
                theMaze[r][c] -= 4;
                break;
            case 2:
                theMaze[r][c] -= 8;
                break;
            case 4:
                theMaze[r][c] -= 1;
                break;
            case 8:
                theMaze[r][c] -= 2;
                break;
        }
        count++;        // another chamber processed.

        // where to go now ?
        int noRows = theMaze.length;
        int noColumns = theMaze[0].length;

        // base case 1: all chambers finished
        if (count == noRows * noColumns) {
            return;
        }

        // recursive case: while there are walkable directions: walk
        while (true) {
            // find walkable directions
            boolean dir1, dir2, dir4, dir8;
            dir1 = dir2 = dir4 = dir8 = false;
            if (r > 0 && (theMaze[r - 1][c] == 0x0f)) {
                dir1 = true;
            }
            if (c > 0 && (theMaze[r][c - 1] == 0x0f)) {
                dir2 = true;
            }
            if (r < noRows - 1 && (theMaze[r + 1][c] == 0x0f)) {
                dir4 = true;
            }
            if (c < noColumns - 1 && (theMaze[r][c + 1] == 0x0f)) {
                dir8 = true;
            }

            // base case 2: no walkable directions left
            if ((dir1 | dir2 | dir4 | dir8) == false) {
                break;
            }

            boolean picked = false;
            do {
                int d = (int) Math.floor(Math.random() * 4); // direction 0-3
                switch (d) {
                    case 0:
                        if (dir1) {
                            picked = true;
                            theMaze[r][c] -= 1;
                            generateRec(r - 1, c, 1);
                            dir1 = false;
                            break;
                        }
                    case 1:
                        if (dir2) {
                            picked = true;
                            theMaze[r][c] -= 2;
                            generateRec(r, c - 1, 2);
                            dir2 = false;
                            break;
                        }
                    case 2:
                        if (dir4) {
                            picked = true;
                            theMaze[r][c] -= 4;
                            generateRec(r + 1, c, 4);
                            dir4 = false;
                            break;
                        }
                    case 3:
                        if (dir8) {
                            picked = true;
                            theMaze[r][c] -= 8;
                            generateRec(r, c + 1, 8);
                            dir8 = false;
                            break;
                        }
                }
            } while (!picked);
        }
        // base case2n cont'd: no more walkable directions left

        for (int i = 0; i < theMaze.length; i++) {
            for (int j = 0; j < theMaze[i].length; j++) {
           //     System.out.print(theMaze[i][j] + " ");
            }
         //   System.out.println();
        }
       // System.out.println("-------------------------------");
        return;

    }

    // ---------------------------
    // toString: returns maze data
    // ---------------------------
    public String toString() {
        int noRows = theMaze.length;
        int noColumns = theMaze[0].length;

        String s = "";
        for (int r = 0; r < noRows; r++) {
            for (int c = 0; c < noColumns; c++) {
                s = s + theMaze[r][c] + " ";
            }
            s = s + "\n";
        }
        return (s);
    }

    // ---------------------------------
    // Action Performed
    // --------------------------------
    public void actionPerformed(ActionEvent e) {
        int noRows = theMaze.length;
        int noColumns = theMaze[0].length;
        generate(noRows, noColumns);

    }
    
     public void runGame(boolean finalWin){
         
      
         Player Jessica = new Player("Jessica");
         
        
         
         while(Jessica.isAlive && !finalWin){
             
             
             EasyDragon ed = new EasyDragon("Shannon");
             
             while(ed.health > 0){
                 if(ed.greeting()){
                   Jessica.greeting();
                   int damage = Jessica.attack(ed.defense);
                   ed.takeDamage(damage);
                   ed.defeated();
                   if(ed.defeated){
                       break;
                   }
                   int dragdamage = ed.attack(Jessica.defense);
                   Jessica.takeDamage(dragdamage);
                   if(!Jessica.isAlive){
                       break;
                   }
                   ed.greeting();
               }

                else{
                     Jessica.setDeath();
                     break;
                 }
             }
             
             
             
             if(!Jessica.isAlive){
                       break;
                   }

                 ed.getTreasure();
                 ed.tType.PowerUp(Jessica, ed);
                 Jessica.greeting();
                 
                 WordGame wg = new WordGame("easy");
                 boolean eFriend = wg.Game();
                 ed.befriend(eFriend, Jessica);
                                
                 Jessica.greeting();
                 
               
                        
             MediumDragon md = new MediumDragon("Alan");
             while(md.health > 0){
                                                
                 if(md.greeting()){
                   Jessica.greeting();
                   int damage = Jessica.attack(md.defense);
                   md.takeDamage(damage);
                   md.defeated();
                   if(md.defeated){
                       break;
                   }
                   int dragdamage = md.attack(Jessica.defense);
                   Jessica.takeDamage(dragdamage);
                   if(!Jessica.isAlive){
                       break;
                   }
               }
                 else{
                     Jessica.setDeath();
                     break;
                 }
             }
             
             if(!Jessica.isAlive){
                       break;
                   }
             
                 md.getTreasure();
                 md.tType.PowerUp(Jessica, md);
                 Jessica.greeting();
                 

                 WordGame wg2 = new WordGame("medium");
                 boolean mFriend = wg2.Game();
                 md.befriend(mFriend, Jessica);
                                   
                 Jessica.greeting();
                 
             
                HardDragon hd = new HardDragon("Rita");
                while(hd.health > 0){
                 
                                
                 if(hd.greeting()){
                   Jessica.greeting();
                   int damage = Jessica.attack(hd.defense);
                   hd.takeDamage(damage);
                   hd.defeated();
                   if(hd.defeated){
                       break;
                   }
                   int dragdamage = hd.attack(Jessica.defense);
                   Jessica.takeDamage(dragdamage);
                   if(!Jessica.isAlive){
                       break;
                   }
               }
                   else{
                     Jessica.setDeath();
                     break;
                 }
             }
             
             if(!Jessica.isAlive){
                       break;
                   }
             
                 hd.getTreasure();
                 hd.tType.PowerUp(Jessica, hd);
                 Jessica.greeting();
                 

                 WordGame wg3= new WordGame("hard");
                 boolean hFriend = wg3.Game();
                 hd.befriend(hFriend, Jessica);
                          
                 Jessica.greeting();
                 
             
        if(ed.friend||md.friend||hd.friend){
             BossDragon bd = new BossDragon("Software Design", 1);
             while(bd.health > 0){
                                            
                 if(bd.greeting()&&bd.health>0){
                   Jessica.greeting();
                   int damage = Jessica.attack(bd.defense);
                   bd.takeDamage(damage);
                   bd.defeated();
                   if(bd.defeated){
                       break;
                   }
                   int dragdamage = bd.attack(Jessica.defense);
                   Jessica.takeDamage(dragdamage);
                   if(!Jessica.isAlive){
                       break;
                   }
               }
                else{
                     Jessica.setDeath();
                     break;
                 }       
             }
           finalWin = bd.defeated;
        }
          
        else{
            System.out.println("\nYou are not worthy to fight me, the BO$$ dragon.");
            Jessica.setDeath();
        }
      
        
        if(!Jessica.isAlive){
                       break;
                   }
              
          
             }
             
         if(finalWin){
             System.out.println("Congrats! YOu have defeated the Bo$$ Dragon!!!");
         }
         
         if(Jessica.health <1){
             
             System.out.println("You have lost");
             System.exit(0);
             
         }
         else{
             System.out.println("Congrats! You have won!");
                          System.exit(0);

         }
     } 
    
  
    
    
}
