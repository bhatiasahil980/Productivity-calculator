import ncu.processors.*;
import ncu.validators.*;
//import ncu.exceptions.*;

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) {

        String username="";
        int confirmation1 = 0;
        int confirmation2 = 0;

        Scanner sc = new Scanner(System.in);


        System.out.println(" --------------------------------------------------------------------------------------- ");
        System.out.println("|                                                                                       |");
        System.out.println("|     Hello user, Welcome to .......                                                    |");
        System.out.println("|                             ________________________                                  |");
        System.out.println("|                            | PRODUCTIVITY CALCULATOR|                                 |");
        System.out.println("|                             ------------------------                                  |");
        System.out.println(" --------------------------------------------------------------------------------------- ");
        System.out.println("|                                                                                       |");
        System.out.println("|    Already a user?  _______                                                           |");
        System.out.println("|    --- Press[1] to | Login |                                                          |");
        System.out.println("|                     -------                                                           |");
        System.out.println("|    New user?        ________                                                          |");
        System.out.println("|    --- Press[2] to | signup |                                                         |");
        System.out.println("|                     --------                                                          |");
        System.out.println(" --------------------------------------------------------------------------------------- ");



        int choice1 = sc.nextInt();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        switch (choice1){

            case 1:{
                login.displayloginpage();
                username = sc.next();
                String password = sc.next();
                String check = String.format(username+password);
                login.check(check);
                confirmation1 = 1;
                break;
            }

            case 2: {
                createuser.displaypage();
                usernamevalidators.validationDispaly();
                username = sc.next();
                boolean valid1 = usernamevalidators.validate(username);
                if(valid1 == true){
                    String password = sc.next();
                    boolean valid2 = passwordvalidators.validate(password);
                    if(valid2 == true){
                        System.out.println("confirm your password");
                       String cpassword = sc.next();
                    if (createuser.confirm(password, cpassword) == 1) {
                        String credentials = String.format(username + password);
                        createuser.adduser(credentials, username);
                        confirmation2 = 1;
                    } else {
                    }
                }
                    else{
                        System.out.println(" Invalid password ^ Enter a password between 6 - 12 characters. ");
                    }}
                else{
                    System.out.println("");
                System.out.println(" Entered Username does not match the Conditions. ^ Try entering the USERNAME again ^");
            }
            break;
            }

            default:
                System.out.println(" Oops :(, Please enter a valid choice....");
        }


        if(confirmation1 == 1 || confirmation2 == 1){

        System.out.println(" What do you want to perform :");
        System.out.println("");
        System.out.println(" 1. ADD TASK.");
        System.out.println(" 2. UPDATE TASK.");
        System.out.println(" 3. DELETE TASK.");
        System.out.println(" 4. DISPLAY TASK.");

        int choice2 = sc.nextInt();

        switch (choice2) {

            case 1: {

                int another = 1;
                do {
                    System.out.println(" Enter category (productive/non-productive)");
                    String category = sc.next();
                    System.out.println(" Enter the task name.");
                    String task_name = sc.next();
                    System.out.println(" Enter time spent on task in hours.");
                    float time = sc.nextFloat();
                    add.save(username, category, task_name, time);
                    System.out.println("");
                    System.out.println("--->Press [1] to enter another task.");
                    System.out.println("--->Press [0] to exit operation.");
                    another = sc.nextInt();
                }
                while (another == 1);
                break;


            }

            case 2: {

                int another = 1;
                do {
                System.out.println(" Which task do you want to update ? ");
                System.out.println(" Specify the : category , task name And Time spent ");
                String category = sc.next();
                String task_name = sc.next();
                float time = sc.nextFloat();
                String original = String.format("category:"+category+"                Task name:"+task_name+"               Time spent:"+time+" hrs");

                System.out.println(" What new task do you want to add in place of that ?");
                System.out.println(" Add the details : category, task name And Time spent ");
                String newcategory = sc.next();
                String newtask_name = sc.next();
                float newtime = sc.nextFloat();
                String newtask = String.format("category:"+newcategory+"                Task name:"+newtask_name+"               Time spent:"+newtime+" hrs");

                update.UpdateFile(username,original,newtask);

                System.out.println("");
                System.out.println("--->Press [1] to enter another task.");
                System.out.println("--->Press [0] to exit operation.");
                another = sc.nextInt();
                }
                while (another == 1);
                break;
            }

            case 3: {

                int another = 1;
                do {
                    System.out.println(" Which task do you want to Delete from your list ? ");
                    System.out.println(" Specify the : category , task name.");
                    String category = sc.next();
                    String task_name = sc.next();

                    String original = String.format("category:"+category+"                Task name:"+task_name);

                    delete.deleteFile(username,original);

                    System.out.println("");
                    System.out.println("--->Press [1] to enter another task.");
                    System.out.println("--->Press [0] to exit operation.");
                    another = sc.nextInt();
                }
                while (another == 1);
                break;
            }

            case 4:
            {
                //display.displayTask(username);
            }
        }
        }
    }
}
