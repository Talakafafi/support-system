package com.example.Support.System.entity.support;

import java.util.concurrent.ThreadLocalRandom;

public class CustomIdGenerator {
    public static String generateId() {
        int part1 = ThreadLocalRandom.current().nextInt(10000, 100000);  // 5 digits
        int part2 = ThreadLocalRandom.current().nextInt(100000, 1000000); // 6 digits
        int part3 = ThreadLocalRandom.current().nextInt(1000, 10000);     // 4 digits
        return part1 + "-" + part2 + "-" + part3;
    }
}