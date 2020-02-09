package seleniumtraining.assignments;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assignmentone {
	boolean status=false;
	ArrayList<WebElement> CheckBoxes;
	public boolean checkTheCheckBoxes(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		CheckBoxes=new ArrayList<WebElement>();
		CheckBoxes.addAll(driver.findElements(By.xpath("//input[contains(@id,'Option')]")));
		CheckBoxes.get(0).click();
		if(CheckBoxes.get(0).isSelected()) {
			status=true;
			System.out.println("Check Box is Checked");
		}
		return status;
	}
	
	public boolean unCheckTheCheckBoxes(WebDriver driver) {
		//driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		CheckBoxes=new ArrayList<WebElement>();
		CheckBoxes.addAll(driver.findElements(By.xpath("//input[contains(@id,'Option')]")));
		CheckBoxes.get(0).click();
		if(!CheckBoxes.get(0).isSelected()) {
			status=true;
			System.out.println("Check Box is Unchecked");
		}
		return status;
	}
	
	public void noOfCheckBoxesOnThePage(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		CheckBoxes=new ArrayList<WebElement>();
		CheckBoxes.addAll(driver.findElements(By.xpath("//input[contains(@type,'checkbox')]")));
		for(WebElement check:CheckBoxes) {
			check.getAttribute("id");
		}
		System.out.println("Number of CheckBoxes on the page:"+CheckBoxes.size());
	}
}
