package tooling.transport;

import com.sun.istack.internal.NotNull;
import tooling.objects.JsonBody;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by 4an70m on 23.11.2017.
 */
@SuppressWarnings("unused")
public class HttpRestRequest {

    private final String url;
    private String requestMethod;
    private String sessionId;
    private JsonBody body;

    public HttpRestRequest(@NotNull String url) {
        this.url = url;
        this.requestMethod = "GET";
    }

    public HttpRestResponse send() throws IOException {
        //make transport
        URL url = new URL(this.url);

        //send request
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        this.makeHttpUrlConnection(con);
        this.makeBody(con);

        //read response
        int responseCode = con.getResponseCode();
        String responseBody = this.readResponseBody(con);

        return new HttpRestResponse(responseCode, responseBody);
    }

    /*
     * Private response forming methods
     */
    private void makeHttpUrlConnection(HttpURLConnection con) throws ProtocolException {
        con.setRequestMethod(this.requestMethod);
        con.setRequestProperty("content-type", "application/json; charset=UTF-8");
        con.setRequestProperty("accept", "application/json");
        con.setRequestProperty("authorization", "Bearer " + this.sessionId);
        con.setDoOutput(true);
    }

    private void makeBody(HttpURLConnection con) throws IOException {
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(this.body.toJson());
        wr.flush();
        wr.close();
    }

    private String readResponseBody(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder responseBody = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            responseBody.append(inputLine);
        }
        in.close();
        return responseBody.toString();
    }

    /*
     * Getters/setters
     */
    public String getUrl() {
        return url;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public JsonBody getBody() {
        return body;
    }

    public void setBody(JsonBody body) {
        this.body = body;
    }
}
