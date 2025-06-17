package com.cts.hotel.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

//• Payment (PaymentID, UserID, BookingID, Amount, Status, PaymentMethod)

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int PaymentID;

	@Column
	private int user;

	public Payment(int paymentID, int user, int booking, float amount, PaymentStatus paymentStatus,
			PaymentType paymentMethod) {
		super();
		PaymentID = paymentID;
		this.user = user;
		this.booking = booking;
		Amount = amount;
		this.paymentStatus = paymentStatus;
		PaymentMethod = paymentMethod;
	}
	
	public Payment() {
		
	}

	public int getPaymentID() {
		return PaymentID;
	}

	public void setPaymentID(int paymentID) {
		PaymentID = paymentID;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getBooking() {
		return booking;
	}

	public void setBooking(int booking) {
		this.booking = booking;
	}

	public float getAmount() {
		return Amount;
	}

	public void setAmount(float amount) {
		Amount = amount;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public PaymentType getPaymentMethod() {
		return PaymentMethod;
	}

	public void setPaymentMethod(PaymentType paymentMethod) {
		PaymentMethod = paymentMethod;
	}


	private int booking;

	@Column
	private float Amount;

	@Column
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;

	@Column
	@Enumerated(EnumType.STRING)
	private PaymentType PaymentMethod;
}
