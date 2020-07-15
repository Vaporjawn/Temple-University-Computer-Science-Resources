package stringPractice1068;

public class SomePracticeStringMethods {
    /* 
     * returns true if c is a letter in the word "temple" or false otherwise
     */
    public static boolean inTU(char c) 
    {
    	if(c == 't' || c == 'T') return true;
    	if(c == 'e' || c == 'E') return true;
    	if(c == 'm' || c == 'M') return true;
    	if(c == 'p' || c == 'P') return true;
    	if(c == 'l' || c == 'L') return true;
    	else return false;
    }
    
    /*
     * returns the index of the first occurrence of in s
     * of a letter in the word "temple" or
     * -1 if s contains no letters in the word "temple"
     */
    public static int indexOfFirstTULetter(String s) 
    {
    	String temple = "templeTEMPLE";
    	int length = s.length();
    	int a = 0;
    	while(length > a)
    	{
	    	char letter = s.charAt(a);
	    	if(temple.indexOf(letter) != -1)
	    	{ 
	    		return s.indexOf(letter);	
	    	}
	    	a++;
    	}
    	return -1;
    }

    /*
     * returns the index of the first occurrence of a letter in "temple" in s starting
     * from index startPosition or -1 if there are none at index
     * startPosition or later. Notice that this method has the same name as the
     * previous one, but that it takes a different number of arguments. This is
     * perfectly legal in Java. It's called "method overloading"
     */
    public static int indexOfFirstTULetter(String s, int startPosition) 
    {
    	String temple = "templeTEMPLE";
    	int length = s.length();
    	while(length > startPosition)
    	{
	    	char letter = s.charAt(startPosition);
	    	if(temple.indexOf(letter) != -1)
	    	{ 
	    		return s.indexOf(letter, startPosition);	
	    	}
	    	startPosition++;
    	}
        return -1;
    }

    /*
     * returns the index of the last occurrence of a letter in the word "temple"
     * in s or -1 if s
     * contains none
     */
    public static int indexOfLastTULetter(String s) 
    {
    	String temple = "templeTEMPLE";
    	int length = s.length();
    	int a = 0;
    	int sub = 1;
    	while(length > a)
    	{
	    	char letter = s.charAt(length-sub);
	    	if(temple.lastIndexOf(letter) != -1)
	    	{ 
	    		return s.lastIndexOf(letter);	
	    	}
	    	a++;
	    	sub++;
    	}
        return -1;
    }

    /* returns true if every letter in s is a letter
     * in the word "temple" or false otherwise */
    public static boolean allTempleLetters(String s) 
    {
    	String temple = "templeTEMPLE";
    	int length = s.length();
    	int a = 0;
    	while(length > a)
    	{
	    	char letter = s.charAt(a);
	    	if(temple.indexOf(letter) == -1)
	    	{ 
	    		return false;	
	    	}
	    	a++;
    	}
        return true;
    }
        
    /* returns true if no letter in s is a letter
     * in the word "temple" or false otherwise */
    public static boolean noTempleLetters(String s) 
    {
    	String temple = "templeTEMPLE";
    	int length = s.length();
    	int a = 0;
    	while(length > a)
    	{
	    	char letter = s.charAt(a);
	    	if(temple.indexOf(letter) != -1)
	    	{ 
	    		return false;	
	    	}
	    	a++;
    	}
        return true;
    }

    /*
     * returns a new String which is the same as s, but with all of the letters
     * in the word "temple" removed.
     */
    public static String withoutTULetters(String s) 
    { 
    	String temple = "templeTEMPLE";
    	int length = s.length();
    	int a = 0;
    	String word = "";
    	while(length > a)
    	{
    		char letter = s.charAt(a);
	    	if(temple.indexOf(letter) == -1) 
	    	{
	    		word += letter;
	    	}
	    	a++;
    	}	
    	return word;
    }

    /*
     * returns s in reverse. For example, if s is "Temple", the method returns the
     * String "elpmeT"
     */
    public static String reversed(String s) 
    {    	
    	int length = s.length();
    	String word = "";
    	int a = 0;
    	int sub = 1;
    	while(length > a)
    	{
    		char letter = s.charAt(length-sub);
	    	word += letter;
	    	a++;
	 	    sub++;
	    }
	    return word;
    }
       
    /*
     * returns the number of times that n occurs in h. For example, if h is
     * "Mississippi" and n is "ss" the method returns 2.
     */
    public static int numOccurrences(String h, String n) 
    {
    	int lastIndex = 0;
    	int count = 0;
    	while(lastIndex != -1)
    	{
    	    lastIndex = h.indexOf(n, lastIndex);
    	    if(lastIndex != -1)
    	    {
    	        count ++;
    	        lastIndex += n.length();
    	    }
    	}
    	return count;
    }

    /*
     * returns true if s is the same backwards and forwards and false otherwise
     */
    public static boolean sameInReverse(String s) 
    {
    	int length = s.length();
    	String word = "";
    	int a = 0;
    	int sub = 1;
    	while(length > a)
    	{
    		char letter = s.charAt(length-sub);
	    	word += letter;
	    	a++;
	 	    sub++;
	    }
    	if(word.contentEquals(s)) 
    	{
    		return true;
    	}
        return false;
    }


    /*
     * Returns a new String that looks like base appended with suffix. If base
     * already ends with suffix, it returns base.
     * 
     * For example, if base is "lightning" and suffix is "bug", returns
     * "lightningbug".
     * 
     * If base is "lightningbug" and suffix is "bug", it also returns
     * "lightningbug".
     */
    public static String appendIfMissing(String base, String suffix) 
    {
    	int lastIndex = 0;
    	lastIndex = base.indexOf(suffix, lastIndex);
	    if(lastIndex == -1)
	    {
	    	String fullWord = base + suffix;
	    	return fullWord;
	    }
	    
        return base;
    }
}