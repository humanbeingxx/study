package priv.cxs.springboot2.controller.view;

import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import priv.cxs.springboot2.model.Job;

import java.awt.*;
import java.util.List;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/11 16:08
 */
public class JobExportUtil {

    public final static BaseFont BASE_FONT;
    public final static Font HEADER_FONT;
    private final static Font CONTENT_FONT;

    static {
        try {
            BASE_FONT = BaseFont.createFont("C:/windows/fonts/simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            HEADER_FONT = new Font(BASE_FONT);
            HEADER_FONT.setColor(Color.BLUE);
            HEADER_FONT.setStyle(Font.BOLD);

            CONTENT_FONT = new Font(BASE_FONT);
            CONTENT_FONT.setColor(Color.BLACK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PdfPTable makePdf(List<Job> jobs) {
        PdfPTable table = new PdfPTable(6);

        makeHeader(table);

        for (Job job : jobs) {
            makeOneLine(table, job);
        }

        return table;
    }

    private static void makeHeader(PdfPTable table) {
        PdfPCell code = new PdfPCell(new Paragraph("code", HEADER_FONT));
        code.setHorizontalAlignment(1);
        table.addCell(code);

        PdfPCell name = new PdfPCell(new Paragraph("name", HEADER_FONT));
        name.setHorizontalAlignment(1);
        table.addCell(name);

        PdfPCell salary = new PdfPCell(new Paragraph("salary", HEADER_FONT));
        salary.setHorizontalAlignment(1);
        table.addCell(salary);

        PdfPCell address = new PdfPCell(new Paragraph("address", HEADER_FONT));
        address.setHorizontalAlignment(1);
        table.addCell(address);

        PdfPCell level = new PdfPCell(new Paragraph("level", HEADER_FONT));
        level.setHorizontalAlignment(1);
        table.addCell(level);

        PdfPCell jobType = new PdfPCell(new Paragraph("jobType", HEADER_FONT));
        jobType.setHorizontalAlignment(1);
        table.addCell(jobType);
    }

    private static void makeOneLine(PdfPTable table, Job job) {
        PdfPCell code = new PdfPCell(new Paragraph(String.valueOf(job.getCode()), CONTENT_FONT));
        code.setHorizontalAlignment(1);
        table.addCell(code);

        PdfPCell name = new PdfPCell(new Paragraph(job.getName(), CONTENT_FONT));
        name.setHorizontalAlignment(1);
        table.addCell(name);

        PdfPCell salary = new PdfPCell(new Paragraph(String.valueOf(job.getSalary()), CONTENT_FONT));
        salary.setHorizontalAlignment(1);
        table.addCell(salary);

        PdfPCell address = new PdfPCell(new Paragraph(job.getAddress(), CONTENT_FONT));
        address.setHorizontalAlignment(1);
        table.addCell(address);

        PdfPCell level = new PdfPCell(new Paragraph(String.valueOf(job.getLevel()), CONTENT_FONT));
        level.setHorizontalAlignment(1);
        table.addCell(level);

        PdfPCell jobType = new PdfPCell(new Paragraph(job.getJobType().name(), CONTENT_FONT));
        jobType.setHorizontalAlignment(1);
        table.addCell(jobType);
    }
}
