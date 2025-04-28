package custom.tibame201020.self_recorder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "exercise")
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exercise_id")
	private Long exerciseId;

	@Column(name = "exercise_name", nullable = false)
	private String exerciseName;

	@Column(name = "calories_per_unit", nullable = false)
	private Double caloriesPerUnit;

	// 新增的欄位
	@Column(name = "unit", nullable = false)
	private String unit;

	@Column(name = "description")
	private String description;

}
