package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Proposal {


    public Proposal() {

    }
}



    /** OLD CODE BELOW **/


    /*protected double sqft;
    protected double securedLinearFeet;
    protected double unsecuredLinearFeet;
    protected double additionalCuttingFeet;
    protected double wallBlockFeet;
    // need a date data type for initial contact
    // need a date data type for meeting date

    public Proposal(String projectType, double sqft, double securedLinearFeet, double unsecuredLinearFeet, double additionalCuttingFeet, double wallBlockFeet) {
        this.projectType = projectType;
        this.sqft = sqft;
        this.securedLinearFeet = securedLinearFeet;
        this.unsecuredLinearFeet = unsecuredLinearFeet;
        this.additionalCuttingFeet = additionalCuttingFeet;
        this.wallBlockFeet = wallBlockFeet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public double getSqft() {
        return sqft;
    }

    public void setSqft(double sqft) {
        this.sqft = sqft;
    }

    public double getSecuredLinearFeet() {
        return securedLinearFeet;
    }

    public void setSecuredLinearFeet(double securedLinearFeet) {
        this.securedLinearFeet = securedLinearFeet;
    }

    public double getUnsecuredLinearFeet() {
        return unsecuredLinearFeet;
    }

    public void setUnsecuredLinearFeet(double unsecuredLinearFeet) {
        this.unsecuredLinearFeet = unsecuredLinearFeet;
    }

    public double getAdditionalCuttingFeet() {
        return additionalCuttingFeet;
    }

    public void setAdditionalCuttingFeet(double additionalCuttingFeet) {
        this.additionalCuttingFeet = additionalCuttingFeet;
    }

    public double getWallBlockFeet() {
        return wallBlockFeet;
    }

    public void setWallBlockFeet(double wallBlockFeet) {
        this.wallBlockFeet = wallBlockFeet;
    }

    /* Create Proposal - Page 2 Variables */
    /*
    protected double moveDays;
    protected double demoDays;
    protected double excavationDays;
    protected double excavationTrips;
    protected double drainageDays;
    protected double basePrepDays;
    protected double roadBaseYards;
    protected double edgingDays;
    protected double beddingDays;
    protected double layingDays;
    protected double cuttingDays;
    protected double sandingDays;
    protected double wallExcavationDays;
    protected double wallExcavationTrips;
    protected double wallBasePrepDays;
    protected double wallBuildDays;

    public double getMoveDays() {
        return moveDays;
    }

    public void setMoveDays(double moveDays) {
        this.moveDays = moveDays;
    }

    public double getDemoDays() {
        return demoDays;
    }

    public void setDemoDays(double demoDays) {
        this.demoDays = demoDays;
    }

    public double getExcavationDays() {
        return excavationDays;
    }

    public void setExcavationDays(double excavationDays) {
        this.excavationDays = excavationDays;
    }

    public double getExcavationTrips() {
        return excavationTrips;
    }

    public void setExcavationTrips(double excavationTrips) {
        this.excavationTrips = excavationTrips;
    }

    public double getDrainageDays() {
        return drainageDays;
    }

    public void setDrainageDays(double drainageDays) {
        this.drainageDays = drainageDays;
    }

    public double getRoadBaseYards() {
        return roadBaseYards;
    }

    public void setRoadBaseYards(double roadBaseYards) {
        this.roadBaseYards = roadBaseYards;
    }

    public double getBasePrepDays() {
        return basePrepDays;
    }

    public void setBasePrepDays(double basePrepDays) {
        this.basePrepDays = basePrepDays;
    }

    public double getEdgingDays() {
        return edgingDays;
    }

    public void setEdgingDays(double edgingDays) {
        this.edgingDays = edgingDays;
    }

    public double getBeddingDays() {
        return beddingDays;
    }

    public void setBeddingDays(double beddingDays) {
        this.beddingDays = beddingDays;
    }

    public double getLayingDays() {
        return layingDays;
    }

    public void setLayingDays(double layingDays) {
        this.layingDays = layingDays;
    }

    public double getCuttingDays() {
        return cuttingDays;
    }

    public void setCuttingDays(double cuttingDays) {
        this.cuttingDays = cuttingDays;
    }

    public double getSandingDays() {
        return sandingDays;
    }

    public void setSandingDays(double sandingDays) {
        this.sandingDays = sandingDays;
    }

    public double getWallExcavationDays() {
        return wallExcavationDays;
    }

    public void setWallExcavationDays(double wallDays) {
        this.wallExcavationDays = wallDays;
    }

    public double getWallExcavationTrips() {
        return wallExcavationTrips;
    }

    public void setWallExcavationTrips(double wallExcavationTrips) {
        this.wallExcavationTrips = wallExcavationTrips;
    }

    public double getWallBasePrepDays() {
        return wallBasePrepDays;
    }

    public void setWallBasePrepDays(double wallBasePrepDays) {
        this.wallBasePrepDays = wallBasePrepDays;
    }

    public double getWallBuildDays() {
        return wallBuildDays;
    }

    public void setWallBuildDays(double wallBuildDays) {
        this.wallBuildDays = wallBuildDays;
    }

    /* Create Proposal - Page 3 Variables */
    /*
    protected double loaderDays;
    protected double excavatorDays;
    protected double bobcatDays;
    protected double compactorDays;
    protected double plateCompactorDays;
    protected double sawDays;
    protected double fuelDays;

    public double getLoaderDays() {
        return loaderDays;
    }

    public void setLoaderDays(double loaderDays) {
        this.loaderDays = loaderDays;
    }

    public double getExcavatorDays() {
        return excavatorDays;
    }

    public void setExcavatorDays(double excavatorDays) {
        this.excavatorDays = excavatorDays;
    }

    public double getBobcatDays() {
        return bobcatDays;
    }

    public void setBobcatDays(double bobcatDays) {
        this.bobcatDays = bobcatDays;
    }

    public double getCompactorDays() {
        return compactorDays;
    }

    public void setCompactorDays(double compactorDays) {
        this.compactorDays = compactorDays;
    }

    public double getPlateCompactorDays() {
        return plateCompactorDays;
    }

    public void setPlateCompactorDays(double plateCompactorDays) {
        this.plateCompactorDays = plateCompactorDays;
    }

    public double getSawDays() {
        return sawDays;
    }

    public void setSawDays(double sawDays) {
        this.sawDays = sawDays;
    }

    public double getFuelDays() {
        return fuelDays;
    }

    public void setFuelDays(double fuelDays) {
        this.fuelDays = fuelDays;
    }
}
**/