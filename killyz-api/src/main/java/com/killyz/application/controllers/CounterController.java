package com.killyz.application.controllers;

import com.killyz.components.counters.CounterManager;
import com.killyz.models.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/counter")
public class CounterController {

    private final CounterManager counterManager;

    @Autowired
    public CounterController(CounterManager counterManager) {
        this.counterManager = counterManager;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public void newCounter(@RequestParam String counterName) {
        Counter counter = new Counter(counterName);
        counterManager.newCounter(counter);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public long getCounter(@RequestParam String counterName) {
        return counterManager.getSequence(counterName);
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public void resetCounter(@RequestParam String counterName) {
        counterManager.resetCounter(counterName);
    }
}
