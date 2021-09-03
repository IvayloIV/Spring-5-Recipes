package com.example.demo.templateSummary;

import com.example.demo.entity.Person;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class PdfPersonSummary extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Person person = (Person) map.get("player");
        Table table = new Table(2);
        table.addCell("Name");
        table.addCell("Age");

        table.addCell(person.getName());
        table.addCell(String.valueOf(person.getAge()));
        document.add(table);
    }
}
