package seleniumtraining.assignments;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Assignmenttwo {
	ArrayList<WebElement> Selects;
	public void validateErrorMessage(WebDriver driver) {
		driver.get("https://www.cleartrip.com");
		driver.findElement(By.xpath("//input[@id='DepartDate']")).click();
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active ']")).click();
		Selects=new ArrayList<WebElement>();
		Selects.addAll(driver.findElements(By.xpath("//select[@size='1']")));
			for(int i = 0;i<Selects.size();i++) {
				new Select(Selects.get(i)).selectByVisibleText("1");
			}
		driver.findElement(By.xpath("//a[@id='MoreOptionsLink']")).click();
		new Select(driver.findElement(By.xpath("//select[@id='Class']"))).selectByVisibleText("Business");
		driver.findElement(By.xpath("//input[@name='airline']")).sendKeys("Air");
		driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='homeErrorMessage']")).getText());
	}
}
