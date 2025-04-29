package custom.tibame201020.self_recorder.repository;

import custom.tibame201020.self_recorder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 使用者 Repository 介面，用於存取使用者資料。
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
