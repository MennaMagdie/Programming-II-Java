
public class AdminRole {
    private EmployeeUserDatabase database;

    public AdminRole() {
        database = new EmployeeUserDatabase("Employee.txt");
        database.readFromFile();
    }


    public void addEmployee(String employeeID, String name, String email, String address, String phoneNumber) {


//            boolean isAdded = false;
//
//            for(int i=0 ; i<database.getNumberOfRecords()+1 ; i++ ) {
//                if(database.returnAllRecords().get(i).getEmployeeID().equals(employeeID)) {
//                    System.out.println("mawgouuuuda already");
//                    isAdded = true;
//                    break;
//                }
//                else {
//                    System.out.println("mashoftesh elID da abl keda");
//                }
//            }

            EmployeeUser e1 = new EmployeeUser(employeeID, name, email, address, phoneNumber);
            database.insertRecord(database.createRecordFrom(e1.lineRepresentation()));
//        logOut();
        }


    public EmployeeUser[] getListOfEmployees() {

//        database.readFromFile();

//        EmployeeUser[] employees = new EmployeeUser[database.getNumberOfRecords()];
//        System.out.println(employees.length);
//        for(int i=0 ; i< database.getNumberOfRecords() ; i++) {
//            try {
//                employees[i].setEmployeeID(database.returnAllRecords().get(i).getEmployeeID());
//                employees[i].setAddress(database.returnAllRecords().get(i).getAddress());
//                employees[i].setEmail(database.returnAllRecords().get(i).getEmail());
//                employees[i].setName(database.returnAllRecords().get(i).getEmail());
//                employees[i].setPhoneNumber(database.returnAllRecords().get(i).getPhoneNumber());
//            }
//            catch(NullPointerException e) {
//               System.out.println("alo");
//            }
//        }

//        for(int i=0 ; i< database.getNumberOfRecords()+1 ; i++) {
//            if(database.getNumberOfRecords() > 0)
//                System.out.println(employees[i].getName());
//            else
//                System.out.println("There are no employees found in records arrayList");
//        }

//        database.readFromFile();

//        return employees;
        return database.returnAllRecords().toArray(EmployeeUser[]::new);
    }

    public void removeEmployee(String key) {
//        System.out.println("I'm trying to delete smth 1");
        database.deleteRecord(key);
        logout();
    }

    public void logout() {
        database.saveToFile();
    }

}
