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
import jakarta.persistence.Table;

//• Booking (BookingID, UserID, RoomID, CheckInDate, CheckOutDate, Status, PaymentID)

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int BookingID;
	@Column
	private int UserID;
	@Column(name="room_id")
	private int RoomID;
	@Column
	private Date CheckInDate;
	@Column
	private Date CheckOutDate;
	@Column
	@Enumerated(EnumType.STRING)
	private BookingStatus Status;

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

	public int getRoomID() {
		return RoomID;
	}

	public void setRoomID(int roomID) {
		RoomID = roomID;
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

	public Booking(int bookingID, int userID, int roomID, Date checkInDate, Date checkOutDate, BookingStatus status) {
		super();
		BookingID = bookingID;
		UserID = userID;
		RoomID = roomID;
		CheckInDate = checkInDate;
		CheckOutDate = checkOutDate;
		Status = status;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Booking [BookingID=" + BookingID + ", UserID=" + UserID + ", RoomID=" + RoomID + ", CheckInDate="
				+ CheckInDate + ", CheckOutDate=" + CheckOutDate + ", Status=" + Status + "]";
	}

}
