import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.ClientAnchor.AnchorType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import selenium.Product;

public class Excel 
{
	
	public static void writeExcel(List<Product> products) throws IOException
	{
		Workbook workbook = new XSSFWorkbook();
		 
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Products");
		sheet.setColumnWidth(0, 6000);
		
		Row header = sheet.createRow(0);
		 
		Cell headerCell = header.createCell(0);
		headerCell.setCellValue("Name");
		 
		headerCell = header.createCell(1);
		headerCell.setCellValue("Price");
		
		headerCell = header.createCell(2);
		headerCell.setCellValue("Old Price");
		
		headerCell = header.createCell(3);
		headerCell.setCellValue("Difference");
		
		headerCell = header.createCell(4);
		headerCell.setCellValue("Category");
		
		headerCell = header.createCell(5);
		headerCell.setCellValue("Picture");
		
		headerCell = header.createCell(6);
		headerCell.setCellValue("URL");
		
		
		int rowcount = 1;
		List<Row> rows = new ArrayList<Row>();
		rows.add(header);
		for(Product product : products)
		{
			
			
			rows.add(sheet.createRow(rowcount));
			rows.get(rowcount).createCell(0).setCellValue(product.getName());
			rows.get(rowcount).createCell(1).setCellValue(product.getPrice());
			rows.get(rowcount).createCell(2).setCellValue(product.getXprice());
			rows.get(rowcount).createCell(3).setCellValue(product.getDif());
			rows.get(rowcount).createCell(4).setCellValue(product.getCategory());
			rows.get(rowcount).createCell(5);
			rows.get(rowcount).createCell(6).setCellValue(product.getURL());
			rows.get(rowcount).setHeightInPoints(100);
			
			
		    ByteArrayOutputStream bos = new ByteArrayOutputStream();
		    ImageIO.write(product.getPic(), "jpeg", bos );
		    byte [] data = bos.toByteArray();
		    int pictureIndex = workbook.addPicture(data, Workbook.PICTURE_TYPE_JPEG);

		    CreationHelper helper = workbook.getCreationHelper();
		    Drawing drawingPatriarch = sheet.createDrawingPatriarch();
		    ClientAnchor anchor = helper.createClientAnchor();
		    anchor.setAnchorType(AnchorType.MOVE_AND_RESIZE);

		    //ImageResize.drawImageInCell(workbook, sheet, ImageResize.cmToPx(5), ImageResize.cmToH(3), product.getPic(), 5, rowcount, 4, rowcount+1);
		    anchor.setCol1(5);
		    anchor.setRow1(rowcount);
		    Picture pict = drawingPatriarch.createPicture(anchor, pictureIndex);
		    pict.resize(1);

		    try {
		        FileOutputStream out = new FileOutputStream("C:\\Users\\email\\Desktop\\test.xlsx");
		        workbook.write(out);
		        out.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
			
			rowcount++;
			
		}
	}
	
	//Clear Excel
	public static void ClearExcel() 
	{
		try
		{
			FileInputStream file = new FileInputStream(new File("C:\\Users\\email\\Desktop\\test.xlsx"));
			Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) 
            {
               sheet.removeRow(row);
            }
            
	        FileOutputStream out = new FileOutputStream("C:\\Users\\email\\Desktop\\test.xlsx");
	        workbook.write(out);
	        out.close();

            file.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
