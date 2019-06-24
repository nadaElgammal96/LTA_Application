package com.fym.lta.BAO;

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.EqTypeSpecDao;
import com.fym.lta.DTO.EquipSpecificationDto;
import com.fym.lta.DTO.EquipTypeSpecDetailsDto;
import com.fym.lta.DTO.EquipmentTypeDto;

import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class EqTypeSpecBaoImpl implements EqTypeSpecBao {
    
    // create object from EqTypeSpecDaoImpl through dao factory createEqTypeSpecDao method 
    private EqTypeSpecDao dao = new DaoFactory().createEqTypeSpecDao();
   
    public EqTypeSpecBaoImpl() {
        super();
    }

    /* method to insert new record passed from ui, check the record then pass it to dao layer to 
     insert it in database tables */
    public boolean add(EquipTypeSpecDetailsDto type_spec) {
        boolean addFlag = false;
        try{
            /* check if the object already exists in databas by using isExist method implemented in dao
             then show message if it exists and return */
            if(dao.isExist(type_spec)){
               
            }
            else{
                // call insert method in dao and pass the object parameter to it then return
                addFlag=dao.insert(type_spec);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    return addFlag;
    }

//delete record passed from ui, check if record exists then call delete method from dao to delete it from database
    public boolean delete(EquipTypeSpecDetailsDto type_spec) {
        boolean deleteFlag = false;
        try{
            if(dao.isExist(type_spec))
                deleteFlag = dao.delete(type_spec);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return deleteFlag;
    }
    
    //method to view all records stored in database calling viewAll method in dao 
    public List<EquipTypeSpecDetailsDto> viewAll() {
        List<EquipTypeSpecDetailsDto> type_sp = null;
        try{
            type_sp=dao.listAll();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return type_sp;
    }

    //method to view all specifications of given type stored in database calling viewAll method in dao 
    public List<EquipSpecificationDto> viewAllSpecif(EquipmentTypeDto type) {
        List<EquipSpecificationDto> eq_sp = null;
        try{
            eq_sp= dao.loadAllSpecif(type);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return eq_sp;
    }
}
