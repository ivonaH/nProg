package rs.ac.bg.fon.ai.nprog.mavenServer.history;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.transfer.RequestObject;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.transfer.ResponseObject;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.util.ResponseStatus;
import rs.ac.bg.fon.ai.nprog.mavenServer.controller.Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class History {
	private static History instance;
	private String jsonFilePath="src\\main\\resources\\history.json";
	public static History getInstance() {
		if (instance == null)
			instance = new History();
		return instance;
	}

	public JsonArray readHistory() {
		JsonArray array = new JsonArray();
		JsonParser jsonParser = new JsonParser();

		try {
			Object obj = jsonParser.parse(new FileReader(jsonFilePath));
			array = (JsonArray) obj;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return array;
	}

	public void saveToHistory(User user, RequestObject requestObject, ResponseObject responseObject, Date date) {
		JsonArray array = readHistory();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

		JsonObject historyObj = new JsonObject();
		if(user==null) {
			user=(User) requestObject.getData();
		}
		historyObj.addProperty("user", user.getUsername());
		historyObj.addProperty("date", sdf.format(date.getTime()));
		historyObj.addProperty("operation", responseObject.getOperation());
		historyObj.addProperty("status", responseObject.getStatus() + "");

		if (responseObject.getStatus() == ResponseStatus.ERROR) {
			historyObj.addProperty("error_message", responseObject.getErrorMessage());
		}
		array.add(historyObj);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileWriter out = new FileWriter(jsonFilePath)) {

			gson.toJson(array, out);
			System.out.println("Saved to history.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
