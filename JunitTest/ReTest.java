import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReTest {

	Re r1=new Re();
	@Test
	void testCheck() {
		assertEquals(1,r1.check("161192358", "chen", "chen@qq.com"));
	}

	@Test
	void testClear() {
		assertEquals("myText clear",r1.clear());
	}

}


