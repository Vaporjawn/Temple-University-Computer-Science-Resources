//import java.util.regex.*;
import java.util.*;
import java.io.*;

public class SouthieStyles 
{

	public static String readScript() throws FileNotFoundException 
	{
		String movie = "";
		Scanner script = new Scanner(new File("jaws.txt"));
		script.useDelimiter("");
		while (script.hasNext()) 
		{
		    movie += script.next();
		}
		script.close();
		return movie;
	}
	
	public static void outputFile(String a) throws FileNotFoundException
	{
		PrintStream out = new PrintStream(new File("editedScript.txt"));
		out.print(a);
	}
	
	public static String replaceVery(String b)
	{
		String wicked = b.replace(" very", " wicked");
		wicked = wicked.replace("Very", "Wicked");
		return wicked;
	}
	
	public static String replaceVowel(String c)
	{
		String vowelRule = c.replace("er", "eh");
		vowelRule = vowelRule.replace("ar", "ah");
		vowelRule = vowelRule.replace("ir", "ih");
		vowelRule = vowelRule.replace("or", "oh");
		vowelRule = vowelRule.replace("ir", "ih");
		vowelRule = vowelRule.replace("AR", "AH");
		vowelRule = vowelRule.replace("ER", "EH");
		vowelRule = vowelRule.replace("IR", "IH");
		vowelRule = vowelRule.replace("OR", "OH");
		return vowelRule;
	}
	
	public static String replaceA(String d)
	{
		//(?!\\w) looks for non-alphanumeric characters
		String aRule = d.replaceAll("a(?!\\w)", "ar");
		aRule = aRule.replaceAll("A(?!\\w)", "AR");
		//changes the word a back to a instead of ar :)
		aRule = aRule.replace(" AR ", " A ");
		aRule = aRule.replace(" ar ", " a ");
		return aRule;
	}
	
	public static String replaceEE(String e) 
	{
		String eeException = e.replaceAll("eeh(?!\\w)", "yah");
		eeException = eeException.replaceAll("ih(?!\\w)", "yah");
		eeException = eeException.replaceAll("EEH(?!\\w)", "YAH");
		eeException = eeException.replaceAll("IH(?!\\w)", "YAH");
		return eeException;
	}
	
	public static String replaceOO(String f)
	{
		String ooException = f.replace("ooh(?!\\w)", "wah");
		ooException = ooException.replace("OOH(?!\\w)", "WAH");
		return ooException;
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		String squidward = readScript();
		squidward = replaceVery(squidward);
		squidward = replaceVowel(squidward);
		squidward = replaceA(squidward);
		squidward = replaceEE(squidward);
		squidward = replaceOO(squidward);
		outputFile(squidward);
		System.out.println("I did it!");
	}

}
