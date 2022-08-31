package ru.netology.javaqa;

public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String departure;
    protected String arrival;
    protected int travelTime;

    public Ticket(int id, int price, String departure, String arrival, int travelTime) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.travelTime = travelTime;
    }


    public String getFromAirport() {
        return departure;
    }

    public String getToAirport() {
        return arrival;
    }

    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }
}

