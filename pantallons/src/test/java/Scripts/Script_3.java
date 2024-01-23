package Scripts;

import org.testng.annotations.Test;

import base.Required_Data;

public class Script_3 {
	Required_Data d=new Required_Data();
	
	@Test
	public void excel() {
		d.getDataFromExcel(null, null, null, false)
	}
	
	

}
