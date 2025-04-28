package custom.tibame201020.self_recorder.service;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserSleepLog;
import custom.tibame201020.self_recorder.repository.UserSleepLogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserSleepLogServiceTest {

    @Mock
    private UserSleepLogRepository userSleepLogRepository;

    @InjectMocks
    private UserSleepLogService userSleepLogService;

    @Test
    public void getAllUserSleepLogs_shouldReturnAllLogs() {
        // Arrange
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("testUser");

        UserSleepLog sleepLog1 = new UserSleepLog();
        sleepLog1.setUser(user);
        sleepLog1.setSleepTime(LocalDateTime.now().minusHours(8));
        sleepLog1.setWakeUpTime(LocalDateTime.now());

        UserSleepLog sleepLog2 = new UserSleepLog();
        sleepLog2.setUser(user);
        sleepLog2.setSleepTime(LocalDateTime.now().minusHours(7));
        sleepLog2.setWakeUpTime(LocalDateTime.now().plusHours(1));

        List<UserSleepLog> sleepLogs = List.of(sleepLog1, sleepLog2);

        when(userSleepLogRepository.findAll()).thenReturn(sleepLogs);

        // Act
        List<UserSleepLog> result = userSleepLogService.getAllUserSleepLogs();

        // Assert
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getSleepTime()).isEqualTo(sleepLog1.getSleepTime());
        assertThat(result.get(1).getSleepTime()).isEqualTo(sleepLog2.getSleepTime());
    }

    @Test
    public void createUserSleepLog_shouldCreateNewLog() {
        // Arrange
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("testUser");
        LocalDateTime sleepTime = LocalDateTime.now().minusHours(8);
        LocalDateTime wakeUpTime = LocalDateTime.now();

        UserSleepLog sleepLog = new UserSleepLog();
        sleepLog.setUser(user);
        sleepLog.setSleepTime(sleepTime);
        sleepLog.setWakeUpTime(wakeUpTime);

        when(userSleepLogRepository.save(any(UserSleepLog.class))).thenReturn(sleepLog);

        // Act
        UserSleepLog result = userSleepLogService.createUserSleepLog(user, sleepTime, wakeUpTime);

        // Assert
        assertThat(result.getUser()).isEqualTo(user);
        assertThat(result.getSleepTime()).isEqualTo(sleepTime);
    }
}
