/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytickets;

import java.util.Scanner;

/**
 *
 * @author eleft
 */
public class BuyTicket {

    //varibales 
    Scanner input = new Scanner(System.in);
    int input1;
    int input2;
    int input3;
    int input4;

    public String kind;     //Electronic or printed
    public String type;     //whole or half
    public int duration;
    public int hostOfRoutes;

    //default constructor
    public BuyTicket() {
    }

    //constructor       
    public BuyTicket(String kind, String type, int duration, int hostOfRoutes, int input1, int input2, int input3, int input4) {

        this.kind = kind;
        this.type = type;
        this.duration = duration;
        this.hostOfRoutes = hostOfRoutes;

        this.input1 = input1;
        this.input2 = input2;
        this.input3 = input3;
        this.input4 = input4;

    }

    //METHOD
    int buyaTicket() {
        for (;;) {     // //every time the user do not give a right input, an error meassage and  the menu will be prnted again and again 

            System.out.println("Choose the type of the ticket:Type 1 for whole and 2 for half");

            if (!(input.hasNextInt())) {           //&& input.hasNextByte() if the input is not an integer and more than one byte
                System.out.println("ERROR!!Enter an integer value ");
                input.next();
            } else {
                input1 = input.nextInt();  //reads what the user has typed

                switch (input1) {

                    case 1:   //WHOLE TICKET
                        WholeTicket ticket2 = new WholeTicket();
                        ticket2.buyAWholeTicket();

                    case 2:  //HALF TICKET
                        HalfTicket ticket3 = new HalfTicket();
                        ticket3.buyAHalfTicket();

                    default:
                        System.out.println("Type correctly a number!");
                    //break;
                }
                return 0;
            }
        }
    }
}
