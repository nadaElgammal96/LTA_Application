package com.fym.lta.BAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.EquipmentTypeDao;
import com.fym.lta.DTO.EquipmentDto;
import com.fym.lta.DTO.EquipmentTypeDto;

import com.fym.lta.DTO.UserDto;

import java.util.Collections;
import java.util.List;

import java.util.List;

import javax.swing.JOptionPane;

public class EquipmentTypeBaoImpl implements EquipmentTypeBao {
    
    // create object from EquipmentTypeDaoImpl through dao factory createEquipmentTypeDao method 
    private  EquipmentTypeDao db = new DaoFactory().createEquipmentTypeDao();
    
    /* method to insert new equipment type passed from ui, check the record then pass it to dao layer to 
     insert it in database tables */
    public boolean add(EquipmentTypeDto equip_type , UserDto  user) {
        boolean insertFlag = false;
        try{
            /* check if the object already exists in databas by using isExist method implemented in dao
             then show message if it exists and return */
                if(db.isExist(equip_type))
                     return false;
                else
                    // call insert method in dao and pass the object parameter to it then return
                    insertFlag = db.createNew(equip_type , user);
            return insertFlag;
        }
            catch(Exception e){
                   e.printStackTrace();
                   return false;
               }
    }

    //method to view all equipment types stored in database calling viewAll method in dao 
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

//delete record passed from ui, check if record exists then call delete method from dao to delete it from database
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

    //method to search for equipment types by calling searchFor method implemented in dao
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
   
    //method to update equipment passed form ui, check if it already exists then call update method in dao  
    public boolean update(EquipmentTypeDto equip_type , UserDto user){
        boolean updateFlag = true;
        try{
                if(db.isExist(equip_type))
                     updateFlag = db.update(equip_type , user);
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
   
   //method to view equipments of specific type by implementing dao method 
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
