package com.example.reviewjava.lessons;

import com.example.reviewjava.Lesson;

public class Lesson02_ControlFlow implements Lesson {
    @Override
    public String getName() { return "lesson02_controlflow"; }

    @Override
    public String getDescription() { return "if/else, switch, loops, methods"; }

    @Override
    public void run() {
        int x = 7;
        if (x % 2 == 0) {
            System.out.println(x + " is even");
        } else {
            System.out.println(x + " is odd");
        }

        String day = "MON";
        switch (day) {
            case "MON", "TUE", "WED", "THU", "FRI" -> System.out.println("Weekday");
            case "SAT", "SUN" -> System.out.println("Weekend");
            default -> System.out.println("Unknown");
        }

        // Loops
        int fact = factorial(5);
        System.out.println("5!=" + fact);
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}
