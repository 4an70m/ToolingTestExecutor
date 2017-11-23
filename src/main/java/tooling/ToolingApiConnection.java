package tooling;

import com.sforce.soap.partner.Connector;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import tooling.exception.ToolingApiException;
import tooling.objects.RunTestsRequest;
import tooling.transport.HttpRestRequest;
import tooling.transport.HttpRestResponse;
import tooling.transport.ToolingUrlConstructor;

/**
 * Created by 4an70m on 19.11.2017.
 */
@SuppressWarnings("all")
public class ToolingApiConnection {

    private final String sessionId;
    private final ToolingUrlConstructor url;

    public ToolingApiConnection(PartnerConnection partnerConnection) throws ToolingApiException {
        this.sessionId = partnerConnection.getConfig().getSessionId();
        this.url = new ToolingUrlConstructor(partnerConnection.getConfig());
    }

    public void executeTestAsynchronious() {
        try {
            HttpRestRequest restRequest = new HttpRestRequest(this.url.executeTestAsynchroniousUrl());
            System.out.println(this.sessionId);

            restRequest.setSessionId(this.sessionId);

            RunTestsRequest request = new RunTestsRequest();
            request.setTestLevel("RunLocalTests");

            restRequest.setBody(request);
            HttpRestResponse response = restRequest.send();

            System.out.println(response);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void executeTestSynchronious() {
        throw new NotImplementedException();
    }

    /*
     * Main method
     */
    public static void main(String[] args) throws ConnectionException, ToolingApiException {
        final String username = "";
        final String password = "";
        final String loginUrl = "";

        ConnectorConfig config = new ConnectorConfig();
        config.setManualLogin(false);
        config.setAuthEndpoint(loginUrl);
        config.setUsername(username);
        config.setPassword(password);
        PartnerConnection connection = Connector.newConnection(config);


        ToolingApiConnection tconn = new ToolingApiConnection(connection);
        tconn.executeTestAsynchronious();
    }
}
