package com.fym.lta.BAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.EquipmentTypeDao;
import com.fym.lta.DTO.EquipmentDto;
import com.fym.lta.DTO.EquipmentTypeDto;

import java.util.Collections;
import java.util.List;

import java.util.List;

import javax.swing.JOptionPane;

public class EquipmentTypeBaoImpl implements EquipmentTypeBao {
    
    private  EquipmentTypeDao db = new DaoFactory().createEquipmentTypeDao();
    
    public boolean add(EquipmentTypeDto equip_type) {
        boolean insertFlag = false;
        try{
                if(db.isExist(equip_type))
                    JOptionPane.showMessageDialog(null, "Record already EXISTS");
                else
                    insertFlag = db.createNew(equip_type);
            return insertFlag;
        }
            catch(Exception e){
                   e.printStackTrace();
                   return false;
               }
    }

    public List<EquipmentTypeDto> viewAll() {
        List<EquipmentTypeDto> eqt = null;
        try{
            eqt=db.viewAll();
            return eqt;
        }
        catch(Exception e){
            e.printStackTrace();
            return eqt;
        }
    }

    public boolean delete(EquipmentTypeDto equip_type) {
        boolean deleteFlag = true;
        try{
                if(db.isExist(equip_type))
                        deleteFlag = db.delete(equip_type);
                else{
                        JOptionPane.showMessageDialog(null, "NO TYPE FOUND TO DELETE");
                        deleteFlag = false ;
                    }
                   return deleteFlag;
               }

            catch(Exception e){
                   e.printStackTrace();
                   return false;
               }
    }

    public List<EquipmentTypeDto> searchFor(EquipmentTypeDto equip_type) {
        List<EquipmentTypeDto> eqt = null;
        try{
            eqt = db.searchFor(equip_type);
                        return eqt ;
        }
        catch(Exception e){
            e.printStackTrace();
            return eqt;
        } 
    }
    
    public boolean update(EquipmentTypeDto equip_type){
        boolean updateFlag = true;
        try{
                if(db.isExist(equip_type))
                     updateFlag = db.update(equip_type);
                else{
                     JOptionPane.showMessageDialog(null,"NO TYPE FOUND TO UPDATE");
                    updateFlag = false;
                    }
                return updateFlag;
            }
        catch(Exception e){
               e.printStackTrace();
               return false;
           }
    }
    
    public List<EquipmentDto> loadAllEquips(EquipmentTypeDto equip_type){
        List<EquipmentDto> eq = null;
        try{
            eq=db.loadAllEquipments(equip_type);
            if (eq==null)
             JOptionPane.showMessageDialog(null, "No Equipments Found Of This Type");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return eq;
    }


}
