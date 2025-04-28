package custom.tibame201020.self_recorder.provider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.env.MockEnvironment;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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
        UUID id1 = snowflakeIdProvider.generateId();
        UUID id2 = snowflakeIdProvider.generateId();
        assertNotNull(id1);
        assertNotNull(id2);
        assertNotEquals(id1, id2);
    }

    @Test
    public void testUniqueIdGeneration() {
        int numIds = 100000;
        Set<UUID> generatedIds = new HashSet<>();

        for (int i = 0; i < numIds; i++) {
            UUID id = snowflakeIdProvider.generateId();
            assertNotNull(id);
            generatedIds.add(id);
        }

        assertEquals(numIds, generatedIds.size());
    }
}
