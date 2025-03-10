package utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import setup.EmployeeModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

    public static void saveUser(EmployeeModel model) throws IOException, ParseException {

        String fileLocation = "./src/test/resources/users.json";

        JSONParser parser = new JSONParser();

        JSONArray empArray = (JSONArray) parser.parse(new FileReader(fileLocation));

        JSONObject empObj = new JSONObject();

        empObj.put("firstName", model.getFirstName());
        empObj.put("lastName", model.getLastName());
        empObj.put("userName", model.getUserName());
        empObj.put("passWord", model.getPassWord());

        empArray.add(empObj);

        FileWriter writer = new FileWriter(fileLocation);
        writer.write(empArray.toJSONString());
        writer.flush();
        writer.close();

    }

    public static JSONArray readJSONData() throws IOException, ParseException {

        String fileLocation = "./src/test/resources/users.json";
        JSONParser parser = new JSONParser();
        JSONArray empArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        return empArray;
    }

    public static void main(String[] args) throws IOException, ParseException {

    }

}
