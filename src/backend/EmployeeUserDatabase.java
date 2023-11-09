package backend;

import backend.Database;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
class EmployeeUserDatabase extends Database {

    private ArrayList<EmployeeUser> records = new ArrayList<>();

    public EmployeeUserDatabase(String filename) {

        this.setFilename(filename);
//        this.records = new ArrayList<backend.EmployeeUser>();
    }

    public void setRecords(ArrayList<EmployeeUser> records) {
        this.records = records;
    }

    public ArrayList<EmployeeUser> getRecords() {
        return records;
    }

    @Override
    public EmployeeUser createRecordFrom(String line) {

        String[] splitData = line.split(",");

        return (new EmployeeUser(splitData[0],splitData[1],
                splitData[2],splitData[3],splitData[4]));

    }

    public ArrayList<EmployeeUser> returnAllRecords() {
        return this.getRecords();
    }

    @Override
    public boolean contains(String key) {

        for (EmployeeUser record : this.records) {

            if (record.getEmployeeID().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public EmployeeUser getRecord(String key) {

        for (EmployeeUser record : this.records) {

            if (record.getEmployeeID().equals(key)) {
                return record;
            }
        }
        return null;
    }


    @Override
    public void deleteRecord(String key) {


        if(this.contains(key)) {

            for(int i=0 ; i<this.records.size() ; i++) {
                if(this.records.get(i).getEmployeeID().equals(key))
                {
                    this.records.remove(i); //Warning: Suspicious 'List.remove()' in loop
                }

            }
        }
    }

    @Override
    public void saveToFile() {
        try {
            FileWriter database = new FileWriter(getFilename(),false);

            for (EmployeeUser record : this.records) {
                database.write(record.getEmployeeID() + "," + record.getName()
                        + "," + record.getEmail() + "," + record.getAddress() + "," + record.getPhoneNumber() + "\n");
            }
            database.close();
        }

        catch (IOException e) {
            System.out.println("An error occurred..");
            e.printStackTrace();
        }
    }

    @Override
    public void insertRecord(Record record){

        this.records.add((EmployeeUser) record);
        setNumberOfRecords(getNumberOfRecords() +  1);
//        this.setNumberOfRecords(this.getNumberOfRecords() + 1);
    }


}

