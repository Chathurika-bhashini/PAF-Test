package com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

import model.User;

@Path("/User")
public class UserService {
	User userObj = new User();

	
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readUser() {
		return userObj.readUser();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertUser(
			
	 @FormParam("name") String name,
	 @FormParam("uAddress") String uAddress,
	 @FormParam("uEmail") String uEmail,
	 @FormParam("nic") String nic,
	 @FormParam("Pno") String Pno)
	{
	 String output = userObj.insertUser(name, uAddress, uEmail,  nic, Pno);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUser(String userData)
	{
	//Convert the input string to a JSON object
	 JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject();
	//Read the values from the JSON object
	 String uID = userObject.get("uID").getAsString();
	 String name = userObject.get("name").getAsString();
	 String uAddress = userObject.get("cAddress").getAsString();
	 String uEmail = userObject.get("uEmail").getAsString();
	 String nic = userObject.get("nic").getAsString();
	 String Pno = userObject.get("Pno").getAsString();
	 String output = userObj.updateUser(uID, name, uAddress, uEmail, nic, Pno);
	return output;
	} 
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUser(String userData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(userData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String uID = doc.select("uID").text();
	 String output = userObj.deleteUser(uID);
	return output;
	}
}
