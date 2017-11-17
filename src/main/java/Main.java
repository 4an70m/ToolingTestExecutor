import com.sforce.soap.partner.*;
import com.sforce.soap.partner.sobject.*;
import com.sforce.ws.*;

import java.util.Arrays;


/**
 * Created by 4an70m on 17.11.2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        ConnectorConfig config = new ConnectorConfig();
        config.setManualLogin(true);
        config.setAuthEndpoint("https://login.salesforce.com/services/Soap/u/41.0");
        config.setUsername("4an70m@gmail.com");
        config.setPassword("12345qwerty");

        PartnerConnection connection = Connector.newConnection(config);
        System.out.println("Querying Contacts");
        final QueryResult queryResult = partnerConnection.query("SELECT Id, Name FROM Contact");
        Arrays.stream(queryResult.getRecords()).forEach(System.out::println);
    }
}
