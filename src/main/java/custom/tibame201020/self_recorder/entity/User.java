package custom.tibame201020.self_recorder.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 使用者名稱。
     */
    @Column(nullable = false, unique = true)
    @Schema(description = "使用者名稱")
    private String username;

    /**
     * 使用者 Email。
     */
    @Column(nullable = false, unique = true)
    @Schema(description = "使用者 Email")
    private String email;

    /**
     * 使用者姓名。
     */
    @Column(nullable = false)
    @Schema(description = "使用者姓名")
    private String name;

}
