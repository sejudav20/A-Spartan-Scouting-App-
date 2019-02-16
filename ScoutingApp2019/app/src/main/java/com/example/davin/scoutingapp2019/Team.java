package com.example.davin.scoutingapp2019;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "TeamInfo")
public class Team {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "team")
    private int teamNumber;

    public Team(int teamNumber, String position, boolean habLine, boolean sandstormCargoBalls, boolean sandstormCargoHatches, boolean sandstormRocketBalls, boolean sandstormRocketHatches, int CargoBallTotal, int CargoHatchesTotal, int RocketBallsTotal, int RocketHatchesTotal, String rocketRole, String climberRole, String overallRole, String otherComments) {
        this.teamNumber = teamNumber;
        this.position = position;
        this.habLine = habLine;
        this.sandstormCargoBalls = sandstormCargoBalls;
        this.sandstormCargoHatches = sandstormCargoHatches;
        this.sandstormRocketBalls = sandstormRocketBalls;
        this.sandstormRocketHatches = sandstormRocketHatches;
        this.CargoBallTotal = CargoBallTotal;
        this.CargoHatchesTotal = CargoHatchesTotal;
       this.RocketBallsTotal = RocketBallsTotal;
        this.RocketHatchesTotal = RocketHatchesTotal;
        this.rocketRole = rocketRole;
        this.climberRole = climberRole;
        this.overallRole = overallRole;
        this.otherComments = otherComments;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setHabLine(boolean habLine) {
        this.habLine = habLine;
    }

    public void setSandstormCargoBalls(boolean sandstormCargoBalls) {
        this.sandstormCargoBalls = sandstormCargoBalls;
    }

    public void setSandstormCargoHatches(boolean sandstormCargoHatches) {
        this.sandstormCargoHatches = sandstormCargoHatches;
    }

    public void setSandstormRocketBalls(boolean sandstormRocketBalls) {
        this.sandstormRocketBalls = sandstormRocketBalls;
    }

    public void setSandstormRocketHatches(boolean sandstormRocketHatches) {
        this.sandstormRocketHatches = sandstormRocketHatches;
    }

    public void setCargoBallTotal(int cargoBallTotal) {
        CargoBallTotal = cargoBallTotal;
    }

    public void setCargoHatchesTotal(int cargoHatchesTotal) {
        CargoHatchesTotal = cargoHatchesTotal;
    }

    public void setRocketBallsTotal(int rocketBallsTotal) {
        RocketBallsTotal = rocketBallsTotal;
    }

    public void setRocketHatchesTotal(int rocketHatchesTotal) {
        RocketHatchesTotal = rocketHatchesTotal;
    }

    public void setRocketRole(String rocketRole) {
        this.rocketRole = rocketRole;
    }

    public void setClimberRole(String climberRole) {
        this.climberRole = climberRole;
    }

    public void setOverallRole(String overallRole) {
        this.overallRole = overallRole;
    }

    public void setOtherComments(String otherComments) {
        this.otherComments = otherComments;
    }

    @ColumnInfo(name="Position")
    private String position;
    @ColumnInfo(name="Crossed Hab Line")
    private boolean habLine;
    @ColumnInfo(name="Put Balls in Cargo Ship during Sandstorm")
    private boolean sandstormCargoBalls;
    @ColumnInfo(name="Put hatches in Cargo Ship during Sandstorm")
    private boolean sandstormCargoHatches;
    @ColumnInfo(name="Put Balls in Rocket Ship during Sandstorm")
    private boolean sandstormRocketBalls;
    @ColumnInfo(name="Put Hatches in Rocket Ship during Sandstorm")
    private boolean sandstormRocketHatches;


    @ColumnInfo(name="Total balls in Cargo Ship")

    private int CargoBallTotal;
    @ColumnInfo(name="Total hatches in Cargo Ship")
    private int CargoHatchesTotal;
    @ColumnInfo(name="Total balls in Rocket Ship")
    private int RocketBallsTotal;
    @ColumnInfo(name="Total hatches in Rocket Ship")
    private int RocketHatchesTotal;

    @ColumnInfo(name="Rocket Role")
    private String rocketRole;
    @ColumnInfo(name="Climbing Role")
    private String climberRole;
    @ColumnInfo(name="Overall Role")
    private String overallRole;
    @ColumnInfo(name="Additional Comments")
    private String otherComments;

    public int getId() {
        return id;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public String getPosition() {
        return position;
    }

    public boolean isHabLine() {
        return habLine;
    }

    public boolean isSandstormCargoBalls() {
        return sandstormCargoBalls;
    }

    public boolean isSandstormCargoHatches() {
        return sandstormCargoHatches;
    }

    public boolean isSandstormRocketBalls() {
        return sandstormRocketBalls;
    }

    public boolean isSandstormRocketHatches() {
        return sandstormRocketHatches;
    }

    public int getCargoBallTotal() {
        return CargoBallTotal;
    }

    public int getCargoHatchesTotal() {
        return CargoHatchesTotal;
    }

    public int getRocketBallsTotal() {
        return RocketBallsTotal;
    }

    public int getRocketHatchesTotal() {
        return RocketHatchesTotal;
    }

    public String getRocketRole() {
        return rocketRole;
    }

    public String getClimberRole() {
        return climberRole;
    }

    public String getOverallRole() {
        return overallRole;
    }

    public String getOtherComments() {
        return otherComments;
    }
}
