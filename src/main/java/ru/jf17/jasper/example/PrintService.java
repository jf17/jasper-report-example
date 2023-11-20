package ru.jf17.jasper.example;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.InputStream;
import java.util.*;

public class PrintService {
    List<Person> persons = Arrays.asList(new Person("Иван", "Иванов"), new Person("Пётр", "Петров"),
            new Person("Сергей", "Сергеев"));

    public void createPdfReport() throws JRException {
        InputStream jrxml = PrintService.class.getClassLoader().getResourceAsStream("employeeList.jrxml");

        // Парсинг/компиляция шаблона employeeList.jrxml
        JasperReport jasperReport = JasperCompileManager.compileReport(jrxml);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("DATE", new Date());

        // заполнения данными
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
                new JRBeanCollectionDataSource(persons));

        // Создание PDF файла
        JasperExportManager.exportReportToPdfFile(jasperPrint, "employeeReport.pdf");
    }

}