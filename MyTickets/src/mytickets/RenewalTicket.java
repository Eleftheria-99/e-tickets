/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytickets;

import java.util.Scanner;
import static mytickets.MyTickets.arrayticket;

/**
 *
 * @author eleft
 */
public class RenewalTicket extends MyCharacteristics {

    private int readcode;

    //constructor
    public RenewalTicket(String type, int Routes, int Days, String kind, String name, String email, int TicketCode, String ExpirationDate, int readcode) {
        super(type, Routes, Days, kind, name, email, TicketCode, ExpirationDate);
        this.readcode = readcode;
    }

    public RenewalTicket() {        //default constructor
    }

    Scanner reader = new Scanner(System.in);

    void Renewal() {
        for (;;) {
            System.out.println("You want to renew your ticket, so type the code of the ticket. ");
            //read the code, that the user gave, print the ticket that the user bought and with the stoixeia from the old ticket create a new one.Cnage only expiration date if needed 

            if (!(reader.hasNextInt())) {
                System.out.println("ERROR!!Enter an integer value ");
                reader.next();
            } else {
                readcode = reader.nextInt();  //reads what the user has typed

                if (arrayticket.contains(readcode)) {  //if the given code is found, it means that exists a ticket , which i will renew 
                    //T s = arrayticket.get(i);
                    arrayticket.forEach(st -> System.out.println("Name : " + st.getName() + " email : " + st.getEmail() + " code : " + st.getTicketCode()));
                    //System.out.println("Name : "+s.getName()+" email : "+s.getEmail()+" code : "+s.getCode());
                    arrayticket.forEach(st -> System.out.println("Type : " + st.getType() + " Routes : " + st.getRoutes() + "Days:" + st.getDays() + " Kind : " + st.getKind() + "ExpirationDate (mentioned only when needed)" + st.getExpirationDate()));

                    if (getDays() == 0) {  //so it is a route ticket 
                        arrayticket.add(new MyCharacteristics(getType(), getRoutes(), getDays(), getKind(), getName(), getEmail(), getTicketCode(), "0"));
                        System.out.println("Your renewed ticket is the following:");

                        if (arrayticket.contains(readcode)) {
                            arrayticket.forEach(st -> System.out.println("Name : " + st.getName() + " email : " + st.getEmail() + " code : " + st.getTicketCode()));
                            arrayticket.forEach(st -> System.out.println("Type : " + st.getType() + " Routes : " + st.getRoutes() + "Days:" + st.getDays() + " Kind : " + st.getKind() + "ExpirationDate (mentioned only when needed)" + st.getExpirationDate()));
                        }

                    } else if (getRoutes() == 0) {  //so it is a days ticket 
                        //++CHANGE EXPIRATION DATE 
                        if (getDays() == 90) {                                      //90 minutes
                            WholeTicket ticket_minutes_90 = new WholeTicket();
                            String expiration = ticket_minutes_90.ticket_90_min(90);
                            arrayticket.add(new MyCharacteristics(getType(), getRoutes(), getDays(), getKind(), getName(), getEmail(), getTicketCode(), expiration));

                            System.out.println("Your renewed ticket is the following:");
                            arrayticket.forEach(st -> System.out.println("Name : " + st.getName() + " email : " + st.getEmail() + " code : " + st.getTicketCode()));
                            arrayticket.forEach(st -> System.out.println("Type : " + st.getType() + " Routes : " + st.getRoutes() + "Days:" + st.getDays() + " Kind : " + st.getKind() + "ExpirationDate (mentioned only when needed)" + st.getExpirationDate()));

                        } else if (getDays() == 1) {                                // 1 day
                            WholeTicket ticket_for_7_days = new WholeTicket();
                            String expiration = ticket_for_7_days.ticket_expiration_date_time(1);
                            arrayticket.add(new MyCharacteristics(getType(), getRoutes(), getDays(), getKind(), getName(), getEmail(), getTicketCode(), expiration));

                            System.out.println("Your renewed ticket is the following:");
                            arrayticket.forEach(st -> System.out.println("Name : " + st.getName() + " email : " + st.getEmail() + " code : " + st.getTicketCode()));
                            arrayticket.forEach(st -> System.out.println("Type : " + st.getType() + " Routes : " + st.getRoutes() + "Days:" + st.getDays() + " Kind : " + st.getKind() + "ExpirationDate (mentioned only when needed)" + st.getExpirationDate()));

                        } else if (getDays() == 7) {                                //7 days
                            WholeTicket ticket_for_7_days = new WholeTicket();
                            String expiration = ticket_for_7_days.ticket_expiration_date_time(1);
                            arrayticket.add(new MyCharacteristics(getType(), getRoutes(), getDays(), getKind(), getName(), getEmail(), getTicketCode(), expiration));

                            System.out.println("Your renewed ticket is the following:");
                            arrayticket.forEach(st -> System.out.println("Name : " + st.getName() + " email : " + st.getEmail() + " code : " + st.getTicketCode()));
                            arrayticket.forEach(st -> System.out.println("Type : " + st.getType() + " Routes : " + st.getRoutes() + "Days:" + st.getDays() + " Kind : " + st.getKind() + "ExpirationDate (mentioned only when needed)" + st.getExpirationDate()));

                        } else if (getDays() == 30) {                               //30 days 
                            WholeTicket ticket_for_30_days = new WholeTicket();
                            String expiration = ticket_for_30_days.ticket_expiration_date_time(1);
                            arrayticket.add(new MyCharacteristics(getType(), getRoutes(), getDays(), getKind(), getName(), getEmail(), getTicketCode(), expiration));

                            System.out.println("Your renewed ticket is the following:");
                            arrayticket.forEach(st -> System.out.println("Name : " + st.getName() + " email : " + st.getEmail() + " code : " + st.getTicketCode()));
                            arrayticket.forEach(st -> System.out.println("Type : " + st.getType() + " Routes : " + st.getRoutes() + "Days:" + st.getDays() + " Kind : " + st.getKind() + "ExpirationDate (mentioned only when needed)" + st.getExpirationDate()));

                        }

                    }
                } else {
                    System.out.println("Ticket does not exist.Let's buy a new one!");
                    BuyTicket ticket1 = new BuyTicket();
                    ticket1.buyaTicket();
                }

            }
        }
    }
}
