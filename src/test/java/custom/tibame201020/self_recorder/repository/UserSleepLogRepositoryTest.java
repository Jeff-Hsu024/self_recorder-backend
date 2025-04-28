package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserSleepLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserSleepLogRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserSleepLogRepository userSleepLogRepository;

    @Test
    public void whenFindByUser_thenReturnUserSleepLogs() {
        // given
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("testUser");
        entityManager.persist(user);

        UserSleepLog sleepLog1 = new UserSleepLog();
        sleepLog1.setUser(user);
        sleepLog1.setSleepTime(LocalDateTime.now().minusHours(8));
        sleepLog1.setWakeUpTime(LocalDateTime.now());
        entityManager.persist(sleepLog1);

        UserSleepLog sleepLog2 = new UserSleepLog();
        sleepLog2.setUser(user);
        sleepLog2.setSleepTime(LocalDateTime.now().minusHours(7));
        sleepLog2.setWakeUpTime(LocalDateTime.now().plusHours(1));
        entityManager.persist(sleepLog2);

        entityManager.flush();

        // when
        List<UserSleepLog> found = userSleepLogRepository.findAll();

        // then
        assertThat(found).hasSize(2);
        assertThat(found.get(0).getUser().getUsername()).isEqualTo("testUser");
    }
}
