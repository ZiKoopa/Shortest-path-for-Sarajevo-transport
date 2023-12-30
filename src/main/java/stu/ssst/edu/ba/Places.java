package stu.ssst.edu.ba;

import java.util.HashMap;
import java.util.Map;

public class Places {
    private static final Map<String, String> placesNameMap = new HashMap<>();

    public static void addPlace(String shortcode, String name) {
        placesNameMap.put(shortcode, name);
    }

    public static String getPlaceInfo(String shortcode) {
        String name = placesNameMap.getOrDefault(shortcode, "Unknown");
        return shortcode + ": " + name;
    }

}