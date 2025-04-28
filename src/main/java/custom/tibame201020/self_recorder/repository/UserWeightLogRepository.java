package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserWeightLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 體重記錄 Repository 介面，用於存取體重記錄資料。
 */
public interface UserWeightLogRepository extends JpaRepository<UserWeightLog, Long> {

    List<UserWeightLog> findByUser(User user);
}
