//package database_choicetable;
import java.sql.*;
import java.util.Scanner;
class choicetable {
    int ch;
    String table="",field_name="",type="",two="",three="",four="",five="";
    String name,val,six="",newone="";
    String field_namee="",vall="";
    int i;
    Scanner input = new Scanner(System.in);


    //System.out.println(enter the choice);
    public void choice() throws SQLException {

        System.out.println("ENTER THE CHOICE \n 1.CREATE TABLE \n 2.INSERT TABLE \n 3.UPDATE TABLE \n 4.DELETE TABLE \n 5.SELECT TABLE");
        //   Scanner input = new Scanner(System.in);

        ch = input.nextInt();
        switch (ch) {

            case 1: {
                create_table();
                break;
            }
            case 2:
            {
                insert_table();
                break;
            }
            case 3:
            {
                update_table();
                break;
            }
            case 4:{
                delete_table();
                break;
            }
            // case 5:
            // {
            //     break;
            // }
            default:
                System.out.println("not found");

        }

    }
    public void create_table()throws SQLException {

        System.out.println("enter the table name");
        //  String table,field_name,type = null;
        table = input.next();

        System.out.println("enter the number of columns");
        int nc=input.nextInt();
        for(int i=0;i<nc;i++){
            System.out.println("enter the field name");
            field_name=input.next();
            System.out.println("enter the field type");
            type=input.next();
            two = two + field_name + " " + type ;
            if(i<nc-1)
                two = two + ",";
        }
        String one= "create table "+table +"("+two+");";
        System.out.println("syntax is "+one);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/vaishu", "root", "root");
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(one);

    }
    //	String one= "create table" +table +" "+two;
    //	System.out.println("sytax is "+one);
    public void insert_table() throws SQLException {
        //t i;
        System.out.println("enter the tablename  you want to insert");
        String in=input.next();


        System.out.println("enter the number of columns");
        int nc=input.nextInt();

        for(int i=1;i<nc;i++){
            System.out.println("enter the field name");
            name = input.next();
            if(i<nc)
                three=three+name+",";
            else if (i==nc)
                three=name;



            System.out.println("enter the value");
            val = input.next();


            four = four + val+",";

        }

        five = "insert into " + in + "(" + three  + ")" + "values" + "(" + four  + ");";
        System.out.println("syntax is " + five);

    }
    // try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/vaishu", "root", "root")) {
    // try (Statement stmt = conn.createStatement()) {
    // stmt.executeUpdate(five);
    //}




    public void update_table() {
        System.out.println("enter the table name");
        table = input.next();
        System.out.println("enter the number of columns");
        int nc=input.nextInt();
        for(int i=0;i<nc;i++){
            System.out.println("enter the field name");
            field_name=input.next();
            System.out.println("enter the field value");
            val=input.next();
            newone=field_name+"="+val+",";
            six=six+newone;
        }

        System.out.println("enter the unique key");
        System.out.println("enter the field name");
        field_namee=input.next();
        System.out.println("enter the field value");
        vall=input.next();
        String seven= "update table "+table +"set"+"("+six+")"+"where"+""+field_namee+"="+vall+";";
        System.out.println("syntax is "+seven);


    }
    public void delete_table() { System.out.println("enter the table name");
        table = input.next();

        System.out.println("enter the field name");
        field_name=input.next();
        System.out.println("enter the field value");
        val=input.next();

        String eight="delete from "+table+""+"where"+""+field_name+"="+val+";";
        System.out.println(eight);
    }
    public static void main(String[] args) throws SQLException {
        choicetable ct=new choicetable();
        ct.choice();

    }


}
















































