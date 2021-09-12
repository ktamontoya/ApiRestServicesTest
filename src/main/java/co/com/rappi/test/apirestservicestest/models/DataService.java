package co.com.rappi.test.apirestservicestest.models;

public class DataService {

    private int responseCode;
    private String name;
    private String job;
    private String endpoint;

    public DataService(String name, String job, String endpoint) {
        this.name = name;
        this.job = job;
        this.endpoint = endpoint;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}