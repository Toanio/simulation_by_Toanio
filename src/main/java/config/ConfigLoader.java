package config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class ConfigLoader {


    public static SimulationConfig loadConfig() {
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream("config.json")) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Файл config.json не найден в resources!");
            }
            return mapper.readValue(inputStream, SimulationConfig.class);

        } catch (IOException e) {
            throw new RuntimeException("Не удалось прочитать конфигурационный файл", e);
        }
    }
}
