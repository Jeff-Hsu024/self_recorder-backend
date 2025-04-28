package custom.tibame201020.self_recorder.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 使用者運動記錄 Entity，記錄使用者、運動、開始時間和結束時間資訊。
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "使用者運動記錄")
public class UserExerciseLog {

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
     * 運動。
     */
    @ManyToOne
    @JoinColumn(name = "exercise_id")
    @Schema(description = "運動")
    private Exercise exercise;

    /**
     * 開始時間。
     */
    @Schema(description = "開始時間")
    private LocalDateTime startTime;

    /**
     * 結束時間。
     */
    @Schema(description = "結束時間")
    private LocalDateTime endTime;
}
