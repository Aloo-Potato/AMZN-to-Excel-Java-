
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.image.BufferedImage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.api.services.sheets.*;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import selenium.ImageResize;
import selenium.Product;
import selenium.Search;

//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.googleapis.auth.oauth2.*;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.client.extensions.*;

import org.apache.poi.*;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.ClientAnchor.AnchorType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressBase;
import org.apache.poi.ss.util.CellRangeAddressBase.CellPosition;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Executer {
	
	public static Sheets sheetsService;
	public static String sheetID = "1EJ63E5TWgqFb4jC6_EGPWfx0ae1nU04KZFImILoWPEw";
	
	public static String pricesXpath = "//span[@data-a-strike=\"true\" or contains(@class,\"text-strike\")][.//text()]/preceding::span[@class][3]";
	public static String XpricesXpath = "//span[@data-a-strike=\"true\" or contains(@class,\"text-strike\")][.//text()]";
	public static String namesXpath = "//span[@data-a-strike=\"true\" or contains(@class,\"text-strike\")][.//text()]/preceding::span[@class][10]";
	public static String picURLsXpath = "//span[@data-a-strike=\"true\" or contains(@class,\"text-strike\")][.//text()]/preceding::img[@src][1]";
	public static String dealURLsXpath = "//span[@data-a-strike=\"true\" or contains(@class,\"text-strike\")][.//text()]/parent::a[@class]";
	
	//Initialize Lists
	public static List<Product> products = new ArrayList<Product>();
	public static List<String> prices = new ArrayList<String>();
	public static List<String> names = new ArrayList<String>();
	public static List<String> Xprices = new ArrayList<String>();
	public static List<String> picURLs = new ArrayList<String>();
	public static List<BufferedImage> pics = new ArrayList<BufferedImage>();
	public static List<String> URLs = new ArrayList<String>();
	public static String listingsURL;

	public static int time = 250;
		
	public static void main(String[] args) throws InterruptedException, IOException
	{		
		//Initialize Browser
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\email\\eclipse-workspace\\ChromeDriver 81\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Excel.ClearExcel();
		
		//Grab Data
		getInfo(driver, "Laptops");
		getInfo(driver, "Desktops");
		getInfo(driver, "PC Gaming");
		getInfo(driver, "Monitors");
		getInfo(driver, "Computer Accessories");
		getInfo(driver, "Networking");
		getInfo(driver, "Computer Components");
		getInfo(driver, "Storage");
		getInfo(driver, "TV & Video");
		getInfo(driver, "Cell Phones & Accessories");
		getInfo(driver, "Speakers");
		getInfo(driver, "Headphones");
		getInfo(driver, "Bluetooth Earbuds");

		
		products = removeDuplicates(products);
		
		Excel.writeExcel(products);

		
		showdata(prices);
		System.out.println("Names: " + names.size());
		System.out.println("Prices: " + prices.size());
		System.out.println("Xprices: " + Xprices.size());
		System.out.println("picURLs: " + picURLs.size());
		System.out.println("Pics: " + pics.size());
		System.out.println("URLs: " + URLs.size());
		System.out.println("Products: " + products.size());
		
        try {
			Desktop.getDesktop().open(new File("C:\\Users\\email\\Desktop\\test.xlsx"));
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		driver.close(); 
		driver.quit();
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void getInfo(WebDriver driver, String category) throws InterruptedException
	{
		if(category == "Laptops")
		{
			Search.searchLaptop(driver);
		}
		else if(category == "Desktops")
		{
			Search.searchDesktop(driver);
		}
		else if(category == "PC Gaming")
		{
			Search.searchPCGaming(driver);
		}
		else if(category == "Monitors")
		{
			Search.searchMonitors(driver);
		}
		else if(category == "Tablets")
		{
			Search.searchTablets(driver);
		}
		else if(category == "Computer Accessories")
		{
			Search.searchComputerAccessories(driver);
		}
		else if(category == "Networking")
		{
			Search.searchNetworking(driver);
		}
		else if(category == "Computer Components")
		{
			Search.searchComputerComponents(driver);
		}
		else if(category == "Storage")
		{
			Search.searchStorage(driver);
		}
		else if(category == "TV & Video")
		{
			Search.searchTV(driver);
		}
		else if(category == "Cell Phones & Accessories")
		{
			Search.searchCellAccessories(driver);
		}
		else if(category == "Speakers")
		{
			Search.searchBluetoothSpeakers(driver);
		}
		else if(category == "Headphones")
		{
			Search.searchHeadphones(driver);
		}
		else if(category == "Bluetooth Earbuds")
		{
			Search.searchBluetoothBuds(driver);
		}
		else
		{
			System.out.println("Category not found");
		}
		//Grabs data for each deal and updates Products List directly
		listingsURL = driver.getCurrentUrl();
		updateURLsList(driver);
		grabData(driver, URLs, category);
		URLs.clear();
		driver.get(listingsURL);
		
		driver.findElement(By.xpath("//a [contains(@href,'pg_2')]")).click();
		Thread.sleep(time);
		
		listingsURL = driver.getCurrentUrl();
		updateURLsList(driver);
		grabData(driver, URLs, category);
		URLs.clear();
		driver.get(listingsURL);
		
		driver.findElement(By.xpath("//a [contains(@href,'pg_3')]")).click();
		Thread.sleep(time);
		
		listingsURL = driver.getCurrentUrl();
		updateURLsList(driver);
		grabData(driver, URLs, category);
		URLs.clear();
		driver.get(listingsURL);
	}
	
	public static void updateURLsList(WebDriver driver) throws InterruptedException
	{
		//list of deals on amazon page
		List<WebElement> deals = driver.findElements(By.xpath(dealURLsXpath));
		System.out.println("Deals Size: " + deals.size());
		for(WebElement element : deals)
		{
			Thread.sleep(time);
			URLs.add(element.getAttribute("href"));
		}
		System.out.println("URL List size: " + URLs.size());
		deals.clear();
	}
	
	public static void grabData(WebDriver driver, List<String> URLs, String category) throws InterruptedException
	{
		for(String url : URLs)
		{
			driver.get(url);
			Thread.sleep(time);
			//TODO check to make sure sale is on amazon page as well as listings page
			if(driver.findElements(By.xpath("//span [@id = \"productTitle\"]")).size() == 0 || driver.findElements(By.xpath("//span [@class = \"priceBlockStrikePriceString a-text-strike\"]")).size() ==0 || driver.findElements(By.xpath("//span [@id = \"priceblock_ourprice\"]")).size() ==0 )
			{
				System.out.println("Something missing in listing. Skipped");
				return;
			}
			String name = driver.findElement(By.xpath("//span [@id = \"productTitle\"]")).getText();
			System.out.println("Name: " + name);
			String StrPrice = driver.findElement(By.xpath("//span [@id = \"priceblock_ourprice\"]")).getText();
			System.out.println("price: " + StrPrice);
			String StrXprice = driver.findElement(By.xpath("//span [@class = \"priceBlockStrikePriceString a-text-strike\"]")).getText();
			System.out.println("Xprice: " + StrXprice);
			String picURL = driver.findElement(By.xpath("//img [@data-old-hires]")).getAttribute("src");
			System.out.println("picURL: " + picURL);
			
			BufferedImage img;
			
			System.out.println("URL: " + url);
			
			double price = Math.round(Double.parseDouble(StrPrice.replace("$", "").replace(",", "")));
			System.out.println("Int Price: " + price);
			double Xprice = Math.round(Double.parseDouble(StrXprice.replace("$", "").replace(",", "")));
			System.out.println("Int Xprice: " + Xprice);
			
			System.out.println("Percent of original price: " + (price/Xprice));
			if(price/Xprice > 0.9)
			{
				return;
			}
			
			try
			{
				img = ImageIO.read(new URL(picURL));
				products.add(new Product(
						name, 
						price, 
						Xprice, 
						img, 
						category, 
						url));
			}
			catch(IOException e)
			{
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
	
	// Function to remove duplicates from an ArrayList 
    public static List<Product> removeDuplicates(List<Product> list) 
    { 
    	int count = 0;
        // Create a new ArrayList 
        ArrayList<Product> newList = new ArrayList<Product>(); 
  
        // Traverse through the first list 
        for (Product element : list) { 
  
            // If this element is not present in newList 
            // then add it 
            if (!newList.contains(element)) { 
  
                newList.add(element); 
            } 
            else
            {
            	count++;
            }
        } 
        System.out.println(count + "removed from Products list");
        // return the new list 
        return newList; 
    } 
	
	//prints everything in the list to the console
	public static void showdata(List<String> list)
	{
		for (String str : list)
		{
			System.out.println(str.replace("$", ""));
		}
	}
	
	
}
