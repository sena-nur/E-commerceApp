package ecommerceapp;

import java.text.ParseException;

public class Test {

    public static void main(String[] args) throws ParseException {
        
        User user1 = new User("Marry77", "Marry", "Steam", "22/05/1990", 
                "123456", "marry77@gmail.com", "St. Johnson Street Miami/USA", 
                "CBU Muradiye");
        
        System.out.println("Name:" + user1.getName());
        System.out.println();
        user1.setName("Robin");
        user1.viewUserInfo();
        
        System.out.println();
        
        User user2 = new User("David45", "David", "Steven", "07/03/1996", 
                "654346", "stevensteven@gmail.com", "Mexico Street/Mexico", 
                "CBU Muradiye");
        Product product1 = new Product("Asus ROG Strix G17","Black","Laptop",
                8.0,"(2020) Gaming Laptop, 17.3” 144Hz FHD IPS Type Display, "
                        + "NVIDIA GeForce RTX 2070");
        Product product2 = new Product("Sneakers","Red","Shoes",1.0,
                "NIKE size-38");
        
        Product product3 = new Product("LAYS Chips","Yellow","Food",1.0,
                "LAY'S® Sour Cream & Onion Flavored Potato Chips");
        
        product1.addProductToStock(5);
        product2.addProductToStock(3);
        product3.addProductToStock(12);
        
        System.out.println();
        
        user1.addProductToFavourites(product1);
        
        System.out.println();
        
        user2.addProductToFavourites(product2);
        user2.addProductToFavourites(product3);
        user2.addProductToFavourites(product2);

        System.out.println();
        
        user1.viewFavouriteProducts();
        
        System.out.println();
        
        user2.viewFavouriteProducts();
        
        System.out.println();
        
        user1.removeProductFromFavourites(product2);
        System.out.println();
        user1.removeProductFromFavourites(product1);
        System.out.println();
        user2.removeProductFromFavourites(product1);
        System.out.println();
        user1.viewFavouriteProducts();
        System.out.println();
        user2.viewFavouriteProducts();
        
        System.out.println();
        
        product1.getProductStockInfo();
        product1.addProductToStock(5);
        product1.getProductStockInfo();
        product1.addProductToStock(3);
        product1.getProductStockInfo();
        product2.addProductToStock(37);
        product2.getProductStockInfo();
        product3.addProductToStock(9);
        product3.getProductStockInfo();
        
        System.out.println();
        
        CreditCard creditCard1 = new CreditCard("9283754854895321", user1, 
                123, "15/09/2026");
        CreditCard creditCard2 = new CreditCard("3452674528904455", user2 , 
                458 , "12/04/2024");
        CreditCard creditCard3 = new CreditCard("3149723849558458", user1 , 
                398 , "08/12/2022");
        
        System.out.println();
        
        user1.addCreditCard(creditCard1);
        user1.addCreditCard(creditCard3);
        user1.removeCreditCard(creditCard1);
        user1.addCreditCard(creditCard2);
        user2.addCreditCard(creditCard2);
        
        System.out.println();
        
        user1.showCreditCards();
        System.out.println();
        user2.showCreditCards();
        
        System.out.println();
        
        user1.addProductToFavourites(product3);
        user1.addProductToFavourites(product2);
        user1.addProductToFavourites(product3);
        user1.addProductToFavourites(product1);
        
        System.out.println();
        
        user1.viewFavouriteProducts();
        
        System.out.println();
        
        user1.removeProductFromFavourites(product3);
        user1.removeProductFromFavourites(product3);
        
        System.out.println();
        user1.purchaseProduct(product3, 0, creditCard3);
        System.out.println();
        
        product3.addProductToStock(5);
        
        System.out.println();
        
        user1.purchaseProduct(product3, 2, creditCard3);
        
        System.out.println();
        
        user1.purchaseProduct(product1, 3, creditCard1);
        
        System.out.println();
        
        user1.purchaseProduct(product3, 3, creditCard3);
        
        System.out.println();
        
        user1.purchaseProduct(product2, 19, creditCard3);
        
        System.out.println();
        
        user2.cancelOrder(product3, 5, creditCard2);
        
        System.out.println();
        
        user2.cancelOrder(product3, 0, creditCard3);
        
        System.out.println();
        
        user2.purchaseProduct(product2, 21, creditCard2);
        user2.purchaseProduct(product2, 1, creditCard2);
        System.out.println();
        user2.viewOrderedProducts();
        System.out.println();
        user2.cancelOrder(product2, 1, creditCard2);
        System.out.println();
        user2.viewCancelOrderedProducts();
        System.out.println();
        user2.viewOrderedProducts();
        System.out.println();
        user1.viewOrderedProducts();
        System.out.println();
        user1.viewCancelOrderedProducts();
        System.out.println();
        user1.cancelOrder(product2, 3, creditCard3);
        System.out.println();
        user1.cancelOrder(product3, 20, creditCard3);
        System.out.println();
        user1.cancelOrder(product3, 6, creditCard3);
        
        System.out.println();
        user1.cancelOrder(product3, 5, creditCard3);
        
        System.out.println();
        user1.viewCancelOrderedProducts();
        user1.viewOrderedProducts();
    }
    
}
