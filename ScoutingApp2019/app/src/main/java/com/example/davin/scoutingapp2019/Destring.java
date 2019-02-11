package com.example.davin.scoutingapp2019;

import java.util.ArrayList;
import java.util.Scanner;

public class Destring {

    private String str;
    private int teamNumber;
    private String position;
    private ArrayList<Boolean> sandstorm= new ArrayList<Boolean>();

    private ArrayList<Integer> teleop=new ArrayList<Integer>();

    private String rocketRole;
    private String climberRole;
    private String overallRole;
    private String otherComments;

    public Destring(String str) {
        this.str = str;
        Scanner sc=new Scanner(str);
        sc.useDelimiter(" \\s* | \\s* ");

        teamNumber=sc.nextInt();
        position=sc.next();
        Scanner oc=new Scanner(sc.next());
        sandstorm.set(0,oc.nextBoolean());
        sandstorm.set(1,oc.nextBoolean());
        sandstorm.set(2,oc.nextBoolean());
        Scanner ec=new Scanner(sc.next());
        teleop.set(0,ec.nextInt());
        teleop.set(1,ec.nextInt());
        teleop.set(2,ec.nextInt());
        rocketRole=sc.next();
        climberRole=sc.next();
        overallRole=sc.next();
        otherComments=sc.next();




    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public boolean getSandstorm(String s){
        boolean o=false;
        switch(s){

            case "hab line":o= sandstorm.get(0);
                break;
            case "cargo balls":o= sandstorm.get(1);
                break;
            case "cargo hatches":o= sandstorm.get(1);
                break;
            case "rocket balls":o=sandstorm.get(2);
                break;
            case "rocket hatches":o=sandstorm.get(3);
                break;
        }






        return o;
    }
    public int getTeleop(String s){
        int o=0;
        switch(s){

            case "cargo balls":o= teleop.get(0);
           break;
            case "cargo hatches":o= teleop.get(1);
            break;
            case "rocket balls":o=teleop.get(2);
            break;
            case "rocket hatches":o=teleop.get(3);
            break;
        }

        return o;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public String getRocketRole() {
        return rocketRole;
    }

    public void setRocketRole(String rocketRole) {
        this.rocketRole = rocketRole;
    }

    public String getClimberRole() {
        return climberRole;
    }

    public void setClimberRole(String climberRole) {
        this.climberRole = climberRole;
    }

    public String getOverallRole() {
        return overallRole;
    }

    public void setOverallRole(String overallRole) {
        this.overallRole = overallRole;
    }

    public String getOtherComments() {
        return otherComments;
    }

    public void setOtherComments(String otherComments) {
        this.otherComments = otherComments;
    }
}
