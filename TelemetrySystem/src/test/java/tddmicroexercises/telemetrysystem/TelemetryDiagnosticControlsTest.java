package tddmicroexercises.telemetrysystem;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TelemetryDiagnosticControlsTest {

    private TelemetryDiagnosticControls telemetryDiagnosticControls;
    private ITelemetryStatusProvider telemetryStatusProvider;
    private ITelemetryDataSender telemetryDataSender;

    String diagnosticMessageResult =
            "LAST TX rate................ 100 MBPS\r\n"
                    + "HIGHEST TX rate............. 100 MBPS\r\n"
                    + "LAST RX rate................ 100 MBPS\r\n"
                    + "HIGHEST RX rate............. 100 MBPS\r\n"
                    + "BIT RATE.................... 100000000\r\n"
                    + "WORD LEN.................... 16\r\n"
                    + "WORD/FRAME.................. 511\r\n"
                    + "BITS/FRAME.................. 8192\r\n"
                    + "MODULATION TYPE............. PCM/FM\r\n"
                    + "TX Digital Los.............. 0.75\r\n"
                    + "RX Digital Los.............. 0.10\r\n"
                    + "BEP Test.................... -5\r\n"
                    + "Local Rtrn Count............ 00\r\n"
                    + "Remote Rtrn Count........... 00";

    @Before
    public void setUp() {
        telemetryStatusProvider = mock(ITelemetryStatusProvider.class);
        telemetryDataSender = mock(ITelemetryDataSender.class);

        telemetryDiagnosticControls = new TelemetryDiagnosticControls();
    }

    @Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        // Arrange
        when(telemetryStatusProvider.getOnlineStatus()).thenReturn(true);
        when(telemetryDataSender.receive()).thenReturn(diagnosticMessageResult);


        telemetryDiagnosticControls.checkTransmission();


        assertEquals(diagnosticMessageResult, telemetryDiagnosticControls.getDiagnosticInfo());
    }

}
