package Task_1par;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class online_Shoping {
	public static WebDriver driver;
	public static Integer min_prize;
	static public void browser_Launch() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		WebElement act = driver.findElement(By.xpath("//a[@style='border-bottom-color:#f26a10;']"));
		Actions ref = new Actions(driver);
		ref.moveToElement(act).perform();
		Thread.sleep(4000);
		driver.findElement(By
				.xpath("//a[@href='/kids?f=Categories%3ATshirts%3A%3AGender%3Aboys%2Cboys%20girls&plaEnabled=false']"))
		.click();

	}
	static public void product_Launch() {
		List<WebElement> element = driver.findElements(By.xpath("//li[@class='product-base']"));
		int store = element.size();
		System.out.println("Total Product" + store);
		System.out.println("===============");
		for (WebElement value : element) {
			String str = value.getText();
			System.out.println(str);
		}

	}
	static public void product_cost() {
		System.out.println("==========================");
		List<WebElement> cost = driver.findElements(By.xpath("//li[@class='product-base']//descendant::span[@class='product-discountedPrice']"));
		ArrayList<Integer> minimum_Cost = new ArrayList<Integer>();
		for (int i = 0; i < cost.size(); i++) {
			String value =cost.get(i).getText().replaceAll("Rs. ","");
			int tag_prize =Integer.parseInt(value);
			minimum_Cost.add(tag_prize);
		}
		System.out.println("Total Product :"+minimum_Cost.size());
		Integer min_prize =Collections.min(minimum_Cost);
		System.out.println("Minium Prize :"+min_prize);
		System.out.println("==================================");
	}
	static public void title_Product(Integer min_prize) throws Throwable {
		Thread.sleep(4000);
		System.out.println("==========================");
		WebElement  minum_band_name =driver.findElement(By.xpath("//li[@class='product-base']//descendant::span[text()="+min_prize+"]//ancestor::div[@class='product-productMetaInfo']//h3[@class='product-brand']"));
		String name =minum_band_name.getText();
		System.out.println(name);
	}

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		browser_Launch();
		product_Launch();
		product_cost();
		title_Product(min_prize);
	}

}
