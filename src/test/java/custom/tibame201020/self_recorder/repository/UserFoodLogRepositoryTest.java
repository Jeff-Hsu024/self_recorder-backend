package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserFoodLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserFoodLogRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserFoodLogRepository userFoodLogRepository;

    @Test
    public void whenFindByUser_thenReturnUserFoodLogs() {
        // given
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("testUser");
        entityManager.persist(user);

        UserFoodLog foodLog1 = new UserFoodLog();
        foodLog1.setUser(user);
        foodLog1.setFoodName("雞腿便當");
        foodLog1.setCalories(800.0);
        foodLog1.setDescription("豐富的雞腿便當");
        foodLog1.setEatTime(LocalDateTime.now());
        foodLog1.setLogTime(LocalDateTime.now());
        entityManager.persist(foodLog1);

        UserFoodLog foodLog2 = new UserFoodLog();
        foodLog2.setUser(user);
        foodLog2.setFoodName("滷肉飯");
        foodLog2.setCalories(500.0);
        foodLog2.setDescription("香噴噴的滷肉飯");
        foodLog2.setEatTime(LocalDateTime.now());
        foodLog2.setLogTime(LocalDateTime.now());
        entityManager.persist(foodLog2);

        entityManager.flush();

        // when
        List<UserFoodLog> found = userFoodLogRepository.findAll();

        // then
        assertThat(found).hasSize(2);
        assertThat(found.get(0).getUser().getUsername()).isEqualTo("testUser");
    }
}
