package Home.model;

public class labResult
{
    private String patientid, labname, result,cost;

    public labResult(){}

    public labResult(String patientid, String labname, String result, String cost) {
        this.patientid = patientid;
        this.labname = labname;
        this.result = result;
        this.cost = cost;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
