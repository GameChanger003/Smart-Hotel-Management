package com.cts.hotel.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

//• Booking (BookingID, UserID, RoomID, CheckInDate, CheckOutDate, Status, PaymentID)

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int BookingID;
	@Column
	private int UserID;
	@Column
	private Date CheckInDate;
	@Column
	private Date CheckOutDate;
	@Column
	@Enumerated(EnumType.STRING)
	private BookingStatus Status;

	@Column
	private int PaymentID;

	public Booking(int bookingID, int userID, Date checkInDate, Date checkOutDate, BookingStatus status,
			int paymentID) {
		super();
		BookingID = bookingID;
		UserID = userID;
		CheckInDate = checkInDate;
		CheckOutDate = checkOutDate;
		Status = status;
		PaymentID = paymentID;
	}

	public int getBookingID() {
		return BookingID;
	}

	public void setBookingID(int bookingID) {
		BookingID = bookingID;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public Date getCheckInDate() {
		return CheckInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		CheckInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return CheckOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		CheckOutDate = checkOutDate;
	}

	public BookingStatus getStatus() {
		return Status;
	}

	public void setStatus(BookingStatus status) {
		Status = status;
	}

	public int getPaymentID() {
		return PaymentID;
	}

	public void setPaymentID(int paymentID) {
		PaymentID = paymentID;
	}

	public Booking() {

	}

}
