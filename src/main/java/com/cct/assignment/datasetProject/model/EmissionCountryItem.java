package com.cct.assignment.datasetProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "emissionsByCountry")
public class EmissionCountryItem {

    @Id
    private String id;
    @Field("Year")
    private int year;
    @Field("Country")
    private String country;
    @Field("Total")
    private int total;
    @Field("Solid Fuel")
    private int solidFuel;
    @Field("Liquid Fuel")
    private int liquidFuel;
    @Field("Gas Fuel")
    private int gasFuel;
    @Field("Cement")
    private int cement;
    @Field("Gas Flaring")
    private int gasFlaring;
    @Field("Per Capita")
    private int perCapita;
    @Field("Bunker Fuels (Not in Total")
    private int bunkerFuels;
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getSolidFuel() {
		return solidFuel;
	}
	public void setSolidFuel(int solidFuel) {
		this.solidFuel = solidFuel;
	}
	public int getLiquidFuel() {
		return liquidFuel;
	}
	public void setLiquidFuel(int liquidFuel) {
		this.liquidFuel = liquidFuel;
	}
	public int getGasFuel() {
		return gasFuel;
	}
	public void setGasFuel(int gasFuel) {
		this.gasFuel = gasFuel;
	}
	public int getCement() {
		return cement;
	}
	public void setCement(int cement) {
		this.cement = cement;
	}
	public int getGasFlaring() {
		return gasFlaring;
	}
	public void setGasFlaring(int gasFlaring) {
		this.gasFlaring = gasFlaring;
	}
	public int getPerCapita() {
		return perCapita;
	}
	public void setPerCapita(int perCapita) {
		this.perCapita = perCapita;
	}
	public int getBunkerFuels() {
		return bunkerFuels;
	}
	public void setBunkerFuels(int bunkerFuels) {
		this.bunkerFuels = bunkerFuels;
	}

    

}
