package custom.tibame201020.self_recorder.service;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserExerciseLog;
import custom.tibame201020.self_recorder.repository.UserExerciseLogRepository;
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
public class UserExerciseLogServiceTest {

    @Mock
    private UserExerciseLogRepository userExerciseLogRepository;

    @InjectMocks
    private UserExerciseLogService userExerciseLogService;

    @Test
    public void getAllUserExerciseLogs_shouldReturnAllLogs() {
        // Arrange
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("testUser");

        UserExerciseLog exerciseLog1 = new UserExerciseLog();
        exerciseLog1.setUser(user);
        exerciseLog1.setExerciseName("跑步");
        exerciseLog1.setIntensity("高");
        exerciseLog1.setDuration(30.0);
        exerciseLog1.setCalories(300.0);
        exerciseLog1.setDescription("操場跑步");
        exerciseLog1.setExerciseTime(LocalDateTime.now());
        exerciseLog1.setLogTime(LocalDateTime.now());

        UserExerciseLog exerciseLog2 = new UserExerciseLog();
        exerciseLog2.setUser(user);
        exerciseLog2.setExerciseName("游泳");
        exerciseLog2.setIntensity("中");
        exerciseLog2.setDuration(60.0);
        exerciseLog2.setCalories(400.0);
        exerciseLog2.setDescription("游泳池游泳");
        exerciseLog2.setExerciseTime(LocalDateTime.now());
        exerciseLog2.setLogTime(LocalDateTime.now());

        List<UserExerciseLog> exerciseLogs = List.of(exerciseLog1, exerciseLog2);

        when(userExerciseLogRepository.findByUser(user)).thenReturn(exerciseLogs);

        // Act
        List<UserExerciseLog> result = userExerciseLogService.getAllUserExerciseLogs(user);

        // Assert
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getExerciseName()).isEqualTo("跑步");
        assertThat(result.get(1).getExerciseName()).isEqualTo("游泳");
    }

    @Test
    public void createUserExerciseLog_shouldCreateNewLog() {
        // Arrange
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("testUser");
        String exerciseName = "重訓";
        String intensity = "高";
        Double duration = 90.0;
        Double calories = 500.0;
        String description = "健身房重訓";

        UserExerciseLog exerciseLog = new UserExerciseLog();
        exerciseLog.setUser(user);
        exerciseLog.setExerciseName(exerciseName);
        exerciseLog.setIntensity(intensity);
        exerciseLog.setDuration(duration);
        exerciseLog.setCalories(calories);
        exerciseLog.setDescription(description);
        exerciseLog.setExerciseTime(LocalDateTime.now());
        exerciseLog.setLogTime(LocalDateTime.now());

        when(userExerciseLogRepository.save(any(UserExerciseLog.class))).thenReturn(exerciseLog);

        // Act
        UserExerciseLog result = userExerciseLogService.createUserExerciseLog(user, exerciseName, intensity, duration, calories, description);

        // Assert
        assertThat(result.getUser()).isEqualTo(user);
        assertThat(result.getExerciseName()).isEqualTo(exerciseName);
    }
}
