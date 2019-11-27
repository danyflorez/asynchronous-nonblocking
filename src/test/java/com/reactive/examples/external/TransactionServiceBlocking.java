package com.reactive.examples.external;

public class TransactionServiceBlocking extends TransactionBase{

    public int get(int id) {
        LOGGER.info("GET Of " + id +  " Thread: " + Thread.currentThread().getName());
        return getTransaction(id);
    }

    public int process(int id) {
        return processTransaction(id);
    }
}
