package com.killyz.components;

import com.killyz.application.service.CounterService;
import com.killyz.models.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CounterManagerImpl implements CounterManager {

    private final CounterService counterService;

    @Autowired
    public CounterManagerImpl(CounterService counterService) {
        this.counterService = counterService;
    }

    @Override
    public void newCounter(Counter counter) {
        if (counterService.isCounterExists(counter.getName()))
            throw new RuntimeException("Counter: " + counter.getName() + " already exists");

        counterService.save(counter);
    }

    @Override
    public void resetCounter(String counterName) {
        if (!counterService.isCounterExists(counterName))
            throw new RuntimeException("Counter: " + counterName + " doesn't exists");

        Counter counter = counterService.get(counterName);
        counter.setSequence(0);
        counterService.save(counter);
    }

    @Override
    public synchronized long getSequence(String counterName) {
        if (!counterService.isCounterExists(counterName))
            throw new RuntimeException("Counter: " + counterName + " doesn't exists");

        Counter counter = counterService.get(counterName);
        counter.setSequence(counter.getSequence() + 1);
        counterService.save(counter);
        return counter.getSequence();
    }
}
