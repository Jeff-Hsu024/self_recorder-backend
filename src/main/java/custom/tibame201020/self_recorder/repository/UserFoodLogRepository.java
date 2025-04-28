package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.entity.UserFoodLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 使用者食物記錄 Repository 介面，用於存取使用者食物記錄資料。
 */
public interface UserFoodLogRepository extends JpaRepository<UserFoodLog, Long> {

    List<UserFoodLog> findByUser(User user);
}
