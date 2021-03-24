/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytickets;

import java.util.*;
import static mytickets.MyTickets.arrayticket;

/**
 *
 * @author eleft
 */
public class UpdateOfTicket extends MyCharacteristics {
    //I ask the user for the code of the ticket, then I print the old ticket,then I delete it and after that I create a new one with same code 

    private int readcode;

    //constructor
    public UpdateOfTicket(String type, int Routes, int Days, String kind, String name, String email, int TicketCode, String ExpirationDate, int readcode) {
        super(type, Routes, Days, kind, name, email, TicketCode, ExpirationDate);
        this.readcode = readcode;
    }

    //default constructor
    public UpdateOfTicket() {
    }

    Scanner reader = new Scanner(System.in);

    void update() {
        for (;;) {
            System.out.println("You want to update the content of your ticket, so type the code of the ticket. ");

            if (!(reader.hasNextInt())) {

                System.out.println("ERROR!!Enter an integer value ");
                reader.next();
            } else {

                readcode = reader.nextInt();  //reads what the user has typed
                //print the old one and then delete it 
                if (arrayticket.contains(readcode)) {
                    //Characteristics s = arrayticket.get(i);
                    arrayticket.forEach(st -> System.out.println("Name : " + st.getName() + " email : " + st.getEmail() + " Ticketcode : " + st.getTicketCode()));
                    arrayticket.forEach(st -> System.out.println("Type : " + st.getType() + " RoutesOrDays : " + st.getEmail() + " Kind : " + st.getTicketCode() + "ExpirationDate (mentioned only when needed)" + st.getExpirationDate()));

                    arrayticket.remove(readcode);// if the code is found, then delete the tciket 
                    System.out.println("The old ticket was deleted.");
                } else {
                    System.out.println("Ticket was not found!");

                }

            }
        }
    }
}
