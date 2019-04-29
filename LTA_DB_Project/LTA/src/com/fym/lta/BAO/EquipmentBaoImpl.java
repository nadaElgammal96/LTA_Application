package com.fym.lta.BAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.EquipmentDao;
import com.fym.lta.DTO.EquipmentDto;
import com.fym.lta.DTO.LocationDto;

import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class EquipmentBaoImpl implements EquipmentBao {
    
    private  EquipmentDao db = new DaoFactory().createEquipmentDao();
    
    public boolean insert(EquipmentDto equip) {
        boolean insertFlag = true;
        try{
             if(db.isExist(equip)){
                    JOptionPane.showMessageDialog(null, "Record is already EXIST");
                    return false;}
                else
                       insertFlag = db.createNew(equip);
            return insertFlag;
        }
            catch(Exception e){
                   e.printStackTrace();
                   return false;
               }
    }

    public boolean delete(EquipmentDto equip) {
        boolean deleteFlag = true;
        try{
                if(db.isExist(equip))
                        deleteFlag = db.delete(equip);
                else
                      deleteFlag=false ;
                return deleteFlag;
               }
            catch(Exception e){
                   e.printStackTrace();
                   return false;
               }

    }

    public List<EquipmentDto> searchFor(EquipmentDto equip){
                List<EquipmentDto> eq =null;
        try{ eq=db.searchFor(equip);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        return eq;
            }

    public List<EquipmentDto> listAll() {
            List<EquipmentDto> eq = null;
            try{
                eq= db.viewAll();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return eq;
        }
    public boolean update(EquipmentDto equip){
        boolean updateFlag = true;
        try{ 
                if(db.isExist(equip))
                {
                    updateFlag = db.update(equip);
                 }
                else{
                    JOptionPane.showMessageDialog(null,"NO EQUIPMENT FOUND TO UPDATE");
                    updateFlag = false;
                    }       
            return updateFlag;
            }
        catch(Exception e){
               e.printStackTrace();
               return false;
           }
}
}
