package backend;

import constants.FileNames;

import java.io.File;
import java.util.ArrayList;

public class AdminRole implements FileNames {

    private EmployeeUserDatabase database;

    public AdminRole() {
        database = new EmployeeUserDatabase(EMPLOYEE_FILENAME);
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
