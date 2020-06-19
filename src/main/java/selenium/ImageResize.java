package selenium;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImageResize 
{
	// set padding between picture and gridlines so gridlines would not covered by the picture
	private static final double PADDING_SIZE = 10;
	private static final int PADDING = Units.toEMU(PADDING_SIZE);

	/**
	 * Draw Image inside specific cell
	 *
	 * @param wb workbook
	 * @param sheet sheet
	 * @param cellW cell width in pixels
	 * @param cellH cell height in pixels
	 * @param imgPath image path
	 * @param col the column (0 based) of the first cell.
	 * @param row the row (0 based) of the first cell.
	 * @param colSize the column size of cell
	 * @param rowSize the row size of cell
	 */
	public static void drawImageInCell(Workbook wb, org.apache.poi.ss.usermodel.Sheet sheet, int cellW, int cellH, BufferedImage img, int col, int row, int colSize, int rowSize) throws IOException 
	{
//	    int[] anchorArray = calCellAnchor(Units.pixelToPoints(cellW), Units.pixelToPoints(cellH), img.getWidth(), img.getHeight());
//	    CreationHelper helper = wb.getCreationHelper();
//	    ClientAnchor anchor = helper.createClientAnchor(anchorArray[0], anchorArray[1], anchorArray[2], anchorArray[3], (short) col, row, (short) (col + colSize), row + rowSize);
//	    
//	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
//	    ImageIO.write(img, "jpeg", bos );
//	    byte [] data = bos.toByteArray();
//	    
//	    int index = wb.addPicture(data, XSSFWorkbook.PICTURE_TYPE_JPEG);
//	    sheet.createDrawingPatriarch().createPicture(anchor, index);
	}

	/**
	 * calculate POI cell anchor
	 *
	 * @param cellX cell width in excel points
	 * @param cellY cell height in excel points
	 * @param imgX image width
	 * @param imgY image height
	 */
	public static int[] calCellAnchor(double cellX, double cellY, int imgX, int imgY) {
	    // assume Y has fixed padding first
	    return calCoordinate(true, cellX, cellY, imgX, imgY);
	}

	/**
	 * calculate cell coordinate
	 *
	 * @param fixTop is Y has fixed padding
	 */
	private static int[] calCoordinate(boolean fixTop, double cellX, double cellY, int imgX, int imgY) {
	    double ratio = ((double) imgX) / imgY;
	    int x = (int) Math.round(Units.toEMU(cellY - 2 * PADDING_SIZE) * ratio);
	    x = (Units.toEMU(cellX) - x) / 2;
	    if (x < PADDING) {
	        return calCoordinate(false, cellY, cellX, imgY, imgX);
	    }
	    return calDirection(fixTop, x);
	}

	/**
	 * calculate X's direction
	 *
	 * @param fixTop is Y has fixed padding
	 * @param x X's padding
	 */
	private static int[] calDirection(boolean fixTop, int x) {
	    if (fixTop) {
	        return new int[] { x, PADDING, -x, -PADDING };
	    } else {
	        return new int[] { PADDING, x, -PADDING, -x };
	    }
	}
	
	public static int cmToPx(double cm) {
	    return (int) Math.round(cm * 166 / 2.54D);
	}
	
	public static int cmToH(double cm) {
	    return (int) (Units.pixelToPoints(cmToPx(cm)) * 20); //POI's Units
	}
	
	public static int cmToW(double cm) {
	    return (int) Math.round(((cmToPx(cm) - 5.0D) / 8 * 7 + 5) / 7 * 256);
	}
}
