package custom.tibame201020.self_recorder.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 使用者運動記錄 Entity。
 * 記錄使用者的運動相關資訊，例如運動名稱、強度、持續時間、消耗卡路里等。
 */
@Data
@Entity
@Table(name = "user_exercise_log")
@Schema(description = "使用者運動記錄")
public class UserExerciseLog {

    /**
     * 運動記錄 ID。
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_exercise_log_id")
    @Schema(description = "運動記錄 ID")
    private Long userExerciseLogId;

    /**
     * 使用者。
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Schema(description = "使用者")
    private User user;

    /**
     * 運動名稱。
     */
    @Column(name = "exercise_name", nullable = false)
    @Schema(description = "運動名稱")
    private String exerciseName;

    /**
     * 運動強度。
     */
    @Column(name = "intensity")
    @Schema(description = "運動強度")
    private String intensity;

    /**
     * 運動持續時間 (分鐘)。
     */
    @Column(name = "duration", nullable = false)
    @Schema(description = "運動持續時間 (分鐘)")
    private Double duration;

    /**
     * 消耗卡路里。
     */
    @Column(name = "calories", nullable = false)
    @Schema(description = "消耗卡路里")
    private Double calories;

    /**
     * 運動描述。
     */
    @Column(name = "description", nullable = false)
    @Schema(description = "運動描述")
    private String description;

    /**
     * 運動時間。
     */
    @Column(name = "exercise_time", nullable = false)
    @Schema(description = "運動時間")
    private LocalDateTime exerciseTime;

    /**
     * 記錄時間。
     */
    @Column(name = "log_time", nullable = false)
    @Schema(description = "記錄時間")
    private LocalDateTime logTime;
}
