/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytickets;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author eleft
 */
public class WholeTicket extends BuyTicket {

//variables
    private int current_hours;
    private int current_minutes;

    private int current_day;
    private int current_month;
    private int current_year;

    private int expiration_hours;
    private int expiration_minutes;

    private int expiration_day;
    private int expiration_month;
    private int expiration_year;

    String expire;
    private int ticket_time;
    // duration;         //minutes
    //days
    double whole_price;

    double price;

    private Date date2;
    private Date date1;
    private Date date7;

    public WholeTicket(int current_hours, int current_minutes, int current_day, int current_month, int current_year, int expiration_hours, int expiration_minutes, int expiration_day, int expiration_month, int expiration_year, String expire, int ticket_time, double whole_price, double price, Date date2, Date date1, Date date7, String kind, String type, int duration, int hostOfRoutes, int input1, int input2, int input3, int input4) {
        super(kind, type, duration, hostOfRoutes, input1, input2, input3, input4);

        this.current_hours = current_hours;
        this.current_minutes = current_minutes;
        this.current_day = current_day;
        this.current_month = current_month;
        this.current_year = current_year;
        this.expiration_hours = expiration_hours;
        this.expiration_minutes = expiration_minutes;
        this.expiration_day = expiration_day;
        this.expiration_month = expiration_month;
        this.expiration_year = expiration_year;
        this.expire = expire;
        this.ticket_time = ticket_time;
        this.whole_price = whole_price;
        this.price = price;
        this.date2 = date2;
        this.date1 = date1;
        this.date7 = date7;

    }

    /**
     *
     */
    //deafult constructor1
    public WholeTicket() {

    }

    Scanner read = new Scanner(System.in); //it creates the Scanner, so that it can take entrance from the user

    void buyAWholeTicket() {
        for (;;) {
            System.out.println("Type 1 for host/number of routes(1,5,11) and 2 for time duration(90 minutes, 1 day, 1 week, 1 month)");

            if (!(input.hasNextInt() && input.hasNextByte())) {
                System.out.println("ERROR!!Enter an integer value ");
                read.next();
            } else {
                input2 = read.nextInt(); //reads what the user has typed
                if (input2 == 1) {
                    for (;;) {
                        System.out.println("How many routes(1,5,11) do you want ? ");

                        if (!(input.hasNextInt() && input.hasNextByte())) {
                            System.out.println("ERROR!!Enter an integer value ");
                            read.next();
                        } else {
                            input3 = read.nextInt();   //reads what the user has typed

                            switch (input3) {
                                case 1:
                                    route_whole_ticket_price_kind(1); //1 route,  the method saves  prints the price of the ticket, asks for electronic or ptinted and saves the characteristics of the ticket into arraylist

                                case 5:
                                    route_whole_ticket_price_kind(5); //5 routes

                                case 11:
                                    route_whole_ticket_price_kind(11); // 11 routes

                                default:
                                    System.out.println("Error!Type corectly!");
                                    break;
                            }
                        }
                    }

                } else if (input2 == 2) {
                    for (;;) {
                        System.out.println("Which duration (90 minutes, 1 day, 1 week, 1 month) do you want ?\n (1)90minutes (2) 1 day (3) 1 week(7 days) (4) 1 month(30 days) ");

                        if (!(input.hasNextInt() && input.hasNextByte())) {

                            System.out.println("ERROR!!Enter an integer value ");
                            read.next();
                        } else {
                            input3 = read.nextInt(); //reads what the user has typed

                            switch (input3) {
                                case 1:
                                    days_ticket_price_kind(expire, 1);          // the method prints the price of the ticket, asks for electronic or ptinted and saves the characteristics of the ticket into arraylist
                                    expire = ticket_90_min(90);                //90 minutes, THIS METHOD FINDS WHEN A 90 MINUTE TICKET WILL EXPIRE

                                case 2:
                                    days_ticket_price_kind(expire, 1);           // the method prints the price of the ticket, asks for electronic or ptinted and  prints the price of the ticket, asks for electronic or ptinted and saves the characteristics of the ticket into arraylist
                                    expire = ticket_expiration_date_time(1);     // 1 day

                                case 3:
                                    days_ticket_price_kind(expire, 7);           //the method prints the price of the ticket, asks for electronic or ptinted and saves the characteristics of a ticket into arraylist
                                    expire = ticket_expiration_date_time(7);     // 1week = 7 days

                                case 4:
                                    days_ticket_price_kind(expire, 30);          //the method prints the price of the ticket, asks for electronic or ptinted and saves the characteristics of a ticket into arraylist
                                    expire = ticket_expiration_date_time(30);   //1 month = 30 days
                                default:
                                    System.out.println("Error!Type corectly!");
                                    break;

                            }
                        }
                    }
                } else {
                    System.out.println("Error!Type corectly!");

                }

            }
        }
    }

    String ticket_90_min(int duration) {          //THIS METHOD FINDS WHEN A 90 MINUTE TICKET WILL EXPIRE
        //ticket_time=0; //0 days 

        Calendar cal1 = Calendar.getInstance(); //create an instance type of calender
        try {
            cal1.setTime(date1);
            current_hours = cal1.get(Calendar.HOUR_OF_DAY);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            current_minutes = cal2.get(Calendar.MINUTE);
            expiration_minutes = current_minutes + 90;
            if (expiration_minutes > 59) {

                expiration_minutes = expiration_minutes % 60;
            } else {
                current_minutes = expiration_minutes;
            }
            expiration_hours = current_hours + 1;
            if (expiration_hours > 23) {
                expiration_hours %= 24;
            }
            System.out.println("Now time :" + current_hours + ":" + current_minutes);
            System.out.println("expiration time :" + expiration_hours + ":" + expiration_minutes);//shows what time the ticket expires
            expire = String.format("expiration time %d:%d ", expiration_hours, expiration_minutes);
            return expire;
        } catch (Exception e) {

            System.out.println(e);
        }
        return expire;
    }

    String ticket_expiration_date_time(int ticket_time
    ) {        //THIS METHOD FINDS WHEN A TICKET (1 DAY, 1 WEEK, 1 MONTH)WILL EXPIRE

        //FIND THE HOUR
        Calendar cal1 = Calendar.getInstance();                     //create an instance type of calender
        try {
            cal1.setTime(date1);
            current_hours = cal1.get(Calendar.HOUR_OF_DAY);

            //FIND THE MINUTES
            Calendar cal2 = Calendar.getInstance();                   //create an instance type of calender
            cal2.setTime(date2);
            current_minutes = cal2.get(Calendar.MINUTE);

            expiration_hours = current_hours;
            expiration_minutes = current_minutes;

            LocalDate localDate7 = date7.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            current_year = localDate7.getYear();                    //FIND THE YEAR WE HAVE
            current_month = localDate7.getMonthValue();              //FIND THE MOMNTH WE HAVE
            current_day = localDate7.getDayOfMonth();              //FIND THE DAY WE HAVE

            System.out.println("Now time :" + current_hours + ":" + current_minutes + "Date of today:" + current_day + ":" + current_month + ":" + current_year);

            expiration_day = current_day + ticket_time;
            expiration_month = current_month;
            expiration_year = current_year;

            System.out.println("Expiration time :" + current_hours + ":" + current_minutes + "Expiration date:" + expiration_day + ":" + expiration_month + ":" + expiration_year);
            expire = String.format("expiration time %d:%d ", expiration_hours, expiration_minutes);

            expire = String.format("Expiration time : %d:%d Expiration date:%d(day)-%d(month)-%d(year)", current_hours, current_minutes, expiration_day, expiration_month, expiration_year);

        } catch (Exception e) {

            System.out.println(e);
        }
        return expire;
    }

    private void days_ticket_price_kind(String expire, int days) {
        // the method  prints the price of the ticket, asks for electronic or printed and saves the characteristics of the ticket into arraylist
        type = " whole";
        whole_price = 1.40;
        price = days * whole_price;
        System.out.println("You want to buy a ticket for " + days + " days.It costs " + price + ".");
        System.out.println("You paid successfully for your ticket.");
        for (;;) {      //every time the user do not give a right input, an error meassage and  the menu will be prnted again and again 
            System.out.println("What type of ticket do you want? 1.Electonic or 2.printed ? ");

            if (!(input.hasNextInt() && input.hasNextByte())) {
                System.out.println("ERROR!!Enter an integer value ");
                input.next();
            } else {
                input4 = input.nextInt(); //reads what the user has typed
                switch (input4) {
                    case 1:     //THE USER CHOSE AN ELECTRONIC TICKET

                        kind = "electronic";
                        SaveData save_dataA = new SaveData();
                        save_dataA.Person2(type, 0, hostOfRoutes, kind, expire);

                    case 2:     //THE USER CHOSE A PRINTED TICKET

                        kind = "printed";
                        SaveData save_dataB = new SaveData();
                        save_dataB.Person3(type, 0, hostOfRoutes, kind, expire);

                    default:
                        break;
                }
            }
        }
    }

    private void route_whole_ticket_price_kind(int hostOfRoutes) {
        // the method saves  prints the price of the ticket, asks for electronic or ptinted and saves the characteristics of the ticket into arraylist
        type = " whole";
        whole_price = 1.40;
        price = hostOfRoutes * whole_price;
        System.out.println("You want to buy a ticket with " + hostOfRoutes + " routes.It costs " + price + ".");
        System.out.println("You paid successfully for your ticket.");

        for (;;) {  //every time the user do not give a right input, an error meassage and  the menu will be prnted again and again 
            System.out.println("What type of ticket do you want? 1.Electonic or 2.printed ? ");

            if (!(input.hasNextInt() && input.hasNextByte())) { // if the input is not 1 or 2
                System.out.println("ERROR!!Enter an integer value ");
                input.next();
            } else {
                input4 = input.nextInt(); //reads what the user has typed

                switch (input4) {
                    case 1:             //THE USER CHOSE ELECTRONIC TICKET

                        kind = "electronic";
                        SaveData save_dataC = new SaveData();
                        save_dataC.Person2(type, hostOfRoutes, 0, kind, " ");     //o for the days, it is a route ticket  

                    case 2:           //THE USER CHOSE PRINTED TICKET

                        kind = "printed";
                        SaveData save_dataD = new SaveData();
                        save_dataD.Person1(type, hostOfRoutes, 0, kind, " ");

                    default:
                        break;
                }
            }
        }
    }
}
