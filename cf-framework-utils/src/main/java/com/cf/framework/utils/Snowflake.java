package com.cf.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * java edition of Twitter <b>Snowflake</b>, a network service for generating
 * unique ID numbers at high scale with some simple guarantees.
 *
 * https://github.com/twitter/snowflake
 */
public class Snowflake {

    private static Logger log = LoggerFactory.getLogger(Snowflake.class);
//    private static Logger
	/*
	 * bits allocations for timeStamp, datacenterId, workerId and sequence
	 */

    private final long unusedBits = 1L;
    /**
     * 'time stamp' here is defined as the number of millisecond that have
     * elapsed since the {@link #epoch} given by users on {@link Snowflake}
     * instance initialization
     */
    private final long timestampBits = 41L;
    private final long datacenterIdBits = 5L;
    private final long workerIdBits = 5L;
    private final long sequenceBits = 12L;

    /*
     * max values of timeStamp, workerId, datacenterId and sequence
     */
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits); // 2^5-1
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits); // 2^5-1
    private final long maxSequence = -1L ^ (-1L << sequenceBits); // 2^12-1

    /**
     * left shift bits of timeStamp, workerId and datacenterId
     */
    private final long timestampShift = sequenceBits + datacenterIdBits + workerIdBits;
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    private final long workerIdShift = sequenceBits;

	/*
	 * object status variables
	 */

    /**
     * reference material of 'time stamp' is '2016-01-01'. its value can't be
     * modified after initialization.
     */
    private final long epoch = 1451606400000L;

    /**
     * data center number the process running on, its value can't be modified
     * after initialization.
     * <p>
     * max: 2^5-1 range: [0,31]
     */
    private final long datacenterId;

    /**
     * machine or process number, its value can't be modified after
     * initialization.
     * <p>
     * max: 2^5-1 range: [0,31]
     *
     */
    private final long workerId;

    /**
     * the unique and incrementing sequence number scoped in only one
     * period/unit (here is ONE millisecond). its value will be increased by 1
     * in the same specified period and then reset to 0 for next period.
     * <p>
     * max: 2^12-1 range: [0,4095]
     */
    private long sequence = 0L;

    /** the time stamp last snowflake ID generated */
    private long lastTimestamp = -1L;

    /**
     * generate an unique and incrementing id
     *
     * @return id
     */
    public synchronized long nextId() {
        long currTimestamp = timestampGen();

        if (currTimestamp < lastTimestamp) {
            throw new IllegalStateException(
                    String.format("Clock moved backwards. Refusing to generate id for %d milliseconds",
                            lastTimestamp - currTimestamp));
        }

        if (currTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & maxSequence;
            if (sequence == 0) { // overflow: greater than max sequence
                currTimestamp = waitNextMillis(currTimestamp);
            }

        } else { // reset to 0 for next period/millisecond
            sequence = 0L;
        }

        // track and memo the time stamp last snowflake ID generated
        lastTimestamp = currTimestamp;

        return ((currTimestamp - epoch) << timestampShift) | //
                (datacenterId << datacenterIdShift) | //
                (workerId << workerIdShift) | // new line for nice looking
                sequence;
    }

    /**
     * @param datacenterId
     *            data center number the process running on, value range: [0,31]
     * @param workerId
     *            machine or process number, value range: [0,31]
     */
    public Snowflake(long datacenterId, long workerId) {
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(
                    String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }

        this.datacenterId = datacenterId;
        this.workerId = workerId;
    }

    /**
     * track the amount of calling {@link #waitNextMillis(long)} method
     */
    private final AtomicLong waitCount = new AtomicLong(0);

    /**
     * @return the amount of calling {@link #waitNextMillis(long)} method
     */
    public long getWaitCount() {
        return waitCount.get();
    }

    /**
     * running loop blocking until next millisecond
     *
     * @param	currTimestamp	current time stamp
     * @return current time stamp in millisecond
     */
    protected long waitNextMillis(long currTimestamp) {
        waitCount.incrementAndGet();
        while (currTimestamp <= lastTimestamp) {
            currTimestamp = timestampGen();
        }
        return currTimestamp;
    }

    /**
     * get current time stamp
     *
     * @return current time stamp in millisecond
     */
    protected long timestampGen() {
        return System.currentTimeMillis();
    }

    /**
     * show settings of Snowflake
     */
    @Override
    public String toString() {
        return "Snowflake Settings [timestampBits=" + timestampBits + ", datacenterIdBits=" + datacenterIdBits
                + ", workerIdBits=" + workerIdBits + ", sequenceBits=" + sequenceBits + ", epoch=" + epoch
                + ", datacenterId=" + datacenterId + ", workerId=" + workerId + "]";
    }

    public long getEpoch() {
        return this.epoch;
    }

    /**
     * extract time stamp, datacenterId, workerId and sequence number
     * information from the given id
     *
     * @param id
     *            a snowflake id generated by this object
     * @return an array containing time stamp, datacenterId, workerId and
     *         sequence number
     */
    public long[] parseId(long id) {
        long[] arr = new long[5];
        arr[4] = ((id & diode(unusedBits, timestampBits)) >> timestampShift);
        arr[0] = arr[4] + epoch;
        arr[1] = (id & diode(unusedBits + timestampBits, datacenterIdBits)) >> datacenterIdShift;
        arr[2] = (id & diode(unusedBits + timestampBits + datacenterIdBits, workerIdBits)) >> workerIdShift;
        arr[3] = (id & diode(unusedBits + timestampBits + datacenterIdBits + workerIdBits, sequenceBits));
        return arr;
    }

    /**
     * extract and display time stamp, datacenterId, workerId and sequence
     * number information from the given id in humanization format
     *
     * @param id snowflake id in Long format
     * @return snowflake id in String format
     */
    public String formatId(long id) {
        long[] arr = parseId(id);
        String tmf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(arr[0]));
        return String.format("%s, #%d, @(%d,%d)", tmf, arr[3], arr[1], arr[2]);
    }

    /**
     * a diode is a long value whose left and right margin are ZERO, while
     * middle bits are ONE in binary string layout. it looks like a diode in
     * shape.
     *
     * @param offset
     *            left margin position
     * @param length
     *            offset+length is right margin position
     * @return a long value
     */
    private long diode(long offset, long length) {
        int lb = (int) (64 - offset);
        int rb = (int) (64 - (offset + length));
        return (-1L << lb) ^ (-1L << rb);
    }

    public static void main(String[] args) {
        Snowflake idWorker = new Snowflake(1, 2);
        Snowflake idWorker2 = new Snowflake(1, 3);
        for(int i=0;i<10;i++){
            long l = idWorker.nextId();
            long l2 = idWorker2.nextId();
            System.out.println(l);
            System.out.println(l2);
        }

    }
}

