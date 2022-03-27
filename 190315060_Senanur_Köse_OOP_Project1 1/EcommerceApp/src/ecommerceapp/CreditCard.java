package ecommerceapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditCard {
    private String creditCardNumber;
    private User creditCardUser;
    private int securityCode;
    private Date expirationDate;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    
    public CreditCard(String creditCardNumber, User creditCardUser, int securityCode, String expirationDate) throws ParseException {
        this.creditCardNumber = creditCardNumber;
        this.creditCardUser = creditCardUser;
        this.securityCode = securityCode;
        this.expirationDate = format.parse(expirationDate);
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public User getCreditCardUser() {
        return creditCardUser;
    }

    public void setCreditCardUser(User creditCardUser) {
        this.creditCardUser = creditCardUser;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    public String getSummaryInfo()
    {
        return this.creditCardNumber + " " + this.expirationDate + 
       " " + this.securityCode + " " + this.creditCardUser.getName();
    }
    
}
