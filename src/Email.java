import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password = "", company = "Oxyzo", email, alternateEmail;
    private int defaultPasswordLength;
    private String department = "";
    private int maxCapacity = 500;

    public Email(String First, String Last) {

        this.firstName = First;
        this.lastName = Last;

        this.department = setDepartment();
        this.password = randomPassword(defaultPasswordLength);
        if (department == "")
            department = "general";

        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "."
                + company.toLowerCase()
                + ".com";

        // System.out.println("Your EMAIL is : " + email);
        System.out.println("Enter Y if you want to change password,else enter N");
        Scanner in = new Scanner(System.in);

        char Y = (in.nextLine()).charAt(0);
        if (Y == 'Y') {
            System.out.println("Enter your own password(atleast 8 characters)");
            in = new Scanner(System.in);

            String s = in.nextLine();
            changePassword(s);

        }

        System.out.println("Enter your alternate Email ID");
        in = new Scanner(System.in);

        String s = in.nextLine();
        setAlternateEmail(s);

    }

    private String setDepartment() {
        // ask the IT for what dept this person is.
        System.out.print("Enter the dept.\n1 for Sales\n2 for Development \n3 for Accounting\n0 for None.\n");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "Development";
        } else if (depChoice == 3) {
            return "Accounting";
        } else {
            return "";
        }

    }

    // returns a random password.
    private String randomPassword(int length) {
        System.out.print("Enter preferred length for password greater than 8.\n");
        Scanner in = new Scanner(System.in);

        length = in.nextInt();
        if (length < 8)
            length = 8;
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*";
        char[] password = new char[length];

        for (int i = 0; i < length; i += 1) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        // convert array of chars to string.
        return new String(password);

    }

    public void setMailboxCapacity(int x) {
        this.maxCapacity = x;
    }

    public int getMailboxCapacity() {
        return maxCapacity;
    }

    public String getEmail() {
        return this.email;
    }

    // set alternate email ID
    public void setAlternateEmail(String x) {
        this.alternateEmail = x;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
        // System.out.println("New password now : " + this.password + "\n");
        // to manually enter your password
    }

    public String PrintInfo() {
        return ("\nEmail Created for " + this.firstName + " " +
                this.lastName + ".\nEMAIL is : " + getEmail() + "\nDepartment is : " + this.department
                + "\nAlternate Email set to " + getAlternateEmail() +
                "\nPassword now : " + getPassword() + "\nCurrent Mailbox Capacity is : " + getMailboxCapacity()
                + " mb.");

    }

}
