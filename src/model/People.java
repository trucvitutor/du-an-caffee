package model;

public abstract class People {
    private Integer id;
    private String code;
    private String name;
    private int phoneNumber;
    private String gmail;

    public People(Integer id, String code, String name, int phoneNumber, String gmail) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gmail = gmail;
    }

    public People() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", gmail='" + gmail + '\'' +
                '}';
    }
}
