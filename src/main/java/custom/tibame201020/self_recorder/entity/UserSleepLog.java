package custom.tibame201020.self_recorder.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 使用者睡眠記錄 Entity，記錄使用者、睡覺時間和起床時間資訊。
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "使用者睡眠記錄")
public class UserSleepLog {

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
     * 睡覺時間。
     */
    @Schema(description = "睡覺時間")
    private LocalDateTime sleepTime;

    /**
     * 起床時間。
     */
    @Schema(description = "起床時間")
    private LocalDateTime wakeUpTime;
}
