package com.sls.report.services.GeneratedPdfService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sls.report.dto.IssueRegisterDTO;
import com.sls.report.services.Watermark;

public class IssueRegisterGeneratedPDFReport {

	public static ByteArrayInputStream issueRegister(List<IssueRegisterDTO> recieptregiDTO) {
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		try {
			
			//first header
			PdfPTable header1 = new PdfPTable(2);
			header1.setWidthPercentage(100);
			header1.setWidths(new int[]{6,6});
            
            Font headFont2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            
            PdfPCell hcell2;
            hcell2 = new PdfPCell(new Phrase("THE EMPIRE JUTE CO LTD ", headFont2));
            hcell2.setHorizontalAlignment(Element.ALIGN_LEFT);
//            hcell2.setBackgroundColor(BaseColor.YELLOW);
            header1.addCell(hcell2);
            
            hcell2 = new PdfPCell(new Phrase("B4", headFont2));
            hcell2.setHorizontalAlignment(Element.ALIGN_LEFT);
//            hcell2.setBackgroundColor(BaseColor.YELLOW);
            header1.addCell(hcell2);
            
          //Second header
			PdfPTable header2 = new PdfPTable(3);
			header2.setWidthPercentage(100);
			header2.setWidths(new int[]{4,4,4});
            
            Font headFont3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            
            PdfPCell hcell3;
            hcell3 = new PdfPCell(new Phrase("Issue Register For The : ", headFont2));
            hcell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//            hcell3.setBackgroundColor(BaseColor.YELLOW);
            header2.addCell(hcell3);
            
            hcell3 = new PdfPCell(new Phrase(" ", headFont2));
            hcell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//            hcell3.setBackgroundColor(BaseColor.YELLOW);
            header2.addCell(hcell3);
            
            hcell3 = new PdfPCell(new Phrase("Formula no 1 ", headFont2));
            hcell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//            hcell3.setBackgroundColor(BaseColor.YELLOW);
            header2.addCell(hcell3);
            
            
            //body
            PdfPTable table = new PdfPTable(10);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{3,3,3,3,3,3,3,3,3,3});
            
            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            
            PdfPCell hcell;
            
            hcell = new PdfPCell(new Phrase("Issue No", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Issue Date", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Lot No", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Quality", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Godown No", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Bales", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("H/ Bales", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Loose", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("P/ Bales", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Weight", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            
            for(IssueRegisterDTO issue : recieptregiDTO) {
            	PdfPCell cell;
            	Font cellFont = FontFactory.getFont(FontFactory.COURIER_OBLIQUE);
            	 
            	 cell = new PdfPCell(new Phrase(String.valueOf(String.valueOf(issue.getIssueNo())), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(String.valueOf(String.valueOf(issue.getIssueDate())), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(" "));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(String.valueOf(issue.getQuality().toString()), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(issue.getWarehouseNo().toString(), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(String.valueOf(issue.getBales()), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(" "));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(String.valueOf(issue.getLoose()),cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(" "));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(issue.getWeight().toString(), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
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
			
		}
		
		return new ByteArrayInputStream(out.toByteArray());
	}

}
