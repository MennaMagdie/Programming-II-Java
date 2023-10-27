import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class EmployeeUserDatabase{ //used to access employees database

//    private ArrayList <EmployeeUser> records;
    private ArrayList<EmployeeUser> records = new ArrayList<>(); //meen feehom sa7?
    //q: recordsss byedeeny warning maybe final BUT records2 mesh bye3mel haga???

    //q: records. not working here? since i'm not inside a fn?

    private String filename;


    public EmployeeUserDatabase(String filename) {
        this.setFilename(filename);
    }


    public void setFilename(String filename) {
        this.filename = filename;

    }

    public String getFilename() {
        return filename;
    }

    public void setRecords(ArrayList<EmployeeUser> records) {
        this.records = records;
    }

    public ArrayList<EmployeeUser> getRecords() {
        return records;
    }

    public void readFromFile() {
        try {
            File database = new File(this.filename);
            Scanner fileReader = new Scanner(database);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                EmployeeUser e = createRecordFrom(line);
                this.insertRecord(e);
            }
            fileReader.close(); //q: 3ady yeshouf filereader w howa out of scope try?
        }
        catch(FileNotFoundException e) {
            System.out.println("An error occurred...");
            e.printStackTrace(); //not sure bete3mel eh lessa
        }


    }

    public EmployeeUser createRecordFrom(String line) {

        String[] splitData = line.split(",");

         return (new EmployeeUser(splitData[0],splitData[1],
                splitData[2],splitData[3],splitData[4]));

    }

    public ArrayList<EmployeeUser> returnAllRecords() {  //q: not sure da elrequired or not
        return this.getRecords();
    }

    public boolean contains(String key) {

        for (EmployeeUser record : this.records) {

            if (record.getEmployeeID().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public EmployeeUser getRecord(String key) {

        for (EmployeeUser record : this.records) {

            if (record.getEmployeeID().equals(key)) {
                return record;
            }
        }
        return null;
    }

    public void insertRecord(EmployeeUser record) {
        this.records.add(record);
    }

    public void deleteRecord(String key) {

        if(this.contains(key)) {
            // needs refactoring ig
            for(int i=0 ; i<this.records.size() ; i++) {
                if(this.records.get(i).getEmployeeID().equals(key))
                    records.remove(i); //Warning: Suspicious 'List.remove()' in loop
            }
        }
    }

    public void saveToFile() {
        try {
            FileWriter database = new FileWriter(this.filename,false);

            for (EmployeeUser record : this.records) {
                database.write(record.getEmployeeID() + "," + record.getName()
                        + "," + record.getEmail() + "," + record.getAddress() + "," + record.getPhoneNumber() + "\n");
            }
//            for(int i=0 ; i<this.records.size() ; i++) {
//                database.write(records.get(i).getEmployeeID()+","+records.get(i).getName()
//                        +","+records.get(i).getEmail()+","+records.get(i).getAddress()+","+records.get(i).getPhoneNumber()+"\n");
//            }

            database.close();
        }

        catch (IOException e) {
            System.out.println("An error occurred..");
            e.printStackTrace();
        }
    }



}
