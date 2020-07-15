/**
 * Jared Gross
 * October 9, 2018
 * CIS1068
 *
 * Professor Fiore
 *
 * Description: This is a collection of functions that manipulate arrays, and
 *              retrieve specific information about specific arrays.
 */
public class ArrayPractice {
    /* sets every item in A[] to initialValue */
    public static void initialize(int A[], int initialValue) {
    	for(int i = 0; i < A.length; i++) {
    		A[i] = initialValue;
    	}
    }

    /* returns the average of the items in A*/
    public static double average(int A[]) {
    	double sum = 0.0;
    	int arrLength = A.length;

    	for(int i = 0; i < arrLength; i++) {
    		sum += A[i];
    	}
        return sum/arrLength;
    }

    /* returns the number of times that x appears in A[] */
    public static int numOccurrences(int A[], int x) {
    	int occ = 0;
    	for(int i = 0; i < A.length; i++) {
    		if(A[i] == x) {
    			occ ++;
    		}
    	}
        return occ;
    }

    public static int numOccurencesFromN(int A[], int x, int index) {
    	int occ = 0;
    	for(int i = index; i < A.length; i++) {
    		if(A[i] == x) {
    			occ ++;
    		}
    	}
        return occ;
    }


    /* returns the index of the first occurrence of
     * x in A[] or -1 if x doesn't exist in A[] */
    public static int find(int A[], int x) {
    	for(int i = 0; i < A.length; i++) {
    		if(A[i] == x) {
    			return i;
    		}
    	}
        return -1;
    }

    /* Returns the index of the first occurrence of
     * item within the first n elements of A[] or -1
     * if item is not among the first n elements of A[] */
    public static int findN(int A[], int item, int n) {
    	if(n <= A.length) {
        	for(int i = 0; i <n; i++) {
        		if(A[i] == item) {
        			return i;
        		}
        	}
    	}

        return -1;
    }

    /* returns the index of the last occurrence of
     * x in A[] or -1 if x doesn't exist in A[] */
    public static int findLast(int A[], int x) {
    	for(int i = A.length -1; i >=0; i--) {
    		if(A[i]== x) {
    			return i;
    		}
    	}
        return -1;
    }

    /* returns the largest item found in A */
    public static int largest(int A[]) {
    	int largest = -1;
    	for(int i = 0; i < A.length; i ++) {
    		if(A[i] > largest) {
    			largest = A[i];
    		}
    	}
        return largest;
    }

    /* returns the index of the largest item found in A */
    public static int indexOfLargest(int A[]) {
    	int largest = -1;
    	int largestIndex = -1;
    	for(int i = 0; i < A.length; i ++) {
    		if(A[i] > largest) {
    			largest = A[i];
    			largestIndex = i;
    		}
    	}
        return largestIndex;
    }

    /* returns the index of the largest odd number
     * in A[] or -1 if A[] contains no odd numbers */
    public static int indexOfLargestOdd(int A[]) {
    	int largestOdd = -1;
    	int largestIndex = -1;
    	for(int i = 0; i < A.length; i ++) {
    		if(A[i] > largestOdd && A[i] % 2 != 0) {
    			largestOdd = A[i];
    			largestIndex = i;
    		}
    	}
        return largestIndex;
    }

    /* inserts n into A[] at A[index] shifting all */
    /*  the previous items one place to the right. For example */
    /*  if A is  */
    /*   |---+---+---+---+---+---+---+---+---+---| */
    /*   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | */
    /*   |---+---+---+---+---+---+---+---+---+---| */
    /*   | 5 | 7 | 6 | 9 | 4 | 3 | 0 | 0 | 0 | 0 | */
    /*   |---+---+---+---+---+---+---+---+---+---| */

    /*   and we call insert(A, 15, 1), A then becomes */

    /*   |---+----+---+---+---+---+---+---+---+---| */
    /*   | 0 |  1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | */
    /*   |---+----+---+---+---+---+---+---+---+---| */
    /*   | 5 | 15 | 7 | 6 | 9 | 4 | 3 | 0 | 0 | 0 | */
    /*   |---+----+---+---+---+---+---+---+---+---| */
    /*  the element in A[] that's in the right-most */
    /*    position is removed.                      */
    /*                                              */
    /*  if index < 0 or index >= A.length-1, the method */
    /*                                    does nothing */
    public static void insert(int A[], int n, int index) {
    	for(int i = A.length -1; i >index; i--) {
    		A[i] = A[i-1];
    	}
        A[index] = n;
    }

    /* returns a new array consisting of all of the
     * elements of A[] */
    public static int[] copy(int A[]) {
    	int[] copyArr = new int[A.length];
    	for(int i = 0; i< A.length; i++) {
    		copyArr[i] = A[i];
    	}
        return copyArr;
    }

    /* Returns a new array consisting of all of the
       first n elements of A[]. If n>A.length, returns a
       new array of size n, with the first A.length elements
       exactly the same as A, and the remaining n-A.length elements
       set to 0. If n<=0, returns null. */
    public static int[] copyN(int A[], int n) {
    	if(n<= 0) {
    		return null;
    	}else if(n <= A.length){
    		int[] copyArr = new int[n];
        	for(int i = 0; i< n; i++) {
        		copyArr[i] = A[i];
        	}
        	if(n >= A.length) {
        	}
        	return copyArr;
    	}else {
    		int[] copyArr = new int[n];
    		for(int i = 0; i<A.length; i++) {
    			copyArr[i] = A[i];
    		}
    		return copyArr;
    	}

    }

    /* returns a new array consisting of all of the
     * elements of A[] followed by all of the
     * elements of B[]. For example, if
     A[] is: {10,20,30} and
     B[] is: {5, 9, 38}, the method returns the
     array : {10,20,30,5,9,38} */
    public static int[] copyAll(int A[], int B[]) {
    	int newLength = A.length + B.length;
    	int[] newArray = new int[newLength];
    	for(int i = 0; i < newLength; i ++) {
    		if(i<A.length) {
    			newArray[i] = A[i];
    		}else {
    			newArray[i] = B[i-A.length];
    		}
    	}
        return newArray;
    }

    /* reverses the order of the elements in A[].
     * For example, if A[] is:
     {10,20,30,40,50}, after the method, A[] would
     be {50,40,30,20,10} */
    public static void reverse(int A[]) {
    	int[] reversed = new int[A.length];
    	int reverseIndex = 0;
    	while(reverseIndex < A.length) {
    		for(int i = A.length - 1; i >=0; i--) {
        		reversed[reverseIndex] = A[i];
        		reverseIndex ++;
        	}
    	}
    	for(int i = 0; i< A.length; i++) {
    		A[i] = reversed[i];
    	}

    }

    /* Extra credit:
     *
     * Returns a new array consisting of all of the
     * elements of A, but with no duplicates. For example,
     * if A[] is {10,20,5,32,5,10,9,32,8}, the method returns
     * the array {10,20,5,32,9,8} */
    public static int[] uniques(int A[]) {
    	//figure out how long the array will be
    	int duplicates = countDuplicates(A);
    	//create new array with length subtracted by the number of duplicates
    	int newLength = A.length - duplicates;
    	int[] uniqueArr = new int[newLength];
    	//set first value
    	uniqueArr[0] = A[0];
    	//set index we are adding to
    	int uniqueIndex = 1;
    	//Add the rest ONLY if they are not in the unique array
    	for(int i = 1; i < A.length; i++) {
    		if(findN(uniqueArr, A[i], uniqueIndex) == -1) {
    			uniqueArr[uniqueIndex] = A[i];
    			uniqueIndex ++;
    		}
    	}
    	return uniqueArr;
    }
    //returns how many times numbers are repeated in an array
    public static int countDuplicates(int A[]) {
    	int duplicates = 0;
    	for(int i = 0; i < A.length; i++) {
    		if(numOccurencesFromN(A, A[i], i) > 1) {
    			duplicates ++;
    		}
    	}
    	return duplicates;
    }

    public static void main(String[] args) {
        return;
    }
}
