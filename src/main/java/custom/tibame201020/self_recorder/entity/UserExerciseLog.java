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

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    // 修改的欄位：使用者進行的運動數量
    @Column(name = "quantity", nullable = false)
    private Double quantity;

    // 修改的欄位：使用者進行的運動單位 (可選)
    @Column(name = "unit")
    private String unit;

    @Column(name = "log_time", nullable = false)
    private LocalDateTime logTime;
}
