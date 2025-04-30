package custom.tibame201020.self_recorder.service;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserWeightLog;
import custom.tibame201020.self_recorder.repository.UserWeightLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 使用者體重記錄服務。
 * 提供使用者體重記錄的相關操作。
 */
@Service
public class UserWeightLogService {

    private final UserWeightLogRepository userWeightLogRepository;

    public UserWeightLogService(UserWeightLogRepository userWeightLogRepository) {
        this.userWeightLogRepository = userWeightLogRepository;
    }

    /**
     * 取得所有使用者體重記錄。
     *
     * @param user 使用者
     * @return 使用者體重記錄列表
     */
    public List<UserWeightLog> getAllUserWeightLogs(User user) {
        return userWeightLogRepository.findByUser(user);
    }

    /**
     * 建立使用者體重記錄。
     *
     * @param user 使用者
     * @param weight 體重
     * @return 使用者體重記錄
     */
    public UserWeightLog createUserWeightLog(User user, Double weight) {
        UserWeightLog userWeightLog = UserWeightLog.builder()
                .user(user)
                .recordDatetime(LocalDateTime.now())
                .weight(weight)
                .logTime(LocalDateTime.now())
                .build();
        return userWeightLogRepository.save(userWeightLog);
    }
}
