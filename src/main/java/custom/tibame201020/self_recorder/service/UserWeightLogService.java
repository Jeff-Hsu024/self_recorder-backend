package custom.tibame201020.self_recorder.service;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserWeightLog;
import custom.tibame201020.self_recorder.repository.UserWeightLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserWeightLogService {

    private final UserWeightLogRepository userWeightLogRepository;

    public UserWeightLogService(UserWeightLogRepository userWeightLogRepository) {
        this.userWeightLogRepository = userWeightLogRepository;
    }

    public List<UserWeightLog> getAllUserWeightLogs(User user) {
        return userWeightLogRepository.findByUser(user);
    }

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
