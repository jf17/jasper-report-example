package ru.jf17.jasper.example;

import net.sf.jasperreports.engine.JRException;

public class Main {
	public static void main(String[] args) throws JRException {
		System.out.println("App started...");

		PrintService printService = new PrintService();
		printService.createPdfReport();

		System.out.println("PDF report done!");
	}
}
