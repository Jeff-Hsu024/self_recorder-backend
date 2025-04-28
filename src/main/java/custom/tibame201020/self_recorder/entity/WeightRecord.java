package custom.tibame201020.self_recorder.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 體重記錄 Entity，記錄使用者、記錄日期和體重資訊。
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "體重記錄")
public class WeightRecord {

    /**
     * 記錄 ID。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "記錄 ID")
    private Long id;

    /**
     * 使用者。
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Schema(description = "使用者")
    private User user;

    /**
     * 記錄日期。
     */
    @Schema(description = "記錄日期")
    private LocalDate recordDate;

    /**
     * 體重 (公斤)。
     */
    @Schema(description = "體重 (公斤)")
    private Double weight;
}
