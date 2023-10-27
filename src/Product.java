public class Product implements Record {
    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private float price;

    public Product(String productID, String productName, String manufacturerName,
                   String supplierName, int quantity, float price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.price = price;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String lineRepresentation(){
        return this.productID + "," + this.productName+","+this.manufacturerName+","
                +this.supplierName+","+this.quantity+","+this.price;
    }

    public String getSearchKey() {
        return getProductID();
    }


}
