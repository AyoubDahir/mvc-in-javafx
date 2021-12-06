package Home.model;

public class medicne
{
    private String medicnename;
    private String country;
    private String manufucteringCOM;
    private String expiredate;

    public medicne(){}

    public medicne(String medicnename, String country, String manufucteringCOM, String expiredate) {
        this.medicnename = medicnename;
        this.country = country;
        this.manufucteringCOM = manufucteringCOM;
        this.expiredate = expiredate;
    }

    public String getMedicnename() {
        return medicnename;
    }

    public void setMedicnename(String medicnename) {
        this.medicnename = medicnename;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getManufucteringCOM() {
        return manufucteringCOM;
    }

    public void setManufucteringCOM(String manufucteringCOM) {
        this.manufucteringCOM = manufucteringCOM;
    }

    public String getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(String expiredate) {
        this.expiredate = expiredate;
    }
}
