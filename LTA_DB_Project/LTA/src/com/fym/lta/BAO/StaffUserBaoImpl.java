package com.fym.lta.BAO;

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.StaffUSerDao;
import com.fym.lta.DTO.StaffDto;
import com.fym.lta.DTO.StaffUserDto;

import javax.swing.JOptionPane;

public class StaffUserBaoImpl implements StaffUserBao {
    
    private StaffUSerDao dao = new DaoFactory().createStaffUserDao();
    
    public StaffUserBaoImpl() {
        super();
    }
    
    /* method to insert new record passed from ui, check the record then pass it to dao layer to 
     insert it in database tables */
    public boolean insert(StaffUserDto staff_acc) {
        boolean addFlag = false;
        try{
            
            
                // call insert method in dao and pass the object parameter to it then return
                addFlag=dao.insert(staff_acc);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return addFlag;
    }

//delete record passed from ui, check if record exists then call delete method from dao to delete it from database
    public boolean delete(StaffUserDto staff_acc) {
        boolean deleteFlag = false;
        try{
            if(dao.isExist(staff_acc))
                deleteFlag = dao.delete(staff_acc);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return deleteFlag;
    }

    public boolean update(StaffUserDto staff_acc) {
        boolean updateFlag = false;
        try{ 
                if(dao.isExist(staff_acc))
                {
                    updateFlag = dao.update(staff_acc );
                 }
                else{
                    updateFlag = dao.insert(staff_acc) ;
                    }    
          
            return updateFlag;
            }
        catch(Exception e){
               e.printStackTrace();
               return false;
           }
    }


  /**Check if staff user account existing in database or not
   * @param take StaffUserDto object
   * @return true if exist, false if not*/
  public Boolean staffIsExist(StaffDto staff)
  
  {
       if(dao.staffIsExist(staff))
        return true;
       
       else 
         return false;
    
  }

  public boolean isExist(StaffUserDto staff_acc)
  {
    boolean flag = false;
    try
      {
        flag = dao.isExist(staff_acc);
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return flag;
  }

  public int getStaffId(StaffUserDto staff_acc)
  {
    int id = 0;
    try
      {
        id = dao.getStaffId(staff_acc);
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return id;
  }
}
