/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytickets;

/**
 *
 * @author eleft
 *
 */
public class MyCharacteristics {      //contains all the characteristics() that need to be saved into the arraylist for the creation of a ticket 

    // instance variables
    private String type;
    private int Routes;
    private int Days;

    private String kind;
    private String name;
    private String email;

    private int TicketCode;
    private String ExpirationDate;

    //constructor
    public MyCharacteristics(String type, int Routes, int Days, String kind, String name, String email, int TicketCode, String ExpirationDate) {
        this.type = type;
        this.Routes = Routes;
        this.Days = Days;
        this.kind = kind;
        name = " ";
        email = " ";
        TicketCode = 0;
        ExpirationDate = " ";

    }

    // default constructor
    public MyCharacteristics() {
    }

    //SETTERS
    public void setType(String type) {
        this.type = type;
    }

    public void setRoutes(int Routes) {
        this.Routes = Routes;
    }

    public void setDays(int Days) {
        this.Days = Days;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTicketCode(int TicketCode) {
        this.TicketCode = TicketCode;
    }

    public void setExpirationDate(String ExpirationDate) {
        this.ExpirationDate = ExpirationDate;
    }

    //GETTERS
    public String getType() {
        return type;
    }

    public int getRoutes() {
        return Routes;
    }

    public int getDays() {
        return Days;
    }

    public String getKind() {
        return kind;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getTicketCode() {
        return TicketCode;
    }

    public String getExpirationDate() {
        return ExpirationDate;
    }

}
