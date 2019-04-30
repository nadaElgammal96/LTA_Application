package com.fym.lta.DAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DTO.EquipmentDto;
import com.fym.lta.DTO.EquipmentTypeDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class EquipmentTypeDaoImpl implements EquipmentTypeDao {
    
    public List<EquipmentTypeDto> searchFor(EquipmentTypeDto et) {
        List<EquipmentTypeDto> equipt = null;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("select ID_EQ_TYPE , CODE_EQ_TYPE , NAME_EQ_TYPE , NO_OF_EQ from EQ_TYPE where ID_EQ_TYPE=? OR CODE_EQ_TYPE =? OR NAME_EQ_TYPE=? OR NO_OF_EQ=? ");
            try{jdbc.setInt(1,Integer.parseInt(et.getSearch()));
            }catch(NumberFormatException e){                 
                jdbc.setInt(1,-1);
            }
            jdbc.setString(2,et.getSearch());
            jdbc.setString(3,et.getSearch());
            try{jdbc.setInt(4,Integer.parseInt(et.getSearch()));
            }catch(NumberFormatException e){                 
                jdbc.setInt(4,-1);
            }
            jdbc.execute();
            EquipmentTypeDto e = null;
            while(jdbc.next())
            {
                if(equipt == null){
                equipt = new ArrayList<>();
                }
                e= new EquipmentTypeDto();
                e.setId(jdbc.getInt("ID_EQ_TYPE"));
                e.setCode(jdbc.getString("CODE_EQ_TYPE"));
                e.setName(jdbc.getString("NAME_EQ_TYPE"));
                e.setNo_of_equip(jdbc.getInt("NO_OF_EQ"));
                equipt.add(e);
                e= null;
            }
        }
            catch(java.sql.SQLException e){
                JOptionPane.showMessageDialog(null, "Error Searching For Equipment Type");
                }
        catch(Exception e){
            e.printStackTrace();
            }
        return equipt;
        }

    public List<EquipmentTypeDto> viewAll() {
        List<EquipmentTypeDto> equipt = null;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("select ID_EQ_TYPE , CODE_EQ_TYPE , NAME_EQ_TYPE , NO_OF_EQ " 
                            + "from EQ_TYPE  order by ID_EQ_TYPE" );
            jdbc.execute();
            EquipmentTypeDto et = null;
            while(jdbc.next()){
                if(equipt == null){
                equipt = new ArrayList<>();
                }
                et= new EquipmentTypeDto();
                et.setId(jdbc.getInt("ID_EQ_TYPE"));
                et.setCode(jdbc.getString("CODE_EQ_TYPE"));
                et.setName(jdbc.getString("NAME_EQ_TYPE"));
                et.setNo_of_equip(jdbc.getInt("NO_OF_EQ"));
                equipt.add(et);
                et= null;
            }
        }
            catch(java.sql.SQLException e){
                JOptionPane.showMessageDialog(null, "Error Listing Equipment Types");
                }
        catch(Exception e){
                e.printStackTrace();
            }
        return equipt;

        }

    public Boolean createNew(EquipmentTypeDto et) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) 
        {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta"); 
            jdbc.setCommand("insert into EQ_TYPE( ID_EQ_TYPE , CODE_EQ_TYPE , NAME_EQ_TYPE ) values(?,?,?) ");
            try{jdbc.setInt(1,et.getId());}
            catch(NumberFormatException e){                 
                            jdbc.setInt(1,-1);
                        }
            jdbc.setString(2,et.getCode());
            jdbc.setString(3,et.getName());
            jdbc.execute();
        return true;   
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null, "Error Inserting Equipment Type");
            return false;
            }
        catch(Exception e){
            e.printStackTrace();
        return false;
        }
    }

    public Boolean isExist(EquipmentTypeDto et) {
        boolean flag = false;
                try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) 
                {
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("lta");
                    jdbc.setPassword("lta"); 
                    jdbc.setCommand("SELECT EQ_TYPE.ID_EQ_TYPE FROM EQ_TYPE where EQ_TYPE.ID_EQ_TYPE=?  ");
                    try{jdbc.setInt(1,et.getId());}
                    catch(NumberFormatException e){
                        jdbc.setInt(1,-1);
                    }
                    jdbc.execute();
                    while(jdbc.next()){
                        flag = true;
                        break;
                        }
                    return flag;
                }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null, "Error Finding Equipment!");
            return false;
            }
                catch(Exception e){
                    e.printStackTrace();
                    return false;
                    }
    }

    public Boolean update(EquipmentTypeDto et) {
            try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                jdbc.setUsername("lta");
                jdbc.setPassword("lta");
                jdbc.setCommand("update EQ_TYPE " + "set CODE_EQ_TYPE=? , NAME_EQ_TYPE=?, NO_OF_EQ=? "
                                + "where ID_EQ_TYPE = ? ");
                jdbc.setString(1,et.getCode());
                jdbc.setString(2,et.getName());
                try{jdbc.setInt(3,et.getNo_of_equip());}
                catch(NumberFormatException e){                 
                                jdbc.setInt(3,-1);
                            }
                try{jdbc.setInt(4,et.getId());}
                catch(NumberFormatException e){                 
                                jdbc.setInt(4,-1);
                            }
                jdbc.execute();
                return true;
            }
            catch(java.sql.SQLException e){
                JOptionPane.showMessageDialog(null, "Error Updating Type");
                return false;
                }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }

    public Boolean delete(EquipmentTypeDto et) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("delete from EQ_TYPE where EQ_TYPE.CODE_EQ_TYPE = ?  ");
            jdbc.setString(1,et.getCode());
            jdbc.execute();
            return true;
        }
        catch(java.sql.SQLException e){
          JOptionPane.showMessageDialog(null, "There exist Equipments of this type\n Please Delete them first!");
            return false;
            }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public List<EquipmentDto> loadAllEquipments(EquipmentTypeDto et){
        List<EquipmentDto> eq = null ;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("select ID_EQ , CODE_EQ , COUNTRY_EQ from EQUIPMENT where EQUIPMENT.ID_EQ_TYPE=? order by ID_EQ ");
            try{jdbc.setInt(1,et.getId());
            }catch(NumberFormatException e){                 
                jdbc.setInt(1,-1);
            }
            jdbc.execute();
            EquipmentDto e = null;
            while(jdbc.next()) {
                if(eq==null)
                    eq = new ArrayList<>();
                e = new EquipmentDto();
                e.setId(jdbc.getInt("ID_EQ"));
                e.setCode(jdbc.getString("CODE_EQ"));
                e.setCountry(jdbc.getString("COUNTRY_EQ"));
                e.setType(new EquipmentTypeDto(et.getCode(),et.getNo_of_equip(),et.getName(),et.getId()));
                eq.add(e);
                e=null;
            }
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null, "Error Listing Equipments");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return eq;
        
    }

    
}
