package tddmicroexercises.telemetrysystem;

public interface ITelemetryStatusProvider {
    boolean getOnlineStatus();
    void connect(String telemetryServerConnectionString);
    void disconnect();
}
