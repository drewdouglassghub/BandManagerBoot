package Spring.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Venue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long venueid;
	private String venuename;
	private String venueaddy1;
	private String venuecity;
	private String venuestate;
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private LocalDate membersince;
	private String bookingagent;
	private String bookingphone;
	private String bookingemail;
	
	public Venue() {
		super();
	}
	
	public Venue(String venueName, String streetAddress, String city, String state,
			LocalDate memberSince, String bookingAgent, String phoneNum, String email) {
		super();
		this.venuename = venueName;
		this.venueaddy1 = streetAddress;
		this.venuecity = city;
		this.venuestate = state;
		this.membersince = memberSince;
		this.bookingagent = bookingAgent;
		this.bookingphone = phoneNum;
		this.bookingemail = email;
	}



	public long getVenueid() {
		return venueid;
	}

	public void setVenueid(long venueid) {
		this.venueid = venueid;
	}

	public String getVenuename() {
		return venuename;
	}

	public void setVenuename(String venuename) {
		this.venuename = venuename;
	}

	public String getVenueaddy1() {
		return venueaddy1;
	}

	public void setVenueaddy1(String venueaddy1) {
		this.venueaddy1 = venueaddy1;
	}

	public String getVenuecity() {
		return venuecity;
	}

	public void setVenuecity(String venuecity) {
		this.venuecity = venuecity;
	}

	public String getVenuestate() {
		return venuestate;
	}

	public void setVenuestate(String venuestate) {
		this.venuestate = venuestate;
	}

	public LocalDate getMembersince() {	
		
		return membersince;
	}

	public void setMembersince(String dateString) {	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
		this.membersince = localDate;
	}

	public String getBookingagent() {
		return bookingagent;
	}

	public void setBookingagent(String bookingagent) {
		this.bookingagent = bookingagent;
	}

	public String getBookingphone() {
		return bookingphone;
	}

	public void setBookingphone(String bookingphone) {
		this.bookingphone = bookingphone;
	}

	public String getBookingemail() {
		return bookingemail;
	}

	public void setBookingemail(String bookingemail) {
		this.bookingemail = bookingemail;
	}

	@Override
	public String toString() {
		return "Venue [venueid=" + venueid + ", venuename=" + venuename + ", venueaddy1=" + venueaddy1 + ", venuecity="
				+ venuecity + ", venuestate=" + venuestate + ", membersince=" + membersince + ", bookingagent="
				+ bookingagent + ", bookingphone=" + bookingphone + ", bookingemail=" + bookingemail + "]";
	}


	
	

	
	
}
