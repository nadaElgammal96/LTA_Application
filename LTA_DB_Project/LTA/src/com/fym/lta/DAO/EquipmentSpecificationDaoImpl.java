package com.fym.lta.DAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DTO.EquipSpecificationDto;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JOptionPane;

public class EquipmentSpecificationDaoImpl implements EquipmentSpecificationDao {
    
    public Boolean update(EquipSpecificationDto es) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("update EQ_SPEECIFICATION " + "set NAME = ? ,VALUE = ? "
                            +"where NO = ? ");
            jdbc.setString(1,es.getName());
            jdbc.setString(2,es.getValue());
            try{jdbc.setInt(3,es.getId());}
            catch(NumberFormatException e){
                jdbc.setInt(3,-1);
                return false;
                }
            jdbc.execute();
            return true;
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null , "Error Updating Specification");
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean createNew(EquipSpecificationDto es) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) 
        {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta"); 
            jdbc.setCommand("insert into EQ_SPEECIFICATION  ( NO , NAME , VALUE ) values( ? , ? , ? )");
            try{
                jdbc.setInt(1,es.getId());
            }catch(NumberFormatException e){
                jdbc.setInt(1,-1);
            }
            jdbc.setString(2,es.getName());
            jdbc.setString(3,es.getValue());
            jdbc.execute();
        return true;   
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null , "Error Inserting Specification");
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
        return false;
        }
    }

    public Boolean delete(EquipSpecificationDto es) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("delete from EQ_SPEECIFICATION where NO = ? ");
            try{jdbc.setInt(1,es.getId());
            }catch(NumberFormatException e) {
                jdbc.setInt(1,-1);
            }
            jdbc.execute();
            return true;
        }catch(java.sql.SQLException e){
          JOptionPane.showMessageDialog(null, "There exist Types of this Specification\n Please Delete them first!");
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<EquipSpecificationDto> searchFor(EquipSpecificationDto es) {
        List<EquipSpecificationDto> equip = null;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("select NO, NAME, VALUE " +
                            "from EQ_SPEECIFICATION where NO=? OR NAME=? OR VALUE=? ");
            try {jdbc.setInt(1,Integer.parseInt(es.getSearch()));
            }
            catch(NumberFormatException e){
                jdbc.setInt(1,-1);
            }
            jdbc.setString(2,es.getSearch());
            jdbc.setString(3,es.getSearch());
            jdbc.execute();
            EquipSpecificationDto e = null;
            while(jdbc.next())
            {
                if(equip == null){
                equip = new ArrayList<>();
                }
                e= new EquipSpecificationDto();
                e.setId(jdbc.getInt("NO"));
                e.setName(jdbc.getString("NAME"));
                e.setValue(jdbc.getString("VALUE"));
                equip.add(e);
                e= null;
            }
        }
            catch(java.sql.SQLException e){
                JOptionPane.showMessageDialog(null , "Error Searching For Specification");
            }
        catch(Exception e){
            e.printStackTrace();
            }
        return equip;
        }

    public List<EquipSpecificationDto> viewAll() {
        List<EquipSpecificationDto> es = null;
                try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("lta");
                    jdbc.setPassword("lta");
                    jdbc.setCommand("select NO, NAME, VALUE " + 
                                    "from EQ_SPEECIFICATION" );
                    jdbc.execute();
                    EquipSpecificationDto e = null;
                    while(jdbc.next()){
                        if(es == null){
                        es = new ArrayList<>();
                        }
                        e= new EquipSpecificationDto();
                        e.setId(jdbc.getInt("NO"));
                        e.setName(jdbc.getString("NAME"));
                        e.setValue(jdbc.getString("Value"));
                        es.add(e);
                        e= null;
                    }
                }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null , "Error Listing Specification");
        }
                catch(Exception e){
                        e.printStackTrace();
                    }
                return es;
    }

    public Boolean isExist(EquipSpecificationDto es) {
        boolean flag = false;
                try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) 
                {
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("lta");
                    jdbc.setPassword("lta"); 
                    jdbc.setCommand("SELECT NO FROM EQ_SPEECIFICATION where NO=?  ");
                    jdbc.setInt(1,es.getId());
                    jdbc.execute();
                    while(jdbc.next()){
                        flag = true;
                        break;
                        }
                    return flag;
                }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null , "Error Finding Specification");
            return false;
        }
                catch(Exception e){
                    e.printStackTrace();
                    return false;
                    }
    }
}
