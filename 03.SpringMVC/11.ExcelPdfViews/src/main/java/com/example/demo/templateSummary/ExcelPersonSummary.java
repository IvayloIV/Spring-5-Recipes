package com.example.demo.templateSummary;

import com.example.demo.entity.Person;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ExcelPersonSummary extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook,
                                      HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) {
        final Person reservations =
                (Person) map.get("player");
        final Sheet sheet = workbook.createSheet();

        addHeaderRow(sheet);
        createRow(sheet, reservations);
    }

    private void addHeaderRow(Sheet sheet) {
        Row header = sheet.createRow(0);
        header.createCell((short) 0).setCellValue("Name");
        header.createCell((short) 1).setCellValue("Age");
    }

    private void createRow(Sheet sheet, Person person) {
        Row row = sheet.createRow(sheet.getLastRowNum() + 1);
        row.createCell((short) 0).setCellValue(person.getName());
        row.createCell((short) 1).setCellValue(person.getAge());
    }
}
