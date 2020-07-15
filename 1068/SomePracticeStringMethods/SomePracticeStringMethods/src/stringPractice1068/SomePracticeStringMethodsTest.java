package stringPractice1068;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomePracticeStringMethodsTest {
	@Test
	public void testInTU() {
		assertTrue(SomePracticeStringMethods.inTU('T'));
		assertTrue(SomePracticeStringMethods.inTU('t'));
		assertTrue(SomePracticeStringMethods.inTU('e'));
		assertTrue(SomePracticeStringMethods.inTU('m'));
		assertTrue(SomePracticeStringMethods.inTU('P'));
		assertFalse(SomePracticeStringMethods.inTU('x'));
		assertFalse(SomePracticeStringMethods.inTU('.'));
		assertFalse(SomePracticeStringMethods.inTU('0'));
	}

	@Test
	public void testIndexOfFirstTULetterString() {
		assertEquals(SomePracticeStringMethods.indexOfFirstTULetter("atom"), 1);
		assertEquals(SomePracticeStringMethods.indexOfFirstTULetter("aTom"), 1);
		assertEquals(SomePracticeStringMethods.indexOfFirstTULetter("Opus"), 1);
		assertEquals(SomePracticeStringMethods.indexOfFirstTULetter("elephant"), 0);
		assertEquals(SomePracticeStringMethods.indexOfFirstTULetter(""), -1);
	}

	@Test
	public void testIndexOfFirstTULetterStringInt() {
		assertEquals(SomePracticeStringMethods.indexOfFirstTULetter("atom", 1), 1);
		assertEquals(SomePracticeStringMethods.indexOfFirstTULetter("atom", 2), 3);
		assertEquals(SomePracticeStringMethods.indexOfFirstTULetter("aTom", 1), 1);
		assertEquals(SomePracticeStringMethods.indexOfFirstTULetter("Opus", 2), -1);
		assertEquals(SomePracticeStringMethods.indexOfFirstTULetter("elephant", 2), 2);
		assertEquals(SomePracticeStringMethods.indexOfFirstTULetter("", 1), -1);
	}

	@Test
	public void testIndexOfLastTULetter() {
		assertEquals(SomePracticeStringMethods.indexOfLastTULetter("atom"), 3);
		assertEquals(SomePracticeStringMethods.indexOfLastTULetter("aTom"), 3);
		assertEquals(SomePracticeStringMethods.indexOfLastTULetter("Opus"), 1);
		assertEquals(SomePracticeStringMethods.indexOfLastTULetter("elephant"), 7);
		assertEquals(SomePracticeStringMethods.indexOfLastTULetter(""), -1);
	}

	@Test
	public void testNoTempleLetters() {
		assertTrue(SomePracticeStringMethods.noTempleLetters("aardvark"));
		assertFalse(SomePracticeStringMethods.noTempleLetters("LioN"));
		assertTrue(SomePracticeStringMethods.noTempleLetters("cougar"));
		assertFalse(SomePracticeStringMethods.noTempleLetters("Winnebago"));
		assertTrue(SomePracticeStringMethods.noTempleLetters("workbook"));
		assertTrue(SomePracticeStringMethods.noTempleLetters(""));
	}

	@Test
	public void testAllTempleLetters() {
		assertTrue(SomePracticeStringMethods.allTempleLetters("meet"));
		assertTrue(SomePracticeStringMethods.allTempleLetters("Elm"));
		assertTrue(SomePracticeStringMethods.allTempleLetters("eel"));
		assertTrue(SomePracticeStringMethods.allTempleLetters("EMMETT"));
		assertTrue(SomePracticeStringMethods.allTempleLetters("melee"));
		assertFalse(SomePracticeStringMethods.allTempleLetters("melees"));
	}

	@Test
	public void testWithoutTULetters() {
		assertEquals(SomePracticeStringMethods.withoutTULetters("Tom"), "o");
		assertEquals(SomePracticeStringMethods.withoutTULetters("put"), "u");
		assertEquals(SomePracticeStringMethods.withoutTULetters("all"), "a");
		assertEquals(SomePracticeStringMethods.withoutTULetters("of"), "of");
		assertEquals(SomePracticeStringMethods.withoutTULetters("my"), "y");
		assertEquals(SomePracticeStringMethods.withoutTULetters("records"), "rcords");
		assertEquals(SomePracticeStringMethods.withoutTULetters("into"), "ino");
		assertEquals(SomePracticeStringMethods.withoutTULetters("this"), "his");
		assertEquals(SomePracticeStringMethods.withoutTULetters("rectangle"), "rcang");
	}

	@Test
	public void testReversed() {
		assertEquals("cba", SomePracticeStringMethods.reversed("abc"));
		assertEquals("a", SomePracticeStringMethods.reversed("a"));
		assertEquals("dcba", SomePracticeStringMethods.reversed("abcd"));
	}

	@Test
	public void testSameInReverse() {
		assertTrue(SomePracticeStringMethods.sameInReverse("peep"));
		assertTrue(SomePracticeStringMethods.sameInReverse("madam"));
		assertTrue(SomePracticeStringMethods.sameInReverse("rotator"));
		assertFalse(SomePracticeStringMethods.sameInReverse("blue"));
		assertFalse(SomePracticeStringMethods.sameInReverse("aspirin"));
		assertFalse(SomePracticeStringMethods.sameInReverse("ab"));
		assertTrue(SomePracticeStringMethods.sameInReverse("a"));
	}

	@Test
	public void testNumOccurrences() {
		assertEquals(2, SomePracticeStringMethods.numOccurrences("banana", "na"));
		assertEquals(2, SomePracticeStringMethods.numOccurrences("mississippi", "ss"));
		assertEquals(0, SomePracticeStringMethods.numOccurrences("undertow", "sushi"));
	}
}
