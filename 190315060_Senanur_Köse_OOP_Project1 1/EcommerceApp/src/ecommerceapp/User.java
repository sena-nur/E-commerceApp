package ecommerceapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {
    private String username;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private String password;
    private String emailAddress;
    private String homeAddress;
    private String workAddress;
    private ArrayList<Product> productsOrdered;
    private ArrayList<Product> productsCancelOrdered;
    private ArrayList<Product> favoriteProducts;
    private ArrayList<CreditCard> creditCards;
    
    public User(String userName, String name, String surname, String dateOfBirth, String password, String emailAddress, String homeAddress, String workAddress) throws ParseException {
        this.username = userName;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth =format.parse(dateOfBirth);
        this.password = password;
        this.emailAddress = emailAddress;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
        this.creditCards = new ArrayList();
        this.favoriteProducts = new ArrayList();
        this.productsOrdered = new ArrayList();
        this.productsCancelOrdered = new ArrayList();
        System.out.println(this.username + " user was created.");
    }

    public ArrayList<Product> getProductsCancelOrdered() {
        return productsCancelOrdered;
    }

    public void setProductsCancelOrdered(ArrayList<Product> productsCancelOrdered) {
        this.productsCancelOrdered = productsCancelOrdered;
    }

    public String getUsername() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public ArrayList<Product> getProductsOrdered() {
        return productsOrdered;
    }

    public void setProductsOrdered(ArrayList<Product> productsOrdered) {
        this.productsOrdered = productsOrdered;
    }

    public ArrayList<Product> getFavoriteProducts() {
        return favoriteProducts;
    }

    public void setFavoriteProducts(ArrayList<Product> favoriteProducts) {
        this.favoriteProducts = favoriteProducts;
    }

    public ArrayList<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(ArrayList<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
    
    public void viewUserInfo()
    {
        System.out.println("USER INFO");
        System.out.println("Username: " + this.username);
        System.out.println("Name:" + this.name);
        System.out.println("Surname:" + this.surname);
        System.out.println("Date of Birth:" + format.format(dateOfBirth));
        System.out.println("E-mail address:" + this.emailAddress);
        System.out.println("Home Address:" + this.homeAddress);
        System.out.println("Work Address:" + this.workAddress);
    }
    
    public void addCreditCard(CreditCard creditCard)
    {
        if(!this.creditCards.contains(this))
        {
            this.creditCards.add(creditCard);
            System.out.println(this.username + " has added the number " + 
                    creditCard.getCreditCardNumber() + 
                    " credit card to card list.");
        }
        else
        {
            System.out.println("The " + creditCard.getCreditCardNumber() + 
                    " has already exist so it was not added to card list.");
        }
    }
    
    public void removeCreditCard(CreditCard creditCard)
    {
        if(this.creditCards.contains(creditCard))
        {
            this.creditCards.remove(creditCard);
            System.out.println(this.username + " has removed the number " + 
             creditCard.getCreditCardNumber() + " credit card from card list.");
        }
        else
        {
            System.out.println("The " + creditCard.getCreditCardNumber() + 
                    " has not exist in credit card list.");
        }
    }
   
    public void showCreditCards()
    {
        System.out.println("The Credit Cards of " + this.username + ":");
        for(int i=0;i<this.creditCards.size();i++)
        {
             System.out.println("$ " + this.creditCards.get(i).getSummaryInfo());
        }
    }
    
    public void addProductToFavourites(Product product)
    {
        if(!this.favoriteProducts.contains(product))
        {
            this.favoriteProducts.add(product);
            System.out.println(this.username + " has added " + 
                    product.getProductSummary() + " to favourites");
        }
        else
        {
            System.out.println(product.getProductSummary() + 
                    " has already exist on " + this.username + " favourites");
        }
    }
    
    public void removeProductFromFavourites(Product product)
    {
        if(this.favoriteProducts.contains(product))
        {
            this.favoriteProducts.remove(product);
            System.out.println(this.username + " has removed " + 
                    product.getProductSummary() + " from favourites");
        }
        else
        {
            System.out.println(product.getProductSummary() + 
                    " has not already exist on " + this.username + " favourites");
        }
    }
    
    public void viewFavouriteProducts()
    {
        if(this.favoriteProducts.size() > 0)
        {
            System.out.println("The Favourite Products of " + this.username + ":");
            for(int i=0;i<this.favoriteProducts.size();i++)
            {
                System.out.println("* " + this.favoriteProducts.get(i).getProductSummary());
            }
        }
        else
        {
            System.out.println("There is no Favourite Products of " + this.username + ".");
        }
    }
    
    public void purchaseProduct(Product product, int numOfProduct, CreditCard creditCard)
    {
        Order order = new Order(this,product,creditCard);
        if(!this.creditCards.contains(creditCard))
        {
            System.out.println("User has not this credit card so ordering was not successful.");
        }
        else
        {
             order.checkOrder(numOfProduct);
        }
    }
    
    public void completePurchasing(Product product, int numOfProduct, CreditCard creditCard)
    {
        for(int i=0;i<numOfProduct;i++)
        {
            this.productsOrdered.add(product);
        }
        System.out.println("Purchasing with " + creditCard.getCreditCardNumber() + " card was successful.");
    }
    
    public void viewOrderedProducts()
    {
        if(this.productsOrdered.size() > 0)
        {
            System.out.println("The Ordered Products of " + this.username + ":");
            viewOrders(this.productsOrdered);
        }
        else
        {
            System.out.println("There is no Ordered Products of " + this.username + ".");
        }
    }
    
    public void cancelOrder(Product product, int numOfProduct, CreditCard creditCard)
    {
        Order order = new Order(this,product,creditCard);
        if(!this.creditCards.contains(creditCard))
        {
            System.out.println("User has not this credit card so cancel ordering was not successful.");
        }
        else if(CancelOrderedBefore(product,numOfProduct))
        {
            order.checkOrderforCancelling(numOfProduct);
        }
        else
        {
            System.out.println("Purchasing Cancel with " + creditCard.getCreditCardNumber() 
                    + " card was not successful because the ordered number of products could not be found.");
        }
        
    }
    
    public boolean CancelOrderedBefore(Product product, int numOfProduct)
    {
        int count=0;
        for(int i=0;i<this.productsOrdered.size();i++)
        {
            if(productsOrdered.get(i).equals(product))
            {
                count++;
            }
        }
        if(count >= numOfProduct)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void completePurchasingCancel(Product product, int numOfProduct, CreditCard creditCard)
    {
        for(int i=0;i<numOfProduct;i++)
        {
            this.productsOrdered.remove(product);
            this.productsCancelOrdered.add(product);
        }
        System.out.println("Purchasing Cancel with " + creditCard.getCreditCardNumber() + " card was successful.");
    }
    
    public void viewCancelOrderedProducts()
    {
        if(this.productsCancelOrdered.size() > 0)
        {
            System.out.println("The Cancel Ordered Products of " + this.username + ":");
            viewOrders(this.productsCancelOrdered);
        }
        else
        {
            System.out.println("There is no Cancel Ordered Products of " + this.username + ".");
        }
    }
    
    public static void viewOrders(ArrayList<Product> list)
    {
        Set<Product> plist = new HashSet<Product>(list);
        for (Product p : plist)
            System.out.println("* " + Collections.frequency(list, p) + " " + p.getProductSummary());
    }
}
