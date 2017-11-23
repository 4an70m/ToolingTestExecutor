package tooling.transport;

import com.sforce.ws.ConnectorConfig;
import tooling.exception.ToolingApiException;

/**
 * Created by 4an70m on 23.11.2017.
 */
@SuppressWarnings("all")
public class ToolingUrlConstructor {

    private String toolingUrl;

    public ToolingUrlConstructor(ConnectorConfig config) throws ToolingApiException {
        if (config.getServiceEndpoint() == null) {
            throw new ToolingApiException("Login before executing tooling API.");
        }
        final String version = "v41.0";
        final String baseUrl = config.getServiceEndpoint().split("/services")[0];
        this.toolingUrl = baseUrl + "/services/data/" + version + "/tooling";
    }

    public String executeTestAsynchroniousUrl() {
        return this.toolingUrl + "/runTestsAsynchronous";
    }

    public String executeTestSynchroniousUrl() {
        return this.toolingUrl + "/runTestsSynchronous";
    }
}
