public class EmployeeUser implements Record{

    private String employeeID;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    EmployeeUser(String employeeID, String name, String email, String address, String phoneNumber) {

        setEmployeeID(employeeID);
        setName(name);
        setEmail(email);
        setAddress(address);
        setPhoneNumber(phoneNumber);

    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    public String getEmployeeID() {
        return employeeID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String lineRepresentation() {
        return this.employeeID+","+this.name+","
                +this.email+","+this.address+","+this.phoneNumber;
    }

    @Override
    public String getSearchKey() {
        return this.employeeID;
    }
}
