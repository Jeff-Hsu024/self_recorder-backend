package custom.tibame201020.self_recorder.containers;

public class DevContainer {
    
    public static void startContainers() {
        EmbeddedContainer.start("redis:7.0", 6379);
    }
}
