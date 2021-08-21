package dataProviders;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

import resources.DataReader;

public class DPClass {

	
	@DataProvider(name="LoginData")
	public static Object[][] getLoginData(Method m) {
		
		switch(m.getName()) {
		case "LoginToForm":
			return new Object[][]{
				{"tomsmith","SuperSecretPassword!"}
			};
		case "LogoutOfForm":	
			return new Object[][]{
				{"tomsmith","SuperSecretPassword!"},{"tomsmith","dummy"}
			};
		}
		return null;
	}
	
	@DataProvider(name = "LoginDataFromExcel")
    public Object[][] Authentication() throws Exception{

         Object[][] testObjArray = DataReader.getTableArray("C:\\Users\\suresha\\eclipse-workspace\\E2E\\src\\main\\java\\testData\\SampleData.xlsx","Sheet1");

         return (testObjArray);

		}
	
}
