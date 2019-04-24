package com.tracker.admin.service.impl;

import com.tracker.admin.service.ImportService;
import com.tracker.entity.DemandDetail;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class ImportServiceImpl implements ImportService {

    @Override
    public void importDemandFile(MultipartFile file) {
        try{
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            XSSFSheet worksheet = workbook.getSheetAt(0);
            int rowNum = worksheet.getPhysicalNumberOfRows();
            validateHeader(worksheet.getRow(0));
            List<DemandDetail> demandDetailList = new ArrayList<>();
            // Read Demand rows
            for(int i=1; i < rowNum; i++){
                XSSFRow row = worksheet.getRow(i);
                if(!checkIfRowIsEmpty(row)) {
                    DemandDetail demandDetail = getDemandFromFileRecord(row);
                    demandDetailList.add(demandDetail);
                }
            }

            uploadDemandsToDB(demandDetailList);

        } catch (IOException e){

        }
    }

    @Override
    public void importSupplyFile(MultipartFile file) {

    }

    private void validateHeader(XSSFRow headerRow){
        if(headerRow != null){
            Iterator<Cell> cellIterator = headerRow.cellIterator();
            Set<String> actualColumnNames = new LinkedHashSet<String>();
            while(cellIterator.hasNext()){
                Cell currentCell = cellIterator.next();
                if (!isCellEmpty(currentCell)){
                    String cellValue = currentCell.getStringCellValue().trim();
                    if(actualColumnNames.contains(cellValue)){
                        // duplicate column
                    }else {
                        actualColumnNames.add(cellValue);
                    }
                }
            }

        } else {
            // Throw error
        }
    }

    private boolean isCellEmpty(final Cell cell){
        if(null == cell || cell.getCellTypeEnum() == CellType.BLANK) {
            return true;
        }

        if(cell.getCellTypeEnum() == CellType.STRING && cell.getStringCellValue().isEmpty()){
            return true;
        }

        return false;
    }

    private boolean checkIfRowIsEmpty(XSSFRow row){
        if( null == row) {
            return true;
        }
        if(row.getLastCellNum() <=0) {
            return true;
        }

        for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++){
            Cell cell = row.getCell(cellNum);
            if(cell !=null && cell.getCellTypeEnum() != CellType.BLANK && StringUtils.isNotBlank(cell.toString())){
                return false;
            }
        }
        return true;
    }

    private DemandDetail getDemandFromFileRecord(XSSFRow row) {
        DemandDetail demandDetail = new DemandDetail();
         return demandDetail;
    }

    private void uploadDemandsToDB(List<DemandDetail> demandDetailList) {
    }
}
