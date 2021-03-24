/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytickets;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import static mytickets.MyTickets.arrayticket;


/**
 *
 * @author eleft
 */
public class SaveData extends MyCharacteristics {

    //SAVE DATA OF TICKET OR PERSON
    private String name;
    private String email;
    private int code;

    static AtomicInteger codeSequence = new AtomicInteger();  //Creates a new AtomicInteger with initial value 0

    //contructor
    public SaveData(String name, String email, int code) {

        name = " ";
        email = " ";
        this.code = codeSequence.incrementAndGet();  //Atomically increments by one the current value.

    }

    //contructor of super class Characteristics 
    public SaveData(String type, int Routes, int Days, String kind, String name, String email, int TicketCode, String ExpirationDate) {
        super(type, Routes, Days, kind, name, email, TicketCode, ExpirationDate);
    }

    //default constructor
    public SaveData() {

    }

    Scanner input = new Scanner(System.in);

    public void Person1(String type, int Routes, int Days, String kind, String expiration) {     //SAVE FIELDS type, Routes, Days, kind, name, email, code, expiration
        code = codeSequence.incrementAndGet();

        //return new Characteristics(type, RoutesOrDays, kind, name, email, code, " ");
        arrayticket.add(new MyCharacteristics(type, Routes, Days, kind, " ", " ", code, expiration));         //email and name do not need to be saved here   
        //return Characteristics;
    }

    public void Person2(String type, int Routes, int Days, String kind, String expiration) {   //SAVE FIELDS type, Routes, Days, kind, email, code, expiration
        System.out.println("Please type your email. ");
        String email = input.nextLine();

        code = codeSequence.incrementAndGet();
        arrayticket.add(new MyCharacteristics(type, Routes, Days, kind, name, email, code, expiration));
        //return new Characteristics(type, RoutesOrDays, kind, name, email,code , " ");       anti gia void Characteristics
    }

    public void Person3(String type, int Routes, int Days, String kind, String expiration) {    //+SAVE type, Routes, Days, kind, name, email, code, expiration
        System.out.println("Type your full name.");
        String name = input.nextLine();
        System.out.println("Please type your email. ");
        String email = input.nextLine();
        code = codeSequence.incrementAndGet();

        arrayticket.add(new MyCharacteristics(type, Routes, Days, kind, name, email, code, expiration));

    }

}
