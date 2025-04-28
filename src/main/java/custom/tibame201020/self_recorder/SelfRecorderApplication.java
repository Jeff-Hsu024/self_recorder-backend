package custom.tibame201020.self_recorder;

import org.springframework.boot.SpringApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Self Recorder API",
				version = "1.0.0",
				description = "This API allows users to record their food intake, exercise, and sleep patterns."
		)
)
public class SelfRecorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelfRecorderApplication.class, args);
	}

}
