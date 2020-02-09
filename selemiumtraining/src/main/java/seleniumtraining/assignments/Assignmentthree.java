package seleniumtraining.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignmentthree {
	public void waitForLink(WebDriver driver) {
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();
		WebDriverWait wdw=new WebDriverWait(driver, 3);
		System.out.println(wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='results']"))).getText());
	}
}
