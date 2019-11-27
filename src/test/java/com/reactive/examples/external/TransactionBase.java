package com.reactive.examples.external;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

abstract class TransactionBase {

    protected static final Logger LOGGER = LoggerFactory.getLogger(TransactionBase.class.getName());

    private final Map<Integer, Integer> sleepGet = Map.of(0, 3000,
                                                          1, 1000,
                                                          2, 500,
                                                          3, 1500);

    private final Map<Integer, Integer> sleepProcess = Map.of(0, 1000,
                                                              1, 500,
                                                              2, 1500,
                                                              3, 3000);

    protected Integer getTransaction(int i) {
        LOGGER.info("GET: " +  i);
        try {
            TimeUnit.MILLISECONDS.sleep(sleepGet.get(i)); // Blocking operation
        } catch (InterruptedException e) {
            LOGGER.error("Interrupted",e);
        }
        return i;
    }

    protected Integer processTransaction(int i) {
        LOGGER.info("PROCESS: " +  i);
        try {
            TimeUnit.MILLISECONDS.sleep(sleepProcess.get(i)); // Blocking operation
        } catch (InterruptedException e) {
            LOGGER.error("Interrupted",e);
        }
        return i;
    }
}
