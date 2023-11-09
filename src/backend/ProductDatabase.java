package backend;

import backend.Database;

import java.util.*;
import java.io.*;

class ProductDatabase extends Database {

    private ArrayList<Product> records = new ArrayList<>();
//    private String filename;

    public ProductDatabase (String filename){
        this.setFilename(filename);
    }
    public void setRecords(ArrayList<Product> records) {
        this.records = records;
    }
    public ArrayList<Product> getRecords() {
        return records;
    }

    @Override
    public Product createRecordFrom(String line){
        String[]  splitData = line.split(",");
        return new Product(splitData[0], splitData[1], splitData[2], splitData[3],Integer.parseInt(splitData[4]),Float.parseFloat(splitData[5]));
    }


    public ArrayList<Product> returnAllRecords(){
        return this.getRecords();
    }
    @Override
    public boolean contains(String key){
        for(Product record:records){
            if(record.getProductID().equals(key))
                return true;
        }
        return false;
    }
    public Product getRecord(String key){
        for (Product record:records){
            if(record.getProductID().equals(key))
                return record;
        }
        return null;
    }

    @Override
    public void insertRecord(Record record){
        this.records.add((Product)record);
        setNumberOfRecords(getNumberOfRecords() +  1);
    }
    @Override
    public void deleteRecord(String key){
        if(this.contains(key)) {


            for (Product record : records) {
                if (record.getProductID().equals(key))
                    records.remove(record);
            }
        }
    }
    @Override
    public void saveToFile(){
        try {
            try (FileWriter writer = new FileWriter(getFilename(), false)) {
                for(Product record:records){
                    writer.write(record.getProductID()+","+record.getProductName()+","+record.getManufacturerName()+","+record.getSupplierName()+","+record.getQuantity()+","+record.getPrice()+"\n");
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}



