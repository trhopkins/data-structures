package com.ccsu.cs.tutoring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {
	/** Runs the program and fails if any exceptions are thrown. */
	@Test
	void verifyNoExceptionThrown() {
		Main.main(new String[]{});
	}

	/** 'Hello world' of JUnit 5 */
	@Test
	void basicCheck() {
		assertEquals(1, 1);
	}
}
