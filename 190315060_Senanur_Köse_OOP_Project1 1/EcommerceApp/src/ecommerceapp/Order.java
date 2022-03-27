package ecommerceapp;

public class Order {
    private User orderingUser;
    private Product orderedProduct;
    private CreditCard paymentCreditCard;
    
    public Order(User orderingUser, Product orderedProduct, CreditCard paymentCreditCard)
    {
        this.orderingUser = orderingUser;
        this.orderedProduct = orderedProduct;
        this.paymentCreditCard = paymentCreditCard;
    }

    public User getOrderingUser() {
        return orderingUser;
    }

    public void setOrderingUser(User orderingUser) {
        this.orderingUser = orderingUser;
    }

    public Product getOrderedProduct() {
        return orderedProduct;
    }

    public void setOrderedProduct(Product orderedProduct) {
        this.orderedProduct = orderedProduct;
    }

    public CreditCard getpaymentCreditCard() {
        return paymentCreditCard;
    }

    public void setpaymentCreditCard(CreditCard paymentCreditCard) {
        this.paymentCreditCard = paymentCreditCard;
    }
    
    public void checkOrder(int num)
    {
        if(num <= 0)
        {
            System.out.println("Please enter valid num of product:" + num);
        }
        else if(this.orderedProduct.hasEnoughStock(num))
        {
            this.orderingUser.completePurchasing(this.getOrderedProduct(), 
                    num, paymentCreditCard);
            System.out.println(this.orderingUser.getUsername() + " ordered " +
           num + " " + this.getOrderedProduct().getProductSummary() +".");
            this.orderedProduct.removeProductFromStock(num);
        }
        else
        {
            System.out.println("There is not enough stock of " + 
                    this.getOrderedProduct().getProductSummary());
            System.out.println("The stock number of product: " + 
                    this.getOrderedProduct().getProductStockInfo());
        }
    }
    
    public void checkOrderforCancelling(int num)
    {
        if(num <= 0)
        {
            System.out.println("Please enter valid num of product:" + num);
        }
        else 
        {
            this.orderingUser.completePurchasingCancel(
                    this.getOrderedProduct(), num, this.paymentCreditCard);
            System.out.println(this.orderingUser.getUsername() + 
                    " cancel ordered " + num + " " + 
                    this.getOrderedProduct().getProductSummary() +".");
            System.out.println("The last stock number of product: " + 
                    this.getOrderedProduct().getProductStockInfo());
            this.orderedProduct.addProductToStock(num);
        }
    }
}
