package tooling.transport;

/**
 * Created by 4an70m on 23.11.2017.
 */
public class HttpRestResponse {

    private final int responseCode;
    private final String responseBody;

    public HttpRestResponse(int responseCode, String responseBody) {
        this.responseCode = responseCode;
        this.responseBody = responseBody;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    @Override
    public String toString() {
        return "HttpRestResponse{" +
                "responseCode=" + responseCode +
                ", responseBody='" + responseBody + '\'' +
                '}';
    }
}
