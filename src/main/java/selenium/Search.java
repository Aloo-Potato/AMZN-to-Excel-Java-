package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search {
	
	public static int time = 500;
	
	public static void searchBluetoothBuds(WebDriver driver) throws InterruptedException
	{
		//Goto PCGaming page 1
		driver.get("https://amazon.com");
		
		//Search Electronics
		driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
		driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
		Thread.sleep(time);
		
		//retry Search Headphones
		if(driver.findElements(By.xpath("//img [@alt = \"Headphones\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
			Thread.sleep(time);
			driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"Headphones\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"Headphones\"]")).click();
			Thread.sleep(time);
		}
		
		//retry Search OverEar
		if(driver.findElements(By.xpath("//img [@alt = \"In Ear Earbuds\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//img [@alt = \"Headphones\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"In Ear Earbuds\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"In Ear Earbuds\"]")).click();
			Thread.sleep(time);
		}
		
		//Switcheroo featured and price low to high pages to get amazon page format correct and readable
		driver.findElement(By.xpath("//select [@class = \"a-spacing-top-mini\"]")).click();
		driver.findElement(By.xpath("//option [@value = \"price-asc-rank\"]")).click();
		Thread.sleep(time);
		driver.findElement(By.xpath("//span [@class = \"a-dropdown-prompt\"]")).click();
		driver.findElement(By.xpath("//option [@value = \"featured-rank\"]")).click();	
		Thread.sleep(time);
		}
	
	public static void searchHeadphones(WebDriver driver) throws InterruptedException
	{
		//Goto PCGaming page 1
		driver.get("https://amazon.com");
		
		//Search Electronics
		driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
		driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
		Thread.sleep(time);
		
		//retry Search Headphones
		if(driver.findElements(By.xpath("//img [@alt = \"Headphones\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
			Thread.sleep(time);
			driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"Headphones\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"Headphones\"]")).click();
			Thread.sleep(time);
		}
		
		//retry Search OverEar
		if(driver.findElements(By.xpath("//img [@alt = \"Over Ear Headphones\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//img [@alt = \"Headphones\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"Over Ear Headphones\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"Over Ear Headphones\"]")).click();
			Thread.sleep(time);
		}
		
		//Switcheroo featured and price low to high pages to get amazon page format correct and readable
		driver.findElement(By.xpath("//select [@class = \"a-spacing-top-mini\"]")).click();
		driver.findElement(By.xpath("//option [@value = \"price-asc-rank\"]")).click();
		Thread.sleep(time);
		driver.findElement(By.xpath("//span [@class = \"a-dropdown-prompt\"]")).click();
		driver.findElement(By.xpath("//option [@value = \"featured-rank\"]")).click();	
		Thread.sleep(time);
		}
	
	public static void searchBluetoothSpeakers(WebDriver driver) throws InterruptedException
	{
		//Goto PCGaming page 1
		driver.get("https://amazon.com");
		
		//Search Electronics
		driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
		driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
		Thread.sleep(time);
		
		//retry Search Electronics
		if(driver.findElements(By.xpath("//img [@alt = \"Home Audio\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
			Thread.sleep(time);
			driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"Home Audio\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"Home Audio\"]")).click();
			Thread.sleep(time);
		}
		
		//retry Search Wireless audio
		if(driver.findElements(By.xpath("//img [@alt = \"Wireless Audio\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//img [@alt = \"Home Audio\"]")).click();;
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"Wireless Audio\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"Wireless Audio\"]")).click();
			Thread.sleep(time);
		}
		
		//Try toprated
		if(driver.findElements(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//img [@alt = \"Wireless Audio\"]")).click();
			Thread.sleep(time);
			try
			{
				driver.findElement(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).click();

			}catch(Exception e)
			{
				//Switcheroo featured and price low to high pages to get amazon page format correct and readable
				driver.findElement(By.xpath("//select [@class = \"a-spacing-top-mini\"]")).click();
				driver.findElement(By.xpath("//option [@value = \"price-asc-rank\"]")).click();
				Thread.sleep(time);
				driver.findElement(By.xpath("//span [@class = \"a-dropdown-prompt\"]")).click();
				driver.findElement(By.xpath("//option [@value = \"featured-rank\"]")).click();	
				Thread.sleep(time);
			}
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).click();
			Thread.sleep(time);
		}
	}
	
	public static void searchCellAccessories(WebDriver driver) throws InterruptedException
	{
		//Goto PCGaming page 1
		driver.get("https://amazon.com");
		
		//Search Electronics
		driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
		driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
		Thread.sleep(time);
		
		//retry Search Electronics
		if(driver.findElements(By.xpath("//img [@alt = \"Cell Phones & Accessories\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
			Thread.sleep(time);
			driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"Cell Phones & Accessories\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"Cell Phones & Accessories\"]")).click();
			Thread.sleep(time);
		}
		
		//Try toprated
		if(driver.findElements(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//img [@alt = \\\"Cell Phones & Accessories\\\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).click();
			Thread.sleep(time);
		}
	}
	
	public static void searchTV(WebDriver driver) throws InterruptedException
	{
		//Goto PCGaming page 1
		driver.get("https://amazon.com");
		
		//Search Electronics
		driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
		driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
		Thread.sleep(time);
		
		//retry Search Electronics
		if(driver.findElements(By.xpath("//img [@alt = \"TV & Video\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
			Thread.sleep(time);
			driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"TV & Video\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"TV & Video\"]")).click();
			Thread.sleep(time);
		}
		
		//Try toprated
		if(driver.findElements(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//img [@alt = \\\"TV & Video\\\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).click();
			Thread.sleep(time);
		}
	}
	
	public static void searchStorage(WebDriver driver) throws InterruptedException
	{
		//Goto PCGaming page 1
		driver.get("https://amazon.com");
		
		//Search Electronics
		driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
		driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
		Thread.sleep(time);
		
		//retry Search Electronics
		if(driver.findElements(By.xpath("//img [@alt = \"Computers & Accessories\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
			Thread.sleep(time);
			driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		
		//Computers and Accessories button
		if(driver.findElements(By.xpath("//a [@aria-label = \"###**Storage &amp; Hard Drives**\"]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//a [@aria-label = \"###**Storage &amp; Hard Drives**\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//a [@aria-label = \"###**Storage &amp; Hard Drives**\"]")).click();
			Thread.sleep(time);
		}
		
		//Try toprated
		if(driver.findElements(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//a [@aria-label = \"###**Storage &amp; Hard Drives**\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//span[contains(text(),\"See more\")]")).click();
			Thread.sleep(time);
		}
	}
	
	public static void searchComputerComponents(WebDriver driver) throws InterruptedException
	{
		//Goto PCGaming page 1
		driver.get("https://amazon.com");
		
		//Search Electronics
		driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
		driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
		Thread.sleep(time);
		
		//retry Search Electronics
		if(driver.findElements(By.xpath("//img [@alt = \"Computers & Accessories\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
			Thread.sleep(time);
			driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		
		//Computers and Accessories button
		if(driver.findElements(By.xpath("//a [@aria-label = \"###**Computer Components**\"]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//a [@aria-label = \"###**Computer Components**\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//a [@aria-label = \"###**Computer Components**\"]")).click();
			Thread.sleep(time);
		}
		
		//Try toprated
		if(driver.findElements(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//a [@aria-label = \"###**Computer Components**\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//span[contains(text(),\"See more\")]")).click();
			Thread.sleep(time);
		}
	}
	
	public static void searchNetworking(WebDriver driver) throws InterruptedException
	{
		//Goto PCGaming page 1
		driver.get("https://amazon.com");
		
		//Search Electronics
		driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
		driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
		Thread.sleep(time);
		
		//retry Search Electronics
		if(driver.findElements(By.xpath("//img [@alt = \"Computers & Accessories\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
			Thread.sleep(time);
			driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		
		//Computers and Accessories button
		if(driver.findElements(By.xpath("//a [@aria-label = \"###**Networking**\"]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//a [@aria-label = \"###**Networking**\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//a [@aria-label = \"###**Networking**\"]")).click();
			Thread.sleep(time);
		}
		
		//Try toprated
		if(driver.findElements(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//a [@aria-label = \"###**Networking**\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//span[contains(text(),\"See more\")]")).click();
			Thread.sleep(time);
		}
	}
	
	public static void searchComputerAccessories(WebDriver driver) throws InterruptedException
	{
		//Goto PCGaming page 1
		driver.get("https://amazon.com");
		
		//Search Electronics
		driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
		driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
		Thread.sleep(time);
		
		//retry Search Electronics
		if(driver.findElements(By.xpath("//img [@alt = \"Computers & Accessories\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
			Thread.sleep(time);
			driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		
		//Computers and Accessories button
		if(driver.findElements(By.xpath("//a [@aria-label = \"###**Computer Accessories**\"]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//a [@aria-label = \"###**Computer Accessories**\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//a [@aria-label = \"###**Computer Accessories**\"]")).click();
			Thread.sleep(time);
		}
		
		//Try toprated
		if(driver.findElements(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//a [@aria-label = \"###**Computer Accessories**\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//span[contains(text(),\"See more\")]")).click();
			Thread.sleep(time);
		}
	}
	
	public static void searchTablets(WebDriver driver) throws InterruptedException
	{
		//Goto PCGaming page 1
		driver.get("https://amazon.com");
		
		//Search Electronics
		driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
		driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
		Thread.sleep(time);
		
		//retry Search Electronics
		if(driver.findElements(By.xpath("//img [@alt = \"Computers & Accessories\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
			Thread.sleep(time);
			driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		
		//Computers and Accessories button
		if(driver.findElements(By.xpath("//a [@aria-label = \"###**Tablets**\"]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//a [@aria-label = \"###**Tablets**\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//a [@aria-label = \"###**Tablets**\"]")).click();
			Thread.sleep(time);
		}
		
		//Try toprated
		if(driver.findElements(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//a [@aria-label = \"###**Tablets**\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//span[contains(text(),\"See more\")]")).click();
			Thread.sleep(time);
		}
	}
	
	public static void searchMonitors(WebDriver driver) throws InterruptedException
	{
		//Goto  page 1
		driver.get("https://amazon.com");
		
		//Search 
		driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
		driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
		Thread.sleep(time);
		
		//retry Search 
		if(driver.findElements(By.xpath("//img [@alt = \"Computers & Accessories\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
			Thread.sleep(time);
			driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		
		//Computers and Accessories button
		if(driver.findElements(By.xpath("//a [@aria-label = \"###**Monitors**\"]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//a [@aria-label = \"###**Monitors**\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//a [@aria-label = \"###**Monitors**\"]")).click();
			Thread.sleep(time);
		}
		
		//Try toprated
		if(driver.findElements(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//a [@aria-label = \"###**Monitors**\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//span[contains(text(),\"See more\")]")).click();
			Thread.sleep(time);
		}
	}
	
	public static void searchPCGaming(WebDriver driver) throws InterruptedException
	{
		//Goto PCGaming page 1
		driver.get("https://amazon.com");
		
		//Search Electronics
		driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
		driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
		Thread.sleep(time);
		
		//retry Search Electronics
		if(driver.findElements(By.xpath("//img [@alt = \"Computers & Accessories\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
			Thread.sleep(time);
			driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		
		//Computers and Accessories button
		if(driver.findElements(By.xpath("//a [@aria-label = \"###**PC Gaming**\"]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//a [@aria-label = \"###**PC Gaming**\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//a [@aria-label = \"###**PC Gaming**\"]")).click();
			Thread.sleep(time);
		}
		
		//Try toprated
		if(driver.findElements(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//a [@aria-label = \"###**PC Gaming**\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//span[contains(text(),\"See more\")]")).click();
			Thread.sleep(time);
		}
	}
	
	public static void searchDesktop(WebDriver driver) throws InterruptedException
	{
		//Goto Desktop page 1
		driver.get("https://amazon.com");
		
		//Search Electronics
		driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
		driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
		Thread.sleep(time);
		
		//retry Search Electronics
		if(driver.findElements(By.xpath("//img [@alt = \"Computers & Accessories\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
			Thread.sleep(time);
			driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		
		//Computers and Accessories button
		if(driver.findElements(By.xpath("//a [@aria-label = \"###**Desktops**\"]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//a [@aria-label = \"###**Desktops**\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//a [@aria-label = \"###**Desktops**\"]")).click();
			Thread.sleep(time);
		}
		
		//Try toprated
		if(driver.findElements(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//a [@aria-label = \"###**Desktops**\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//span[contains(text(),\"See more\")]")).click();
			Thread.sleep(time);
		}		
	}
	
	public static void searchLaptop(WebDriver driver) throws InterruptedException
	{
		//Goto Desktop page 1
		driver.get("https://amazon.com");
		
		//Search Electronics
		driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
		driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
		Thread.sleep(time);
		
		//retry Search Electronics
		if(driver.findElements(By.xpath("//img [@alt = \"Computers & Accessories\"]")).size()==0)
		{
			driver.navigate().back();
			driver.findElement(By.xpath("//option [@value = \"search-alias=electronics\"]")).click();;
			driver.findElement(By.xpath("//input [@type = \"submit\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
		}
		
		//Computers and Accessories button
		if(driver.findElements(By.xpath("//a [@aria-label = \"###**Laptops**\"]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//img [@alt = \"Computers & Accessories\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//a [@aria-label = \"###**Laptops**\"]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//a [@aria-label = \"###**Laptops**\"]")).click();
			Thread.sleep(time);
		}
		
		//Try toprated
		if(driver.findElements(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).size()==0)
		{
			//if page not correct
			driver.navigate().back();
			driver.findElement(By.xpath("//a [@aria-label = \"###**Laptops**\"]")).click();
			Thread.sleep(time);
			driver.findElement(By.xpath("//span[contains(text(),'Top rated')]//parent::div[@class = 'a-section octopus-pc-card-title']//a[@class = 'a-link-normal']//span[contains(text(),'See more')]")).click();
			Thread.sleep(time);
		}
		else
		{
			//Click on Computers and Accessories button
			driver.findElement(By.xpath("//span[contains(text(),\"See more\")]")).click();
			Thread.sleep(time);
		}	
	}
	
}
