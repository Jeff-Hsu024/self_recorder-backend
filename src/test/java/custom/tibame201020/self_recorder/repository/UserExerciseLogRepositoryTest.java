package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserExerciseLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserExerciseLogRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserExerciseLogRepository userExerciseLogRepository;

    @Test
    public void whenFindByUser_thenReturnUserExerciseLogs() {
        // given
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("testUser");
        entityManager.persist(user);

        UserExerciseLog exerciseLog1 = new UserExerciseLog();
        exerciseLog1.setUser(user);
        exerciseLog1.setExerciseName("跑步");
        exerciseLog1.setIntensity("高");
        exerciseLog1.setDuration(30.0);
        exerciseLog1.setCalories(300.0);
        exerciseLog1.setDescription("操場跑步");
        exerciseLog1.setExerciseTime(LocalDateTime.now());
        exerciseLog1.setLogTime(LocalDateTime.now());
        entityManager.persist(exerciseLog1);

        UserExerciseLog exerciseLog2 = new UserExerciseLog();
        exerciseLog2.setUser(user);
        exerciseLog2.setExerciseName("游泳");
        exerciseLog2.setIntensity("中");
        exerciseLog2.setDuration(60.0);
        exerciseLog2.setCalories(400.0);
        exerciseLog2.setDescription("游泳池游泳");
        exerciseLog2.setExerciseTime(LocalDateTime.now());
        exerciseLog2.setLogTime(LocalDateTime.now());
        entityManager.persist(exerciseLog2);

        entityManager.flush();

        // when
        List<UserExerciseLog> found = userExerciseLogRepository.findAll();

        // then
        assertThat(found).hasSize(2);
        assertThat(found.get(0).getUser().getUsername()).isEqualTo("testUser");
    }
}
