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
import com.sls.report.dto.SummaryRecieptRegisterReportDTO;

public class SummaryRecieptRegisterReportGeneratedPDF {

	public static ByteArrayInputStream createReport(List<SummaryRecieptRegisterReportDTO> sumaryreport) {
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
//            hcell2.setBackgroundColor(BaseColor.YELLOW);
            header1.addCell(hcell2); 
            
          //secoond header
			PdfPTable header2 = new PdfPTable(3);
			header2.setWidthPercentage(100);
			header2.setWidths(new int[]{6,2,3});
            
            Font headFont3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            
            PdfPCell hcell3;
            hcell3 = new PdfPCell(new Phrase("Summary Receipt Register For The : ", headFont2));
            hcell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//            hcell2.setBackgroundColor(BaseColor.YELLOW);
            header2.addCell(hcell3); 
            
            hcell3 = new PdfPCell(new Phrase(" ", headFont2));
            hcell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//            hcell2.setBackgroundColor(BaseColor.YELLOW);
            header2.addCell(hcell3);
            
            hcell3 = new PdfPCell(new Phrase("Formula no 1 ", headFont2));
            hcell3.setHorizontalAlignment(Element.ALIGN_LEFT);
//            hcell2.setBackgroundColor(BaseColor.YELLOW);
            header2.addCell(hcell3);
            
          //body
			PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{3,3,3,4,2,3,3});
//            table.addCell(table1);
            
            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            
            PdfPCell hcell;
            
            hcell = new PdfPCell(new Phrase("Receipt No", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Date", headFont));
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
            
            hcell = new PdfPCell(new Phrase("Quantity Unit", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Weight", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            for(SummaryRecieptRegisterReportDTO summery : sumaryreport) {
            	PdfPCell cell;
            	Font cellFont = FontFactory.getFont(FontFactory.COURIER_OBLIQUE);
            	 
            	 cell = new PdfPCell(new Phrase(summery.getChallanNo().toString(), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(String.valueOf(summery.getChallanDate()), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(summery.getActualQuality().toString(), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(summery.getWarehouseNo().toString(), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(String.valueOf(summery.getBales()), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(summery.getQuantityUnit().toString(), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(String.valueOf(summery.getActualWeight()), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
            }
            
            PdfWriter.getInstance(document, out);
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
