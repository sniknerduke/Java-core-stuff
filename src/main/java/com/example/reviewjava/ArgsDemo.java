package com.example.reviewjava;

public class ArgsDemo {
    public static void main(String[] args) {
        System.out.println("Number of arguments: " + args.length);
        
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = \"" + args[i] + "\"");
        }
        
        if (args.length > 0) {
            System.out.println("\nFirst argument is: " + args[0]);
            if (args[0].equals("hello")) {
                System.out.println("You said hello!");
            }
        }
    }
}