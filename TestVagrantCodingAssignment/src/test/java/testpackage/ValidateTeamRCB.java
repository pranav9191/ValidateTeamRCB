package testpackage;

import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidateTeamRCB {
  @SuppressWarnings({ "unused", "rawtypes" })
@Test
  public void validateTeamRCB() {
		JSONParser parser = new JSONParser();
        int wicketKeepers = 0, foreignPlayers = 0;
		try
		{
			Object object = parser.parse(new FileReader("target\\TeamRCB.json"));
			JSONObject jb = (JSONObject)object;
			JSONArray players = (JSONArray)jb.get("player");
	        Iterator iterator = players.iterator();
	         while (iterator.hasNext()) {
	        	 JSONObject childObject = (JSONObject) iterator.next();
	        	 if(childObject.get("role").toString().equals("Wicket-keeper")) wicketKeepers++;
	        	 if(!(childObject.get("country").toString().equals("India"))) foreignPlayers++;
	         }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(wicketKeepers >=1);
		softAssert.assertTrue(foreignPlayers<=4);
		softAssert.assertAll();
  }
}
