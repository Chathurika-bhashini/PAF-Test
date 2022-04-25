package com;

import model.PowerCutTime;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/PowerCutTime")
public class PowerCutTimeAPI {
	PowerCutTime PowerCutObj = new PowerCutTime();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPowerCut() {
		return PowerCutObj.readPowerCut();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPowerCut(@FormParam("City_ID") String City_ID,
			@FormParam("Province") String Province,
			@FormParam("Town") String Town,
			@FormParam("Time") String Time) {
		String output = PowerCutObj.insertPowerCut(City_ID, Province, Town, Time);
		return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public String updatePowerCut(String powercutData) {
		// Convert the input string to a JSON object
		JsonObject PayObject = new JsonParser().parse(powercutData).getAsJsonObject();

		// Read the values from the JSON object
		String PcutID = PayObject.get("PcutID").getAsString();
		String City_ID = PayObject.get("City_ID").getAsString();
		String Province = PayObject.get("Province").getAsString();
		String Town = PayObject.get("Town").getAsString();
		String Time = PayObject.get("Time").getAsString();	
		String output = PowerCutObj.updatePowerCut(PcutID, City_ID, Province, Town, Time);
		return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePowerCut(String powercutData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(powercutData, "", Parser.xmlParser());

		// Read the value from the element
		String PcutID = doc.select("PcutID").text();
		String output = PowerCutObj.deletePowerCut(PcutID);
		return output;
	}
}
