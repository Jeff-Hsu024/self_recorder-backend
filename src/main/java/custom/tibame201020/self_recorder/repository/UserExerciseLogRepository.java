package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserExerciseLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 使用者運動記錄 Repository 介面，用於存取使用者運動記錄資料。
 */
public interface UserExerciseLogRepository extends JpaRepository<UserExerciseLog, Long> {

    List<UserExerciseLog> findByUser(User user);
}
