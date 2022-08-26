/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busreservation;

import java.lang.reflect.Array;
import java.util.Scanner;
/**
 *
 * @author rshri
 */
abstract class Person {
    Scanner sc = new Scanner(System.in);
    int per_id, per_bookingnum;
    String per_name, per_email, per_password, per_mobilenum;
    public abstract void increaseCount();
    public abstract void viewCount(); 
    public void display(){
                           System.out.println("ID\t\tNAME\t\tEMAIL\t\t\t\tPHONENUMBER\t\tTOTAL BOOKINGS");        
    }
    public void viewCustomers(){
        System.out.println(per_id + "\t\t" + per_name + "\t\t" + per_email + "\t\t" + per_mobilenum+ "\t\t"+ per_bookingnum);
    }
}

class Customer extends Person {
    public void addCustomer(){
        //System.out.println("Enter id :");
        //per_id = sc.nextInt();
        System.out.println("Enter Name :");
        per_name = sc.next();
        System.out.println("Enter Email :");
        per_email = sc.next();
        System.out.println("Enter Mobilenumber :");
        per_mobilenum = sc.next();
        per_bookingnum = 0;        
    }
    int totnumofbookings;
    @Override
    public void increaseCount(){
        per_bookingnum += 1;
    }
    @Override
    public void viewCount(){
        System.out.println("To be filled");
    }
    Customer(int per_id, String per_name, String per_email, String per_mobilenum, int per_bookingnum){
        this.per_id = per_id;
        this.per_name = per_name;
        this.per_email = per_email;
        this.per_mobilenum = per_mobilenum;
        this.per_bookingnum = per_bookingnum;
    }
}

class Bus {
    Scanner sc = new Scanner(System.in);
    
    int bus_id, get_id;
    int[] seatcount = new int[2]; 
    int[] ticketbooked = {0, 0};
    String driverName, source, destination, int_busstop1, int_busstop2, int_busstop3, start_time, end_time, start_date, end_date;
    public void addNewBus(){
        //System.out.println("Enter id :");
        //bus_id = sc.nextInt();
        System.out.println("Enter Source point :");
        source = sc.next();
        System.out.println("Enter destination :");
        destination = sc.next();
        System.out.println("Enter driver name :");
        driverName = sc.next();
        System.out.println("Enter First Bus stop :");
        int_busstop1 = sc.next();
        System.out.println("Enter Second Bus stop :");
        int_busstop2 = sc.next();
        System.out.println("Enter Third Bus stop :");
        int_busstop3 = sc.next();
        System.out.println("Enter Start date :");
        start_date = sc.next();
        System.out.println("Enter Start time :");
        start_time = sc.next();
        System.out.println("Enter End date :");
        end_date = sc.next();
        System.out.println("Enter End time :");
        end_time = sc.next();
        System.out.println("Enter Number of seater seats :");
        seatcount[0] = sc.nextInt();
        System.out.println("Enter Number of sleeper seats :");
        seatcount[1] = sc.nextInt();        
    }
    Bus(int bus_id, String source, String destination, String driverName, String int_busstop1, String int_busstop2, String int_busstop3, String start_date, String start_time, String end_date, String end_time, int sleeperseatcount, int seaterseatcount){
        this.bus_id = bus_id;
        this.destination = destination;
        this.driverName = driverName;
        this.start_date = start_date;
        this.start_time = start_time;
        this.end_date = end_date;
        this.end_time = end_time;
        this.source = source;
        this.int_busstop1 = int_busstop1;
        this.int_busstop2 = int_busstop2;
        this.int_busstop3 = int_busstop3;
        this.seatcount[0] = seaterseatcount;
        this.seatcount[1] = sleeperseatcount;        
    }
    public void viewAvailableBuses(){
        System.out.println("\nBUS ID :"+bus_id+"\tDriver Name"+driverName+"\n"+"Source Point :"+source+"\tDestination :"+destination+"\nBus stop 1 :"+int_busstop1+"\tBus stop 2 :"+int_busstop2+"\tBus stop 3 :"+int_busstop3
                +"\nStart Time :"+start_date+"  "+start_time+"\nEnd time :"+end_date+"  "+end_time+"\nSeater seats available :"+seatcount[0]+"\nSleeper seats available :"+seatcount[1]);
    }
    public int getSeaterSeatNum(){
        return seatcount[0];
    }
    public int getSleeperSeatNum(){
        return seatcount[1];                
    }   
}

class TicketBooking {
    Scanner sc = new Scanner(System.in);
    int[] seats_num = new int[2];
    int bus_ID, amount, a, seaterprice, sleeperprice;
    String cus_ID, time, date;
    public int[] TicketBooking(int bid, int uid, int SleeperSeatNum, int SeaterSeatNum){
        if (uid == -1){cus_ID = "-";}else{cus_ID = String.valueOf(uid);}
        bus_ID = bid;
        System.out.println("Enter number of seater seats :");
        int seaterseatnum = sc.nextInt();
        System.out.println("Enter number of sleeper seats :");
        int sleeperseatnum = sc.nextInt();     
        int[] arr = new int[4];
        arr[0] = SeaterSeatNum - seaterseatnum; arr[1] = SleeperSeatNum - sleeperseatnum;
        arr[2]  = seaterseatnum; arr[3] = sleeperseatnum;
        return arr;
    }    
    public void viewBooking(){
        System.out.println(cus_ID + "\t\t"+bus_ID+"\t\t"+seats_num[0]+"\t\t"+seats_num[1]+"\t\t"+amount);
    }    
}
class SeaterPrice extends TicketBooking{
    
    SeaterPrice(int id, int price){
        this.bus_ID = id;
        this.seaterprice = price;
    }
    public void addSeaterPrice(){
        //System.out.println("Enter bus ID to add seater Price :");
        //bus_ID = sc.nextInt();
        System.out.println("Enter Price per seat :");
        seaterprice = sc.nextInt();
    }
    public void editSeaterPrice(){
        System.out.println("Current Seater Price per seat is :"+seaterprice+"\nEnter Edited Price per seat :");
        seaterprice = sc.nextInt();
    }
    public int getSeaterPrice(){
        return seaterprice;
    }    
}
class SleeperPrice extends TicketBooking{
    SleeperPrice(int id, int price){
        this.bus_ID = id;
        this.sleeperprice = price;
    }
    public void addSleeperPrice(){
        //System.out.println("Enter bus ID to add seater Price :");
        //bus_ID = sc.nextInt();
        System.out.println("Enter Price per seat :");
        sleeperprice = sc.nextInt();
    }
    public void editSleeperPrice(){
        System.out.println("Current Sleeper Price per seat is :"+sleeperprice+"\nEnter Edited Price per seat :");
        sleeperprice = sc.nextInt();
    }
    public int getSleeperPrice(){
        return sleeperprice;
    }    
}

public class SkTravels {    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int choice, cus_cnt=5, bus_cnt=3, tb_cnt=0;
        int ch, temp, m, n;
        Customer[] c = new Customer[100];
        Bus[] b = new Bus[20];
        TicketBooking[] t = new TicketBooking[100];
        SleeperPrice[] sp1 = new SleeperPrice[20];
        SeaterPrice[] sp2 = new SeaterPrice[20];
        c[0] = new Customer (1, "Shriram", "rshriramrsr2003@gmail.com", "9677751871", 0);
        c[1] = new Customer (2,"Kishore","kishore12@gmail.com", "866756828",0);
        c[2] = new Customer (3,"Avinash","avinashravi@gmail.com", "8705632876",0);
        c[3] = new Customer (4,"Santhosh","santhoshkumar@gmail.com","9873467890",0);
        c[4] = new Customer (5,"kaavi","kaavisudhan@gmail.com","7598657955",0);
        b[0] = new Bus (1, "COIMBATORE", "RAJAPALAYAM", "Kishore", "Tirupur", "Madurai", "-", "02-11-2021", "8.30PM", "03-11-2021", "4.45AM", 11, 25);
        b[1] = new Bus (2, "COIMBATORE", "RAJAPALAYAM", "Shriram", "-", "Madurai", "Srivilliputhur", "02-11-2021", "9.15PM", "03-11-2021", "5.00AM", 10, 22);
        b[2] = new Bus (3, "OOTY", "SENKOTTAI", "Kvinash", "Coimbatore", "Madurai", "Rajapalayam", "02-11-2021", "8.00PM", "03-11-2021", "6.00AM", 12, 27);     
        sp1[0] = new SleeperPrice(1, 650);
        sp1[1] = new SleeperPrice(2, 820);
        sp1[2] = new SleeperPrice(3, 730);
        sp2[0] = new SeaterPrice(1, 350);
        sp2[1] = new SeaterPrice(2, 400);
        sp2[2] = new SeaterPrice(3, 313);
        while(true){
           System.out.println("\tWELCOME TO SK TRAVELS");
           System.out.println("1. Customer Management\n2. Bus Management\n3. TicketBooking Transactions\n4. Edit Seat Prices\n5.EXIT\n");
           System.out.println("Enter the choice");
           choice = input.nextInt();
           
           switch(choice){
               case 1:
                   System.out.println("\t1. Add new Customer\n\t2. View existing Customer\n\t3. View all Customer\n\t4. Return to Main Menu");
                   ch = input.nextInt();
                   switch(ch){
                       case 1:
                           c[cus_cnt] = new Customer(cus_cnt + 1, "", "", "", 0);
                           c[cus_cnt].addCustomer();
                           cus_cnt++;
                           break;
                       case 2:
                           System.out.println("Enter Customer id :");
                           temp = input.nextInt();
                           c[1].display();
                           for (m = 0; m < cus_cnt; m++){
                               if (c[m].per_id == temp){
                                   c[m].viewCustomers();
                               }
                           }
                           break;
                       case 3:
                           c[1].display();
                           for (n = 0; n < cus_cnt; n++){
                               c[n].viewCustomers();                                   
                                   }
                           break;
                       case 4:
                           System.out.println("Returning to Menu");
                       default:
                           System.out.println("Invalid Input");
                           break;
                   }
                   break;
               case 2:
                   System.out.println("\t1. Add new Bus\n\t2. View existing Bus\n\t3. View all Bus\n\t4. Return to Main Menu");
                   ch = input.nextInt();
                   switch(ch){
                       case 1:
                           b[bus_cnt] = new Bus(bus_cnt + 1, "", "", "", "", "", "", "", "", "", "", 0, 0);
                           b[bus_cnt].addNewBus();
                           sp1[bus_cnt] = new SleeperPrice(0, 0);
                           sp1[bus_cnt].addSleeperPrice();
                           sp2[bus_cnt] = new SeaterPrice(0, 0);
                           sp2[bus_cnt].addSeaterPrice();
                           bus_cnt++;
                           break;
                       case 2:
                           System.out.println("Enter Bus id :");
                           temp = input.nextInt();
                           
                           for (m = 0; m < bus_cnt; m++){
                               if (b[m].bus_id == temp){
                                   b[m].viewAvailableBuses();
                               }
                           }
                           break;
                       case 3:
                           for (n = 0; n < bus_cnt; n++){
                               b[n].viewAvailableBuses();
                                   }
                           break;
                       case 4:
                           System.out.println("Returning to Menu");
                       default:
                           System.out.println("Invalid Input");
                           break;
                   }
                   break;
               case 3:
                   System.out.println("\t1. New Ticket Booking\n\t2. Cancel Booking\n\t3. View Booking\n\t4. Return to the main menu.");
                   ch = input.nextInt();
                   switch(ch){
                       case 1:
                           int temp4, temp_uid=-1;
                           System.out.println("Do you have a user account?\n\t1. YES\n\t2. NO");
                           temp4 = input.nextInt();
                           if (temp4 == 1){
                               System.out.print(("\nEnter user id :"));
                               temp_uid = input.nextInt();
                               }                           
                           for (n = 0; n < bus_cnt; n++){
                               b[n].viewAvailableBuses();
                                   }
                           System.out.println("Enter Bus ID to proceed to Booking :");
                           int temp_bid = input.nextInt();                
                           int SleeperSeatNum =0, SeaterSeatNum=0, SleeperSeatPrice =0, SeaterSeatPrice=0;
                           int bookedseat = 0, bookedsleep = 0;
                           for (int u = 0; u < bus_cnt; u++){
                               if (sp1[u].bus_ID == temp_bid){
                                   SleeperSeatPrice = sp1[u].getSleeperPrice();
                                   SeaterSeatPrice = sp2[u].getSeaterPrice();
                                           }                          
                           }
                           for (m = 0; m < bus_cnt; m++){
                               if (b[m].bus_id == temp_bid){
                                   SleeperSeatNum = b[m].getSleeperSeatNum();
                                   SeaterSeatNum = b[m].getSeaterSeatNum();
                                   t[tb_cnt] = new TicketBooking();
                                   int[] arr = new int[4];
                                   arr = t[tb_cnt].TicketBooking(temp_bid, temp_uid, SleeperSeatNum, SeaterSeatNum);
                                   b[m].seatcount[0] = arr[0];
                                   b[m].seatcount[1] = arr[1];     
                                   bookedseat = arr[2];
                                   bookedsleep = arr[3];
                                   tb_cnt++;
                               }
                           } 
                             
                           if (temp4 == 1){                               
                               for (int q = 0; q < cus_cnt; q++){
                                   if (temp_uid == c[q].per_id){
                                       c[q].increaseCount();
                                   }
                           }
                           int res;
                           res = (SleeperSeatPrice * bookedsleep) + (SeaterSeatPrice * bookedseat);
                           t[tb_cnt - 1].amount = res;
                           //Integer.sum(SleeperSeatPrice * bookedseat, n)
                           System.out.println("Total Price of Tickets :" + res);
                           
                           }
                           break;
                       case 2:
                           System.out.println("To be filled");
                           break;
                       case 3:
                           System.out.println("CUSTOMER ID\t\tBUS ID\t\tSEATER SEATS\t\tSLEEPER SEATS\t\tTOTAL");
                           for (n = 0; n < tb_cnt; n++){
                               t[n].viewBooking();
                                   }
                           break;
                       case 4:
                           System.out.println("Returning to Menu");
                           break;
                       default:
                           System.out.println("Invalid Input");
                           break;
                   }
                   break;
               case 4:
                   System.out.println("Enter Bus ID to edit seat :");
                   int temp6 = input.nextInt();
                   for (int y = 0; y < bus_cnt; y++){
                       if (sp2[y].bus_ID == temp6){
                           sp2[y].editSeaterPrice();
                           sp1[y].editSleeperPrice();
                       }                       
                   }
                   
                   break;
               default :
                   System.exit(0);     
           }
        }        
    }    
}
