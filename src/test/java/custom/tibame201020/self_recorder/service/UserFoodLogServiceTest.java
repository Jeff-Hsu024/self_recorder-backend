package custom.tibame201020.self_recorder.service;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserFoodLog;
import custom.tibame201020.self_recorder.repository.UserFoodLogRepository;
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
public class UserFoodLogServiceTest {

    @Mock
    private UserFoodLogRepository userFoodLogRepository;

    @InjectMocks
    private UserFoodLogService userFoodLogService;

    @Test
    public void getAllUserFoodLogs_shouldReturnAllLogs() {
        // Arrange
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("testUser");

        UserFoodLog foodLog1 = new UserFoodLog();
        foodLog1.setUser(user);
        foodLog1.setFoodName("雞腿便當");
        foodLog1.setCalories(800.0);
        foodLog1.setDescription("豐富的雞腿便當");
        foodLog1.setEatTime(LocalDateTime.now());
        foodLog1.setLogTime(LocalDateTime.now());

        UserFoodLog foodLog2 = new UserFoodLog();
        foodLog2.setUser(user);
        foodLog2.setFoodName("滷肉飯");
        foodLog2.setCalories(500.0);
        foodLog2.setDescription("香噴噴的滷肉飯");
        foodLog2.setEatTime(LocalDateTime.now());
        foodLog2.setLogTime(LocalDateTime.now());

        List<UserFoodLog> foodLogs = List.of(foodLog1, foodLog2);

        when(userFoodLogRepository.findByUser(user)).thenReturn(foodLogs);

        // Act
        List<UserFoodLog> result = userFoodLogService.getAllUserFoodLogs(user);

        // Assert
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getFoodName()).isEqualTo("雞腿便當");
        assertThat(result.get(1).getFoodName()).isEqualTo("滷肉飯");
    }

    @Test
    public void createUserFoodLog_shouldCreateNewLog() {
        // Arrange
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("testUser");
        String foodName = "牛肉麵";
        Double calories = 600.0;
        String description = "好吃的牛肉麵";

        UserFoodLog foodLog = new UserFoodLog();
        foodLog.setUser(user);
        foodLog.setFoodName(foodName);
        foodLog.setCalories(calories);
        foodLog.setDescription(description);
        foodLog.setEatTime(LocalDateTime.now());
        foodLog.setLogTime(LocalDateTime.now());

        when(userFoodLogRepository.save(any(UserFoodLog.class))).thenReturn(foodLog);

        // Act
        UserFoodLog result = userFoodLogService.createUserFoodLog(user, foodName, calories, description);

        // Assert
        assertThat(result.getUser()).isEqualTo(user);
        assertThat(result.getFoodName()).isEqualTo(foodName);
    }
}
