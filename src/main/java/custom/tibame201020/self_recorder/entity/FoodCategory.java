package custom.tibame201020.self_recorder.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 食物類別 Entity，記錄食物類別資訊。
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "食物類別")
public class FoodCategory {

    /**
     * 類別 ID。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "類別 ID")
    private Long id;

    /**
     * 類別名稱。
     */
    @Schema(description = "類別名稱")
    private String name;

    /**
     * 類別描述。
     */
    @Schema(description = "類別描述")
    private String description;
}
