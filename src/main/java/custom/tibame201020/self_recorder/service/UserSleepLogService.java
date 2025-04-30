package custom.tibame201020.self_recorder.service;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserSleepLog;
import custom.tibame201020.self_recorder.repository.UserSleepLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 使用者睡眠記錄服務。
 * 提供使用者睡眠記錄的相關操作。
 */
@Service
public class UserSleepLogService {

    private final UserSleepLogRepository userSleepLogRepository;

    public UserSleepLogService(UserSleepLogRepository userSleepLogRepository) {
        this.userSleepLogRepository = userSleepLogRepository;
    }

    /**
     * 取得所有使用者睡眠記錄。
     *
     * @param user 使用者
     * @return 使用者睡眠記錄列表
     */
    public List<UserSleepLog> getAllUserSleepLogs(User user) {
        return userSleepLogRepository.findByUser(user);
    }

    /**
     * 建立使用者睡眠記錄。
     *
     * @param user 使用者
     * @param sleepTime 睡覺時間
     * @param wakeUpTime 起床時間
     * @return 使用者睡眠記錄
     */
    public UserSleepLog createUserSleepLog(User user, LocalDateTime sleepTime, LocalDateTime wakeUpTime) {
        UserSleepLog userSleepLog = new UserSleepLog();
        userSleepLog.setUser(user);
        userSleepLog.setSleepTime(sleepTime);
        userSleepLog.setWakeUpTime(wakeUpTime);
        return userSleepLogRepository.save(userSleepLog);
    }
}
