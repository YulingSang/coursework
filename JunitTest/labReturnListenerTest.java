import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class labReturnListenerTest {

	labReturnListener l1=new labReturnListener();
	@Test
	void testActionPerformed() {
		//assertEquals("Station Full",l1.actionPerformed());
		assertEquals("Return Succeed",l1.actionPerformed());
	}

}
