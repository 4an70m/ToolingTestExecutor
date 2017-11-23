import com.sforce.soap.apex.*;
import com.sforce.soap.metadata.ApexTestSuite;
import com.sforce.soap.partner.*;
import com.sforce.soap.partner.Connector;
import com.sforce.ws.*;

import java.util.Arrays;


/**
 * Created by 4an70m on 17.11.2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        final String username = "4an70m2@gmail.com";
        final String password = "J2M78BLqcYEgf6HybLGTVn4lrMC97YFjwYTQ9Lwke";
        final String loginUrl = "https://login.salesforce.com/services/Soap/u/41.0";


        ConnectorConfig config = new ConnectorConfig();
        config.setManualLogin(false);
        config.setAuthEndpoint(loginUrl);
        config.setUsername(username);
        config.setPassword(password);
        PartnerConnection connection = Connector.newConnection(config);

        System.out.println(config.getSessionId());
    }
}
