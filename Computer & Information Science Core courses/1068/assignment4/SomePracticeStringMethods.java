package stringPractice1068;

public class SomePracticeStringMethods {
    /* returns true if c is a punctuation mark or false otherwise
     *
     * Punctuation mark is defined as:
     * apostrophe '
     * comma ,
     * period .
     * semicolon ;
     * colon :
     * exclamation point !
     * question mark ?
     *
     * (You don't have to worry about any others)
     */
    public static boolean isPunct(char c) {
    	return c== '\'' || c== ',' ||c== '.' ||c== ';' ||c== ':' ||
    			c== '!' || c== '?'|| c== '*';
    }

    /*
     * returns the index of the first punctuation mark in s or
     * -1 if s contains no punctuation marks
     */
    public static int indexOfFirstPunct(String s) {
    	for(int i = 0; i < s.length(); i++) {
    		if(isPunct(s.charAt(i))) {
    			return i;
    		}
    	}
	return -1;
    }

    /*
     * returns the index of the first occurrence of a punctuation mark in s starting
     * from index startPosition or -1 if there are none at index
     * startPosition or later. Notice that this method has the same name as the
     * previous one, but that it takes a different number of arguments. This is
     * perfectly legal in Java. It's called "method overloading"
     */
    public static int indexOfFirstPunct(String s, int startPosition) {
    	for(int i = startPosition; i <s.length(); i++) {
    		if(isPunct(s.charAt(i))) {
    			return i;
    		}
    	}
	return -1;
    	}



    /*
     * returns the index of the last occurrence of a punctuation mark in s or -1 if s
     * contains none
     */
    public static int indexOfLastPunct(String s) {
    	for(int i = s.length() -1; i >= 0; i--) {
    		if(isPunct(s.charAt(i))) {
    			return i;
    		}
    	}
	return -1;
    }

    /*
     * returns s in reverse. For example, if s is "Apple", the method returns the
     * String "elppA"
     */
    public static String reversed(String s) {
    	String rev = "";
    	for(int i = s.length() -1; i >= 0; i--) {
    		rev += s.charAt(i);
    	}
	return rev;
    }

    /*
     * returns the number of times that n occurs in h. For example, if h is
     * "Mississippi" and n is "ss" the method returns 2.
     */
    public static int numOccurrences(String h, String n) {
    	int occurences = 0;
    	int foundIndex = 0;
    	while(h.indexOf(n, foundIndex) != -1) {
    		occurences ++;
    		foundIndex = h.indexOf(n, foundIndex) + 1;
    	}
	return occurences;
    }

    /*
     * returns true if s is the same backwards and forwards and false otherwise
     */
    public static boolean sameInReverse(String s) {
    	return s.equals(reversed(s));
    }

    /*
     * returns a new String which is the same as s, but with all of the punctuation
     * marks removed.
     */
    public static String withoutPunct(String s) {
    	String noPunct = "";

    	for(int i = 0; i< s.length(); i++) {
    		char c = s.charAt(i);
    		if(!isPunct(c)) {
    			noPunct += c;
    		}
    	}
	return noPunct;
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
    public static String appendIfMissing(String base, String suffix) {
    	String fullString = base;
    	if(!base.endsWith(suffix)) {
    		fullString += suffix;
    	}
    	return fullString;
    }

    /* Returns true of s contains none of the characters
     * found in chars or false otherwise.
     *
     * For example, if s is "
     */
    public static boolean containsNone(String s, String chars) {
    	for(int i = 0; i < chars.length(); i++) {
    		char c = chars.charAt(i);
    		for(int j = 0; j < s.length(); j++) {
    			char stringChar = s.charAt(j);
    			if(c == stringChar) {
    				return false;
    			}
    		}
    	}
    	return true;
    }

    public static int numOfPunctAndSpaces(String s) {
    	int num = 0;
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if(isPunct(c) || c == ' ') {
    			num ++;
    		}
    	}

    	return num;
    }

    public static boolean allUpperCase(String s) {
    	if(numOfPunctAndSpaces(s) == s.length()) {
    		return false;
    	}
    	return withoutPunct(s).equals(withoutPunct(s).toUpperCase());
    }

    public static boolean allLowerCase(String s) {
    	if(numOfPunctAndSpaces(s) == s.length()) {
    		return false;
    	}
    	return withoutPunct(s).equals(withoutPunct(s).toLowerCase());
    }
}
