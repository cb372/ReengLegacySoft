package chapter4.stack;

import junit.framework.TestCase;

public class BoundedStackJunit3Test extends TestCase {

public void testWorksAsItShould() {
    int stackSize = 5;
    BoundedStack<Integer> stack =
            new BoundedStack<Integer>(stackSize);
    for (int i = 1; i <= 20; i++) {
        stack.push(i);
    }
    while (!stack.isEmpty()) {
        System.out.println(stack.pop());
    }
}

}