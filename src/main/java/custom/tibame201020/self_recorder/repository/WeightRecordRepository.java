package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.WeightRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 體重記錄 Repository 介面，用於存取體重記錄資料。
 */
@Repository
public interface WeightRecordRepository extends JpaRepository<WeightRecord, Long> {
}
