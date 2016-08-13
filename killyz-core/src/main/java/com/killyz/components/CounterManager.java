package com.killyz.components;

import com.killyz.models.Counter;

public interface CounterManager {

    void newCounter(Counter counter);
    void resetCounter(String counterName);
    long getSequence(String counterName);
}
