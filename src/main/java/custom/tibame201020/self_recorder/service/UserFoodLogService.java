package custom.tibame201020.self_recorder.service;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserFoodLog;
import custom.tibame201020.self_recorder.repository.UserFoodLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserFoodLogService {

    @Autowired
    private UserFoodLogRepository userFoodLogRepository;

    public List<UserFoodLog> getAllUserFoodLogs() {
        return userFoodLogRepository.findAll();
    }

    public UserFoodLog createUserFoodLog(User user, String foodName, Double calories, String description) {
        UserFoodLog userFoodLog = new UserFoodLog();
        userFoodLog.setUser(user);
        userFoodLog.setFoodName(foodName);
        userFoodLog.setCalories(calories);
        userFoodLog.setDescription(description);
        userFoodLog.setEatTime(LocalDateTime.now());
        userFoodLog.setLogTime(LocalDateTime.now());
        return userFoodLogRepository.save(userFoodLog);
    }
}
