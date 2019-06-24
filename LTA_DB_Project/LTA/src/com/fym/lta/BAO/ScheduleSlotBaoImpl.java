package com.fym.lta.BAO;

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.ScheduleSlotDao;
import com.fym.lta.DTO.ScheduleSlotDto;

import javax.swing.JOptionPane;

public class ScheduleSlotBaoImpl implements ScheduleSlotBao {
    
    private ScheduleSlotDao dao = new DaoFactory().createScheduleSlotDao();

    public ScheduleSlotBaoImpl() {
        super();
    }

    public boolean insert(ScheduleSlotDto ss) {
     boolean addFlag = false;
    try
      {
        /* check if the object already exists in databas by using isExist method implemented in dao
                   then show message if it exists and return */
        if(!(dao.isExist(ss)))
          {
            // call insert method in dao and pass the object parameter to it then return
            addFlag = dao.createNew(ss);
          }
            else{
                // call insert method in dao and pass the object parameter to it then return
                addFlag=dao.createNew(ss);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return addFlag;
    }

    public boolean delete(ScheduleSlotDto ss) {
        boolean deleteFlag = false;
        try{
            if(dao.isExist(ss))
                deleteFlag = dao.delete(ss);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return deleteFlag;
    }

    public boolean update(ScheduleSlotDto ss) {
        boolean updateFlag = true;
        try{ 
                if(dao.isExist(ss))
                {
                    updateFlag = dao.update(ss);
                 }
                else{
                    JOptionPane.showMessageDialog(null,"NO RECORD FOUND TO UPDATE");
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
