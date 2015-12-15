
package nieruchomosci.biuro;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

public class PDFSetting {
    
    public Document print(List<JLabel> list, String filename) throws FileNotFoundException, DocumentException{
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));

            document.open();
            
            List<PdfPCell> pdfCell = new ArrayList<>();
            
            for (JLabel labelek : list) {
                PdfPTable table = new PdfPTable(2); 
                PdfPCell cell1 = new PdfPCell(new Paragraph(labelek.getAccessibleContext().getAccessibleName()));
                PdfPCell cell2 = new PdfPCell(new Paragraph(labelek.getText()));
                table.addCell(cell1);
                table.addCell(cell2);
                document.add(table);
            }
            
            document.close();
            
            return document;
        } catch(FileNotFoundException | DocumentException e){
            throw e;
        }
    }
}