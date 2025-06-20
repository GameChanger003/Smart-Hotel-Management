package com.cts.hotel.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//• LoyaltyAccount (LoyaltyID, UserID, PointsBalance, LastUpdated)

@Entity
@Table
public class Loyality {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int LoyaltyID;
	@Column
	private int UserID;
	@Column
	private int PointsBalance;
	@Column
	private Date LastUpdated;

	public int getLoyaltyID() {
		return LoyaltyID;
	}

	public void setLoyaltyID(int loyaltyID) {
		LoyaltyID = loyaltyID;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public int getPointsBalance() {
		return PointsBalance;
	}

	public void setPointsBalance(int pointsBalance) {
		PointsBalance = pointsBalance;
	}

	public Date getLastUpdated() {
		return LastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		LastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "Loyality [LoyaltyID=" + LoyaltyID + ", UserID=" + UserID + ", PointsBalance=" + PointsBalance
				+ ", LastUpdated=" + LastUpdated + "]";
	}

	public Loyality(int loyaltyID, int userID, int pointsBalance, Date lastUpdated) {
		super();
		LoyaltyID = loyaltyID;
		UserID = userID;
		PointsBalance = pointsBalance;
		LastUpdated = lastUpdated;
	}

	public Loyality() {
		super();
		// TODO Auto-generated constructor stub
	}

}
