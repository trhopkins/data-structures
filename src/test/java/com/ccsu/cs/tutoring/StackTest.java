package com.ccsu.cs.tutoring;

import com.ccsu.cs.tutoring.structures.Stack;
import org.junit.jupiter.api.Test; // for Test annotations
import org.junit.jupiter.api.Assertions; // for tests themselves

public class StackTest {
	@Test
	void stackStartsEmpty() {
		Stack<Integer> numbers = new Stack<>();
		Assertions.assertTrue(numbers.empty());
	}

	@Test
	void addingFiveElementsMakesSizeFive() {
		Stack<String> stack = new Stack<>();
		stack.push("data"); // 1
		stack.push("data"); // 2
		stack.push("data"); // 3
		stack.push("data"); // 4
		stack.push("data"); // 5
		Assertions.assertEquals(5, stack.size());
	}

	@Test
	void deletingElementsReducesSize() {
		Stack<Character> stack = new Stack<>();
		int oldSize, newSize;
		stack.push('a');
		stack.push('b');
		stack.push('c');
		stack.push('d');
		stack.push('e');
		oldSize = stack.size();
		stack.pop(); // should return 'e' btw
		newSize = stack.size();
		Assertions.assertTrue(oldSize > newSize);
	}

	@Test
	void toStringWorksForIntegers() {
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(3);
		stack.push(10);
		Assertions.assertEquals(stack.toString(), "10\n3\n5\n");
	}

	@Test
	void addingElementsMakesEmptyFalse() {
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		Assertions.assertFalse(stack.empty());
	}
}
