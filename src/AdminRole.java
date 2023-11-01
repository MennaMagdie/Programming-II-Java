import java.util.ArrayList;

public class AdminRole {

    private EmployeeUserDatabase database;

    public AdminRole() {
        database = new EmployeeUserDatabase("D:\\Uni\\Term-5\\Programming-2\\inventory_elsobh\\Employee.txt");
        database.readFromFile();
    }

    public void addEmployee(String employeeID, String name, String email, String address, String phoneNumber) {

        EmployeeUser e1 = new EmployeeUser(employeeID, name, email, address, phoneNumber);
        database.insertRecord(database.createRecordFrom(e1.lineRepresentation()));
        logout();
    }

    public EmployeeUser[] getListOfEmployees() {
        ArrayList<EmployeeUser> employee = database.returnAllRecords();
        return employee.toArray(EmployeeUser[]::new);
    }

    public void removeEmployee(String key) {
        database.deleteRecord(key);
        logout();
    }

    public void logout() {
        database.saveToFile();
    }

}
