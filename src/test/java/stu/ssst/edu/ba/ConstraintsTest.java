package stu.ssst.edu.ba;

import junit.framework.TestCase;

public class ConstraintsTest extends TestCase {

    public void testRoadClosed() {
        Constraints constraints = new Constraints("A", "B", "medics helicopter", 1.0);
        assertTrue(constraints.isRoadClosed());
    }

    public void testRoadNotClosed() {
        Constraints constraints = new Constraints("A", "B", "none", 0.0);
        assertFalse(constraints.isRoadClosed());
    }

}