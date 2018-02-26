package com.bindschaedel.nachhilfe.DAO;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Entry {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date date;
	private String name;
	private double cost;
	private double given;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setGiven(double given) {
		this.given = given;
	}

	public double getCost() {
		return cost;
	}


	public double getGiven() {
		return given;
	}
	
}
