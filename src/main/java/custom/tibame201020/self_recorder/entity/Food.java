package custom.tibame201020.self_recorder.entity;

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
}
