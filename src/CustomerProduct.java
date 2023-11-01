import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProduct implements Record{

    private String customerSSN, productID;
    private LocalDate purchaseDate;

    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate){
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
    }
    public void setCustomerSSN(String customerSSN) {
        this.customerSSN = customerSSN;
    }
    public String getCustomerSSN() {
        return customerSSN;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String lineRepresentation() {
        return getCustomerSSN() + "," + getProductID() + "," + getPurchaseDate().toString();
    }

    @Override
    public String getSearchKey() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        formatter.format(getPurchaseDate());
        String formattedDate = getPurchaseDate().format(formatter);
        return getCustomerSSN() + "," + getProductID() + "," + formattedDate+ "\n";
    }
}
