package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserWeightLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserWeightLogRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserWeightLogRepository userWeightLogRepository;

    @Test
    public void whenFindByUser_thenReturnUserWeightLogs() {
        // given
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("testUser");
        entityManager.persist(user);

        UserWeightLog weightLog1 = UserWeightLog.builder()
                .user(user)
                .recordDatetime(LocalDateTime.now())
                .weight(70.0)
                .logTime(LocalDateTime.now())
                .build();
        entityManager.persist(weightLog1);

        UserWeightLog weightLog2 = UserWeightLog.builder()
                .user(user)
                .recordDatetime(LocalDateTime.now())
                .weight(72.0)
                .logTime(LocalDateTime.now())
                .build();
        entityManager.persist(weightLog2);

        entityManager.flush();

        // when
        List<UserWeightLog> found = userWeightLogRepository.findAll();

        // then
        assertThat(found).hasSize(2);
        assertThat(found.get(0).getUser().getUsername()).isEqualTo("testUser");
    }
}
