package com.fym.lta.BAO;

import com.fym.lta.DAO.UserDao;
import com.fym.lta.DAO.UserDaoImpl;
import com.fym.lta.DTO.EmployeeDto;
import com.fym.lta.DTO.RoleDto;
import com.fym.lta.DTO.StaffDto;
import com.fym.lta.DTO.UserDto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class UserBaoImpl implements UserBao {
    
    UserDaoImpl dao =new UserDaoImpl();

  /**use to check if the last user logged in program saved his login or not
   * @return the last logged in user
   * */
    public  void savelogin(UserDto u)
    {
    try
      {
           dao.savelogin(u);
      }
    catch(Exception e)
      {
        e.printStackTrace();
       
      }}

  /**use to check if the last user logged in program saved his login or not
   * @return the last logged in user
   * */
    public UserDto Keeplogin()
    {
      
    List<UserDto> list = null;
    UserDto user =null;
    try
      {
      
        list = dao.Keeplogin();
      
        if(!list.isEmpty() && list!=null)
        {for(int i=0 ; i<list.size() ; i++)
             user = list.get(i);}
      }
    catch(Exception e)
      {
        user = new UserDto();
        e.printStackTrace();
      }
        return user;
      }

  /** Method to view all exist users
   * @param no parameters
   * @return list of users objects */
    public List<UserDto> viewAll() {
        List<UserDto> list = null;
        try{
             list = dao.viewAll();
                               }
        catch(Exception e){
        e.printStackTrace();
        }
        return list;
            }


  /** Create a new user account
   * @param takes user object inserted by anthor user
   * @Return true for if it success, False if not */
  public boolean add(UserDto u, UserDto user)
  {
    boolean saveFlage = true;
    try
      {
        //data is valid
        if(dao.isExist(u))
          {
           
            saveFlage = false;

          }
        else
          {
            saveFlage = dao.createNew(u, user);
          }
      }
    catch(Exception e)
      {
        e.printStackTrace();
        return false;
      }
    return saveFlage;
  }

  /** Delete user account.
   * Takes the object and return true if it has deleted and false if any exception occur*/
    public boolean delete(UserDto u) {
        
                        boolean deleteFlage = true;
                        try{
                            if(dao.isExist(u))
                                deleteFlage = dao.delete(u);
                            else
                                deleteFlage = false;
                        }catch(Exception e){
                            e.printStackTrace();
                            return false;
                        }
                        return deleteFlage;
            }


  /** Search For user account with any attributes of it(id,name,code,...)
   * This method takes user object and return list of users if exist.
   */
    public List<UserDto> searchFor(UserDto user) {
        List<UserDto> users = null;
              try{
                  users = dao.searchFor(user);
                  return  users ;
              }
              catch(Exception e){
                  e.printStackTrace();
                  return  users;
              }}


  /** update an existed one
   * @param takes user object inserted by user
   * @Return true for if it success, False if not */
  public boolean update(UserDto u, UserDto user)
  {

    boolean updateFlag = true;
    try
      {

        if(dao.isExist(user))
          {
            updateFlag = dao.update(u, user);
          }
        else
          {
            
            updateFlag = false;
          }
      }

    catch(Exception e)
      {
        e.printStackTrace();
        return false;
      }
    return updateFlag;
  }


  /** used for login
   * @param take user object with entered username/email and password
   * @return it with other needed data (if user found in database)
   */
    public UserDto login(UserDto user)
   {
       UserDto result = null;
       result = dao.check(user);
       
       if(result!=null)
           return result;
           
       else
       return null;
   }



  /**Method to get user staff 
   * @param take user dto
   * @return user's staff (if exist)
   * */
  public StaffDto getStaff(UserDto u)
{
    StaffDto staff = null;
    staff = dao.getStaff(u);

    if(staff!=null)
      return staff;

    else
      return null;
}

  /**Method to get user employee
   * @param take user dto
   * @return user's employee (if exist)
   * */
  public EmployeeDto getEmployee(UserDto u)
  
  {
    EmployeeDto employee = null;
    employee = dao.getEmployee(u);

    if(employee!=null)
      return employee;

    else
      return null;
    
  }

  //////////////////////////Nada El-Gammal
  public int calcMaxId()
  {
    int id = 0;
    try
      {
        id = dao.getMaxId();
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return id;
  }


  ///////////////////////Nada El-Gammal
  public boolean isExist(UserDto u)
  {
    boolean existFlag = false;
    try
      {
        existFlag = dao.isExist(u);
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return existFlag;
  }


  ////////////////////////////////Nada El-Gammal
  public int getId(UserDto u)
  {
    int id = 0;
    try
      {
        id = dao.getId(u);
      }
    catch(Exception e)
      {
        e.printStackTrace();
      }
    return id;
  }


}
