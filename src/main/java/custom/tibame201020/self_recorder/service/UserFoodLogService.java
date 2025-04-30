package custom.tibame201020.self_recorder.service;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserFoodLog;
import custom.tibame201020.self_recorder.repository.UserFoodLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 使用者食物記錄服務。
 * 提供使用者食物記錄的相關操作。
 */
@Service
public class UserFoodLogService {

    private final UserFoodLogRepository userFoodLogRepository;

    public UserFoodLogService(UserFoodLogRepository userFoodLogRepository) {
        this.userFoodLogRepository = userFoodLogRepository;
    }

    /**
     * 取得所有使用者食物記錄。
     *
     * @param user 使用者
     * @return 使用者食物記錄列表
     */
    public List<UserFoodLog> getAllUserFoodLogs(User user) {
        return userFoodLogRepository.findByUser(user);
    }

    /**
     * 建立使用者食物記錄。
     *
     * @param user 使用者
     * @param foodName 食物名稱
     * @param calories 卡路里
     * @param description 描述
     * @return 使用者食物記錄
     */
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
