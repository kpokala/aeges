package com.aeges.service;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryService {

    public int getTotalCount(String input) {
        AtomicBoolean exception = new AtomicBoolean(false);
        AtomicInteger total = new AtomicInteger();
        AtomicInteger powerIndex = new AtomicInteger();
        input.chars().forEach(c -> {
            if ((char) c < 48 || (char) c > 49) {
                exception.set(true);
            } else {
                total.set(total.get() + (Character.getNumericValue(c) * (int) Math.pow(2, powerIndex.get())));
                powerIndex.incrementAndGet();
            }
        });

        if (exception.get() == true) {
            return 0;
        }
        return total.get();

    }
}
