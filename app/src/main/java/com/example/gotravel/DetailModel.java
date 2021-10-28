package com.example.gotravel;

public class DetailModel {
    public String title,address,description,price,type,specialty,ticketPrice,id;
    public DetailModel(){

    }
    public DetailModel(String id,String title, String address, String info1, String info2) {
        this.title = title;
        this.address = address;
        this.description = info1;
        this.price = info2;
        this.id=id;
        switch (id)
        {
            case "hotel":
                this.title=title;
                this.address=address;
                this.description=info1;
                this.price=info2;
                break;
            case "restaurant":
                this.title=title;
                this.address=address;
                this.specialty=info1;
                this.type=info2;
                break;
            case "entertainment":
                this.title=title;
                this.address=address;
                this.type=info1;
                this.ticketPrice=info2;
            case "temple":
                this.title=title;
                this.address=address;
                this.description=info1;
                break;
            case "local_food":
                this.title=title;
                this.price=info2;
                this.description=info1;
                break;
            case "sightseeing":
                this.title=title;
                this.address=address;
                this.description=info1;
                break;
            default:
                break;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }
    public String getType() {
        return type;
    }
    public String getSpecialty() {
        return specialty;
    }
    public String getPrice() {
        return price;
    }
    public String getTicketPrice() {
        return ticketPrice;
    }

}
