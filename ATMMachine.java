package ModulesJava.ATM;

/*This project is to make automated teller machine with
user's account and password, and bank account. User's
are able to withdraw, deposit, and view their account balance.
 */

//Requirements are CORE Java concepts
/*Accounts:
Acc. Number: 1039864 Password: 1030
Acc. Number: 839789 Password: 1228
 */

import java.io.IOException;

public class ATMMachine extends OptionMenu {

    public static void main(String[] args) throws IOException {

        OptionMenu optionMenu = new OptionMenu();

        optionMenu.getLogin();
}
}
