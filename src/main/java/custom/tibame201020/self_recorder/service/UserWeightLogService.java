package custom.tibame201020.self_recorder.service;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserWeightLog;
import custom.tibame201020.self_recorder.repository.UserWeightLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserWeightLogService {

    @Autowired
    private UserWeightLogRepository userWeightLogRepository;

    public List<UserWeightLog> getAllUserWeightLogs() {
        return userWeightLogRepository.findAll();
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
