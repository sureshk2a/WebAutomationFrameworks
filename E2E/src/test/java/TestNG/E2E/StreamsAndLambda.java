package TestNG.E2E;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StreamsAndLambda extends Base {
	
	
	@Test
	public void test1() throws IOException {
		
//		String name = "suresh";
//		
//		List<Character> chars = new ArrayList<Character>();
//		
//		for(char a: name.toCharArray()) {
//			chars.add(a);
//		}
//		
//		List<Character> filtered = chars.stream().distinct().collect(Collectors.toList());
//		
//		for(int i=0;i<chars.size();i++) {
//			if(chars.get(i) != filtered.get(i)) {
//				System.out.println(chars.get(i));
//			}
//		}
		
		WebDriver driver = initializeDriver("Chrome");
		
		driver.get("https://mariadb.org/donate/individual-sponsors/");
		
		List<WebElement> heads = driver.findElements(By.xpath("//table[@class='wp-block-table']/tbody/tr/th"));
		
		for(int i=1;i<=heads.size();i++) {
			if(heads.get(i).getText()=="Donor") {
				List<WebElement> rows = driver.findElements(By.xpath("//table[@class='wp-block-table']/tbody/tr"));
				for(int j=1;j<=rows.size();j++) {
					rows.get(j).findElement(By.xpath("//tr['"+i+"']")).getText();
				}
			}
		}
		
	}

}
