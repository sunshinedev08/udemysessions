package selemiumtraining;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		ArrayList<WebElement>CheckBoxes=new ArrayList<WebElement>();
		CheckBoxes.addAll(driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")));
		for (WebElement check : CheckBoxes) {
			check.getAttribute("id");
		}
		System.out.println("Number of CheckBoxes on the page:"+CheckBoxes.size());
	}
}