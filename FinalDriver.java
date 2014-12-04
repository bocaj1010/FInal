


import java.io.PrintStream;
import javax.swing.JOptionPane;



/**Runs program using case structure to verify user input and implements Account and Item classes.
 * 
 * @author Jacob
 */
public class FinalDriver
{

    public FinalDriver()
    {
    }

    public static void main(String args[])
    {
        Item products[] = new Item[10];
        Item receipt[] = new Item[10];
        String choices[] = {
            "Create a product", "Sell a product", "Print receipt", "Exit Program", "Display userlog"
        };
        String welcome[] = {
            "Login", "Create Account"
        };
        Account users[] = new Account[5];
        users[0] = new Account("jacob", "power");
        boolean loop = true;
        while(loop) 
        {
            loop = false;
            String inputUrname = null;
            String inputPass = null;
            String loginChoice = (String)JOptionPane.showInputDialog(null, "Choose an action...", "List of Actions", 3, null, welcome, welcome[0]);
            String s;
            switch((s = loginChoice).hashCode())
            {
            default:
                break;

            case 73596745: 
                if(!s.equals("Login"))
                    break;
                inputUrname = JOptionPane.showInputDialog("Enter User Name");
                if(inputUrname != null)
                    inputPass = JOptionPane.showInputDialog("Enter Password");
                boolean loggedIn = false;
                Account loginInput = new Account(inputUrname, inputPass);
                for(int i = 0; i < users.length; i++)
                    if(users[i] != null && loginInput.equals(users[i]))
                    {
                        System.out.println((new StringBuilder("Comparing ")).append(loginInput).append(" with ").append(users[i]).toString());
                        loggedIn = true;
                    }

                if(loggedIn)
                {
                    createLogEntry((new StringBuilder("User : ")).append(inputUrname).append(" logged in").toString());
                    JOptionPane.showMessageDialog(null, (new StringBuilder("Welcome ")).append(inputUrname).toString());
                    boolean keepLooping = true;
                    while(keepLooping) 
                    {
                        String menuChoice = (String)JOptionPane.showInputDialog(null, "Choose an action...", "List of Actions", 3, null, choices, choices[0]);
                        String s1;
                        switch((s1 = menuChoice).hashCode())
                        {
                        default:
                            break;

                        case -1943772798: 
                            String name;
                            Item choice;
                            String productsSold;
                            String price;
                            boolean found;
                            double total;
                            Item p;
                            int i;
                            
                            int j;
                            if(s1.equals("Exit Program"))
                                keepLooping = false;
                            break;

                        case 81180930: 
                            if(!s1.equals("Sell a product") || isEmpty(products))
                                break;
                            choice = (Item)JOptionPane.showInputDialog(null, "Choose a product", "List of Products", 3, null, products, products[0]);
                            found = false;
                            for(i = 0; i < products.length; i++)
                                if(products[i] != null && !found && products[i].equals(choice))
                                {
                                    found = true;
                                    for(j = 0; receipt[j] != null && j < receipt.length; j++);
                                    if(j < receipt.length)
                                        receipt[j] = choice;
                                    products[i] = null;
                                    createLogEntry((new StringBuilder(String.valueOf(inputUrname))).append(" sold product : ").append(choice).toString());
                                }

                            break;

                        case 1687254572: 
                            if(!s1.equals("Create a product"))
                                break;
                            name = JOptionPane.showInputDialog("Enter name of product");
                            price = JOptionPane.showInputDialog("Enter price of product");
                            p = new Item(name, Double.parseDouble(price));
                            for(i = 0; products[i] != null && i < products.length; i++);
                            if(i < products.length)
                            {
                                createLogEntry((new StringBuilder(String.valueOf(inputUrname))).append(" created product : ").append(p).toString());
                                JOptionPane.showMessageDialog(null, "Successfully Created Product");
                                products[i] = p;
                            } else
                            {
                                createLogEntry((new StringBuilder(String.valueOf(inputUrname))).append(" failed to create product : ").append(p).toString());
                                JOptionPane.showMessageDialog(null, "Failed to Create Product, inventory full");
                            }
                            break;

                        case 1796469669: 
                            if(!s1.equals("Print receipt"))
                                break;
                            createLogEntry((new StringBuilder(String.valueOf(inputUrname))).append(" printed a receipt").toString());
                            productsSold = "";
                            total = 0.0D;
                            for(j = 0; j < receipt.length; j++)
                                if(receipt[j] != null)
                                {
                                    total += receipt[j].getPrice();
                                    productsSold = (new StringBuilder(String.valueOf(productsSold))).append(receipt[j].toString()).append("\n").toString();
                                }

                            JOptionPane.showMessageDialog(null, (new StringBuilder("Sold these products\n")).append(productsSold).append("\nTotal Revenue : $").append(total).toString());
                            break;

                        case 1826400795: 
                            if(!s1.equals("Display userlog"))
                                break;
                            String logString = "";
                            for( i = 0; i < log.length; i++)
                                if(log[i] != null)
                                    logString = (new StringBuilder(String.valueOf(logString))).append(log[i]).append("\n").toString();

                            JOptionPane.showMessageDialog(null, logString);
                            break;
                        }
                    }
                    break;
                }
                if(inputUrname != null)
                {
                    loop = true;
                    JOptionPane.showMessageDialog(null, "Fail Authentication");
                }
                break;

            case 278621961: 
                if(s.equals("Create Account"))
                {
                    loop = true;
                    String newName = null;
                    String newPassword = null;
                    for(; newName == null; newName = JOptionPane.showInputDialog("Enter User Name"));
                    for(; newPassword == null; newPassword = JOptionPane.showInputDialog("Enter Password"));
                    int i;
                    for(i = 0; users[i] != null && i < users.length; i++);
                    users[i] = new Account(newName, newPassword);
                }
                break;
            }
        }
    }

    /**Checking to see if any items were created
     * 
     * @param p
     * @return
     */
    public static boolean isEmpty(Item p[])
    {
        for(int i = 0; i < p.length; i++)
            if(p[i] != null)
                return false;

        return true;
    }

    /**Outputting "out of space" message if log entry exceeds limit.
     * 
     * @param entry
     */
    public static void createLogEntry(String entry)
    {
        int i;
        for(i = 0; log[i] != null && i < log.length; i++);
        if(i < log.length)
            log[i] = entry;
        else
            System.out.println("Out of space for log entries");
    }

    public static String log[] = new String[30];

}
