package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserFoodLog;
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
public class UserFoodLogRepositoryTest {

    private SnowflakeIdProvider snowflakeIdProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFoodLogRepository userFoodLogRepository;

    @BeforeEach
    public void setUp() {
        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.setProperty("provider.snowflake.worker-id", "0");
        mockEnvironment.setProperty("provider.snowflake.data-center-id", "0");
        snowflakeIdProvider = new SnowflakeIdProvider(mockEnvironment);
    }

    @Test
    public void whenFindByUser_thenReturnUserFoodLogs() {
        // given
        User user = new User();
        user.setId(snowflakeIdProvider.nextId());
        user.setUsername("testUser");
        User savedUser = userRepository.save(user);

        UserFoodLog foodLog1 = new UserFoodLog();
        foodLog1.setUser(savedUser);
        foodLog1.setFoodName("雞腿便當");
        foodLog1.setCalories(800.0);
        foodLog1.setDescription("豐富的雞腿便當");
        foodLog1.setEatTime(LocalDateTime.now());
        foodLog1.setLogTime(LocalDateTime.now());
        userFoodLogRepository.save(foodLog1);

        UserFoodLog foodLog2 = new UserFoodLog();
        foodLog2.setUser(savedUser);
        foodLog2.setFoodName("滷肉飯");
        foodLog2.setCalories(500.0);
        foodLog2.setDescription("香噴噴的滷肉飯");
        foodLog2.setEatTime(LocalDateTime.now());
        foodLog2.setLogTime(LocalDateTime.now());
        userFoodLogRepository.save(foodLog2);


        // when
        List<UserFoodLog> found = userFoodLogRepository.findAll();

        // then
        assertThat(found).hasSize(2);
        assertThat(found.get(0).getUser().getUsername()).isEqualTo("testUser");
    }
}
