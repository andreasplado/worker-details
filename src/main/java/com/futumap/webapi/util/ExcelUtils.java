package com.futumap.webapi.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.futumap.webapi.dao.entity.WorkerEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelUtils {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Id", "Title", "Description", "Published" };
    static String SHEET = "Tutorials";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<WorkerEntity> excelToWorkerList(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<WorkerEntity> workers = new ArrayList<>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                WorkerEntity workerEntity = new WorkerEntity();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            workerEntity.setCompany(currentCell.getStringCellValue());
                            break;
                        case 1:
                            workerEntity.setFirstname(currentCell.getStringCellValue());
                            break;
                        case 2:
                            workerEntity.setLastname(currentCell.getStringCellValue());
                            break;
                        case 3:
                            workerEntity.setProffession(currentCell.getStringCellValue());
                            break;
                        case 4:
                            workerEntity.setContact(currentCell.getStringCellValue());
                            break;
                        case 6:
                            workerEntity.setEmail(currentCell.getStringCellValue());
                            break;
                        case 7:
                            workerEntity.setWorker_needs(currentCell.getStringCellValue());
                            break;
                        case 8:
                            workerEntity.setNotes(currentCell.getStringCellValue());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }
                System.out.println(workerEntity.getCompany());

                workers.add(workerEntity);
            }

            workbook.close();

            return workers;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}