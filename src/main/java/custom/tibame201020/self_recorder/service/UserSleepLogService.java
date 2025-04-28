package custom.tibame201020.self_recorder.service;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserSleepLog;
import custom.tibame201020.self_recorder.repository.UserSleepLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserSleepLogService {

    private final UserSleepLogRepository userSleepLogRepository;

    public UserSleepLogService(UserSleepLogRepository userSleepLogRepository) {
        this.userSleepLogRepository = userSleepLogRepository;
    }

    public List<UserSleepLog> getAllUserSleepLogs(User user) {
        return userSleepLogRepository.findByUser(user);
    }

    public UserSleepLog createUserSleepLog(User user, LocalDateTime sleepTime, LocalDateTime wakeUpTime) {
        UserSleepLog userSleepLog = new UserSleepLog();
        userSleepLog.setUser(user);
        userSleepLog.setSleepTime(sleepTime);
        userSleepLog.setWakeUpTime(wakeUpTime);
        return userSleepLogRepository.save(userSleepLog);
    }
}
