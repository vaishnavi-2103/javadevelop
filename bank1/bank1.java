package bank1;
import java.io.*;
import java.util.Scanner;
import java.io.IOException;

public class bank1 {
    int a, b;
    String ac = "vaishu";
    int pin;
    int newpin;
    double bal = 10000;
    double c;
    int i = 0;
    int j;
    double[] money = new double[6];
    double[] arr = new double[6];
    String[] choice = new String[6];

    Scanner input = new Scanner(System.in);


    public void check_card () throws IOException // to check the card number
        {
            System.out.println("Insert your card (i.e., Enter the card number)");
            Scanner input1 = new Scanner(System.in);
            String aa = input1.nextLine();
            //input1.close();
        //  String aa1= toString();
            if (aa.equals(ac)) {
                System.out.println("Welcome to SBI, \n Enter your PIN Number");
                check_pin();
            } else {
                System.out.println("Sorry! Invalid Card Number, Try Again");
            }

        }
        public void check_pin () throws IOException { ///to check if enterted pin is valid

            a = input.nextInt();
            // use switch case instead
            if (a == pin) {
                System.out.println("Select your choice \n 1. Withdrawal \n 2. Balance \n 3. Deposit \n 4. Mini Statement \n 5. Change Password \n 6. Change username");//user select in any option 1-4int b = input.nextInt();
                b = input.nextInt();
                switch (b) {
                    case 1:
                        choice_withdraw();//calling method
                        check_card();
                        break;

                    case 2:
                        choice_balance();
                        check_card();
                        break;

                    case 3:
                        choice_deposit();
                        check_card();
                        break;

                    case 4:
                        choice_ministatement();
                        check_card();
                        break;

                    case 5:
                       // check_pin();
                        System.out.println("Enter the new pin");
                        int newpin=input.nextInt();
                        change_details(newpin);
                        System.out.println("enter the new pin again");
                        check_pin();
                        break;

                    case 6:
                        System.out.println("Enter the new user id");
                     //   Object userid;
                        Scanner input2 = new Scanner(System.in);
                        String userid =input2.nextLine();
                        //input2.close();
                        change_details(userid);
                        check_card();
                        break;

                    default:
                        System.out.println("not found");
                        System.out.println("Sorry! Invalid PIN Number, Try Again");
                }
            }
            else
            {
                System.out.println("Invalid Pin");
                check_card();
            }
        }


        public void choice_withdraw () //method for withdrawal
        {
            System.out.println("Enter the amount");
            c = input.nextDouble();
            if (c < bal) {                     //checking the limit of cash given whether its above limited specified
                bal = bal - c;
                arr[i] = bal;
                money[i] = c;
                choice[i] = "withdraw";
                System.out.println("Kindly Collect the Cash: " + c);
                System.out.println("Your balance is: " + arr[i]);
                //System.out.print(arr[i]);

            } else {
                System.out.println("No sufficient balance");
            }
            out_bound();
        }

        public void choice_balance () {                         //to get the balance

            System.out.println("Your balance amount is: " + bal);  //printing balance
            System.out.println("PLEASE TAKE YOUR SLIP");
        }

        public void choice_deposit () {                            //method to deposit amount in bank
            System.out.println("Enter the amount");
            c = input.nextDouble();
            bal = bal + c;                                            //with the previous balance the deposited amount is addad
            System.out.println("Deposited Successfully! ");
            System.out.println("\nYour Balance is: " + bal);
            System.out.println("\n THANKYOU !!");

            //  arr[i]=bal;
            arr[i] = bal;
            money[i] = c;
            choice[i] = " deposit";
            i++;
            //balance iss stored with array
            out_bound();
        }

        public void choice_ministatement ()
        {                            //this is statement which gives your transactional details

            int k = arr.length;
            // System.out.println(b);
            System.out.println("Transaction " + "\t" + "Amount" + "\t" + "balance");
            for (int i = 0; i < k; i++) {

                if (arr[i] != 0.0) {
                    //  System.out.println("Transaction type" + "\t"+"\t" + "Amount" + "\t"+"\t"8 +"balance");

                    System.out.println(choice[i] + "\t" + "\t" + money[i] + "\t" + arr[i]);
                     // System.out.format("%f" + choice[i]);
                }
            }


            System.out.println("PLEASE TAKE YOUR SLIP");
            System.out.println("THANKYOU !!");


        }


        public void out_bound () {                   //this method is for check  whether array is full
            int k = arr.length;
            int flag = 1;
            for (j = 0; j <= k - 1; j++) {
                if (arr[j] == 0.0) {
                    flag = 0;
                }
            }
            if (flag == 1) {
                System.out.println("Array is full"); //when the array is full then its pops the first value

                for (j = 0; j < k - 1; j++) {

                    choice[j] = choice[j + 1];
                    money[j] = money[j + 1];
                    arr[j] = arr[j + 1];
                    i = j;
                    //System.out.println(arr[i]);
                }
                arr[i] = 0.0;
            }


        }
    public void get_data() throws IOException {
        File filein = new File("C:\\Users\\Vaishnavi\\IdeaProjects\\formulaif\\src\\pwdd.txt");
        BufferedReader br = (new BufferedReader(new FileReader(filein)));
        String line = null;
        String k = "";
        while((line = br.readLine()) != null){
            k = k + line;
        }
        br.close();
        pin = Integer.parseInt(k);

        File filein1 = new File("C:\\Users\\Vaishnavi\\IdeaProjects\\formulaif\\src\\usr.txt");
        BufferedReader br1 = (new BufferedReader(new FileReader(filein1)));
        String line1 = null;
        String k1 = "";
        while((line1 = br1.readLine()) != null){
            k1 = k1 + line1;
        }
        br1.close();
        ac = k1;

    }
    public void change_details(String un) throws IOException {
        ac=un;
        File fileout = new File("C:\\Users\\Vaishnavi\\IdeaProjects\\formulaif\\src\\usr.txt");
        FileWriter pw = new FileWriter(fileout);
        pw.write("");
        FileWriter pw1 = new FileWriter(fileout,true);
        String line = null;
        pw1.write(ac);
        pw.close();
        pw1.close();
        System.out.println("Successfully changed the user id");

    }
    public void change_details(int np) throws IOException {
        String  k;
        pin=np;
        File fileout = new File("C:\\Users\\Vaishnavi\\IdeaProjects\\formulaif\\src\\pwdd.txt");
        FileWriter pw = new FileWriter(fileout);
     //   pw.write("");
        FileWriter pw1 = new FileWriter(fileout,true);
        String line = null;
        k=Integer.toString(pin);
        pw1.write(k);
        pw.close();
        pw1.close();
        System.out.println("Successfully changed the pin");

    }



        public static void main (String[]args) throws IOException {
            //bank_inhertance in = new bank_inhertance();
            // in.check_card();
           // bank1 in2=new bank1();
            bank1 in1 = new bank1();
          //  in1.newbank1();
            in1.get_data();
            in1.check_card();

        }

       /* static class b_i extends bank1 {
            // int d;
            public b_i() {
                super();
                //  super(bal);
                System.out.println("Updated Balance: " + bal);
            }

            public void newbank1() {
                bal = bal * 2;
                System.out.println("New Balance: " + bal);*/
            }

