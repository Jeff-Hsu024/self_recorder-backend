package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 食物類型 Repository 介面，用於存取食物類型資料。
 */
@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {
}
