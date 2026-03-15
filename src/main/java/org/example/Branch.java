package org.example;

public class Branch {

    private String name;

    public Branch(String rawName) {
        this.name = formatName(rawName);
    }

    public String getName() {
        return name;
    }

    public static String formatName(String rawName) {
        if (rawName == null || rawName.trim().isEmpty()) {
            return "untitled-branch";
        }
        return rawName.trim().toLowerCase().replace(" ", "-");
    }

    public boolean isProtected() {
        return name.equals("main") || name.equals("master");
    }
}