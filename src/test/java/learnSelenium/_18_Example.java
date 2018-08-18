package learnSelenium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.skyscreamer.jsonassert.JSONAssert;

public class _18_Example
{
	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws Exception
	{	
		try
		{
	        String current = System.getProperty("user.dir");
	        _18_Example.log(current);
			
			long start = System.currentTimeMillis();
			/*final String credentialsFilePath = "C:\\GeneratePayloadResponsesFromRequests\\credentials.txt";
			final String payloadRequestPath = "C:\\GeneratePayloadResponsesFromRequests\\RW_Payloads\\PayloadRequests\\";
			final String payloadActualResponsePath = "C:\\GeneratePayloadResponsesFromRequests\\RW_Payloads\\PayloadActualResponses\\";
			final String payloadExpectedResponsePath = "C:\\GeneratePayloadResponsesFromRequests\\RW_Payloads\\PayloadExpectedResponses\\";
			final String payloadResponses = "C:\\GeneratePayloadResponsesFromRequests\\RW_Payloads\\PayloadResponses_RW.xlsx";*/
			
			final String credentialsFilePath = current+"\\credentials.txt";
			final String payloadRequestPath = current+"\\PayloadRequests\\";
			final String payloadActualResponsePath = current+"\\PayloadActualResponses\\";
			final String payloadExpectedResponsePath = current+"\\PayloadExpectedResponses\\";
			final String payloadResponses = current+"\\PayloadResponses_RW.xlsx";
			
			
			String uname="",pwd="", requestUrl="";		
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Responses");
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
			_18_Example.log(uname+" / "+pwd);
			
			//System.out.println(username);
			//System.out.println(password);
			
			//Authentication for getting response
			Authenticator.setDefault(new Authenticator() 
			{
			    @Override
			    protected PasswordAuthentication getPasswordAuthentication() 
			    {          
			        return new PasswordAuthentication(username, password.toCharArray());
			    }
			});
			_18_Example.log("Authenticator Initialized");
			
			//Clean Actual Responses directory
			FileUtils.cleanDirectory(new File(payloadActualResponsePath));			
			_18_Example.log("Cleaned Actual Responses directory");

			
			//Highlight Style
			XSSFCellStyle highlightStyle = workbook.createCellStyle();
			Font hlFont = workbook.createFont();
			hlFont.setColor(IndexedColors.BLACK.getIndex());
			hlFont.setItalic(true);
			highlightStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			highlightStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			highlightStyle.setFont(hlFont);			
			
			//Pass Style
			XSSFCellStyle passStyle = workbook.createCellStyle();
			Font headerFont = workbook.createFont();
			headerFont.setColor(IndexedColors.WHITE.getIndex());
			passStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			passStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			passStyle.setFont(headerFont);			
			
			//Fail Style
			XSSFCellStyle failStyle = workbook.createCellStyle();
			failStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
			failStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			failStyle.setFont(headerFont);					
			
			//Normal Style
			XSSFCellStyle normalStyle = workbook.createCellStyle();
			Font headerFont1 = workbook.createFont();
			headerFont1.setColor(IndexedColors.BLACK.getIndex());
			normalStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
			normalStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			normalStyle.setFont(headerFont1);			
			
			//Hyperlink Style
			CreationHelper createHelper = workbook.getCreationHelper();
			XSSFCellStyle hlinkstyle = workbook.createCellStyle();
			XSSFFont hlinkfont = workbook.createFont();
			hlinkfont.setUnderline(XSSFFont.U_SINGLE);
			hlinkfont.setColor(HSSFColor.BLUE.index);
			hlinkstyle.setFont(hlinkfont);
			XSSFHyperlink link = (XSSFHyperlink)createHelper.createHyperlink(Hyperlink.LINK_URL);
			
			_18_Example.log("Cell Styles Loaded");
			
				
			String jsonString="", expectedResponse="";
			XSSFCell cell0,cell1,cell2,cell3,cell4;
			XSSFRow row;			
			
			//Get Requests from Payload Text Files
			File folder = new File(payloadRequestPath);
			File[] listOfFiles = folder.listFiles();
			
			_18_Example.log("Get Requests from Payload Text Files : " + listOfFiles.length);			
			row = sheet.createRow(0);
			cell0 = row.createCell(0);
			cell0.setCellStyle(highlightStyle);
			cell0.setCellValue("Requests");
			cell1 = row.createCell(1);
			cell1.setCellStyle(highlightStyle);
			cell1.setCellValue("Expected Response");
			cell2 = row.createCell(2);
			cell2.setCellStyle(highlightStyle);
			cell2.setCellValue("Actual Response");
			cell3 = row.createCell(3);
			cell3.setCellStyle(highlightStyle);
			cell3.setCellValue("Result");
			cell3 = row.createCell(4);
			cell3.setCellStyle(highlightStyle);
			cell3.setCellValue("Failure Reason");
			
			int rowNum=1;
			StringBuffer sbuf;
			PrintWriter writer;
			for(File file : listOfFiles)
			{
				_18_Example.log("Processing File : " + file.getAbsolutePath());
				row = sheet.createRow(rowNum);
				if(file.isFile() && file.getName().endsWith(".txt"))
				{
					cell0 = row.createCell(0);	//Requests
					cell1 = row.createCell(1);	//Expected Response
					cell2 = row.createCell(2);	//Actual Response
					cell3 = row.createCell(3);	//Result
					cell4 = row.createCell(4);	//Failure Reason	
					
					cell0.setCellValue(file.getName());
					link = (XSSFHyperlink)createHelper.createHyperlink(Hyperlink.LINK_FILE);
					link.setAddress((file.toURI().toString()).replace("\\", "/"));
					cell0.setHyperlink((XSSFHyperlink) link);
					cell0.setCellStyle(hlinkstyle);
					
					try
					{
						sbuf = new StringBuffer();
						sbuf.append(FileUtils.readFileToString(file));
						_18_Example.log("Read File to String : " + file.getName());
						jsonString = sendPostRequest(requestUrl, sbuf.toString());
						_18_Example.log("Got JSon Response for File : " + file.getName());
						writer = new PrintWriter(payloadActualResponsePath+file.getName(), "UTF-8");
						writer.print(jsonString);
						writer.close();
						_18_Example.log("Created Actual Response Text File for : " + file.getName());
						try
						{
							expectedResponse = FileUtils.readFileToString(new File(payloadExpectedResponsePath+file.getName()));
						}
						catch(Exception e1)
						{
							throw new Exception("Expected Response not present for Request in '"+file.getName()+"'");
						}
						_18_Example.log("Read Expected Response for File "+file.getName()+" from : " + payloadExpectedResponsePath+file.getName());
						cell1.setCellValue(file.getName());
						link = (XSSFHyperlink)createHelper.createHyperlink(Hyperlink.LINK_FILE);
						link.setAddress(((new File(payloadExpectedResponsePath).toURI())+file.getName()).replace("\\", "/"));
						cell1.setHyperlink((XSSFHyperlink) link);
						cell1.setCellStyle(hlinkstyle);
						
						cell2.setCellValue(file.getName());
						link = (XSSFHyperlink)createHelper.createHyperlink(Hyperlink.LINK_FILE);
						link.setAddress(((new File(payloadActualResponsePath).toURI())+file.getName()).replace("\\", "/"));
						cell2.setHyperlink((XSSFHyperlink) link);
						cell2.setCellStyle(hlinkstyle);
						
						try
						{
							JSONAssert.assertEquals(expectedResponse, jsonString, false);
						}
						catch(AssertionError e1)
						{
							throw new Exception(e1);
						}
						_18_Example.log("Case Passed : for Text File " + file.getName());
						cell3.setCellStyle(passStyle);
						cell3.setCellValue("Passed");
						counterPass++;
					}
					catch(Exception e)
					{
						_18_Example.log("Case Failed : for Text File " + file.getName());
						cell3.setCellStyle(failStyle);
						cell3.setCellValue("Failed");
						cell4.setCellStyle(normalStyle);
						cell4.setCellValue(e.getMessage());
						counterFail++;
					}
				}
				rowNum++;
			}
			
			_18_Example.log("Completed processing for "+listOfFiles.length+" text files");
			//Delete Old Excel File
			try
			{
				new File(payloadResponses).delete();
			}
			catch(Exception e){}
			
			
			_18_Example.log("Deleted Old Excel Result File");
			
			//Write this new Excel File in hard disk
			try
			{
				FileOutputStream out = new FileOutputStream(new File(payloadResponses));
				workbook.write(out);
				out.close();
				_18_Example.log("Success!!!");
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
					//System.out.println("The file has been successfully deleted"); 
				}
			}					
			
			//Close Workbook and print success message
			long end = System.currentTimeMillis();
			float diff = ((float)(end-start)/(float)1000.0);
			JOptionPane.showMessageDialog(null, "Completed Successfully!\nTotal Responses Tested : " + (counterPass+counterFail) + "\nTotal Success = '"+counterPass+"'\nTotal Failures = '"+counterFail+"'\nTotal Time elapsed : " + String.format("%.1f", diff) + " seconds", "Web Service Automated Testing", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error : "+e.getMessage()+ "\nExiting Application", "Web Service Automated Testing", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public static void log(String str)
	{
		//System.out.println(str);
		//JOptionPane.showMessageDialog(null, str, "Payload Generator", JOptionPane.INFORMATION_MESSAGE);
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
