package custom.tibame201020.self_recorder.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 食物 Entity，記錄食物名稱和熱量資訊。
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "食物")
public class Food {

    /**
     * 食物 ID。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "食物 ID")
    private Long id;

    /**
     * 食物名稱。
     */
    @Schema(description = "食物名稱")
    private String name;

    /**
     * 熱量 (每單位)。
     */
    @Schema(description = "熱量 (每單位)")
    private Double calories;

    /**
     * 建立者。
     */
    @Schema(description = "建立者")
    private String createUser;

    /**
     * 食物類別。
     */
    @ManyToOne
    @JoinColumn(name = "food_category_id")
    @Schema(description = "食物類別")
    private FoodCategory foodCategory;

    /**
     * 食物類型 (原形食物, 加工食品)。
     */
    @ManyToOne
    @JoinColumn(name = "food_type_id")
    @Schema(description = "食物類型 (原形食物, 加工食品)")
    private FoodType foodType;
}
