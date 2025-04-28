package custom.tibame201020.self_recorder.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

/**
 * 使用者 Entity。
 * 記錄使用者的基本資訊，例如 ID 和使用者名稱。
 */
@Entity
@Table(name = "users")
@Data
@Schema(description = "使用者")
public class User {

    /**
     * 使用者 ID。
     */
    @Id
    @Schema(description = "使用者 ID")
    private UUID id;

    /**
     * 使用者名稱。
     */
    @Column(nullable = false, unique = true)
    @Schema(description = "使用者名稱")
    private String username;
}
