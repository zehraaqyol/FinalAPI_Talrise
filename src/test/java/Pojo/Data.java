
package Pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.annotation.processing.Generated;
@Generated("jsonschema2pojo")
public class Data {

    @SerializedName("data")
    @Expose
    private com.login.Data__1 data;
    @SerializedName("errors")
    @Expose
    private List<Object> errors;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    /**
     * No args constructor for use in serialization
     */
    public Data() {
    }

    /**
     * @param data
     * @param errors
     * @param timestamp
     */
    public Data(com.login.Data__1 data, List<Object> errors, String timestamp) {
        super();
        this.data = data;
        this.errors = errors;
        this.timestamp = timestamp;
    }

    public com.login.Data__1 getData() {
        return data;
    }

    public void setData(com.login.Data__1 data) {
        this.data = data;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public String getTimestamp() {
        return timestamp;
    }
}