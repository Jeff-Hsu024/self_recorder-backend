package custom.tibame201020.self_recorder.service;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserWeightLog;
import custom.tibame201020.self_recorder.repository.UserWeightLogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserWeightLogServiceTest {

    @Mock
    private UserWeightLogRepository userWeightLogRepository;

    @InjectMocks
    private UserWeightLogService userWeightLogService;

    @Test
    public void getAllUserWeightLogs_shouldReturnAllLogs() {
        // Arrange
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("testUser");

        UserWeightLog weightLog1 = UserWeightLog.builder()
                .user(user)
                .recordDatetime(LocalDateTime.now())
                .weight(70.0)
                .logTime(LocalDateTime.now())
                .build();

        UserWeightLog weightLog2 = UserWeightLog.builder()
                .user(user)
                .recordDatetime(LocalDateTime.now())
                .weight(72.0)
                .logTime(LocalDateTime.now())
                .build();

        List<UserWeightLog> weightLogs = List.of(weightLog1, weightLog2);

        when(userWeightLogRepository.findByUser(user)).thenReturn(weightLogs);

        // Act
        List<UserWeightLog> result = userWeightLogService.getAllUserWeightLogs(user);

        // Assert
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getWeight()).isEqualTo(70.0);
        assertThat(result.get(1).getWeight()).isEqualTo(72.0);
    }

    @Test
    public void createUserWeightLog_shouldCreateNewLog() {
        // Arrange
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("testUser");
        Double weight = 75.0;

        UserWeightLog weightLog = UserWeightLog.builder()
                .user(user)
                .recordDatetime(LocalDateTime.now())
                .weight(weight)
                .logTime(LocalDateTime.now())
                .build();

        when(userWeightLogRepository.save(any(UserWeightLog.class))).thenReturn(weightLog);

        // Act
        UserWeightLog result = userWeightLogService.createUserWeightLog(user, weight);

        // Assert
        assertThat(result.getUser()).isEqualTo(user);
        assertThat(result.getWeight()).isEqualTo(weight);
    }
}
