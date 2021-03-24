/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytickets;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author eleft
 */
public class MyTickets {

    static ArrayList<MyCharacteristics> arrayticket = new ArrayList<MyCharacteristics>() {

        {

            add(new MyCharacteristics(" ", 0, 0, " ", " ", " ", 0, " "));
        }
    };

    //default construcor
    public MyTickets() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //it creates the Scanner, so that it can take entrance from the user
        Scanner input = new Scanner(System.in);

        for (;;) {       //every time the user do not give a right input, an error meassage and  the menu will be prnted again and again 
            System.out.println("MENU:What do you want to do ? \n1.Buy a new ticket!\n2.Renewal of a ticket\n3.Update the content");
            System.out.println("Type the number of what you want to do ");

            if (!(input.hasNextInt() && input.hasNextByte())) {
                System.out.println("ERROR!!Enter an integer value ");
                input.next();
            } else {

                int Read = input.nextInt(); //reads what the user has typed/given
                switch (Read) {
                    case 1:            //BUY A TICKET
                        BuyTicket ticket1 = new BuyTicket();
                        ticket1.buyaTicket();

                    case 2:           //RENEW A TICKET
                        RenewalTicket ticket2 = new RenewalTicket();
                        ticket2.Renewal();

                    case 3:          //UPDATE A TICKET
                        UpdateOfTicket ticket3 = new UpdateOfTicket();
                        ticket3.update();

                    default:
                        System.out.println("Type correctly a number!");
                        break;
                }
            }
        }
    }
}
