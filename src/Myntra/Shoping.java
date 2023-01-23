package Myntra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shoping {
	public static WebDriver driver;
	public static int min_prize;

	@Test(priority =1)
	public void browserLaunch() throws Throwable {
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

	//@Test(priority =2)
//	public void productLaunch() {
//		List<WebElement> element = driver.findElements(By.xpath("//li[@class='product-base']"));
//		//System.out.println("===============");
//		for (WebElement value : element) {
//			String str = value.getText();
//			//System.out.println(str);
//		}
//
//	}

	@Test(priority =3)
	public void productCost() {
		System.out.println("==========================");
		List<WebElement> cost = driver.findElements(By.xpath("//li[@class='product-base']//descendant::span[@class='product-discountedPrice']"));
		ArrayList<Integer> minimum_Cost = new ArrayList<Integer>();
		for (int i = 0; i < cost.size(); i++) {
			String value =cost.get(i).getText().replaceAll("Rs. ","");
			int tag_prize =Integer.parseInt(value);
			minimum_Cost.add(tag_prize);
		}
		System.out.println("Total Product :"+minimum_Cost.size());
		min_prize =Collections.min(minimum_Cost);
		System.out.println("Minium Prize :"+min_prize);
		
	}
	@Test(priority =4)
	public void titleProduct() {
		System.out.println("==========================");
		WebElement  minum_band_name =driver.findElement(By.xpath("//li[@class='product-base']//descendant::span[text()=" + min_prize + "]//ancestor::div[@class='product-productMetaInfo']//h3[@class='product-brand']"));
		String name =minum_band_name.getText();
		System.out.println(name);
		System.out.println("==============");
	}
	@Test(priority =5)
	public void subproduct() {
		System.out.println("======");
		WebElement sub_product =driver.findElement(By.xpath("//li[@class='product-base']//descendant::span[@class='product-discountedPrice']//ancestor::div[@class='product-productMetaInfo']//h4[@class='product-product']"));
		String name =sub_product.getText();
		System.out.println("subproduct :"+ ":"+name);
		System.out.println("============");
		}
	@Test(priority =6)
	public void subproductname() {
		System.out.println("======");
		String name = "Boys Pure Cotton T-shirt";
		WebElement findElement = driver.findElement(By.xpath("//li[@class='product-base']//descendant::span[@class='product-discountPercentage']//ancestor::div[@class='product-productMetaInfo']//preceding-sibling::h4[text()='"+name+"']//preceding-sibling::h3"));
		String bandname=findElement.getText();
		System.out.println("sub product name "+ bandname);
		System.out.println("=========");
	}



}




