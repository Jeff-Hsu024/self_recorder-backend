package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 食物類別 Repository 介面，用於存取食物類別資料。
 */
@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
