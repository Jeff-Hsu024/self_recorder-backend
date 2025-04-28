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
import custom.tibame201020.self_recorder.entity.User;

@Data
@Entity
@Table(name = "user_exercise_log")
public class UserExerciseLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_exercise_log_id")
    private Long userExerciseLogId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "exercise_name", nullable = false)
    private String exerciseName;

    @Column(name = "intensity")
    private String intensity;

    @Column(name = "duration", nullable = false)
    private Double duration;

    @Column(name = "calories", nullable = false)
    private Double calories;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "exercise_time", nullable = false)
    private LocalDateTime exerciseTime;

    @Column(name = "log_time", nullable = false)
    private LocalDateTime logTime;
}
