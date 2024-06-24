/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appjgomez.rest3.utils;

/**
 *
 * @author JGomez
 */
public class LogColor {

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE

    public static enum Color {
        //Color end string, color reset
        RESET("\033[0m"),
        // Regular Colors. Normal color, no bold, background color etc.
        BLACK("\033[0;30m"), // BLACK
        RED("\033[0;31m"), // RED
        GREEN("\033[0;32m"), // GREEN
        YELLOW("\033[0;33m"), // YELLOW
        BLUE("\033[0;34m"), // BLUE
        MAGENTA("\033[0;35m"), // MAGENTA
        CYAN("\033[0;36m"), // CYAN
        WHITE("\033[0;37m"), // WHITE

        // Bold
        BLACK_BOLD("\033[1;30m"), // BLACK
        RED_BOLD("\033[1;31m"), // RED
        GREEN_BOLD("\033[1;32m"), // GREEN
        YELLOW_BOLD("\033[1;33m"), // YELLOW
        BLUE_BOLD("\033[1;34m"), // BLUE
        MAGENTA_BOLD("\033[1;35m"), // MAGENTA
        CYAN_BOLD("\033[1;36m"), // CYAN
        WHITE_BOLD("\033[1;37m"), // WHITE

        // Underline
        BLACK_UNDERLINED("\033[4;30m"), // BLACK
        RED_UNDERLINED("\033[4;31m"), // RED
        GREEN_UNDERLINED("\033[4;32m"), // GREEN
        YELLOW_UNDERLINED("\033[4;33m"), // YELLOW
        BLUE_UNDERLINED("\033[4;34m"), // BLUE
        MAGENTA_UNDERLINED("\033[4;35m"), // MAGENTA
        CYAN_UNDERLINED("\033[4;36m"), // CYAN
        WHITE_UNDERLINED("\033[4;37m"), // WHITE

        // Background
        BLACK_BACKGROUND("\033[40m"), // BLACK
        RED_BACKGROUND("\033[41m"), // RED
        GREEN_BACKGROUND("\033[42m"), // GREEN
        YELLOW_BACKGROUND("\033[43m"), // YELLOW
        BLUE_BACKGROUND("\033[44m"), // BLUE
        MAGENTA_BACKGROUND("\033[45m"), // MAGENTA
        CYAN_BACKGROUND("\033[46m"), // CYAN
        WHITE_BACKGROUND("\033[47m"), // WHITE

        // High Intensity
        BLACK_BRIGHT("\033[0;90m"), // BLACK
        RED_BRIGHT("\033[0;91m"), // RED
        GREEN_BRIGHT("\033[0;92m"), // GREEN
        YELLOW_BRIGHT("\033[0;93m"), // YELLOW
        BLUE_BRIGHT("\033[0;94m"), // BLUE
        MAGENTA_BRIGHT("\033[0;95m"), // MAGENTA
        CYAN_BRIGHT("\033[0;96m"), // CYAN
        WHITE_BRIGHT("\033[0;97m"), // WHITE

        // Bold High Intensity
        BLACK_BOLD_BRIGHT("\033[1;90m"), // BLACK
        RED_BOLD_BRIGHT("\033[1;91m"), // RED
        GREEN_BOLD_BRIGHT("\033[1;92m"), // GREEN
        YELLOW_BOLD_BRIGHT("\033[1;93m"), // YELLOW
        BLUE_BOLD_BRIGHT("\033[1;94m"), // BLUE
        MAGENTA_BOLD_BRIGHT("\033[1;95m"), // MAGENTA
        CYAN_BOLD_BRIGHT("\033[1;96m"), // CYAN
        WHITE_BOLD_BRIGHT("\033[1;97m"), // WHITE

        // High Intensity backgrounds
        BLACK_BACKGROUND_BRIGHT("\033[0;100m"), // BLACK
        RED_BACKGROUND_BRIGHT("\033[0;101m"), // RED
        GREEN_BACKGROUND_BRIGHT("\033[0;102m"), // GREEN
        YELLOW_BACKGROUND_BRIGHT("\033[0;103m"), // YELLOW
        BLUE_BACKGROUND_BRIGHT("\033[0;104m"), // BLUE
        MAGENTA_BACKGROUND_BRIGHT("\033[0;105m"), // MAGENTA
        CYAN_BACKGROUND_BRIGHT("\033[0;106m"), // CYAN
        WHITE_BACKGROUND_BRIGHT("\033[0;107m");     // WHITE

        private final String code;

        Color(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }
    }

    public static void i(String className, String message) {
        System.out.println(GREEN + "[INFO] => " + className + " : " + message + RESET);
    }

    //error
    public static void e(String className, String message) {
        System.out.println(RED + "[ERROR] => " + className + " : " + message + RESET);
    }

    //debug
    public static void d(String className, String message) {
        System.out.println(BLUE + "[DEBUG] => " + className + " : " + message + RESET);
    }

    //warning
    public static void w(String className, String message) {
        System.out.println(YELLOW + "[WARNING] => " + className + " : " + message + RESET);
    }

    /*
        class RunApp {
            public static void main(String[] args) {

                System.out.print(Color.BLACK_BOLD);
                System.out.println("Black_Bold");
                System.out.print(Color.RESET);

                System.out.print(Color.YELLOW);
                System.out.print(Color.BLUE_BACKGROUND);
                System.out.println("YELLOW & BLUE");
                System.out.print(Color.RESET);

                System.out.print(Color.YELLOW);
                System.out.println("YELLOW");
                System.out.print(Color.RESET);
            }
        }    
    
    
     */
}
