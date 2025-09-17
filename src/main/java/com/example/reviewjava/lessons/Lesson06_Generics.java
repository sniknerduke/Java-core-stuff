package com.example.reviewjava.lessons;

import com.example.reviewjava.Lesson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lesson06_Generics implements Lesson {
    @Override public String getName() { return "lesson06_generics"; }
    @Override public String getDescription() { return "Type params, bounds, wildcards (PECS), generic methods"; }

    @Override
    public void run() {
        List<Integer> ints = List.of(1, 2, 3, 4);
        List<Double> doubles = List.of(1.5, 2.5);

        double sum = sumAll(ints) + sumAll(doubles);
        System.out.println("sumAll(ints)+sumAll(doubles) = " + sum);

        List<Number> out = new ArrayList<>();
        copyAll(ints, out);
        copyAll(doubles, out);
        System.out.println("copyAll -> " + out);

        String longest = maxOf(List.of("ana", "bob", "charlie"), Comparator.comparingInt(String::length));
        System.out.println("max by length -> " + longest);
    }

    /*
     * QUICK NOTES
     * - PECS: Producer Extends, Consumer Super.
     * - <? extends T> is read-only (can't add except null); <? super T> is write-friendly.
     * - Prefer method type params over raw types; avoid unchecked casts.
     */

    // Producer Extends (PECS)
    static double sumAll(List<? extends Number> nums) {
        double s = 0;
        for (Number n : nums) s += n.doubleValue();
        return s;
    }

    // Consumer Super (PECS)
    static <T> void copyAll(List<? extends T> src, List<? super T> dst) {
        dst.addAll(src);
    }

    static <T> T maxOf(List<T> items, Comparator<? super T> cmp) {
        if (items.isEmpty()) throw new IllegalArgumentException("empty");
        T best = items.get(0);
        for (int i = 1; i < items.size(); i++) {
            if (cmp.compare(items.get(i), best) > 0) best = items.get(i);
        }
        return best;
    }

    /*
     Practice (PECS and variance):
     1) Why does the compiler reject: List<? extends Number> xs; xs.add(42)?
        - Answer: ? extends Number could be List<Double>, List<Long>, etc. Adding Integer 42 might violate the actual element type. Only reading as Number is safe; writing (except null) is unsafe.

     2) Implement merge that copies all from a and b into out using PECS.
        Signature to think about: merge(List<? extends T> a, List<? extends T> b, List<? super T> out)
        - Answer:
          // static <T> void merge(List<? extends T> a, List<? extends T> b, List<? super T> out) {
          //     out.addAll(a);
          //     out.addAll(b);
          // }

     3) Change maxOf to work when no comparator is provided by falling back to natural order (Comparable).
        - Idea (reference only, do NOT replace working code):
          // static <T> T maxOf(List<T> items, Comparator<? super T> cmp) {
          //     if (items.isEmpty()) throw new IllegalArgumentException("empty");
          //     Comparator<? super T> c = (cmp != null) ? cmp : (o1, o2) -> ((Comparable) o1).compareTo(o2);
          //     T best = items.get(0);
          //     for (int i = 1; i < items.size(); i++) if (c.compare(items.get(i), best) > 0) best = items.get(i);
          //     return best;
          // }

     4) Why Comparator<? super T> (not <? extends T>) for maxOf?
        - Answer: Comparator consumes T (compare(T a, T b)), so any comparator of a supertype (e.g., Comparator<Object>) can compare Ts. That's covariance via contravariance on the comparator input.
    */

    public static void main(String[] args) { new Lesson06_Generics().run(); }
}
