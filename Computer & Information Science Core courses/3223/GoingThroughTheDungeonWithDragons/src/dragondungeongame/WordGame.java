package dragondungeongame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Me
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class WordGame {
    
    public String level;
    
    
    WordGame(String dlevel){
        level = dlevel;
        
    }
    /**
     * 
     * 
     *
     */
    public Scanner reader = new Scanner(System.in);
    public boolean shouldPlay = true;
    public int qAsked = 0;
    public boolean Win = true;
    public Random rand = new Random();
    public int numOfQs;
    
    public int questionsAsked[] = new int[20];
    
    
       
   
    
    
    
    public String [][] questions = {{"Which of these is an ellipses?", "...", "!", "?", ".", "1"}, //0
                        {"Which word is an antoynm of abnegation?", "self-denial", "austerity", "surrender", "self-indulgence", "4"}, //1
                        {"Who played Mr. Spock in Star Trek: The Original Series?", "William Shatner", "Leonard McCoy", "Leonard Nimoy", "Willam Clinton", "3"},
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
   
    
    public void setLevel(String level){
        
        level = level.toLowerCase();
        
        switch (level) {
            case "easy":
                numOfQs = 3;
                break;
            case "medium":
                numOfQs = 7;
                break;
            case "hard":
                numOfQs = 15;
                break; 
        }
        
    }
    
    public int PresentQuestion(){
        
        int qToAsk = questions.length -1;
        int qnum = rand.nextInt(qToAsk);
        
        //System.out.println("This is the number originally given" + qnum);
   
        while(compareQuestionNumber(qnum)==true){
            
            qnum++;
            if(qnum == (questions.length)){
                qnum = 0;
            }
        }
        
        questionsAsked[qAsked] = qnum;
        
        //System.out.println(Arrays.toString(questionsAsked));
        //System.out.println("I am asking" + qnum);
        
        qAsked++;
        
        System.out.println("\n ************************************ \nThis is your question. \n ************************************ \n" 
                            + questions[qnum][0] 
                            + "\n 1. " + questions[qnum][1]
                            + "\n 2. " + questions[qnum][2]
                            + "\n 3. " + questions[qnum][3]
                            + "\n 4. " + questions[qnum][4]
                            + "\n Choose your answer carefully"    
                
                );
        
        
        
        return qnum;
        
    }
    
    //This method will check if the question has already been asked.    
    public boolean compareQuestionNumber(int number){
        
        
        int i =0;
       
             
        
       while(i<questionsAsked.length){
           if(questionsAsked[i]==number){
               return true;
           }
           else{
               
               i++;
               
           }
       }
        
        
        return false;
    }
    
    //This method will check if the user's answer is correct.
    public boolean CheckAnswer(int questionNumber, int userInput){
        
        String answer = Integer.toString(userInput);
        String correctAnswer = questions[questionNumber][5];
                     
        return answer.equals(correctAnswer);
    }
    
    public boolean Game(){
        System.out.println("\nWelcome, Traveller! \n I see you have bested the beast! It would be in your best interest to befriend her.\n "
                + "Even if she is wounded by you, a simple test can prove your worthiness for her to aid you.\n Trust me. You will need her help.\n"
                + "When presented with a question, please press the key of the corresponding number to the answer you beleive is correct.\n"
                + "If you are incorrect, you will lose any growing trust she might have for you, and will move to the next room without her help. \n \n"
                + "Good luck, Traveller.");
        
        int loop = 0;
        
        setLevel(level);
       
// System.out.println(numOfQs);
        
        while((loop<numOfQs) && (Win == true)){
        
        
            int questionNumber = PresentQuestion();
            int userInput = reader.nextInt();
            Win = CheckAnswer(questionNumber, userInput); 
            
            loop++;
            
        }
        
        //reader.close();
        
        if(Win){
               System.out.println("\nCongratulations! The beast is now on your side!\n"
                       + "She will aid you in fighting the master of the dungeon. \n"
                       + "Good luck, Traveller.");
        }
    return Win;
}
}
                        
                
    
    
    
   
    

