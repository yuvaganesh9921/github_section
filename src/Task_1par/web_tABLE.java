package Task_1par;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class web_tABLE {
static public WebDriver driver;
static public void browser_Launch() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\yuvag\\New folder\\Selenium_Conpect\\chrome\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.w3schools.com/html/html_tables.asp");
	
}
static public void all_Data() {
	List<WebElement> all_data = driver.findElements(By.xpath("//table[@class='ws-table-all']"));
for (WebElement webElement : all_data) {
	System.out.println(webElement.getText());
}
System.out.println("===============");
}
static public void all_row() {
	List<WebElement> findElement = driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr/td"));
	for (WebElement findElement1 : findElement) {
		System.out.println(findElement1.getText());
	}
	System.out.println("===================");
}
static public void particular_row() {
	System.out.println("=====particular_row=======");
	System.out.println("particluar row");
	List<WebElement> row =driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr[3]"));
	for (WebElement data : row) {
		System.out.println(data.getText());
	}
}
static public void particular_colunm() {
	System.out.println("=====particular_colunm=====");
	List<WebElement> colunm = driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr/td[2]"));
	for (WebElement data : colunm) {
		System.out.println(data.getText());
	}
}
static public void particular_cell() {
	List<WebElement> cell = driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr[5]/td[2]"));
	for (WebElement webElement : cell) {
		System.out.println(webElement.getText());
	}

}
public static void main(String[] args) {
	 browser_Launch();
	 all_Data();
	 all_row();
	 particular_row();
	 particular_colunm();
}
}
