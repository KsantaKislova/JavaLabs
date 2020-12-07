package by.gsu.asoilab;

import java.util.Scanner;

public class House implements Comparable<House>{

    private int id;
    private int apartmentNumber;
    private int area;
    private int floor;
    private int number_of_rooms;
    private String street;
    private String buildingType;
    private int lifetime;

    public House(int id, int apartmentNumber, int area, int floor, int number_of_rooms, String street, String buildingType, int lifetime) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.number_of_rooms = number_of_rooms;
        this.street = street;
        this.buildingType = buildingType;
        this.lifetime = lifetime;
    }

    public House(int i, int nextInt) {
        this.id = 0;
        this.apartmentNumber = 0;
        this.area = 0;
        this.floor = 0;
        this.number_of_rooms = 0;
        this.street = " ";
        this.buildingType = " ";
        this.lifetime = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        if (apartmentNumber > 0) {
            this.apartmentNumber = apartmentNumber;
        }
        else System.out.println("The number of apartment should equal integers.");
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        if (area > 0) {
            this.area = area;
        }
        else System.out.println("The area should equal more than 0.");
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        if (floor > 0) {
            this.floor = floor;
        }
        else System.out.println("The number of floors should equal integers.");
    }

    public int getNumber_of_rooms() {
        return number_of_rooms;
    }

    public void setNumber_of_rooms(int number_of_rooms) {
        if (number_of_rooms > 0) {
            this.number_of_rooms = number_of_rooms;
        }
        else System.out.println("The number of rooms should equal integers.");
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        if (lifetime > 0) {
            this.lifetime = lifetime;
        }
        else System.out.println("The lifetime of building should equal integers.");
    }

    public House(Scanner sr){
        this.id = sr.nextInt();
        this.floor = sr.nextInt();
        this.apartmentNumber = sr.nextInt();
        this.buildingType = sr.next();
        this.number_of_rooms = sr.nextInt();
        this.street = sr.next();
        this.lifetime = sr.nextInt();
    }

    @Override
    public int compareTo(House house) {
        return buildingType.compareTo(house.getBuildingType());
    }
}
