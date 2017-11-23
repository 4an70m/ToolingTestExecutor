package tooling.objects;

import com.google.gson.Gson;

/**
 * Created by 4an70m on 23.11.2017.
 */
@SuppressWarnings("unused")
public class TestsNode implements JsonBody {

    private String classId;
    private String className;
    private String[] testMethods;

    public TestsNode() {
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String[] getTestMethods() {
        return testMethods;
    }

    public void setTestMethods(String[] testMethods) {
        this.testMethods = testMethods;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
