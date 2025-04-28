package custom.tibame201020.self_recorder.service;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserSleepLog;
import custom.tibame201020.self_recorder.repository.UserSleepLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserSleepLogService {

    @Autowired
    private UserSleepLogRepository userSleepLogRepository;

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
