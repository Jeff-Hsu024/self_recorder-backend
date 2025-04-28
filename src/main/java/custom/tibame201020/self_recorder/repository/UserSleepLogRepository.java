package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.UserSleepLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 使用者睡眠記錄 Repository 介面，用於存取使用者睡眠記錄資料。
 */
@Repository
public interface UserSleepLogRepository extends JpaRepository<UserSleepLog, Long> {
}
