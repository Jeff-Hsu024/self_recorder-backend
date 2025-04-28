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

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * 使用者飲食記錄 Entity。
 * 記錄使用者的飲食相關資訊，例如食物名稱、卡路里、描述等。
 */
@Data
@Entity
@Table(name = "user_food_log")
@Schema(description = "使用者飲食記錄")
public class UserFoodLog {

    /**
     * 飲食記錄 ID。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_food_log_id")
    @Schema(description = "飲食記錄 ID")
    private Long userFoodLogId;

    /**
     * 使用者。
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Schema(description = "使用者")
    private User user;

    /**
     * 食物名稱。
     */
    @Column(name = "food_name", nullable = false)
    @Schema(description = "食物名稱")
    private String foodName;

    /**
     * 卡路里。
     */
    @Column(name = "calories", nullable = false)
    @Schema(description = "卡路里")
    private Double calories;

    /**
     * 描述。
     */
    @Column(name = "description", nullable = false)
    @Schema(description = "描述")
    private String description;

    /**
     * 用餐時間。
     */
    @Column(name = "eat_time", nullable = false)
    @Schema(description = "用餐時間")
    private LocalDateTime eatTime;

    /**
     * 記錄時間。
     */
    @Column(name = "log_time", nullable = false)
    @Schema(description = "記錄時間")
    private LocalDateTime logTime;
}
