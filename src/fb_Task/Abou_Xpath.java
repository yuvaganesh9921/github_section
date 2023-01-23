package fb_Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Abou_Xpath {
	static public WebDriver driver;
	static public void selction_Path() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Thread.sleep(6000);
	}
	static public void log_In() throws Throwable {
	
		WebElement asd =driver.findElement(By.xpath("//input[@type='text']//self::input[@type='text']"));
		asd.sendKeys("yuva");
		driver.findElement(By.xpath("//div[@class='_6luv _52jv']//child::input[@type='password']")).sendKeys("1234567");
		driver.findElement(By.xpath("(//div[@class='_8iep _8icy _9ahz _9ah-']//descendant::div[@class='_6ltg'])[1]")).click();
	}
	static public void creat_Id() throws Throwable {
		
		driver.findElement(By.xpath("//div[@class='_8iep _8icy _9ahz _9ah-']//child::div[@class='_6ltg'][2]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//div[@class='_8fgl _9l2p']//descendant::div[@id='reg_form_box']//descendant::div[@class='_5dbb']//child::input[@type='text'])[1]")).sendKeys("Ambika");
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//div[@class='_8fgl _9l2p']//descendant::div[@id='reg_form_box']//descendant::div[@class='_5dbb']//child::input[@type='text'])[2]")).sendKeys("Amma");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='_8fgl _9l2p']//descendant::div[@id='reg_form_box']//descendant::div[@class='_5dbb']//child::input[@type='text'])[3]")).sendKeys("8667010779");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='_8fgl _9l2p']//descendant::div[@class='_5dbb']//child::input[@type='password']")).sendKeys("123456789");
		//dob
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='_5k_5']//child::select[@aria-label='Day']//following::option[@value='9'])[1]")).click();
		//month
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='_5k_5']//child::select[@aria-label='Month']//following::option[@value='9']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='_5k_5']//child::select[@aria-label='Year']//following::option[@value='2014']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='mtm _5wa2 _5dbb']//child::span[@class='_5k_3']//child::label[@class='_58mt'])[1]")).click();
	}
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		selction_Path();
		//log_In();
		creat_Id();
	}

}
