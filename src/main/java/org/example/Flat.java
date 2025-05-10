package org.example;

public class Flat {
    @Id
    private int id;

    private String district;
    private String address;
    private int rooms;
    private int area;
    private int price;

    public Flat() {
    }

    public Flat( String district, String address, int rooms, int area, int price) {
        this.district = district;
        this.address = address;
        this.rooms = rooms;
        this.area = area;
        this.price = price;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", rooms=" + rooms +
                ", area=" + area +
                ", price=" + price +
                '}';
    }



}