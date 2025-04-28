package custom.tibame201020.self_recorder.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 運動 Entity，記錄運動名稱和消耗的熱量資訊。
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "運動")
public class Exercise {

    /**
     * 運動 ID。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "運動 ID")
    private Long id;

    /**
     * 運動名稱。
     */
    @Schema(description = "運動名稱")
    private String name;

    /**
     * 消耗的熱量 (每單位)。
     */
    @Schema(description = "消耗的熱量 (每單位)")
    private Double caloriesBurned;
}
