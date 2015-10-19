package example.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class JunitExampleTest {

	@Test
	public void testFoo() {
		JunitExample example = new JunitExample();
		assertEquals(1, example.foo());
	}

}
