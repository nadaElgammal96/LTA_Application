package com.fym.lta.UI;

import com.fym.lta.BAO.BaoFactory;
import com.fym.lta.BAO.ScheduleBao;
import com.fym.lta.BAO.SlotBao;
import com.fym.lta.DTO.ScheduleDto;
import com.fym.lta.DTO.SlotDto;
import com.fym.lta.UI.ReadExcelClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class UpdateExcelClass {
    
    private String filename;
    private SlotBao slot_bao = new BaoFactory().createSLotBao();
    private SlotDto slot = new SlotDto();
    private ScheduleBao schedule_bao = new BaoFactory().createScheduleBao();

    
    public UpdateExcelClass() {
        super();
    }
    
    public UpdateExcelClass(String filename) {
        this.filename=filename;
    }

     
    public void updateCell(int rowIndex , int cellIndex , String value)throws IOException{
        InputStream ExcelFileToRead = new FileInputStream(filename);
        HSSFWorkbook workbook = new HSSFWorkbook(ExcelFileToRead);
        HSSFSheet sheet = workbook.getSheetAt(0);

        HSSFRow row ;
        HSSFCell cell;
        row=sheet.getRow(rowIndex);
        cell=row.getCell(cellIndex);
        cell.setCellValue(value);
        FileOutputStream fileOut = new FileOutputStream(filename);
        workbook.write(fileOut);
        fileOut.close();
    }
    
    
    public void updateSheet()throws FileNotFoundException, IOException {
        
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filename));
        HSSFSheet sheet = workbook.getSheetAt(0);   
        
         int scheduleId = schedule_bao.getScheduleID(filename);
        
        for(int r=0 ; r<5 ; r++){
            for(int c=0 ; c<9 ; c++){
                HSSFRow row5 = sheet.getRow((r*5)+5);
                HSSFRow row8 = sheet.getRow((r*5)+8);
                if (row8.getCell(2*c +1).getCellType() == CellType.STRING){
                String[] day = row5.getCell(0).getStringCellValue().split("d",2);
                String code = "Sch"+scheduleId+"-"+day[0]+"-S"+((2*c)+1);
                slot.setCode(code);
                String locName = slot_bao.getSlot(slot).getLocation().getName();
                updateCell( (r*5)+8 , (c*2)+1 , locName);
                }
            }
        }
    }
}
