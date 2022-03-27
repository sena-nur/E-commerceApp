package ecommerceapp;

public class Product {
    private String productName;
    private String productColor;
    private String productCategory;
    private long productStockInfo;
    private double productWeight;
    private String productDescriptionInfo;

    public Product(String productName, String productColor, String productCategory, double productWeight, String productDescriptionInfo)
    {
        this.productName = productName;
        this.productColor = productColor;
        this.productCategory = productCategory;
        this.productStockInfo = 0;
        this.productWeight = productWeight;
        this.productDescriptionInfo = productDescriptionInfo;
    }
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public long getProductStockInfo() {
        return productStockInfo;
    }

    public void setProductStockInfo(long productStockInfo) {
        this.productStockInfo = productStockInfo;
    }

    public double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(double productWeight) {
        this.productWeight = productWeight;
    }

    public String getProductDescriptionInfo() {
        return productDescriptionInfo;
    }

    public void setProductDescriptionInfo(String productDescriptionInfo) {
        this.productDescriptionInfo = productDescriptionInfo;
    }
    
    public void addProductToStock(long num)
    {
        this.productStockInfo += num;
        System.out.println(num + " product added to " + 
                getProductSummary() + " stocks. The last stock number: " +
                this.productStockInfo);
    }
    
    public void removeProductFromStock(long num)
    {
        this.productStockInfo -= num;
        System.out.println(num + " product remove from " + 
                getProductSummary() + " stocks. The last stock number: " +
                this.productStockInfo);
    }
    
    public String getProductSummary()
    {
        return this.productColor + " " + this.getProductName();
    }
    
    public boolean hasEnoughStock(int num)
    {
        if(this.productStockInfo >= num)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
