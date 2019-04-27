package com.fym.lta.DAO;


import com.fym.lta.DTO.DepartmentDto;
import com.fym.lta.DTO.EmployeeDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class EmployeeDaoImpl implements EmployeeDao {
    UserDaoImpl endUserDaoImpl;

    public Boolean createNew(EmployeeDto emp) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
                {
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("lta");
                    jdbc.setPassword("lta");
                    jdbc.setCommand("insert into EMPLOYEE (SSN_EMPLOYEE,NAME_EMPLOYEE,JOP_EMPLOYEE) values(?,?,?)");
                    jdbc.setString(1,emp.getSsn());
                    jdbc.setString(2,emp.getName());
                    jdbc.setString(3,emp.getJob());
                    jdbc.execute();
                    return true;
                }
                    
                 catch(Exception e){
                    e.printStackTrace();
                    return false;
                }
    
    }

    public Boolean delete(EmployeeDto emp) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
                {
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("lta");
                    jdbc.setPassword("lta");
                    jdbc.setCommand("delete from EMPLOYEE where SSN_EMPLOYEE=?");
                    jdbc.setString(1,emp.getSsn());

                    jdbc.execute();
                    return true;
                }catch(java.sql.SQLException e){
                    return false;
                }
                catch(Exception e){
                    e.printStackTrace();
                    return false;
            }
        
    }

    public Boolean update(EmployeeDto emp) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
         {
             jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
             jdbc.setUsername("lta");
             jdbc.setPassword("lta");
             jdbc.setCommand("UPDATE EMPLOYEE " + 
             "SET NAME_EMPLOYEE = ? ,JOP_EMPLOYEE = ? " + 
             "WHERE SSN_EMPLOYEE = ?");
            
             jdbc.setString(1,emp.getName());
             jdbc.setString(2,emp.getJob());
             jdbc.setString(3,emp.getSsn());
             jdbc.execute();
             return true;
         }catch(java.sql.SQLException e){
             return false;
         }
         catch(Exception e){
             e.printStackTrace();
             return false;
        }
    }

    public List<EmployeeDto> searchFor(EmployeeDto emp) {
        List<EmployeeDto> emps = null;
       // EmployeeDto emp = null;
        try (JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet())
        {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
            jdbc.setCommand("select SSN_EMPLOYEE , NAME_EMPLOYEE , JOP_EMPLOYEE from EMPLOYEE where EMPLOYEE.SSN_EMPLOYEE=? OR EMPLOYEE.NAME_EMPLOYEE=? OR EMPLOYEE.JOP_EMPLOYEE=? ");
            jdbc.setString(1,emp.getSearch());
            jdbc.setString(2,emp.getSearch());
            jdbc.setString(3,emp.getSearch());
            jdbc.execute();
            
            EmployeeDto employee = null;
            while(jdbc.next()){
                if(employee == null){
                    emps = new ArrayList<>();
                }
                employee= new EmployeeDto();
                employee .setSsn(jdbc.getString("SSN_EMPLOYEE"));
                employee .setName(jdbc.getString("NAME_EMPLOYEE"));
                employee .setJob(jdbc.getString("JOP_EMPLOYEE"));
                
                emps.add(employee);
                employee= null;
            }
            
            
        }catch(SQLException e){
             e.printStackTrace();
            System.out.println("Error Searching for Employee!");
            }
            catch(Exception e){
            e.printStackTrace();
        }
        
        return emps ; 
    }

    public List<EmployeeDto> viewAll() {
        List <EmployeeDto> employees = null ;
        try {
            JdbcRowSet jdbc = RowSetProvider.newFactory() .createJdbcRowSet();
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("select SSN_EMPLOYEE,NAME_EMPLOYEE,JOP_EMPLOYEE from EMPLOYEE order by SSN_EMPLOYEE ");
            jdbc.execute();
            
            EmployeeDto temp = null;
            while(jdbc.next()){
                if (employees == null ){
                employees = new ArrayList <>();
                }
                temp = new EmployeeDto ();
                temp.setSsn(jdbc.getString("SSN_EMPLOYEE"));
                temp.setName(jdbc.getString("NAME_EMPLOYEE"));
                temp.setJob(jdbc.getString("JOP_EMPLOYEE"));
                employees.add(temp);
                temp = null ; 
                
            }
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null, "Error Listing Employees!");
            }

        catch (Exception e ){
            e.printStackTrace();
        }
        return employees;
    }

    public Boolean isExist(EmployeeDto emp) {
        boolean flag = false;
                       try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) 
                       {
                           jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                           jdbc.setUsername("lta");
                           jdbc.setPassword("lta"); 
                           jdbc.setCommand("SELECT SSN_EMPLOYEE FROM EMPLOYEE WHERE SSN_EMPLOYEE = ?");
                           jdbc.setString(1, emp.getSsn());
                           jdbc.execute();
                          
                         while(jdbc.next()){
                                flag = true;
                                break;
                                }
                            return flag;
                        } 
                           catch(java.sql.SQLException e){
                               JOptionPane.showMessageDialog(null, "Error Finding Employee!");
                               return false;
                               }
                       
    catch(Exception e){
                       e.printStackTrace();
                       return false;}
                       }
    
    
    }
    
                    
