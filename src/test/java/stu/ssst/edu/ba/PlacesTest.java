package stu.ssst.edu.ba;

import junit.framework.TestCase;

public class PlacesTest extends TestCase {

    public void testAddPlace() {
        Places.addPlace("A", "Airport");
        assertEquals("A: Airport", Places.getPlaceInfo("A"));
    }

    public void testGetPlaceInfoUnknown() {
        assertEquals("Z: Unknown", Places.getPlaceInfo("Z"));
    }

    public void testGetPlaceInfo() {
        Places.addPlace("B", "Beach");
        assertEquals("B: Beach", Places.getPlaceInfo("B"));
    }

    public void testAddMultiplePlaces() {
        Places.addPlace("C", "City");
        Places.addPlace("D", "Desert");
        Places.addPlace("E", "Forest");

        assertEquals("C: City", Places.getPlaceInfo("C"));
        assertEquals("D: Desert", Places.getPlaceInfo("D"));
        assertEquals("E: Forest", Places.getPlaceInfo("E"));
    }

}