import java.sql.SQLOutput;
import java.util.Scanner;

public class bank {
    int a,b;
    double ac=111,pin=1111,bal=10000;
    double c;
    int i=0;
    int j;
    double[] arr=new double[6];

    Scanner input=new Scanner(System.in);
    public void check_card()
    {
        System.out.println("Insert your card (i.e., Enter the card number)");
        a=input.nextInt();
        if (a==ac)
        {
            System.out.println("Welcome to SBI, \n Enter your PIN Number");
            check_pin();
        }
        else
            {
            System.out.println("Sorry! Invalid Card Number, Try Again");
        }
    }
    public void check_pin()
    {
      //  System.out.println("Enter your PIN Number");
        a=input.nextInt();
        if (a==pin) {
            System.out.println("Select your choice \n 1. Withdrawal \n 2.balance\n 3.deposit \n 4.ministatement ");
            b = input.nextInt();
            if (b == 1) {
                choice_withdraw();
                check_card();
            }
            else if (b == 2) {
                choice_balance();
                check_card();
            }
            else if (b == 3){
                choice_deposit();
            check_card();
        }
           else if (b==4) {

            choice_ministatement();
            check_card();
        }


        }
        else
        {
            System.out.println("Sorry! Invalid PIN Number, Try Again");
        }
    }


    public void choice_withdraw(){
        System.out.println("Enter the amount");
        c=input.nextDouble();
        if(c<bal){
            bal = bal - c;
            arr[i]=bal;
        //    i++;
            System.out.println("Kindly Collect the Cash");

           // System.out.println(bal);
            System.out.println(arr[i]);
            i++;

        }
        else
    {
            System.out.println("No sufficient balance");
        }
        out_bound();
    }
    public void choice_balance(){

        System.out.println("Your balance amount is: "+bal);

        System.out.println("PLEASE TAKE YOUR SLIP");
    }
    public void choice_deposit(){
        System.out.println("Enter the amount");
        c=input.nextDouble();
        bal = bal + c;
        System.out.println("Deposited Successfully! ");
        System.out.println("\nYour Balance is: "+ bal);
        System.out.println("\n THANKYOU !!");
        out_bound();
    }
    public  void choice_ministatement()
    {
        int k= arr.length;
        for(j=0;j<=k-1;j++){
            if(arr[j]!=0.0) {
                System.out.println(arr[j]);

            }


            }

       System.out.println("PLEASE TAKE YOUR SLIP");
        System.out.println("THANKYOU !!" );
    }
    public void out_bound() {
    int k= arr.length;
    int flag = 1;
    for(j=0;j<=k-1;j++) {
        if (arr[j] == 0.0) {
            flag = 0;
        }
    }
        if(flag==1)
        {
            System.out.println("Array is full");

            for(j=0;j<k-1;j++){

                arr[j]=arr[j+1];
                i=j;
                //System.out.println(arr[i]);
            }
            arr[i]=0.0;
        }




    }

    public static void main(String[] args)
    {
        bank in=new bank();
        in.check_card();
       // in.check_pin();

        //in.choice_withdraw();
     //   System.out.println(arr[i]);


    }
}
