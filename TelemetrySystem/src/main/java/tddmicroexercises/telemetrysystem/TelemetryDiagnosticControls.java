package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls
{
    private final String DiagnosticChannelConnectionString = "*111#";
    
    private final ITelemetryStatusProvider telemetryStatusProvider;
    private final ITelemetryDataSender telemetryDataSender;
    private String diagnosticInfo = "";

        public TelemetryDiagnosticControls()
        {
            this.telemetryStatusProvider = new TelemetryStatusProvider();
            this.telemetryDataSender = new TelemetryClient();
        }
        
        public String getDiagnosticInfo(){
            return diagnosticInfo;
        }
        
        public void setDiagnosticInfo(String diagnosticInfo){
            this.diagnosticInfo = diagnosticInfo;
        }
 
        public void checkTransmission() throws Exception
        {
            diagnosticInfo = "";

            telemetryStatusProvider.disconnect();
    
            int retryLeft = 3;
            while (telemetryStatusProvider.getOnlineStatus() == false && retryLeft > 0)
            {
                telemetryStatusProvider.connect(DiagnosticChannelConnectionString);
                retryLeft -= 1;
            }
             
            if(telemetryStatusProvider.getOnlineStatus() == false)
            {
                throw new Exception("Unable to connect.");
            }
    
            telemetryDataSender.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
            diagnosticInfo = telemetryDataSender.receive();
    }
}
//TelementaryClient interface -> Dependency inversion
