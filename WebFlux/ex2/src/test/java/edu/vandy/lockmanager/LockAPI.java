package edu.vandy.lockmanager;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static edu.vandy.lockmanager.Constants.Endpoints.*;

/**
 * An auto-generated proxy used by clients to access the
 * capabilities of the {@link LockApplication} microservice.
 */
public interface LockAPI {
    /**
     * Initialize the {@link Lock} manager.
     *
     * @param maxLocks The total number of {@link Lock}
     *                 objects to create
     */
    @PostExchange(CREATE)
    void create(@RequestBody Integer maxLocks);

    /**
     * Acquire a {@link Lock}.
     *
     * @return A {@link Mono} that emits a newly acquired
     *         {@link Lock}
     */
    @GetExchange(ACQUIRE_LOCK)
    Mono<Lock> acquire();

    /**
     * Acquire {@code permits} number of {@link Lock} objects.
     *
     * @param permits The number of permits to acquire
     * @return A {@link Flux} that emits {@code permits} newly
     *         acquired {@link Lock} objects
     */
    @GetExchange(ACQUIRE_LOCK)
    Flux<Lock> acquire(int permits);

    /**
     * Release the {@code lock} back to the {@link Lock} manager.
     *
     * @param lock A {@link Lock} to release
     * @return A {@link Mono} that emits a {@link Void}
     */
    @PostExchange(RELEASE_LOCK)
    Mono<Void> release(@RequestBody Lock lock);
}
