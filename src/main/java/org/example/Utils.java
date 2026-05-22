package org.example;

public class Utils {
    static public String statusToCompleted(boolean bool) {
        if(bool) {
            return "completed";
        }
        else {
            return "";
        }
    }

    static public String computeFilterClass(String e1, String e2) {
        if(e1.equals(e2)) {
            return "selected";
        }
        else {
            return "";
        }
    }
}
