package model;

public class StaffType {
    private int id;
    private String name;

    public StaffType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public StaffType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StaffType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
