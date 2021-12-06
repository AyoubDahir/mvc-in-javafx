package Home.model;

public class cunsultation
{
    private String patientid,symptoms,diagnosis,tearment,comment;

    public cunsultation(){}

    public cunsultation(String patientid, String symptoms, String diagnosis, String tearment, String comment) {
        this.patientid = patientid;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.tearment = tearment;
        this.comment = comment;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTearment() {
        return tearment;
    }

    public void setTearment(String tearment) {
        this.tearment = tearment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
