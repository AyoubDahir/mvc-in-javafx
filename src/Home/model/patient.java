package Home.model;

public class patient
{


    private String name, address ,phone,DOb,underDoctorB,age;


    public patient(){}

    public patient(String name, String address, String phone, String DOb, String underDoctorB, String age) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.DOb = DOb;
        this.underDoctorB = underDoctorB;
        this.age = age;
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
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDOb() {
        return DOb;
    }

    public void setDOb(String DOb) {
        this.DOb = DOb;
    }

    public String getUnderDoctorB() {
        return underDoctorB;
    }

    public void setUnderDoctorB(String underDoctorB) {
        this.underDoctorB = underDoctorB;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
