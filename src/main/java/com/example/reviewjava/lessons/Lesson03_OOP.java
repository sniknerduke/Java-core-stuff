package com.example.reviewjava.lessons;

import com.example.reviewjava.Lesson;

public class Lesson03_OOP implements Lesson {
    @Override
    public String getName() { return "lesson03_oop"; }

    @Override
    public String getDescription() { return "Classes, encapsulation, inheritance, polymorphism"; }

    @Override
    public void run() {
        Shape c = new Circle(2.0);
        Shape r = new Rectangle(3.0, 4.0);
        System.out.printf("Circle area=%.2f, perim=%.2f%n", c.area(), c.perimeter());
        System.out.printf("Rect area=%.2f, perim=%.2f%n", r.area(), r.perimeter());
    }

    interface Shape {
        double area();
        double perimeter();
    }

    static class Circle implements Shape {
        private final double radius;
        Circle(double radius) { this.radius = radius; }
        @Override public double area() { return Math.PI * radius * radius; }
        @Override public double perimeter() { return 2 * Math.PI * radius; }
    }

    static class Rectangle implements Shape {
        private final double w, h;
        Rectangle(double w, double h) { this.w = w; this.h = h; }
        @Override public double area() { return w * h; }
        @Override public double perimeter() { return 2 * (w + h); }
    }
}
