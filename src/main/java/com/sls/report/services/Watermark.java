package com.sls.report.services;

import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class Watermark extends  PdfPageEventHelper{

	 protected Phrase watermark = new Phrase("STORE REPORT", new Font(FontFamily.HELVETICA, 60, Font.NORMAL, BaseColor.LIGHT_GRAY));
	 public static final Font FONT = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, GrayColor.GRAYWHITE);
	 
     @Override
     public void onEndPage(PdfWriter writer, Document document) {
         PdfContentByte canvas = writer.getDirectContentUnder();
         try {
			Image img = Image.getInstance("C:\\Users\\souga\\eclipse-workspace\\report\\src\\main\\java\\com\\sls\\report\\services\\logo.png");
			img.scaleToFit(400, 700);
			img.setAbsolutePosition(0f, 0f);
			canvas.addImage(img);
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 298, 421, 45);
         
     }
     
     public Image getWatermarkedImage(PdfContentByte cb, Image img, String watermark) throws DocumentException {
         float width = img.getScaledWidth();
         float height = img.getScaledHeight();
         PdfTemplate template = cb.createTemplate(width, height);
         template.addImage(img, width, 0, 0, height, 0, 0);
         ColumnText.showTextAligned(template, Element.ALIGN_CENTER,
                 new Phrase(watermark, FONT), width / 2, height / 2, 30);
         return Image.getInstance(template);
     }
	
}
