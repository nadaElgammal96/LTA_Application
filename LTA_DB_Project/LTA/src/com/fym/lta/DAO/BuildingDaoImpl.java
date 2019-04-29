package com.fym.lta.DAO;
/**
 *
 * @author Islam
 */

import com.fym.lta.DTO.BuildingDto;

import java.util.Collections;
import java.util.List;
import com.fym.lta.DTO.BuildingDto;

import com.fym.lta.DTO.DepartmentDto;
import com.fym.lta.DTO.EmployeeDto;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import java.util.ArrayList;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class BuildingDaoImpl implements BuildingDao {
    
    public List<BuildingDto> SearchFor(BuildingDto b)
    {
        List<BuildingDto> buildss = null;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet())
        {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("select ID_BUILD,CODE_BUILD,DESCRIPTION_BUILD from BUILDING where ID_BUILD=? OR CODE_BUILD =? OR DESCRIPTION_BUILD=? ");
            try{
                 jdbc.setInt(1,Integer.parseInt(b.getSearch()));
            }catch(NumberFormatException e){                 
                jdbc.setInt(1,-1);
            }
            jdbc.setString(2, b.getSearch());
            jdbc.setString(3, b.getSearch());
            jdbc.execute();
            BuildingDto buil = null;
            while(jdbc.next()){
                if(buil == null){
                    buildss = new ArrayList<>();
                }
                buil = new BuildingDto();
                buil.setId(jdbc.getInt("id_build"));
                buil.setCode(jdbc.getString("code_build"));
                buil.setDescription(jdbc.getString("description_build"));
                
                buildss.add(buil);
                buil= null;
            }
            
        }catch(SQLException e){
             e.printStackTrace();
            System.out.println("invalid input");
            }
            catch(Exception e){
            e.printStackTrace();
        }
        return buildss;

    }


    public List<BuildingDto> viewAll() {
        List<BuildingDto> build = null;
        try{
            JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("select id_build, code_build, description_build " + 
            "from building order by id_build ");
            jdbc.execute();
            BuildingDto b = null;
            while(jdbc.next()){
                if(build == null){
                    build = new ArrayList<>();
                }
                b= new BuildingDto();
                b.setId(jdbc.getInt("ID_build"));
                b.setCode(jdbc.getString("CODE_build"));
                b.setDescription(jdbc.getString("DESCRIPTION_build"));
                build.add(b);
                b= null;
            }

            
        }catch(Exception e){
            e.printStackTrace();
        }
        return build;
    }

    public Boolean createNew(BuildingDto b) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
        {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("insert into BUILDING (ID_BUILD,CODE_BUILD,DESCRIPTION_BUILD) values(?,?,?)");
            jdbc.setInt(1,b.getId());
            jdbc.setString(2,b.getCode());
            jdbc.setString(3,b.getDescription());
            jdbc.execute();
            return true;
        }catch(SQLIntegrityConstraintViolationException e){
                System.out.println("Error !");
                return false;
            }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        }

    public Boolean delete(BuildingDto b) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
                {
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("lta");
                    jdbc.setPassword("lta");
                    jdbc.setCommand("delete from building where CODE_BUILD=?");
                    jdbc.setString(1,b.getCode());
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

    public Boolean isExist(BuildingDto b) {
        boolean flag = false;
                try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) 
                {
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("lta");
                    jdbc.setPassword("lta"); 
                    jdbc.setCommand("SELECT CODE_BUILD FROM BUILDING WHERE CODE_BUILD = ?");
                    jdbc.setString(1, b.getCode());
                    jdbc.execute();
                    while(jdbc.next()){
                        flag = true;
                        break;
                        }
                    return flag;
                }
                catch(Exception e){
                    e.printStackTrace();
                    return false;
                    }
    }

    public Boolean update(BuildingDto b) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
         {
             jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
             jdbc.setUsername("lta");
             jdbc.setPassword("lta");
            
            
             jdbc.setCommand("UPDATE BUILDING " +
                        "SET ID_BUILD = ? , DESCRIPTION_BUILD = ? " +
                        "WHERE CODE_BUILD = ?");
          
             jdbc.setInt(3,b.getId());
             jdbc.setString(2,b.getDescription());
             jdbc.setString(1,b.getCode());
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
}
