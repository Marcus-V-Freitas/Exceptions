package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Exceptions.DomainExceptions;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
private static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {}
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainExceptions {
		super();
		if(!checkout.after(checkin)) {
			throw new DomainExceptions("check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	
	public long Duration() {
		long diff=checkout.getTime()-checkin.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkin, Date checkout) throws DomainExceptions {
		Date now=new Date();
		if(checkin.before(now)||checkout.before(now)) {
			throw new DomainExceptions("Reservation Dates for update must be future dates");
		}
		if(!checkout.after(checkin)) {
			throw new DomainExceptions("check-out date must be after check-in date");
		}
		this.checkin=checkin;
		this.checkout=checkout;
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Reservation: Room" +getRoomNumber()+", "+ "check-in: "+ sdf.format(getCheckin())+ ", "+ "check-out: "+ sdf.format(getCheckout())+", "+ Duration()+" nights");
		return sb.toString();
	}
	
	
	
}
