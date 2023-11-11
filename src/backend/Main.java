package backend;

public class Main {

    private AdminRole admin;

    public Main() {
        admin = new AdminRole();
    }

    public void testAdminRole() {
        EmployeeUser[] employees = admin.getListOfEmployees();
        for (EmployeeUser emp : employees) {
            admin.removeEmployee(emp.getSearchKey());
        }
        admin.logout();

        admin = new AdminRole();
        employees = admin.getListOfEmployees();

        if (employees.length != 0) {
            System.out.println("There is a problem in removing old employees from the employees file or arraylist");
            return;
        }

        admin.addEmployee("EMP-001", "Ahmed", "ahmed@email.com", "Cairo", "+20123456789");
        admin.addEmployee("EMP-002", "Mohamed", "mohamed@email.com", "Giza", "+20198765432");
        admin.addEmployee("EMP-003", "Mariam", "mariam@email.com", "Alexandria", "+20145678923");
        admin.addEmployee("EMP-004", "Hossam", "hossam@email.com", "Luxor", "+20132165498");
        admin.addEmployee("EMP-005", "Nour", "nour@email.com", "Aswan", "+20165432178");


        admin.logout();


        admin = new AdminRole();
        employees = admin.getListOfEmployees();
        if (employees.length != 5) {
            System.out.println("There is a problem in adding new employees to the employees file or arraylist");
            return;
        }
        admin.logout();
        System.out.println("You have passed the tests of admin role.\nHowever, there will be different tests during the discussion.\nMake sure that you have implemented all the requirements correctly");

    }



    public static void main(String[] args) {
        Main test = new Main();
        test.testAdminRole();
        System.out.println("---------------------------------------------------\n---------------------------------------------------");
    }
}

    
