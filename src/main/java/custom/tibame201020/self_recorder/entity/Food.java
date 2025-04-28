package custom.tibame201020.self_recorder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "food")
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	private Long foodId;

	@Column(name = "food_name", nullable = false)
	private String foodName;

	@ManyToOne
	@JoinColumn(name = "food_category_id", nullable = false)
	private FoodCategory foodCategory;

	@ManyToOne
	@JoinColumn(name = "food_type_id", nullable = false)
	private FoodType foodType;

	@Column(name = "calories_per_unit", nullable = false)
	private Double caloriesPerUnit;

	// 新增的欄位
	@Column(name = "unit", nullable = false)
	private String unit;

	@Column(name = "protein", nullable = false)
	private Double protein;

	@Column(name = "fat", nullable = false)
	private Double fat;

	@Column(name = "carbohydrates", nullable = false)
	private Double carbohydrates;

}
