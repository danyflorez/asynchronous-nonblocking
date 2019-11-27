package com.reactive.examples.external;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class TransactionServiceNonBlocking extends TransactionBase{

    public Mono<Integer> get(Integer id) {
        LOGGER.info("GET Of " + id +  " Thread: " + Thread.currentThread().getName());
        return Mono.fromCallable(() -> getTransaction(id))
                .subscribeOn(Schedulers.boundedElastic());  // wrap a synchronous, blocking call
    }

    public Mono<Integer> process(Integer id) {
        return Mono.fromCallable(() -> processTransaction(id))
                .subscribeOn(Schedulers.boundedElastic());  // wrap a synchronous, blocking call
    }
}
