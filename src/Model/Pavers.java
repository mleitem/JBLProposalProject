package Model;

import java.util.Date;

public class Pavers extends Proposal{

    protected String projectType;
    protected String projectAddress;
    protected double sqft;
    protected double securedLinearFeet;
    protected double unsecuredLinearFeet;
    protected double addtlLinearFeet;
    protected boolean easyAccess;

    protected double moveDays;
    protected double demoDays;
    protected double roadBaseYards;
    protected double roadBaseDays;
    protected double excDays;
    protected double drainageDays;
    protected double edgingFeet;
    protected double edgingDays;
    protected double beddingYards;
    protected double beddingDays;
    protected double totalLinealFeet;
    protected double layingPaversDays;
    protected double cuttingDays;
    protected double numSandBags;
    protected double sandingDays;
    protected double dirtYards;
    protected int excTrips;

    protected double loaderDays;
    protected double excavatorDays;
    protected double bobcatDays;
    protected double smallCompactorDays;
    protected double bigCompactorDays;
    protected double cuttingSystemDays;
    protected double totalDays;
    protected double fuelWeeks;

    protected double totalLabor;
    protected double totalCost;

    protected String proposalDate;

    public Pavers() {
    }


    public Pavers(String projectType, double sqft, double securedLinearFeet, double unsecuredLinearFeet, double addtlLinearFeet, boolean easyAccess) {
        super();
        this.projectType = projectType;
        this.sqft = sqft;
        this.securedLinearFeet = securedLinearFeet;
        this.unsecuredLinearFeet = unsecuredLinearFeet;
        this.addtlLinearFeet = addtlLinearFeet;
        this.easyAccess = easyAccess;
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

    public double getAddtlLinearFeet() {
        return addtlLinearFeet;
    }

    public void setAddtlLinearFeet(double addtlLinearFeet) {
        this.addtlLinearFeet = addtlLinearFeet;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public boolean isEasyAccess() {
        return easyAccess;
    }

    public void setEasyAccess(boolean easyAccess) {
        this.easyAccess = easyAccess;
    }

    public double getMoveDays() {
        return moveDays;
    }

    public void setMoveDays(double moveDays) {
        this.moveDays = moveDays;
    }

    public double getRoadBaseYards() {
        return roadBaseYards;
    }

    public void setRoadBaseYards(double roadBaseYards) {
        this.roadBaseYards = roadBaseYards;
    }

    public double getRoadBaseDays() {
        return roadBaseDays;
    }

    public void setRoadBaseDays(double roadBaseDays) {
        this.roadBaseDays = roadBaseDays;
    }

    public double getEdgingFeet() {
        return edgingFeet;
    }

    public void setEdgingFeet(double edgingFeet) {
        this.edgingFeet = edgingFeet;
    }

    public double getEdgingDays() {
        return edgingDays;
    }

    public void setEdgingDays(double edgingDays) {
        this.edgingDays = edgingDays;
    }

    public double getBeddingYards() {
        return beddingYards;
    }

    public void setBeddingYards(double beddingYards) {
        this.beddingYards = beddingYards;
    }

    public double getBeddingDays() {
        return beddingDays;
    }

    public void setBeddingDays(double beddingDays) {
        this.beddingDays = beddingDays;
    }

    public double getTotalLinealFeet() {
        return totalLinealFeet;
    }

    public void setTotalLinealFeet(double totalLinealFeet) {
        this.totalLinealFeet = totalLinealFeet;
    }

    public double getLayingPaversDays() {
        return layingPaversDays;
    }

    public void setLayingPaversDays(double layingPaversDays) {
        this.layingPaversDays = layingPaversDays;
    }

    public double getCuttingDays() {
        return cuttingDays;
    }

    public void setCuttingDays(double cuttingDays) {
        this.cuttingDays = cuttingDays;
    }

    public double getNumSandBags() {
        return numSandBags;
    }

    public void setNumSandBags(double numSandBags) {
        this.numSandBags = numSandBags;
    }

    public double getSandingDays() {
        return sandingDays;
    }

    public void setSandingDays(double sandingDays) {
        this.sandingDays = sandingDays;
    }

    public double getDirtYards() {
        return dirtYards;
    }

    public void setDirtYards(double dirtYards) {
        this.dirtYards = dirtYards;
    }

    public int getExcTrips() {
        return excTrips;
    }

    public void setExcTrips(int excTrips) {
        this.excTrips = excTrips;
    }

    public double getExcDays() {
        return excDays;
    }

    public void setExcDays(double excdays) {
        this.excDays = excdays;
    }

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

    public double getSmallCompactorDays() {
        return smallCompactorDays;
    }

    public void setSmallCompactorDays(double smallCompactorDays) {
        this.smallCompactorDays = smallCompactorDays;
    }

    public double getBigCompactorDays() {
        return bigCompactorDays;
    }

    public void setBigCompactorDays(double bigCompactorDays) {
        this.bigCompactorDays = bigCompactorDays;
    }

    public double getCuttingSystemDays() {
        return cuttingSystemDays;
    }

    public void setCuttingSystemDays(double cuttingSystemDays) {
        this.cuttingSystemDays = cuttingSystemDays;
    }

    public double getFuelWeeks() {
        return fuelWeeks;
    }

    public void setFuelWeeks(double fuelWeeks) {
        this.fuelWeeks = fuelWeeks;
    }

    public double getDemoDays() {
        return demoDays;
    }

    public void setDemoDays(double demoDays) {
        this.demoDays = demoDays;
    }

    public double getDrainageDays() {
        return drainageDays;
    }

    public void setDrainageDays(double drainageDays) {
        this.drainageDays = drainageDays;
    }

    public double getTotalLabor() {
        return totalLabor;
    }

    public void setTotalLabor(double totalLabor) {
        this.totalLabor = totalLabor;
    }

    public double getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(double totalDays) {
        this.totalDays = totalDays;
    }

    public String getProposalDate() {
        return proposalDate;
    }

    public void setProposalDate(String proposalDate) {
        this.proposalDate = proposalDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }
}
