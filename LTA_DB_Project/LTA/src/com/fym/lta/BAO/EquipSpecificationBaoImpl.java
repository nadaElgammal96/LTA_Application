package com.fym.lta.BAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.EquipmentSpecificationDao;
import com.fym.lta.DTO.EquipSpecificationDto;

import com.fym.lta.DTO.EquipmentTypeDto;

import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class EquipSpecificationBaoImpl implements EquipSpecificationBao {
   
    private  EquipmentSpecificationDao db = new DaoFactory().createEquipmentSpecificationDao();
   
    public boolean insert(EquipSpecificationDto eq_spec) {
        boolean insertFlag = false;
        try{
                if(db.isExist(eq_spec))
                    JOptionPane.showMessageDialog(null, "Specification already EXISTS");
                else
                    insertFlag = db.createNew(eq_spec);
        }
            catch(Exception e){
                   e.printStackTrace();
               }
            return insertFlag;

        }
    
    public boolean update(EquipSpecificationDto eq_spec){
            boolean updateFlag = false;
            try{
                    if(db.isExist(eq_spec))
                         updateFlag = db.update(eq_spec);
                    else{
                         JOptionPane.showMessageDialog(null,"NO Specification FOUND TO UPDATE");
                        }
                    return updateFlag;
                }
            catch(Exception e){
                   e.printStackTrace();
                   return false;
               }
        }

    public boolean delete(EquipSpecificationDto eq_spec) {
        boolean deleteFlag = false;
        try{
                if(db.isExist(eq_spec))
                        deleteFlag = db.delete(eq_spec);
                else{
                        JOptionPane.showMessageDialog(null, "NO TYPE FOUND TO DELETE");
                    }
               }
            catch(Exception e){
                   e.printStackTrace();
               }
        return deleteFlag;

    }

    public List<EquipSpecificationDto> searchFor(EquipSpecificationDto eq_spec) {
        List<EquipSpecificationDto> eq_spc = null;
        try{
            eq_spc = db.searchFor(eq_spec);
        }
        catch(Exception e){
            e.printStackTrace();
        } 
        return eq_spc;

    }
    
    public List<EquipSpecificationDto> listall() {
        List<EquipSpecificationDto> eq_spec = null;
        try{
            eq_spec=db.viewAll();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return eq_spec;
    }
}
