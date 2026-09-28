package config;

public record SimulationConfig(
        MapConfig map,
        WolfConfig wolf,
        RabbitConfig rabbit,
        GrassConfig grass,
        TreeConfig tree,
        RockConfig rock

) {
}
