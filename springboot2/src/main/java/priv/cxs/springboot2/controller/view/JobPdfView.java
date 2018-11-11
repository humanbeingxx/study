package priv.cxs.springboot2.controller.view;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import priv.cxs.springboot2.model.Job;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/11 16:02
 */
public class JobPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {
        addDocInfo(document);
        List<Job> jobs = (List<Job>) model.get("jobs");
        PdfPTable pdfPTable = JobExportUtil.makePdf(jobs);
        document.add(pdfPTable);
    }

    private void addDocInfo(Document document) throws DocumentException {
        document.addTitle("职位信息");
        document.setPageSize(PageSize.A4);

        Font font = new Font(JobExportUtil.BASE_FONT);
        font.setColor(Color.RED);
        font.setStyle(Font.BOLD);
        font.setSize(20);

        Chunk chunk = new Chunk("职位信息");
        chunk.setFont(font);

        Paragraph paragraph = new Paragraph(chunk);
        paragraph.setAlignment(1);

        document.add(paragraph);
        document.add(new Chunk("\n"));
    }
}
