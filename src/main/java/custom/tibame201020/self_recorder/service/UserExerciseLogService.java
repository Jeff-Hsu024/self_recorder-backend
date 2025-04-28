package custom.tibame201020.self_recorder.service;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserExerciseLog;
import custom.tibame201020.self_recorder.repository.UserExerciseLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserExerciseLogService {

    @Autowired
    private UserExerciseLogRepository userExerciseLogRepository;

    public List<UserExerciseLog> getAllUserExerciseLogs() {
        return userExerciseLogRepository.findAll();
    }

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
