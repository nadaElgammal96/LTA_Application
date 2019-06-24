package com.fym.lta.BAO;

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.StageDao;
import com.fym.lta.DTO.StageDto;
import com.fym.lta.DTO.UserDto;

import java.util.List;

import javax.swing.JOptionPane;

public class StageBaoImpl implements StageBao {
    
    private StageDao dao = new DaoFactory().createStageDao();
    
    public boolean update(StageDto S , UserDto user) {
        boolean saveFlage = true;
               try{
                     //data is valid
                    if(dao.isExist(S)){
                        saveFlage = dao.update(S,user);
                    }         else{
                              saveFlage = false;
                                   }
               }
                   catch(Exception e){
                          e.printStackTrace();
                          return false;
                      }
                      return saveFlage;    }

    public List<StageDto> viewAll() {
        List<StageDto> stages = null;
        try{
            stages = dao.viewAll();
           }
        catch(Exception e) {
            e.printStackTrace();
        }
        return stages;
    }

    public boolean add(StageDto s ,UserDto user) {
        boolean saveFlage = true;
               try{
                     //data is valid
                    if(dao.isExist(s)){
                        JOptionPane.showMessageDialog(null,"Record Already Exixts");
                               saveFlage = false;
                    }         else{
                              saveFlage = dao.createNew(s,user);
                                   }
                   
               }
                   catch(Exception e){
                          e.printStackTrace();
                          return false;
                      }
                      return saveFlage;
    }

    public List<StageDto> searchFor(StageDto s) {
        List<StageDto> stages = null;
                try{
                   stages  = dao.searchFor(s);
                    return stages  ;
                }catch(Exception e){
                    e.printStackTrace();
                    return stages ;
                }  
    }

    public boolean delete(StageDto s) {
        boolean deleteFlage = true;
                      try{
                          if(dao.isExist(s))
                              deleteFlage = dao.delete(s);
                          else
                              deleteFlage = false;
                      }catch(Exception e){
                          e.printStackTrace();
                          return false;
                      }
                      return deleteFlage;
    }
    
   
    
    public boolean isExist(StageDto s){
        boolean flag = false;
        try{
            flag=dao.isExist(s);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

}
