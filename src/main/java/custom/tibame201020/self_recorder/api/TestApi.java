package custom.tibame201020.self_recorder.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {
    
    @GetMapping("/api/todo")
    public List<String> test() {
        System.err.println("------------------------------");
        return List.of("a", "b", "c", "E");
    }
}
