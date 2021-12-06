package Home.model;

public class labrequest
{
    private String patientid;
    private String resultname;
    private String state;

    public labrequest(){}

    public labrequest(String patientid, String resultname, String state) {
        this.patientid = patientid;
        this.resultname = resultname;
        this.state = state;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getResultname() {
        return resultname;
    }

    public void setResultname(String resultname) {
        this.resultname = resultname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
