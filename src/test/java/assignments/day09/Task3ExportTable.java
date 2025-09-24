package assignments.day09;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Task3ExportTable {
    @Test
    void exportTableToExcel() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://claruswaysda.github.io/webTable.html");

        // Locate Table 1
        WebElement table = driver.findElement(By.xpath("//table[1]/tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Create Excel workbook
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Table1");

        // Loop over table rows
        for (int i = 0; i < rows.size(); i++) {
            Row excelRow = sheet.createRow(i); // create new row in Excel
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < cells.size(); j++) {
                excelRow.createCell(j).setCellValue(cells.get(j).getText());
            }
        }

        // Save Excel file
        FileOutputStream fileOut = new FileOutputStream("Table1.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        driver.quit();

        System.out.println("✅ Table 1 exported to Excel successfully!");
    }
}



