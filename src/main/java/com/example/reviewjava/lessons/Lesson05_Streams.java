package com.example.reviewjava.lessons;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.reviewjava.Lesson;

public class Lesson05_Streams implements Lesson {
    @Override
    public String getName() { return "lesson05_streams"; }

    @Override
    public String getDescription() { return "Stream map/filter/reduce, collect, Optional"; }

    @Override
    public void run() {
        List<Integer> nums = List.of(1,2,3,4,5,6);
        List<Integer> evensSquared = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("evensSquared=" + evensSquared);

        int sum = nums.stream().reduce(0, Integer::sum);
        System.out.println("sum=" + sum);

        Optional<Integer> maybeBig = nums.stream().filter(n -> n > 3).findFirst();
        System.out.println(">10 present? " + maybeBig.isPresent());
        System.out.println("value or default: " + maybeBig.orElse(-1));
    }
}
