package raq.modal;

public class Complaint {
	private int complaintID;
	private int accountNumber;
	private String complaintDate;
	private String nComplaint;
	private String email;
	private String contact;
	private String anythingMoreToTell;
	
	public Complaint(int complaintID, int accountNumber, String complaintDate, String nComplaint, String email,
			String contact, String anythingMoreToTell) {
		this.complaintID = complaintID;
		this.accountNumber = accountNumber;
		this.complaintDate = complaintDate;
		this.nComplaint = nComplaint;
		this.email = email;
		this.contact = contact;
		this.anythingMoreToTell = anythingMoreToTell;
	}

	public Complaint() {
		
	}

	public int getComplaintID() {
		return complaintID;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getComplaintDate() {
		return complaintDate;
	}

	public String getnComplaint() {
		return nComplaint;
	}

	public String getEmail() {
		return email;
	}

	public String getContact() {
		return contact;
	}

	public String getAnythingMoreToTell() {
		return anythingMoreToTell;
	}

	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setComplaintDate(String complaintDate) {
		this.complaintDate = complaintDate;
	}

	public void setnComplaint(String nComplaint) {
		this.nComplaint = nComplaint;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setAnythingMoreToTell(String anythingMoreToTell) {
		this.anythingMoreToTell = anythingMoreToTell;
	}

	@Override
	public String toString() {
		return "Complaint [complaintID=" + complaintID + ", accountNumber=" + accountNumber + ", complaintDate="
				+ complaintDate + ", nComplaint=" + nComplaint + ", email=" + email + ", contact=" + contact
				+ ", anythingMoreToTell=" + anythingMoreToTell + "]";
	}
	
	
	
	
	
	
}
