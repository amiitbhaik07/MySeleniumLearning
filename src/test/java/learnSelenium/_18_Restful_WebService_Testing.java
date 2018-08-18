package learnSelenium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.skyscreamer.jsonassert.JSONAssert;

public class _18_Restful_WebService_Testing
{
	public static void main(String args[]) throws Exception
	{
		long start = System.currentTimeMillis();
		final String credentialsFilePath = ".\\WebServiceFiles\\credentials.txt";
		final String payloadResponses = ".\\WebServiceFiles\\PayloadResponses.xlsx";
		String uname="",pwd="", requestUrl="";		
		FileInputStream fis = new FileInputStream(payloadResponses);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		fis.close();
		XSSFSheet sheet = workbook.getSheet("Responses");
		BufferedReader br = null;
		FileReader fr = null;
		int counterPass=0, counterFail=0;		
			
		//Read Username, Password and URL from credentials.txt
		try
		{
			fr = new FileReader(credentialsFilePath);
			br = new BufferedReader(fr);
			uname = br.readLine();
			pwd = br.readLine();
			requestUrl = br.readLine();
		}
		catch(Exception e){}
		br.close();
		fr.close();
		
		final String username = uname;
		final String password = pwd;
		
		//Authentication for getting response
		Authenticator.setDefault(new Authenticator()
		{
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() 
		    {          
		        return new PasswordAuthentication(username, password.toCharArray());
		    }
		});
		
		
		//Set Cell Styles for data to be stored in Excel
		XSSFCellStyle passStyle = workbook.createCellStyle();
		Font headerFont = workbook.createFont();
		headerFont.setColor(IndexedColors.WHITE.getIndex());
		passStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		passStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		passStyle.setFont(headerFont);
		XSSFCellStyle failStyle = workbook.createCellStyle();
		failStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		failStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		failStyle.setFont(headerFont);
		XSSFCellStyle normalStyle = workbook.createCellStyle();
		Font headerFont1 = workbook.createFont();
		headerFont1.setColor(IndexedColors.BLACK.getIndex());
		normalStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
		normalStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		normalStyle.setFont(headerFont);
		
		
		String jsonString="", request="", expectedResponse="";
		XSSFCell cell1,cell2,cell3;
		
		for(int i=0; i<sheet.getPhysicalNumberOfRows(); i++)
		{		
			request="";
			expectedResponse="";
			
			try
			{
				request = sheet.getRow(i).getCell(0).getStringCellValue().toString().trim();
			}
			catch(Exception e)
			{
				request = sheet.getRow(i).getCell(0).getRawValue().toString().trim();
			}			
			
			try
			{
				expectedResponse = sheet.getRow(i).getCell(1).getStringCellValue().trim();
			}
			catch(Exception e)
			{
				expectedResponse = sheet.getRow(i).getCell(1).getRawValue().trim();
			}
			
			try
			{
				cell3 = sheet.getRow(i).getCell(3);
				cell3.setCellStyle(normalStyle);
				cell3.setCellValue("");
			}
			catch(Exception e){}
			
			try
			{
				jsonString = sendPostRequest(requestUrl, request);
				try
				{
					JSONAssert.assertEquals(expectedResponse, jsonString, false);
				}
				catch(AssertionError e1)
				{
					throw new Exception(e1);
				}
				
				cell1 = sheet.getRow(i).createCell(2);
				cell1.setCellStyle(passStyle);
				cell1.setCellValue(jsonString);
				counterPass++;
			}
			catch(Exception e)
			{
				cell1 = sheet.getRow(i).createCell(2);
				cell1.setCellStyle(failStyle);
				cell1.setCellValue(jsonString);
				cell2 = sheet.getRow(i).createCell(3);
				cell2.setCellValue(e.getMessage());
				counterFail++;
			}
		}
		
		
		
		//Write this new Excel File in hard disk
		try
		{
			FileOutputStream out = new FileOutputStream(new File(payloadResponses));
			workbook.write(out);
			out.close();
			System.out.println("Success");	
		}
		catch(Exception e)
		{
			System.err.println("File already present");
			BufferedWriter out = new BufferedWriter(new FileWriter("filename"));
			out.write("aString1\n");
			out.close();
			boolean success = (new File("filename")).delete();
			if (success) {
				System.out.println("The file has been successfully deleted"); 
			}
		}		
		
		//Close Workbook and print success message
		long end = System.currentTimeMillis();
		float diff = ((float)(end-start)/(float)1000.0);
		System.out.println("Showing Message");
		JOptionPane.showMessageDialog(null, "Completed Successfully!\nTotal Payload Response Tested : " + (sheet.getPhysicalNumberOfRows()) + "\nTotal Success = '"+counterPass+"'\nTotal Failures = '"+counterFail+"'\nTotal Time elapsed : " + String.format("%.1f", diff) + " seconds", "Payload Generator", JOptionPane.INFORMATION_MESSAGE);
		System.out.println("Shown Message");
	}
	
	
	
	public static String sendPostRequest(String requestUrl, String payload) 
	{	
		StringBuffer jsonString = null;
		try 
		{
	        URL url = new URL(requestUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setDoInput(true);
	        connection.setDoOutput(true);
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Accept", "application/json");
	        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
	        writer.write(payload);
	        writer.close();
	        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        jsonString = new StringBuffer();
	        String line;
	        while ((line = br.readLine()) != null) 
	        {
	        	jsonString.append(line);
	        }
	        br.close();
	        connection.disconnect();
	    } 
		catch (Exception e) 
		{
	        throw new RuntimeException(e.getMessage());
	    }
	    return jsonString.toString();
	}
}
