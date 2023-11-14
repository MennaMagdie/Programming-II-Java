package backend;

import backend.CustomerProduct;
import backend.CustomerProductDatabase;
import backend.Product;
import backend.ProductDatabase;
import constants.FileNames;

import java.util.ArrayList;
import java.time.LocalDate;

public class EmployeeRole implements FileNames {

    private ProductDatabase productDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public EmployeeRole() {
        productDatabase = new ProductDatabase(PRODUCT_FILENAME);
        customerProductDatabase = new CustomerProductDatabase(CUSTOMER_PRODUCT_FILENAME);
//        productDatabase.readFromFile();
//        customerProductDatabase.readFromFile();

    }

    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        Product product = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
        productDatabase.insertRecord(productDatabase.createRecordFrom(product.lineRepresentation()));
        logout();
    }

    public Product[] getListOfProducts() {
        ArrayList<Product> product = productDatabase.returnAllRecords();
        return product.toArray(Product[]::new);
    }

    public CustomerProduct[] getListOfPurchasingOperations() {
        ArrayList<CustomerProduct> customerProduct = customerProductDatabase.returnAllRecords();
        return customerProduct.toArray(CustomerProduct[]::new);
    }

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        Product product = productDatabase.getRecord(productID);
        if (product == null || product.getQuantity() == 0) {
            return false;
        } else {
            product.setQuantity(product.getQuantity() - 1);
            CustomerProduct customerProduct = new CustomerProduct(customerSSN, productID, purchaseDate);
            customerProductDatabase.insertRecord(customerProductDatabase.createRecordFrom(customerProduct.lineRepresentation()));
            logout();
            return true;
        }
    }

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate) {

        if (returnDate.isBefore(purchaseDate) || returnDate.isAfter(purchaseDate.plusDays(14))) {
            return -1;
        }

        Product product = productDatabase.getRecord(productID);
        if (product == null) {
            return -1;
        }

        CustomerProduct customerProduct = new CustomerProduct(customerSSN, productID, purchaseDate);
        String key = customerProduct.getSearchKey();
        if (!customerProductDatabase.contains(key)) {
            return -1;
        }

        product.setQuantity(product.getQuantity() + 1);
        customerProductDatabase.deleteRecord(key);
        logout();
        return product.getPrice();
    }

    public void logout() {
        productDatabase.saveToFile();
        customerProductDatabase.saveToFile();
    }
}
