package com.design.patterns.JavaPractices;


/*
Strings - Special Characters
Because strings must be written within quotes,
Java will misunderstand this string, and generate an error:

String txt = "We are the so-called "Vikings" from the north.";

The solution to avoid this problem, is to use the backslash escape character.

The backslash (\) escape character turns special characters into string characters:

String txt = "We are the so-called \"Vikings\" from the north.";

In this example, the double quotes within the string are escaped with a backslash.

The sequence \'  inserts a single quote in a string:

The sequence \\  inserts a single backslash in a string:
 */

public class EscapeChar {
    public static void main(String[] args) {
        System.out.println("\"Java\" is OOP language");
        //New Line
        String txtNewLine = "Hello\nWorld!";
        System.out.println(txtNewLine);
        //Carriage Return
        String txtCarriage = "Hello\rWorld!";
        System.out.println(txtCarriage);
        //Tab
        String txtTab = "Hello\tWorld!";
        System.out.println(txtTab);

        //Backspace
        String txtBackspace = "Hel\blo World!";
        System.out.println(txtBackspace);

        // Form Feed
        String txtFormFeed = "This is a form feed\fPage 2";
        System.out.println(txtFormFeed);

    }
}
