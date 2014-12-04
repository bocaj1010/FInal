// Decompiled by DJ v3.12.12.98 Copyright 2014 Atanas Neshkov  Date: 11/30/2014 10:44:37 PM
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   User.java


/**Set and get methods for the Account that returns the name and password of the account.
 * 
 * @author Jacob
 *
 */

public class Account
{

    public Account()
    {
        accountName = "";
        password = "";
    }

    public Account(String accountName, String password)
    {
        this.accountName = accountName;
        this.password = password;
    }

    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getAccountName()
    {
        return accountName;
    }

    public String getPassword()
    {
        return password;
    }

    public boolean equals(Account other)
    {
        return accountName.equals(other.getAccountName()) && password.equals(other.getPassword());
    }

    public String toString()
    {
        String output = "";
        output = (new StringBuilder(String.valueOf(output))).append("Account Name : ").append(accountName).append(" Password : ").append(password).toString();
        return output;
    }

    private String accountName;
    private String password;
}
