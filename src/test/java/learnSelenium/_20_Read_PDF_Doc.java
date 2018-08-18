package learnSelenium;

/*import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.fontbox.*;*/

import java.io.File;
import java.io.FileInputStream;

public class _20_Read_PDF_Doc
{
	public static void main(String args[]) throws Exception
	{	
		
		final String pdfPath = "C:\\Users\\abhaik\\Documents\\My Documents\\Resume\\23 May\\Resume_AmitBhaik_23_May_2017.pdf";
		
		try
		{
			/*File file = new File(pdfPath);
			PDFParser parser = new PDFParser(new FileInputStream(file));			
			parser.parse();
			COSDocument cosDoc = parser.getDocument();
			PDFTextStripper pdfStripper = new PDFTextStripper();
			pdfStripper.setStartPage(1);
			pdfStripper.setEndPage(1);			
			PDDocument pdDoc = new PDDocument(cosDoc);
			String parsedText = pdfStripper.getText(pdDoc);					
			System.out.println("+++++++++++++++++");
			System.out.println(parsedText);
			System.out.println("+++++++++++++++++");		*/	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
