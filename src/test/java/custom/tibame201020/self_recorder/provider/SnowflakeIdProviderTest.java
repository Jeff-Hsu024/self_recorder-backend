package custom.tibame201020.self_recorder.provider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.env.MockEnvironment;

import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class SnowflakeIdProviderTest {

    private SnowflakeIdProvider snowflakeIdProvider;

    @BeforeEach
    public void setUp() {
        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.setProperty("provider.snowflake.worker-id", "0");
        mockEnvironment.setProperty("provider.snowflake.data-center-id", "0");
        snowflakeIdProvider = new SnowflakeIdProvider(mockEnvironment);
    }

    @Test
    public void testGenerateId() {
        var id1 = snowflakeIdProvider.nextId();
        var id2 = snowflakeIdProvider.nextId();
        assertNotNull(id1);
        assertNotNull(id2);
        assertNotEquals(id1, id2);
    }

    @Test
    public void testUniqueIdGeneration() {
        int numIds = 100000;
        Set<Long> generatedIds = new HashSet<>();

        for (int i = 0; i < numIds; i++) {
            var id = snowflakeIdProvider.nextId();
            assertNotNull(id);
            generatedIds.add(id);
        }

        assertEquals(numIds, generatedIds.size());
    }
}
