package com.example.cardviewexample;

public class Store {
    String name;
    String hours;
    String address;
    boolean open;
    String description;
    int phoneNumber;
    int imagePath;

    public Store(String name, String hours, String address, String description, int phoneNumber, int imagePath) {
        this.name = name;
        this.hours = hours;
        this.address = address;

        this.description = description;
        this.phoneNumber = phoneNumber;
        this.imagePath = imagePath;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isOpen() {
        return open;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
