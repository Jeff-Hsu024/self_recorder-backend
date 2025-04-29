package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserSleepLog;
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
public class UserSleepLogRepositoryTest {

    private SnowflakeIdProvider snowflakeIdProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSleepLogRepository userSleepLogRepository;

    @BeforeEach
    public void setUp() {
        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.setProperty("provider.snowflake.worker-id", "0");
        mockEnvironment.setProperty("provider.snowflake.data-center-id", "0");
        snowflakeIdProvider = new SnowflakeIdProvider(mockEnvironment);
    }

    @Test
    public void whenFindByUser_thenReturnUserSleepLogs() {
        // given
        User user = new User();
        user.setId(snowflakeIdProvider.nextId());
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setName("Test User");
        User savedUser = userRepository.save(user);

        UserSleepLog sleepLog1 = new UserSleepLog();
        sleepLog1.setUser(savedUser);
        sleepLog1.setSleepTime(LocalDateTime.now().minusHours(8));
        sleepLog1.setWakeUpTime(LocalDateTime.now());
        userSleepLogRepository.save(sleepLog1);

        UserSleepLog sleepLog2 = new UserSleepLog();
        sleepLog2.setUser(savedUser);
        sleepLog2.setSleepTime(LocalDateTime.now().minusHours(7));
        sleepLog2.setWakeUpTime(LocalDateTime.now().plusHours(1));
        userSleepLogRepository.save(sleepLog2);

        // when
        List<UserSleepLog> found = userSleepLogRepository.findAll();

        // then
        assertThat(found).hasSize(2);
        assertThat(found.get(0).getUser().getUsername()).isEqualTo("testUser");
    }
}
