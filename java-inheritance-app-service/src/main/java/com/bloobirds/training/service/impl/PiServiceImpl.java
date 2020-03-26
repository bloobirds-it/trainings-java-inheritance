package com.bloobirds.training.service.impl;

import com.bloobirds.training.service.spec.PiService;
import org.springframework.stereotype.Service;

@Service
public class PiServiceImpl implements PiService {

    public double computePi() {
        return Math.PI;
    }

}
