package atomiclongs;

import java.util.concurrent.atomic.AtomicLong;

/**
 * This class implements a subset of the {@code AtomicLong} class
 * using {@link AtomicLong} itself.
 */
public class AtomicLongAdapter
       implements AbstractAtomicLong {
    /**
     * The value that's manipulated atomically via the methods.
     */
    private final AtomicLong mAtomicLong;

    /**
     * Creates a new SimpleAtomicLong with the given initial value.
     */
    public AtomicLongAdapter(long initialValue) {
        // Store the initial value in mAtomicLong.
        mAtomicLong = new AtomicLong(initialValue);
    }

    /**
     * Get the current value.
     * 
     * @return The current value
     */
    public long get() {
        // This read is guaranteed to be atomic.
        return mAtomicLong.get();
    }

    /**
     * Atomically increments the current value by one.
     *
     * @return the updated value
     */
    public long incrementAndGet() {
        synchronized (this) {
            // This operation is guaranteed to be atomic.
            return mAtomicLong.incrementAndGet();
        }
    }

    /**
     * Atomically decrement the current value by one.
     *
     * @return The updated value
     */
    public long decrementAndGet() {
        synchronized (this) {
            // This operation is guaranteed to be atomic.
            return mAtomicLong.decrementAndGet();
        }
    }

    /**
     * Atomically increment the current value by one.
     *
     * @return The previous value
     */
    public long getAndIncrement() {
        synchronized (this) {
            // This operation is guaranteed to be atomic.
            return mAtomicLong.getAndIncrement();
        } 
    }

    /**
     * Atomically decrement the current value by one.
     *
     * @return The previous value
     */
    public long getAndDecrement() {
        synchronized (this) {
            // This operation is guaranteed to be atomic.
            return mAtomicLong.getAndDecrement();
        } 
    }
}

