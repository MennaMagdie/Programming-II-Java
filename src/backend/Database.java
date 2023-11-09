package backend;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public abstract class Database {
    //    protected ArrayList<backend.Record> records;
    private String filename = "";
    private int numberOfRecords = 0;

    public int getNumberOfRecords() {
        return this.numberOfRecords;
    }

    public void setNumberOfRecords(int numberOfRecords) {
        this.numberOfRecords = numberOfRecords;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void readFromFile() {
        try {
            File database = new File(getFilename());
            Scanner fileReader = new Scanner(database);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                Record e = createRecordFrom(line);
                this.insertRecord(e);
            }
            fileReader.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("An error occurred...");
            e.printStackTrace();
        }

    }

    public abstract Record createRecordFrom(String line);

    public abstract void insertRecord(Record record);

    public abstract boolean contains(String key);

    public abstract Record getRecord(String key);
    public abstract void deleteRecord(String key);
    public abstract void saveToFile();

}

