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
import com.sls.report.dto.GroupwiseQualityStockRegisterGeneratedPdfReportDTO;

public class GroupwiseQualityStockRegisterGeneratedPdfReport {

	public static ByteArrayInputStream groupwiseQualityStockRegister(List<GroupwiseQualityStockRegisterGeneratedPdfReportDTO> physicalstockDTOs) {
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
            
            
            //second header
            PdfPTable header2 = new PdfPTable(1);
            header2.setWidthPercentage(100);
            header2.setWidths(new int[]{16});
            
            Font headFont3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            
            PdfPCell hcell3;
            hcell3 = new PdfPCell(new Phrase("Groupwise Quality Stock Register For The  ", headFont2));
            hcell3.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header2.addCell(hcell3);
            
            //body
			PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{3,3,3,4,2,3});
//            table.addCell(table1);
            
            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            
            PdfPCell hcell;
            
            hcell = new PdfPCell(new Phrase("Quality", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Op. Stock Weight", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Receipt Weight", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Issue Weight", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Sale/Ret weight", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            hcell = new PdfPCell(new Phrase("Cl. Stock Weight", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(hcell);
            
            
            for(GroupwiseQualityStockRegisterGeneratedPdfReportDTO physicalstock : physicalstockDTOs) {
            	PdfPCell cell;
            	Font cellFont = FontFactory.getFont(FontFactory.COURIER_OBLIQUE);
            	 
            	 cell = new PdfPCell(new Phrase(String.valueOf(physicalstock.getQualityCode()), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(String.valueOf(physicalstock.getOppenningWt()), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(String.valueOf(physicalstock.getReceiptWt()), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(String.valueOf(physicalstock.getIssueWt()), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase("Not yet implemented", cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	 cell.setBackgroundColor(BaseColor.GRAY);
                 table.addCell(cell);
                 
                 cell = new PdfPCell(new Phrase(String.valueOf(physicalstock.getClosingWt()), cellFont));
            	 cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	 cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                 table.addCell(cell);
                 
            }
            
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(header1);
            document.add(header2);
            document.add(table);
            
            
            document.close();
            
		}catch(DocumentException e){
			e.printStackTrace();
		}
		
		return new ByteArrayInputStream(out.toByteArray());
}
	
}
