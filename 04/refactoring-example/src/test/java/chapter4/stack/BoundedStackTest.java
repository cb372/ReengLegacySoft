package chapter4.stack;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class BoundedStackTest {

@Test
public void stackFullFlagIsSet() throws Exception {
    int stackSize = 5;
    BoundedStack<Integer> stack =
            new BoundedStack<Integer>(stackSize);

    // Expose the private field "wibble"
    Field wibble =
            BoundedStack.class.getDeclaredField("wibble");
    wibble.setAccessible(true);

    // Flag should start off false
    assertThat(wibble.getBoolean(stack), is(false));

    // Fill the stack
    for (int i = 1; i <= stackSize; i++) {
        stack.push(i);
    }

    // Flag should now be true
    assertThat(wibble.getBoolean(stack), is(true));
}

}