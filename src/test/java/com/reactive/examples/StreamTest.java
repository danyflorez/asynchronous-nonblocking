package com.reactive.examples;

import com.reactive.examples.external.TransactionServiceBlocking;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamTest.class.getName());

    @Test
    void streamBlockingExample()  {
        var transactionService = new TransactionServiceBlocking();

        IntStream.range(0, 4)
                .map(transactionService::get)
                .map(transactionService::process)
                .forEach(i -> LOGGER.info("Client: " + i));
    }
}
