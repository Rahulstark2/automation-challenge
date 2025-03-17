import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automation {
	WebDriver driver;
	Scanner sc = new Scanner(System.in);
	
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/rahulroychowdhury/chromedriver-mac-arm64/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}
	
	public void signin() throws InterruptedException {
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='H6-NpN _3N4_BX']")).click();
		
		Thread.sleep(2000);
		
		
		System.out.println("Enter email or phone: ");
		 
		String email = sc.nextLine();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']")).sendKeys(email);
		
		driver.findElement(By.xpath("//button[@class='QqFHMw twnTnD _7Pd1Fp']")).click();
		
		
		
		
		
	    
	}
	
	public void search() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Enter product you want to search: ");
		
		String product = sc.nextLine();
		
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys(product);
		
		driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();
		

	}
	
	public void addToCart() throws InterruptedException {
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//img[@class='_53J4C-']")).click();
		
		
		Thread.sleep(2000);
		
		String mainWindowHandle = driver.getWindowHandle();
		
		Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> iterator = allWindows.iterator();
        
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!mainWindowHandle.equals(childWindow)) {
                
                driver.switchTo().window(childWindow);
                break;
            }
        }
		
		
		driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ _3Yl67G _7Pd1Fp']")).click();
		

}
	
	public void addAddress() throws InterruptedException {
		Thread.sleep(2000);

		
		driver.findElement(By.id("to-payment")).click();
		
		
	}
	
	public void payment() throws InterruptedException {
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[@for='CREDIT']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='cardNumber']")).sendKeys("378282246310005");
		
		driver.findElement(By.xpath("//input[@name='cardNumber']")).sendKeys("378282246310005");
		
		 WebElement monthDropdown = driver.findElement(By.name("month"));

	        
	        Select select = new Select(monthDropdown);

	        
	        select.selectByVisibleText("05");
	        
	     WebElement yearDropdown = driver.findElement(By.name("year"));

	        
	     Select select1 = new Select(yearDropdown);

	        
	     select1.selectByVisibleText("27");
	     
	     driver.findElement(By.xpath("//input[@name='cvv']")).sendKeys("5666");
	     
	     driver.findElement(By.xpath("//input[@name='billing_pincode']")).sendKeys("700079");
	     
	     WebElement countryDropdown = driver.findElement(By.name("billing_country"));

	       
	        Select select2 = new Select(countryDropdown);

	        
	        select2.selectByVisibleText("India");
	        
	        
	     driver.findElement(By.xpath("//input[@name='billing_city']")).sendKeys("Kolkata");  
	     
	     driver.findElement(By.xpath("//input[@name='billing_state']")).sendKeys("West Bengal");  
	     
	     driver.findElement(By.xpath("//textarea[@name='billing_address']")).sendKeys("29th Nabapally, Manikpur");
	     
	     driver.findElement(By.xpath("//button[@class='QqFHMw JO5Wdq TVgwvR _7Pd1Fp']")).click();
	     
	}
	
	
	

	public static void main(String[] args) throws InterruptedException {
		Automation org = new Automation();
		
		org.launchBrowser();
		
		org.signin();
		
		org.search();
		
		org.addToCart();
		
		org.addAddress();
		
		org.payment();
		
		
		

	}

}
