package com.reactive.examples;

import com.reactive.examples.external.TransactionServiceNonBlocking;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;


public class ReactiveTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReactiveTest.class.getName());

    @Test
    void asynscronousNonBlockingExample() throws InterruptedException {
        var transactionService = new TransactionServiceNonBlocking();

        Flux.range(0, 4)
                .flatMap(transactionService::get)
                .flatMap(transactionService::process)
                .subscribe(i -> LOGGER.info("Client: " + i));

        TimeUnit.SECONDS.sleep(6);
    }



}
