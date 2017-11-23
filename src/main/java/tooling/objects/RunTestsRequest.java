package tooling.objects;

import com.google.gson.Gson;

/**
 * Created by 4an70m on 23.11.2017.
 */
@SuppressWarnings("unused")
public class RunTestsRequest implements JsonBody {

    private TestsNode[] tests;
    private String testLevel;


    public RunTestsRequest() {
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public TestsNode[] getTests() {
        return tests;
    }

    public void setTests(TestsNode[] tests) {
        this.tests = tests;
    }

    public String getTestLevel() {
        return testLevel;
    }

    public void setTestLevel(String testLevel) {
        this.testLevel = testLevel;
    }
}
