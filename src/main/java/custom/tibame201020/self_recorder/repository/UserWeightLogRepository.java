package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.UserWeightLog;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 體重記錄 Repository 介面，用於存取體重記錄資料。
 *
 * <p>
 *   此介面繼承自 {@link JpaRepository}，提供了基本的 CRUD (新增、讀取、更新、刪除) 功能，
 *   以及分頁和排序功能。
 * </p>
 *
 * @author  [您的名字]
 * @version 1.0
 * @since   2025-04-28
 */
@Repository
@Tag(name = "UserWeightLog", description = "體重記錄相關 API")
public interface UserWeightLogRepository extends JpaRepository<UserWeightLog, Long> {
}
