package dragondungeongame;

import java.awt.Graphics;

public class DragonFight extends javax.swing.JPanel {

    String test = "Click anywhere to begin the trivia game.";
    private String textDisplay = null;
    WordGame wg = new WordGame("easy");
    int x = 0, y = 0;

    public String[][] questions = {{"Which of these is an ellipses?", "...", "!", "?", ".", "1"}, //0
    {"Which word is an antoynm of abnegation?", "self-denial", "austerity", "surrender", "self-indulgence", "4"}, //1
    {"Who played Mr. Spock in Star Trek: The Original Series?", "William Shatner", "Leonard McCoy", "Leonard Nimoy", "Willam Clinton", "3"},
    {"Should Karl make jerk chicken for the class?", "Definitely", "Why hasn't he yet?", "Uh, no.", "What about the vegans?", "2"},
    {"In November 2017, a trailer was released for the Incredibles 2. \n In what month did the trailer say the movie was to come out?", "November", "December", "June", "July", "3"},
    {"Who wrote the novel, Perelandra?", "C.S. Lewis", "Lemony Snickett", "J.R.R Tolkien", "Charles Dickens", "1"},//5
    {"Who is the creator of Star Trek?", "Gene Roddenberry", "George Lucas", "Mike George", "JJ Abrams", "1"},
    {"Who is the CEO of QVC?", "George Lucas", "George Smith", "Mike George", "Josh George", "3"},
    {"Which of the Pevensie children meets the White Witch first?", "Lucy", "Peter", "Edmund", "Susan", "3"},//8
    {"Who sings 'Oops, I did it again'?", "Rihanna", "Britney Spears", "Gwen Stefani", "Jessica Simpson", "2"},
    {"Who plays Barney on The Andy Griffith Show?", "Andy Griffith", "Andy Taylor", "Barney Fife", "Don Knotts", "4"},//10
    {"True or False: The brand Mt. Olive sells pickles", "true", "false", "3", "4", "1"},
    {"Which of these movies/series did John Williams not compose the soundtrack for?", "Star Wars", "Home Alone", "Jurassic Park", "Lord of the Rings", "4"},
    {"Which of these is not a flavor offered by Jarritos?", "Tamarind", "Orange", "Hibiscus", "Cantaloupe", "4"}, //13
    {"What Disney movie is known to have the song 'Hakuna Matata'", "The Lion King", "The Fox and the Hound", "Bambi", "Lady and the Tramp", "1"},
    {"What country has the second largest population?", "Russia", "Australia", "China", "India", "4"}, //15
    {"Who sings 'The Piano Man?'", "Billy Joel", "Bono", "Journey", "Bruce Springsteen", "1"},
    {"Who did Anne Hathaway play in the Princess Diaries?", "Princess Maya", "Princess Merida", "Princess Mia", "Princess Mary", "3"},
    {"What is a drawback to using a Linked List?", "Nothing. It is a very useful data structure.", "You can't randomly access an element, and must traverse the entire structure.", "It wastes a lot of memory.", "It's really annoying to use.", "2"},
    {"Which of these is not a feline?", "Tiger", "Lion", "Cougar", "Wolf", "4"}, //19
    {"Who is the fourth president of the United States?", "James Madison", "Thomas Jefferson", "Benjamin Franklin", "James Polk", "1"},
    {"Which MLB pitcher has the most career wins?", "Babe Ruth", "Cy Young", "Nolan Ryan", "Randy Johnson", "2"},
    {"Which of these is not a famous viner?", "Logan Paul", "Lele Pons", "King Bach", "Smosh", "4"},
    {"Who was the first winner of American Idol?", "Carrie Underwood", "Kelly Clarkson", "Katherine McPhee", "Kelli Pickler", "2"},
    {"What flavor is not in Neapolitan ice cream?", "Strawberry", "Chocolate", "Vanilla", "Mango", "4"},
    {"Where did French Fries originate?", "France", "Italy", "England", "Belgium", "4"}, //25
    {"What is in Neapolitan ice cream?", "French Vanilla", "Vanilla", "Vanilla Bean", "Classic Vanilla", "2"},
    {"Who plays Aslan in the 2006 remake of the Lion, the Witch, and the Wardrobe?", "Morgan Freeman", "Liam Neeson", "Alan Rickman", "James Earl Jones", "2"},
    {"Who plays Captain America?", "Chris Evans", "Chris Pine", "Chris Pratt", "Chris Hemsworth", "1"},
    {"Who plays Thor?", "Chris Evans", "Chris Pine", "Chris Pratt", "Chris Hemsworth", "4"},
    {"Who plays Star Lord?", "Chris Evans", "Chris Pine", "Chris Pratt", "Chris Hemsworth", "3"}, //30
    {"Who plays Captain Kirk?", "Chris Evans", "Chris Pine", "Chris Pratt", "Chris Hemsworth", "2"}

    };

    public DragonFight() {
        initComponents();
        displayText(test);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        screentext = new javax.swing.JScrollPane();
        screentextarea = new javax.swing.JTextArea();
        triviabg = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setPreferredSize(new java.awt.Dimension(630, 700));
        setLayout(null);

        jButton1.setText("Choice 1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(110, 580, 150, 23);

        jButton2.setText("Choice 2");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(370, 580, 150, 23);

        jButton3.setText("Choice 3");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(110, 610, 150, 23);

        jButton4.setText("Choice 4");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(370, 610, 150, 23);

        screentext.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        screentext.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        screentext.setOpaque(false);

        screentextarea.setBackground(new java.awt.Color(0, 0, 0));
        screentextarea.setColumns(20);
        screentextarea.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        screentextarea.setForeground(new java.awt.Color(0, 102, 102));
        screentextarea.setRows(5);
        screentextarea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        screentextarea.setOpaque(false);
        screentext.setViewportView(screentextarea);

        add(screentext);
        screentext.setBounds(110, 500, 410, 60);

        triviabg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BossDragon1.png"))); // NOI18N
        triviabg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                triviabgMouseClicked(evt);
            }
        });
        add(triviabg);
        triviabg.setBounds(0, 0, 630, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void triviabgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_triviabgMouseClicked
        iterateThroughText();
        if (x < questions.length - 1) {
            x++;
        }

    }//GEN-LAST:event_triviabgMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if ((questions[x - 1][5]).equals("1")) {
            iterateThroughText();
        } else {
            setVisible(false);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if ((questions[x - 1][5]).equals("2")) {
            iterateThroughText();
        } else {
            setVisible(false);
        }
     }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        if ((questions[x - 1][5]).equals("3")) {
            iterateThroughText();
        } else {
            setVisible(false);
        }
     }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
         if ((questions[x - 1][5]).equals("4")) {
            iterateThroughText();
        } else {
            setVisible(false);
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    public void iterateThroughText() {
        textDisplay = questions[x][0];
        displayText(textDisplay);
        jButton1.setText(questions[x][1]);
        jButton2.setText(questions[x][2]);
        jButton3.setText(questions[x][3]);
        jButton4.setText(questions[x][4]);

    }

    public void displayText(String text) {
        screentextarea.setText(text);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane screentext;
    private javax.swing.JTextArea screentextarea;
    private javax.swing.JLabel triviabg;
    // End of variables declaration//GEN-END:variables
}
