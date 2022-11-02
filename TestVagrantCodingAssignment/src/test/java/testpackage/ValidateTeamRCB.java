package testpackage;

import java.util.List;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basepackage.ReadJSON;

public class ValidateTeamRCB {
	  String caseid;
  @SuppressWarnings({ "unused", "rawtypes", "unchecked" })
  
  List<JSONObject> players;
  
@BeforeClass
public void readRCBTeam()
{
	  players = ReadJSON.getRCBPlayers("target\\TeamRCB.json");
}
  
@Test
  public void validateTeamRCBWicketKeepers() {
		int wicketKeepers = ReadJSON.getWicketKeepers(players);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(wicketKeepers >=1,"team have wicketkeeper");
		softAssert.assertAll();
  }

@Test
public void validateTeamRCBForeignPlayers() {
		int foreignPlayers = ReadJSON.getWicketKeepers(players);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(foreignPlayers <=4,"team have wicketkeeper");
		softAssert.assertAll();
}

}

