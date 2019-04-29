package com.fym.lta.DAO;


import com.fym.lta.DTO.BuildingDto;
import com.fym.lta.DTO.DepartBuildingDto;
import java.util.Collections;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class DepartBuildingDaoImpl implements DepartBuildingDao {
    public Boolean delete (DepartBuildingDto bd) {
        
        
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();)
                        {
                    
                            // Start DataBase connection
                            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                            jdbc.setUsername("lta");
                            jdbc.setPassword("lta");
                    
                    
                           // Delete the row with id of the selected department and its dependence
                            jdbc.setCommand("delete from DEPARTMENT_BUILDING where ID_DEPARTMENT=?");
                            jdbc.setInt(1,bd.getDepartment_id());
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

    public DepartBuildingDto searchFor(String c) {
        return null;
    }

    public List<DepartBuildingDto> viewAll() {
        return Collections.emptyList();
    }

    public Boolean update(DepartBuildingDto bd) {
        return null;
    }

    public Boolean createNew(DepartBuildingDto bd) {
        
        
        try (JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet()) {


            // Start DataBase connection
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");

            

            //Insert department in buildings through thier relationship
                jdbc.setCommand("insert into DEPARTMENT_BUILDING" +
                                "(ID_DEPARTMENT,ID_BUILD) values(?,?)");
                jdbc.setInt(1, bd.getDepartment_id());
                jdbc.setInt(2, bd.getBuilding_id());

            
            return true;

        } catch (java.sql.SQLException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean isExist(DepartBuildingDto bd){return null;}
}
