package com.fym.lta.BAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.EquipmentSpecificationDao;
import com.fym.lta.DTO.EquipSpecificationDto;

import java.util.Collections;
import java.util.List;

public class EquipSpecificationBaoImpl implements EquipSpecificationBao {
    private  EquipmentSpecificationDao db = new DaoFactory().createEquipmentSpecificationDao();
    public boolean save(EquipSpecificationDto eq_spec) {
        boolean saveFlage = true;
                try{
                           System.out.println(eq_spec.getId());
                           //Check the data validity
                 if( eq_spec.getId()<0)
                 { System.out.println("invalid input");
                   return false;
                     }
                 else{//data is valid
                        if(db.isExist(eq_spec))
                                saveFlage = db.update(eq_spec);
                        else
                               saveFlage = db.createNew(eq_spec);
                       }
                }
                    catch(Exception e){
                           e.printStackTrace();
                           return false;
                       }
                       return saveFlage;
    }

    public boolean delete(EquipSpecificationDto eq_spec) {
        boolean deleteFlag = true;
        try{
                   System.out.println(eq_spec.getId());
                   //Check the data validity
         if( eq_spec.getId()<0)
         { System.out.println("invalid input");
           return false;
             }
         else{//data is valid
                if(db.isExist(eq_spec))
                        deleteFlag = db.delete(eq_spec);
                else
                      System.out.println("not existent equipment") ;
               }
        }
            catch(Exception e){
                   e.printStackTrace();
                   return false;
               }
        return deleteFlag;
    }

    public List<EquipSpecificationDto> searchFor(EquipSpecificationDto eq_spec) {
        return db.searchFor(eq_spec);
    }
    
    public List<EquipSpecificationDto> listall() {
        return db.viewAll();
    }
}
