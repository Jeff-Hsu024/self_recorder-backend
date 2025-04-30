package custom.tibame201020.self_recorder.service;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserExerciseLog;
import custom.tibame201020.self_recorder.repository.UserExerciseLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 使用者運動記錄服務。
 * 提供使用者運動記錄的相關操作。
 */
@Service
public class UserExerciseLogService {

    private final UserExerciseLogRepository userExerciseLogRepository;

    public UserExerciseLogService(UserExerciseLogRepository userExerciseLogRepository) {
        this.userExerciseLogRepository = userExerciseLogRepository;
    }

    /**
     * 取得所有使用者運動記錄。
     *
     * @param user 使用者
     * @return 使用者運動記錄列表
     */
    public List<UserExerciseLog> getAllUserExerciseLogs(User user) {
        return userExerciseLogRepository.findByUser(user);
    }

    /**
     * 建立使用者運動記錄。
     *
     * @param user 使用者
     * @param exerciseName 運動名稱
     * @param intensity 運動強度
     * @param duration 運動持續時間
     * @param calories 消耗卡路里
     * @param description 運動描述
     * @return 使用者運動記錄
     */
    public UserExerciseLog createUserExerciseLog(User user, String exerciseName, String intensity, Double duration, Double calories, String description) {
        UserExerciseLog userExerciseLog = new UserExerciseLog();
        userExerciseLog.setUser(user);
        userExerciseLog.setExerciseName(exerciseName);
        userExerciseLog.setIntensity(intensity);
        userExerciseLog.setDuration(duration);
        userExerciseLog.setCalories(calories);
        userExerciseLog.setDescription(description);
        userExerciseLog.setExerciseTime(LocalDateTime.now());
        userExerciseLog.setLogTime(LocalDateTime.now());
        return userExerciseLogRepository.save(userExerciseLog);
    }
}
