package basepackage;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJSON {
	
	@SuppressWarnings("unchecked")
	public static List<JSONObject> getRCBPlayers(String file)
	{
		List<JSONObject> players = null;
		JSONParser parser = new JSONParser();
		try
		{
			Object object = parser.parse(new FileReader(file));
			JSONObject jb = (JSONObject)object;
			players = (List<JSONObject>) jb.get("player");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		players.remove(null);
		return players;
	}
	
	public static Integer getWicketKeepers(List<JSONObject> players)
	{
		int wicketKeepers = 0;
        Iterator<JSONObject> iterator = players.iterator();
        while (iterator.hasNext()) {
       	 JSONObject childObject = (JSONObject) iterator.next();
       	 if(childObject.get("role").toString().equals("Wicket-keeper")) wicketKeepers++;
        }
		return wicketKeepers;
	}

	public static Integer getForeignPlayers(List<JSONObject> players)
	{
		int foreignPlayers = 0;
        Iterator<JSONObject> iterator = players.iterator();
        while (iterator.hasNext()) {
       	 JSONObject childObject = (JSONObject) iterator.next();
       	if(!(childObject.get("country").toString().equals("India"))) foreignPlayers++;
        }
		return foreignPlayers;
	}
}
