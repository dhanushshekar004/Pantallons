package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Required_Data extends toStoreAllTheData {
	public static String URL = "https://test-apigate.abfrl.in/";
	public String fcmToken = "asdfasda";
	public String shopId = "1";
	public String deviceId = "1234565432";
	public String deviceApp = "edfd";
	public String hash = "HASH";
	public String deviceToken = "a69c4ac4a0594b5925e17ffa07a44462.1705043310";
	public String deviceType = "dasa";
	public long a = 50;
	public boolean trueflag = true;
	public boolean falseflag = false;
	public static String gmtTime;
public static String sheetName="cityName";
public static int cityNamecolumanIndex=0;
public static int pintcode=1;
	// @Test
	public static void dateAndTime() {

		/*
		 * // Create a LocalDateTime in IST LocalDateTime istDateTime =
		 * LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
		 * 
		 * // Convert LocalDateTime to ZonedDateTime in IST ZonedDateTime
		 * istZonedDateTime = istDateTime.atZone(ZoneId.of("Asia/Kolkata"));
		 * 
		 * // Convert ZonedDateTime to GMT ZonedDateTime gmtZonedDateTime =
		 * istZonedDateTime.withZoneSameInstant(ZoneId.of("GMT"));
		 * 
		 * // Format the date and time in GMT DateTimeFormatter formatter =
		 * DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); String gmtDateTimeString
		 * = gmtZonedDateTime.format(formatter);
		 * 
		 * System.out.println("IST Date and Time: " + istDateTime);
		 * System.out.println("GMT Date and Time: " + gmtDateTimeString); }
		 */

		LocalDateTime ist = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
		ZonedDateTime fgg = ist.atZone(ZoneId.of("Asia/Kolkata"));
		ZonedDateTime hjk = fgg.withZoneSameInstant(ZoneId.of("GMT"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		gmtTime = hjk.format(formatter);

		System.out.println(gmtTime);
	}

	public static LinkedHashMap<String, String> getDataFromExcel(String excelPath, String sheetName, String uniqueData,
			boolean isTableVertical) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook work = WorkbookFactory.create(fis);

		DataFormatter df = new DataFormatter();
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		Sheet sheetname = work.getSheet(sheetName);

		int rowindex = sheetname.getLastRowNum();
		String value = "";
		String actualTestCaseName = "";
		String actualKey = "";
		// For Horizontal Data Featching In Key Value Pair
		if (isTableVertical == false) {
			for (int i = 0; i <= rowindex; i++) {
				String actualTestcase = df.formatCellValue(sheetname.getRow(i).getCell(0));
				if (actualTestcase.equals(uniqueData)) {
					short lastcellNumber = sheetname.getRow(i).getLastCellNum(); // return count/size ==> count-1
					for (int j = 1; j < lastcellNumber - 1; j++) {
						actualKey = df.formatCellValue(sheetname.getRow(i - 1).getCell(j));
						value = df.formatCellValue(sheetname.getRow(i).getCell(j));
						map.put(actualKey, value);
					}
					break;
				}
			}
		}

		// For Vertical Data Featching In Key Value Pair
		else if (isTableVertical == true) {
			for (int i = 1; i <= sheetname.getRow(i).getLastCellNum(); i++) {

				try {
					actualTestCaseName = df.formatCellValue(sheetname.getRow(0).getCell(i));

				} catch (Exception e) {
				}
				if (actualTestCaseName.equalsIgnoreCase(uniqueData)) {
					for (int j = 0; j <= sheetname.getLastRowNum(); j++) {

						try {
							actualKey = df.formatCellValue(sheetname.getRow(j).getCell(i - 1));
							try {
								value = df.formatCellValue(sheetname.getRow(j).getCell(i));
							} catch (Exception e) {
							}

							if ((actualKey.isEmpty() && value.isEmpty()) || actualKey.isEmpty()) {
							} else {
								map.put(actualKey, value);
							}
						} catch (Exception e) {
						}
					}
					break;
				}
			}


		}
		return map;

	}
	
	
	public List<String> addlist(String data) {
		List<String> actualdata=new ArrayList<>();
				actualdata.add(data);
				return actualdata;
	}
	
	public List<String> addcityName(int columnindex) throws EncryptedDocumentException, IOException {
		FileInputStream ips = new FileInputStream("C:\\Users\\Dhanush S\\Downloads\\cityName.xlsx");
		Workbook work = WorkbookFactory.create(ips);
		Sheet sheet = work.getSheet(sheetName);
		int rowNum = sheet.getLastRowNum();
		List<String>CityName=new ArrayList<>();
		
		for (int i = 1; i < rowNum;  i++)
		{
			String data=sheet.getRow(i).getCell(columnindex).getStringCellValue();
				CityName.add(data);	 
	}
	
		work.close();
		ips.close();
		return CityName;
		}
	
	
}
