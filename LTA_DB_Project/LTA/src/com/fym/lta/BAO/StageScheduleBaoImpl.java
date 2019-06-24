package com.fym.lta.BAO;

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.StageScheduleDao;
import com.fym.lta.DTO.StageScheduleDto;

import javax.swing.JOptionPane;

public class StageScheduleBaoImpl implements StageScheduleBao {
    
    private StageScheduleDao dao= new DaoFactory().createStageScheduleDao();
    
    public StageScheduleBaoImpl() {
        super();
    }

    public boolean isExist(StageScheduleDto ss) {
        boolean flag = false;
        try{
            flag = dao.isExist(ss);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }


    public boolean add(StageScheduleDto ss) {
        boolean addFlag=false;
        try{
            if(dao.isExist(ss)){
                JOptionPane.showMessageDialog(null,"record already exists ");
            }
            else{
                addFlag=dao.createNew(ss);
            }
        }
        catch(Exception e){
           e.printStackTrace();}
        return addFlag;
    }

    public boolean delete(StageScheduleDto ss) {
        boolean deleteFlag= false ;
        try{
            if(dao.isExist(ss)){
                deleteFlag=dao.delete(ss);
            }
            else{
                JOptionPane.showMessageDialog(null,"No record Exist to delete");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return deleteFlag;
    }
}
