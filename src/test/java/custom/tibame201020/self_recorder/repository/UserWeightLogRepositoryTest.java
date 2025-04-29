package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserWeightLog;
import custom.tibame201020.self_recorder.provider.SnowflakeIdProvider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserWeightLogRepositoryTest {

    private SnowflakeIdProvider snowflakeIdProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserWeightLogRepository userWeightLogRepository;

    @BeforeEach
    public void setUp() {
        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.setProperty("provider.snowflake.worker-id", "0");
        mockEnvironment.setProperty("provider.snowflake.data-center-id", "0");
        snowflakeIdProvider = new SnowflakeIdProvider(mockEnvironment);
    }

    @Test
    public void whenFindByUser_thenReturnUserWeightLogs() {
        // given
        User user = new User();
        user.setId(snowflakeIdProvider.nextId());
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setName("Test User");
        User savedUser = userRepository.save(user);

        UserWeightLog weightLog1 = UserWeightLog.builder()
                .user(savedUser)
                .recordDatetime(LocalDateTime.now())
                .weight(70.0)
                .logTime(LocalDateTime.now())
                .build();
        userWeightLogRepository.save(weightLog1);

        UserWeightLog weightLog2 = UserWeightLog.builder()
                .user(savedUser)
                .recordDatetime(LocalDateTime.now())
                .weight(72.0)
                .logTime(LocalDateTime.now())
                .build();
        userWeightLogRepository.save(weightLog2);

        // when
        List<UserWeightLog> found = userWeightLogRepository.findAll();

        // then
        assertThat(found).hasSize(2);
        assertThat(found.get(0).getUser().getUsername()).isEqualTo("testUser");
    }
}
