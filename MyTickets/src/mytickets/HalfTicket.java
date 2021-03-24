/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytickets;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author eleft
 */
public class HalfTicket extends WholeTicket {

    Scanner inputs = new Scanner(System.in);

    public HalfTicket(int current_hours, int current_minutes, int current_day, int current_month, int current_year, int expiration_hours, int expiration_minutes, int expiration_day, int expiration_month, int expiration_year, String expire, int ticket_time, double whole_price, double price, Date date2, Date date1, Date date7, String kind, String type, int duration, int hostOfRoutes, int input1, int input2, int input3, int input4) {

        super(current_hours, current_minutes, current_day, current_month, current_year, expiration_hours, expiration_minutes, expiration_day, expiration_month, expiration_year, expire, ticket_time, whole_price, price, date2, date1, date7, kind, type, duration, hostOfRoutes, input1, input2, input3, input4);
        type = "half";

        expire = " ";
    }

    public HalfTicket() {
    }

    void buyAHalfTicket() {
        for (;;) {          //every time the user do not give a right input, an error meassage and  the menu will be prnted again and again 

            System.out.println("You chose a half ticket!Type 1 for host of routes(1,5,11) and 2 for time duration(90 minutes, 1 day(24 hours) , 1 week, 1 month(30 days))");

            if (!(inputs.hasNextInt() && inputs.hasNextByte())) {  // if the input is not an integer and more than one byte
                System.out.println("ERROR!!Enter an integer value ");
                input.next();
            } else {
                input2 = inputs.nextInt(); //reads what the user has typed

                if (input2 == 1) {
                    for (;;) {
                        System.out.println("How many routes(1,5,11) do you want ? ");

                        if (!(input.hasNextInt() && input.hasNextByte())) {
                            System.out.println("ERROR!!Enter an integer value ");
                            input.next();
                        } else {
                            input3 = inputs.nextInt(); //reads what the user has typed

                            switch (input3) {  // no expiration day time needed
                                case 1:

                                    kind = route_half_ticket_price_kind(1);
                                    SaveData save_data1 = new SaveData();
                                    save_data1.Person3(type, 1, 0, kind, " ");             //1 = number of routes, 0=number of days

                                case 5:
                                    kind = route_half_ticket_price_kind(5);

                                    SaveData save_data5 = new SaveData();
                                    save_data5.Person3(type, 5, 0, kind, " ");          //5= number of routes 
                                case 11:
                                    kind = route_half_ticket_price_kind(11);
                                    SaveData save_data11 = new SaveData();
                                    save_data11.Person3(type, 11, 0, kind, " ");        //11 = number of routes

                                default:
                                    System.out.println("Error!Type corectly!");
                                    break;
                            }
                        }
                    }

                } else if (input2 == 2) {

                    for (;;) {
                        System.out.println("Which duration (90 minutes, 1 day, 1 week, 1 month) do you want ?\n (1)90minutes (2) 1 day (3) 1 week(5 days) (4) 1 month(30 days) ");
                        //++ if the user wants a monthly ticket, has to type name, code of the ticket , expiration date 

                        if (!(input.hasNextInt() && input.hasNextByte())) {
                            System.out.println("ERROR!!Enter an integer value ");
                            input.next();
                        } else {
                            input3 = inputs.nextInt(); //reads what the user has typed

                            switch (input3) {
                                case 1:
                                    WholeTicket ticket90 = new WholeTicket();
                                    expire = ticket90.ticket_90_min(0);                      //90 minutes, 0 days

                                    //SaveData save = new SaveData();
                                    //arrayTicket.add(save.Person4(type, 90, kind));
                                    SaveData ticket_90_minutes_data = new SaveData();
                                    ticket_90_minutes_data.Person3(type, 0, 90, kind, expire);      //0 is for routes,90 for  miutes      
                                case 2:
                                    WholeTicket ticket_1_day = new WholeTicket();
                                    expire = ticket_1_day.ticket_expiration_date_time(1);     // 1 day

                                    SaveData ticket_1_day_data = new SaveData();
                                    ticket_1_day_data.Person3(type, 0, 1, kind, expire);            //0 is for routes, 1 for days

                                case 3:
                                    WholeTicket ticket_7_days = new WholeTicket();
                                    expire = ticket_7_days.ticket_expiration_date_time(7);     // 1 week = 7 days

                                    SaveData ticket_7_days_data = new SaveData();
                                    ticket_7_days_data.Person3(type, 0, 7, kind, expire);       //0 is for routes, 7 for days

                                case 4:
                                    WholeTicket ticket_30_days = new WholeTicket();
                                    expire = ticket_30_days.ticket_expiration_date_time(30);     // 1 month =30 days

                                    SaveData ticket_30_days_data = new SaveData();
                                    ticket_30_days_data.Person3(type, 0, 30, kind, expire);        //0 is for routes, 30 for  days

                                default:
                                    System.out.println("Error!Type corectly!");
                                    break;

                            }
                        }
                    }

                }
            }
        }
    }

    private String route_half_ticket_price_kind(int hostOfRoutes) {
        // hostOfRoutes = input3
        whole_price = 0.60;
        price = hostOfRoutes * whole_price;

        System.out.println("You want to buy a ticket with" + hostOfRoutes + "routes.It costs " + price + ".");
        for (;;) {
            System.out.println("You paid successfully for your ticket.What type of ticket do you want? 1.Electonic or 2.printed ? ");

            if (!"1".equals(input3) || !"2".equals(input3)) {
                System.out.println("ERROR!!Enter an integer value ");
                input.next();
            } else {
                input4 = input.nextInt();         //reads what the user has typed

                switch (input4) {
                    case 1:

                        kind = "electronic";

                    case 2:

                        kind = "printed";

                    default:
                        break;
                }
            }
            return kind;
        }
    }

}
