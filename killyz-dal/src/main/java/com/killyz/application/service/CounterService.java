package com.killyz.application.service;

import com.killyz.models.Counter;

public interface CounterService {

    void save(Counter counter);
    Counter get(String counterName);
    boolean isCounterExists(String counterName);
}
