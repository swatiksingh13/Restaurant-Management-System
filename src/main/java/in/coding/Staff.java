package in.coding;

public class Staff {
    private final int id;
    private final String name;
    private final String role;
    private final String contactNumber;

    public Staff(int id, String name, String role, String contactNumber) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.contactNumber = contactNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
