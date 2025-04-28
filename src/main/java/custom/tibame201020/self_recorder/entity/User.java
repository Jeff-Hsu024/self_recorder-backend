package custom.tibame201020.self_recorder.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;
}
