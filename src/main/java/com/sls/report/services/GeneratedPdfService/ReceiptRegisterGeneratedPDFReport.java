package com.sls.report.services.GeneratedPdfService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sls.report.dto.ReceiptRegisterDTO;
import com.sls.report.services.Watermark;

public class ReceiptRegisterGeneratedPDFReport {

	public static ByteArrayInputStream receiptRegister(List<ReceiptRegisterDTO> reportDtoList) throws MalformedURLException, IOException {
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			//first header
			PdfPTable header1 = new PdfPTable(1);
			header1.setWidthPercentage(100);
			header1.setWidths(new int[]{12});
            
            Font headFont2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            
            PdfPCell hcell2;
            hcell2 = new PdfPCell(new Phrase("THE EMPIRE JUTE CO LTD ", headFont2));
            hcell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell2.setBackgroundColor(BaseColor.YELLOW);
            header1.addCell(hcell2);
            
          //secoond header
			PdfPTable header2 = new PdfPTable(3);
			header2.setWidthPercentage(100);
			header2.setWidths(new int[]{6,2,3});
            
            Font headFont3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            
            PdfPCell hcell3;
            hcell3 = new PdfPCell(new Phrase("Receipt Register For The : ", headFont2));
            hcell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//            hcell2.setBackgroundColor(BaseColor.YELLOW);
            header2.addCell(hcell3); 
            
            hcell3 = new PdfPCell(new Phrase(" ", headFont2));
            hcell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//            hcell2.setBackgroundColor(BaseColor.YELLOW);
            header2.addCell(hcell3);
            
            hcell3 = new PdfPCell(new Phrase(String.valueOf(Date.valueOf(LocalDate.now())), headFont2));
            hcell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//            hcell2.setBackgroundColor(BaseColor.YELLOW);
            header2.addCell(hcell3);
            
            
            //body
            PdfPTable table = new PdfPTable(10);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{3,3,3,4,2,3,3,2,2,2});
            
            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            
            PdfPCell hcell;
            
            hcell = new PdfPCell(new Phrase(" ", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("No.Date", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Packing Type", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("No", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Bales", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Quality", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase(" ", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Condition", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase(" ", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase(" ", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            for(ReceiptRegisterDTO receiptRegister : reportDtoList) {
            	PdfPCell cell;
            	Font cellFont = FontFactory.getFont(FontFactory.COURIER_OBLIQUE);
            	
            	 cell = new PdfPCell(new Phrase("", cellFont));
	           	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	           	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	           	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
            	 
            	 cell = new PdfPCell(new Phrase(String.valueOf(receiptRegister.getChallanDate()), cellFont));
//            	cell = new PdfPCell(new Phrase("challan", cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(receiptRegister.getVehicleNo().toString(), cellFont));
//                 cell = new PdfPCell(new Phrase("vehicle", cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(receiptRegister.getUom().toString(), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(receiptRegister.getActualQuality().toString(), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(String.valueOf(receiptRegister.getActualQuantity()), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase("", cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(String.valueOf(receiptRegister.getClaimsCondition()), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase("", cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase("", cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
            }
            
            PdfWriter writer = PdfWriter.getInstance(document, out);
            writer.setPageEvent(new Watermark());
            
            document.open();
            document.add(header1);
            document.add(header2);
            document.add(table);
            
            
            document.close();
            
            
		}catch(DocumentException e) {
			e.printStackTrace();
		}
		
		return new ByteArrayInputStream(out.toByteArray());
	}

}
