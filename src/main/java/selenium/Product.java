package selenium;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;
import java.lang.*;

public class Product {
	
	String name;
	double price;
	double xprice;
	BufferedImage pic;
	double dif;
	String category;
	String URL;
	
	public Product (String Name, double Price, double XP, BufferedImage picture, String ctgry, String url)
	{
		name=Name;
		price = Price;
		xprice= XP;
		pic = picture;
		dif = xprice - price;
		category = ctgry;
		URL = url;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getPrice()
	{
		return price;
	}
	public double getXprice()
	{
		return xprice;
	}
	
	public double getDif()
	{
		return dif;
	}
	public BufferedImage getPic()
	{
		return pic;
	}
	public String getCategory()
	{
		return category;
	}
	
	public String getURL()
	{
		return URL;
	}

	
//	public Product (List<String> Names, List<String> Prices, List<String> XPs, List<Image> pictures)
//	{
//		for(String n : Names)
//		{
//			name = n;
//		}
//		
//		for(String p : Prices)
//		{
//			price = Integer.parseInt(p.replaceAll("[^\\d.]", ""));
//		}
//		
//		for(String xp : XPs)
//		{
//			xprice = Integer.parseInt(xp.replaceAll("[^\\d.]", ""));
//		}
//		
//		for(String p : pictures)
//		{
//			pic = p;
//		}
//		for(int i=0; i<Prices.size(); i++)
//		{
//			
//		}
//	}
}
