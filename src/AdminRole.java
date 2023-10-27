import java.util.ArrayList;
import java.util.List;
public class AdminRole {
    private EmployeeUserDatabase database;

    public AdminRole() {
        database = new EmployeeUserDatabase(database.getFilename());
    }


    public void addEmployee(String employeeID, String name, String email, String address, String phoneNumber) {

        EmployeeUser e1 = new EmployeeUser(employeeID, name, email, address, phoneNumber);
        database.insertRecord(database.createRecordFrom(e1.lineRepresentation()));
        logOut();
    }

    public EmployeeUser[] getListOfEmployees() { //not sure hateshtaghal wala la: ig yess

        return (EmployeeUser[]) database.getRecords().toArray(); //toArray returns object
    }

    public void removeEmployee(String key) {

        database.deleteRecord(key);
        logOut();
    }

    public void logOut() {
        database.saveToFile();
    }

}
