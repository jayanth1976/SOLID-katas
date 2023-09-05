package tddmicroexercises.telemetrysystem;

public interface ITelemetryDataSender {
    String DIAGNOSTIC_MESSAGE = "AT#UD";
    void send(String message);
    String receive();
}
