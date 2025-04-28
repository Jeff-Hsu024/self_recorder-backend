package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 運動 Repository 介面，用於存取運動資料。
 */
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
