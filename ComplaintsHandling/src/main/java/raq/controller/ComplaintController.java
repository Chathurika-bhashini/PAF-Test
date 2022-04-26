package raq.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import raq.constants.Constant;
import raq.constants.ComplaintConstant;
import raq.modal.Complaint;
import raq.util.DatabaseConnection;

public class ComplaintController {
	
    //get all
	public static ArrayList<Complaint> getComplaints() throws ClassNotFoundException, SQLException {
		ArrayList<Complaint> plist = new ArrayList<>();
		String getQury = ComplaintConstant.GETALLCOMPLAINTS;
		Connection con = DatabaseConnection.getConnection();
		
		PreparedStatement preparedStatement = con.prepareStatement(getQury);
		ResultSet rs = preparedStatement.executeQuery();
		
		while(rs.next()) {
			Complaint complaint = new Complaint();
			complaint.setAccountNumber(rs.getInt(Constant.INDEX_ONE));
			complaint.setComplaintDate(rs.getString(Constant.INDEX_TWO));
			complaint.setnComplaint(rs.getString(Constant.INDEX_TREE));
			complaint.setEmail(rs.getString(Constant.INDEX_FOUR));
			complaint.setContact(rs.getString(Constant.INDEX_FIVE));
			complaint.setAnythingMoreToTell(rs.getString(Constant.INDEX_SIX));
			
			plist.add(complaint);
		}
		return  plist;
		
	}
	
	//create
	public static Complaint createComplaint(Complaint complaint) throws SQLException, ClassNotFoundException {
		  String CreateQury =ComplaintConstant.CREATECOMPLAINTS;
		  Connection con = DatabaseConnection.getConnection();
		  PreparedStatement preparedStatement = con.prepareStatement(CreateQury);
		  preparedStatement.setInt(Constant.INDEX_ONE, complaint.getAccountNumber());
		  preparedStatement.setString(Constant.INDEX_TWO, complaint.getComplaintDate());
		  preparedStatement.setString(Constant.INDEX_TREE, complaint.getnComplaint());
		  preparedStatement.setString(Constant.INDEX_FOUR, complaint.getEmail());
		  preparedStatement.setString(Constant.INDEX_FIVE, complaint.getContact());
		  preparedStatement.setString(Constant.INDEX_SIX, complaint.getAnythingMoreToTell());
		  
		  boolean isCreate = preparedStatement.execute();
		  if(!isCreate) {
			  return complaint;
		  }
		  else {
			  return null;
		  }
	}
	
	//get by ID
	
	public static Complaint getComplaintByID(int compId) throws SQLException, ClassNotFoundException {
		
		String getdata_query = ComplaintConstant.GETCOMPLAINTSBYID;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(getdata_query);
				
		Complaint complaint = null;
				
		preparedStatement.setInt(Constant.INDEX_ONE, compId);
				
		ResultSet rs = preparedStatement.executeQuery();
				
		while(rs.next()) {
			int complaintID = rs.getInt(Constant.INDEX_ONE);
			int accountNumber = rs.getInt(Constant.INDEX_TWO);
			String complaintDate = rs.getString(Constant.INDEX_TREE);
			String nComplaint = rs.getString(Constant.INDEX_FOUR);
			String email = rs.getString(Constant.INDEX_FIVE);
			String contact = rs.getString(Constant.INDEX_SIX);
			String anythingMoreToTell = rs.getString(Constant.INDEX_SEVEN);
			
			
			complaint = new Complaint(complaintID, accountNumber, complaintDate, nComplaint, email, contact, anythingMoreToTell);
		}
		return complaint;
				
	}
	
	//Update
	public static Complaint updateComplaint(Complaint complaint,int compId) throws SQLException, ClassNotFoundException {
		
		String update_query = ComplaintConstant.UPDATECOMPLAINTS;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(update_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, complaint.getAccountNumber());
		preparedStatement.setString(Constant.INDEX_TWO, complaint.getComplaintDate());
		preparedStatement.setString(Constant.INDEX_TREE, complaint.getnComplaint());
		preparedStatement.setString(Constant.INDEX_FOUR, complaint.getEmail());
		preparedStatement.setString(Constant.INDEX_FIVE, complaint.getContact());
		preparedStatement.setString(Constant.INDEX_SIX, complaint.getAnythingMoreToTell());
		
		preparedStatement.setInt(Constant.INDEX_SEVEN, compId); //ask
				
		if(preparedStatement.executeUpdate() > 0) {
			return getComplaintByID(compId); //ask
		}
		else {
			return null;
		}
				
	}
	
	//Delete
	public static boolean deleteComplaint(int compId) throws SQLException, ClassNotFoundException {
		
		String delete_query = ComplaintConstant.DELETECOMPLAINTS;
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(delete_query);
				
		preparedStatement.setInt(Constant.INDEX_ONE, compId);
		boolean isDeleted = preparedStatement.execute();
				
		return isDeleted;
				
	}
	
}
