package Home.model;

public class Doctor
{
    private String name,address,Phone,certificate,expiriment,selary;

    public Doctor(){}

    public Doctor(String name, String address, String phone, String certificate, String expiriment, String selary) {
        this.name = name;
        this.address = address;
        Phone = phone;
        this.certificate = certificate;
        this.expiriment = expiriment;
        this.selary = selary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getExpiriment() {
        return expiriment;
    }

    public void setExpiriment(String expiriment) {
        this.expiriment = expiriment;
    }

    public String getSelary() {
        return selary;
    }

    public void setSelary(String selary) {
        this.selary = selary;
    }
}
