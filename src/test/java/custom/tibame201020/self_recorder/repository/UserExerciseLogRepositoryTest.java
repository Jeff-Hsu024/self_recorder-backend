package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserExerciseLog;
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
public class UserExerciseLogRepositoryTest {

    private SnowflakeIdProvider snowflakeIdProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserExerciseLogRepository userExerciseLogRepository;

    @BeforeEach
    public void setUp() {
        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.setProperty("provider.snowflake.worker-id", "0");
        mockEnvironment.setProperty("provider.snowflake.data-center-id", "0");
        snowflakeIdProvider = new SnowflakeIdProvider(mockEnvironment);
    }

    @Test
    public void whenFindByUser_thenReturnUserExerciseLogs() {
        // given
        User user = new User();
        user.setId(snowflakeIdProvider.nextId());
        user.setUsername("testUser");
        user.setEmail("test@example.com");
        user.setName("Test User");
        User savedUser = userRepository.save(user);

        UserExerciseLog exerciseLog1 = new UserExerciseLog();
        exerciseLog1.setUser(savedUser);
        exerciseLog1.setExerciseName("跑步");
        exerciseLog1.setIntensity("高");
        exerciseLog1.setDuration(30.0);
        exerciseLog1.setCalories(300.0);
        exerciseLog1.setDescription("操場跑步");
        exerciseLog1.setExerciseTime(LocalDateTime.now());
        exerciseLog1.setLogTime(LocalDateTime.now());
        userExerciseLogRepository.save(exerciseLog1);

        UserExerciseLog exerciseLog2 = new UserExerciseLog();
        exerciseLog2.setUser(savedUser);
        exerciseLog2.setExerciseName("游泳");
        exerciseLog2.setIntensity("中");
        exerciseLog2.setDuration(60.0);
        exerciseLog2.setCalories(400.0);
        exerciseLog2.setDescription("游泳池游泳");
        exerciseLog2.setExerciseTime(LocalDateTime.now());
        exerciseLog2.setLogTime(LocalDateTime.now());
        userExerciseLogRepository.save(exerciseLog2);

        // when
        List<UserExerciseLog> found = userExerciseLogRepository.findAll();

        // then
        assertThat(found).hasSize(2);
        assertThat(found.get(0).getUser().getUsername()).isEqualTo("testUser");
    }
}
