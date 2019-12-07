package com.hawliczek.tau.test.selenium;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest
{
	private WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:/Programy/Selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	private int getRandom() 
	{
        Random rand = new Random();
        int n = rand.nextInt(999);

        return n;
    }
	
	// test walidacji pól rejestracji
	@Test
	public void registrationValidation() throws Exception
	{
		String email = "kasia" + getRandom() + "@vp.pl";
			
		driver.get("http://automationpractice.com/index.php");
	    driver.findElement(By.cssSelector(".login")).click();
	    driver.findElement(By.id("email_create")).clear();
	    driver.findElement(By.id("email_create")).sendKeys(email);

	    driver.findElement(By.id("SubmitCreate")).click();

	    Thread.sleep(1000);
	    assertEquals(false, driver.findElement(By.cssSelector("#create_account_error")).isDisplayed());

	    driver.findElement(By.id("uniform-id_gender2")).click();

	    driver.findElement(By.id("customer_firstname")).clear();
	    driver.findElement(By.id("customer_firstname")).sendKeys("123");

	    driver.findElement(By.id("customer_lastname")).clear();
	    driver.findElement(By.id("customer_lastname")).sendKeys("456");

	    driver.findElement(By.id("passwd")).clear();
	    driver.findElement(By.id("passwd")).sendKeys("xyz");
	        
	    driver.findElement(By.id("address1")).clear();
	    driver.findElement(By.id("address1")).sendKeys("");

	    driver.findElement(By.id("city")).clear();
	    driver.findElement(By.id("city")).sendKeys("^&^");

	    driver.findElement(By.cssSelector("#id_state > option:nth-child(1)")).click();

	    driver.findElement(By.id("postcode")).clear();
	    driver.findElement(By.id("postcode")).sendKeys("666");

	    driver.findElement(By.cssSelector("#id_country > option:nth-child(1)")).click();

	    driver.findElement(By.id("phone_mobile")).clear();
	    driver.findElement(By.id("phone_mobile")).sendKeys("0000");

	    driver.findElement(By.id("submitAccount")).click();

	    Thread.sleep(500);
	    assertEquals("There are 7 errors", driver.findElement(By.cssSelector("div.alert.alert-danger > p:nth-child(1)")).getText());
	}
	
	// test udanej rejestracji przy rozdzielczości 1920x1080
	@Test
	public void successfulRegistration() throws Exception
	{
		String email = "kasia" + getRandom() + "@vp.pl";
		
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.findElement(By.cssSelector(".login")).click();
        driver.findElement(By.id("email_create")).clear();
        driver.findElement(By.id("email_create")).sendKeys(email);

        driver.findElement(By.id("SubmitCreate")).click();

        Thread.sleep(1000);
        assertEquals(false, driver.findElement(By.cssSelector("#create_account_error")).isDisplayed());

        driver.findElement(By.id("uniform-id_gender2")).click();
        assertEquals(true, driver.findElement(By.cssSelector("#id_gender2")).isSelected());

        driver.findElement(By.id("customer_firstname")).clear();
        driver.findElement(By.id("customer_firstname")).sendKeys("Kasia");
        assertNotNull(driver.findElement(By.id("customer_firstname")).getAttribute("value"));

        driver.findElement(By.id("customer_lastname")).clear();
        driver.findElement(By.id("customer_lastname")).sendKeys("Hawel");
        assertNotNull(driver.findElement(By.id("customer_lastname")).getAttribute("value"));

        assertNotNull(driver.findElement(By.id("email")).getAttribute("value"));

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys("abcdef");
        assertNotNull(driver.findElement(By.id("passwd")).getAttribute("value"));
        assertTrue(driver.findElement(By.id("passwd")).getAttribute("value").length()>=5 );

        driver.findElement(By.id("address1")).clear();
        driver.findElement(By.id("address1")).sendKeys("Kasztanowa 6c");
        assertNotNull(driver.findElement(By.id("address1")).getAttribute("value"));

        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("Malbork");
        assertNotNull(driver.findElement(By.id("city")).getAttribute("value"));

        driver.findElement(By.cssSelector("#id_state > option:nth-child(7)")).click();
        assertEquals("6", driver.findElement(By.id("id_state")).getAttribute("value"));

        driver.findElement(By.id("postcode")).clear();
        driver.findElement(By.id("postcode")).sendKeys("12345");
        assertNotNull(driver.findElement(By.id("postcode")).getAttribute("value"));
        assertTrue(driver.findElement(By.id("postcode")).getAttribute("value").length()==5);

        driver.findElement(By.cssSelector("#id_country > option:nth-child(2)")).click();
        assertEquals("21", driver.findElement(By.id("id_country")).getAttribute("value"));

        driver.findElement(By.id("phone_mobile")).clear();
        driver.findElement(By.id("phone_mobile")).sendKeys("123456789");
        assertNotNull(driver.findElement(By.id("phone_mobile")).getAttribute("value"));

        driver.findElement(By.id("submitAccount")).click();

        Thread.sleep(1000);
        if(driver.findElements(By.linkText("Sign out")).size() != 0) 
        {
            driver.findElement(By.linkText("Sign out")).click();
        }
        else
        {
        	assertTrue(false);
        }
	}

	// test nieudanej rejestracji przy rozdzielczości 480x800 - walidacja adresu email
	@Test
	public void unsuccessfulRegistration() throws Exception
	{
		String email = "kasia" + getRandom();
		
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().setSize(new Dimension(480, 800));
        driver.findElement(By.cssSelector(".login")).click();
        driver.findElement(By.id("email_create")).clear();
        driver.findElement(By.id("email_create")).sendKeys(email);

        driver.findElement(By.id("SubmitCreate")).click();
        
        Thread.sleep(2000);
        assertEquals(true, driver.findElement(By.cssSelector("#create_account_error")).isDisplayed());
	}
	
	// test udanego logowania
	@Test
	public void successfulLogin() throws Exception
	{
		driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.cssSelector(".login")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("kaha123@vp.pl");
        driver.findElement(By.id("passwd")).sendKeys("123456");
        driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
        
        Thread.sleep(1000);
        if(driver.findElements(By.linkText("Sign out")).size() != 0) 
        {
            driver.findElement(By.linkText("Sign out")).click();
        }
        else
        {
        	assertTrue(false);
        }
	}
	
	// test nieudanego logowania
	@Test
	public void unsuccessfulLogin() throws Exception
	{
		driver.get("http://automationpractice.com/index.php");
	    driver.findElement(By.cssSelector(".login")).click();
	    driver.findElement(By.id("email")).click();
	    driver.findElement(By.id("email")).sendKeys("kaha123@vp.pl");
	    driver.findElement(By.id("passwd")).sendKeys("123");
	    driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
	        
	    Thread.sleep(1000);
        assertEquals(true, driver.findElements(By.linkText("Sign out")).size() == 0);
        assertEquals("There is 1 error", driver.findElement(By.cssSelector("div.alert.alert-danger > p:nth-child(1)")).getText());
	}
	
	@After
	public void tearDown() throws Exception
	{
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString))
		{
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by)
	{
		try
		{
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e)
		{
			return false;
		}
	}

	private boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e)
		{
			return false;
		}
	}

	private String closeAlertAndGetItsText()
	{
		try
		{
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert)
			{
				alert.accept();
			} else
			{
				alert.dismiss();
			}
			return alertText;
		} 
		finally
		{
			acceptNextAlert = true;
		}
	}
}
