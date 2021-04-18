package com.ankush.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@Column(name="itemName")
	String itemName;
	@Column(name="metal")
	String metal;
	@Column(name="metalWeight")
	double metalWeight;
	@Column(name="otherWeight")
	double otherWeight;
	@Column(name="weightUnit")
	String weightUnit;
	@Column(name="labourChareges")
	double labourChareges;
	@Column(name="otherCharges")
	double otherCharges;
	@Column(name="purity")
	double purity;
	@Column(name="hsn")
	int hsn;
	public Item() {
		super();
	}
	public Item(String itemName, String metal, double metalWeight, double otherWeight, String weightUnit,
			double labourChareges, double otherCharges, double purity, int hsn) {
		super();
		this.itemName = itemName;
		this.metal = metal;
		this.metalWeight = metalWeight;
		this.otherWeight = otherWeight;
		this.weightUnit = weightUnit;
		this.labourChareges = labourChareges;
		this.otherCharges = otherCharges;
		this.purity = purity;
		this.hsn = hsn;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getMetal() {
		return metal;
	}
	public void setMetal(String metal) {
		this.metal = metal;
	}
	public double getMetalWeight() {
		return metalWeight;
	}
	public void setMetalWeight(double metalWeight) {
		this.metalWeight = metalWeight;
	}
	public double getOtherWeight() {
		return otherWeight;
	}
	public void setOtherWeight(double otherWeight) {
		this.otherWeight = otherWeight;
	}
	public String getWeightUnit() {
		return weightUnit;
	}
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	public double getLabourChareges() {
		return labourChareges;
	}
	public void setLabourChareges(double labourChareges) {
		this.labourChareges = labourChareges;
	}
	public double getOtherCharges() {
		return otherCharges;
	}
	public void setOtherCharges(double otherCharges) {
		this.otherCharges = otherCharges;
	}
	public double getPurity() {
		return purity;
	}
	public void setPurity(double purity) {
		this.purity = purity;
	}
	public int getHsn() {
		return hsn;
	}
	public void setHsn(int hsn) {
		this.hsn = hsn;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + ", metal=" + metal + ", metalWeight=" + metalWeight
				+ ", otherWeight=" + otherWeight + ", weightUnit=" + weightUnit + ", labourChareges=" + labourChareges
				+ ", otherCharges=" + otherCharges + ", purity=" + purity + ", hsn=" + hsn + "]";
	}
	
}
