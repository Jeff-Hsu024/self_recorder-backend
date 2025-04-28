package custom.tibame201020.self_recorder.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 食物類型 Entity，記錄食物類型資訊。
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "食物類型")
public class FoodType {

    /**
     * 類型 ID。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "類型 ID")
    private Long id;

    /**
     * 類型名稱。
     */
    @Schema(description = "類型名稱")
    private String name;

    /**
     * 類型描述。
     */
    @Schema(description = "類型描述")
    private String description;
}
