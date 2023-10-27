import java.util.ArrayList;

public abstract class Database {

     private String filename;
//     private ArrayList<EmployeeUser> records;
//    private ArrayList<Product> records;
//    private ArrayList<EmployeeUser> records;

    abstract public void readFromFile();
    abstract public boolean contains(String key);
    abstract public void deleteRecord(String key);
    abstract public void saveToFile();


//    abstract public EmployeeUser createRecordFrom(String line);
//    abstract public ArrayList<EmployeeUser> returnAllRecords()

//    abstract public EmployeeUser getRecord();

//    abstract public void insertRecord(EmployeeUser record);

}
