package com.bloobirds.training.service.impl;

import com.bloobirds.training.service.spec.PiService;

import java.util.stream.IntStream;

public class PiServiceMonteCarlo implements PiService {


    @Override
    public double computePi() {
        int n = 100;
        long inside = IntStream.range(0, n)
                .filter(x -> test())
                .count();
        return ((double) inside) / n;
    }

    private boolean test() {
        double x = Math.random();
        double y = Math.random();
        return x * x + y * y < 1;
    }

}
