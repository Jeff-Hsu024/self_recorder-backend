package custom.tibame201020.self_recorder.containers;

import org.testcontainers.containers.GenericContainer;

public class EmbeddedContainer {
        private static GenericContainer<?> container;

    public static void start(String image, int port) {
        if (container == null) {
            container = new GenericContainer<>(image)
                    .withExposedPorts(port);
                    container.start();
        }
    }

    public static void stop() {
        if (container != null) {
            container.stop();
            container = null;
        }
    }
}
