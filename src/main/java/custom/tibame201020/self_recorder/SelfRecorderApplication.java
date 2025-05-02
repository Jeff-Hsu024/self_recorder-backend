package custom.tibame201020.self_recorder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import custom.tibame201020.self_recorder.containers.DevContainer;

/**
 * Self Recorder 應用程式的進入點。
 */
@SpringBootApplication
@EnableJpaRepositories
@OpenAPIDefinition(
		info = @Info(
				title = "Self Recorder API",
				version = "1.0.0",
				description = "This API allows users to record their food intake, exercise, and sleep patterns."
		)
)
public class SelfRecorderApplication {

	/**
	 * 應用程式的主要方法。
	 *
	 * @param args 命令行參數
	 */
	public static void main(String[] args) {
		DevContainer.startContainers();
		SpringApplication.run(SelfRecorderApplication.class, args);
	}

}
