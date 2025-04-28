package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 食物 Repository 介面，用於存取食物資料。
 */
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
