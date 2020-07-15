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

/**
 *
 * @author Me
 */

public class WordGameTest {
    
    public WordGameTest() {
    }
    
    WordGame instance = new WordGame("easy");
    
    @BeforeClass
    public static void setUpClass() {
        
    
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setLevel method, of class WordGame.
     */
    @Test
    public void testSetLevel() {
        System.out.println("setLevel");
        instance.setLevel(instance.level);
        assertEquals(instance.numOfQs, 3);

    }

    /**
     * Test of PresentQuestion method, of class WordGame.
     */
    @Test
    public void testPresentQuestion() {
        System.out.println("PresentQuestion");
        
            WordGame instance2 = new WordGame("easy");
            boolean okay = false;
        
        instance2.PresentQuestion();
        instance2.PresentQuestion();
        
        if(instance2.questionsAsked != null){
            okay = true;
        }
        
        assertTrue("There have been questions asked", okay);
        
        
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of compareQuestionNumber method, of class WordGame.
     */
    @Test
    public void testCompareQuestionNumber() {
        System.out.println("compareQuestionNumber");
    
        WordGame instance3 = new WordGame("easy");
        
        instance3.questionsAsked[3] = 4;
        
                   
                       
        int number = 4;
        boolean expResult = false;
        boolean result = instance.compareQuestionNumber(4);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of CheckAnswer method, of class WordGame.
     */
    @Test
    public void testCheckAnswer() {
        System.out.println("CheckAnswer");
        int questionNumber = 1;
        int userInput = 4;
        boolean expResult = true;
        boolean result = instance.CheckAnswer(questionNumber, userInput);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of Game method, of class WordGame.
     */
   
        
// TODO review the generated test code and remove the default call to fail.

    }
    

