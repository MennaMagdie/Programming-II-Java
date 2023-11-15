package backend;

import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class CustomerProductDatabase extends Database {

    private ArrayList<CustomerProduct> records = new ArrayList<>();

    public CustomerProductDatabase (String filename){

        this.setFilename(filename);

    }
    public void setRecords(ArrayList<CustomerProduct> records) {
        this.records = records;
    }
    public ArrayList<CustomerProduct> getRecords() {
        return records;
    }
    @Override
    public CustomerProduct createRecordFrom(String line){
        String[]  splitData = line.split(",");
        return new CustomerProduct(splitData[0], splitData[1], LocalDate.parse(splitData[2]));
    }
    public ArrayList<CustomerProduct> returnAllRecords(){
        return this.getRecords();
    }
    @Override
    public boolean contains(String key){
        for(CustomerProduct record:records){
            if(record.getSearchKey().equals(key))
                return true;
        }
        return false;
    }
    @Override
    public CustomerProduct getRecord(String key){
        for (CustomerProduct record:records){
            if(record.getSearchKey().equals(key))
                return record;
        }
        return null;
    }
    @Override
    public void insertRecord(Record record){

        this.records.add((CustomerProduct)record);
        setNumberOfRecords(getNumberOfRecords() +  1);
    }
    @Override
    public void deleteRecord(String key){ //ConcurrentModificationException
        try {
            for (CustomerProduct record : records) {
                if (record.getSearchKey().equals(key))
                    records.remove(record);
            }
        }
        catch(ConcurrentModificationException c) {
//            System.out.println("trial?");
        }
        }

    @Override
    public void saveToFile(){
        try {
            FileWriter writer = new FileWriter(getFilename(), false);
            for(CustomerProduct record:records) {
                writer.write(record.getSearchKey());
//                System.out.println("hii");
            }
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
