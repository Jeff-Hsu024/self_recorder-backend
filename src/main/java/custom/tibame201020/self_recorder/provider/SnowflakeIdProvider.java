package custom.tibame201020.self_recorder.provider;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Snowflake ID 提供者，用於生成分散式唯一 ID。
 */
@Component
public class SnowflakeIdProvider {

    private static final String WORKER_ID_PROPERTY = "provider.snowflake.worker-id";
    private static final String DATA_CENTER_ID_PROPERTY = "provider.snowflake.data-center-id";

    private final long EPOCH = 1609459200000L; // 2021-01-01 00:00:00 UTC
    private final long WORKER_ID_BITS = 5L;
    private final long DATA_CENTER_ID_BITS = 5L;
    private final long SEQUENCE_BITS = 12L;

    private final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);
    private final long MAX_DATA_CENTER_ID = ~(-1L << DATA_CENTER_ID_BITS);

    private final long WORKER_ID_SHIFT = SEQUENCE_BITS;
    private final long DATA_CENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
    private final long TIMESTAMP_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATA_CENTER_ID_BITS;

    private final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);

    private final long workerId;
    private final long dataCenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    /**
     * 建構子。
     *
     * @param environment Spring 環境
     */
    public SnowflakeIdProvider(Environment environment) {
        long workerId = environment.getRequiredProperty(WORKER_ID_PROPERTY, Long.class);
        long dataCenterId = environment.getRequiredProperty(DATA_CENTER_ID_PROPERTY, Long.class);

        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(String.format("Worker ID cannot be greater than %d or less than 0", MAX_WORKER_ID));
        }
        if (dataCenterId > MAX_DATA_CENTER_ID || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format("DataCenter ID cannot be greater than %d or less than 0", MAX_DATA_CENTER_ID));
        }

        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    /**
     * 生成下一個 ID。
     *
     * @return 下一個 ID
     */
    public synchronized long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        long id = ((timestamp - EPOCH) << TIMESTAMP_SHIFT) |
                (dataCenterId << DATA_CENTER_ID_SHIFT) |
                (workerId << WORKER_ID_SHIFT) |
                sequence;

        return id;
    }

    /**
     * 阻塞到下一個毫秒。
     *
     * @param lastTimestamp 上一次的時間戳
     * @return 下一個時間戳
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 生成時間戳。
     *
     * @return 當前時間戳
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }
}
