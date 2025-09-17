package com.example.reviewjava.lessons;

import com.example.reviewjava.Lesson;

public class Lesson01_Basics implements Lesson {
    @Override
    public String getName() { return "lesson01_basics"; }

    @Override
    public String getDescription() { return "Variables, types, strings, arrays, and loops"; }

    @Override
    public void run() {
        int a = 5;
        double b = 2.5;
        boolean flag = true;
        char c = 'J';
        String s = "Java";

        System.out.printf("a=%d, b=%.2f, flag=%b, c=%c, s=%s%n", a, b, flag, c, s);

        // Arrays
        int[] nums = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int n : nums) sum += n;
        System.out.println("sum=" + sum);

        // String operations
        String msg = s + " " + (a + 1);
        System.out.println("msg=" + msg);
        System.out.println("Upper=" + msg.toUpperCase());
        System.out.println("Contains 'Java'=" + msg.contains("Java"));
    }
}
