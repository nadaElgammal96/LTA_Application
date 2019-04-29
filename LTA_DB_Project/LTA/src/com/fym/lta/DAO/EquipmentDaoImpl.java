package com.fym.lta.DAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DTO.EquipTypeSpecDetailsDto;
import com.fym.lta.DTO.EquipmentDto;

import com.fym.lta.DTO.EquipmentTypeDto;

import java.util.Collections;
import java.util.List;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EquipmentDaoImpl implements EquipmentDao {
    
    
    public Boolean update(EquipmentDto eq) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("update EQUIPMENT " + "set CODE_EQ = ?  , COUNTRY_EQ = ? , ID_EQ_TYPE = ? "
                            + "where ID_EQ = ? ");
            jdbc.setString(1,eq.getCode());
            jdbc.setString(2,eq.getCountry());
            try{jdbc.setInt(3,eq.getType().getId());}
            catch(NumberFormatException e){
                    jdbc.setInt(3,-1);
                }
            try {
                jdbc.setInt(4,eq.getId());}
            catch(NumberFormatException e){
                    jdbc.setInt(4,-1);
                }
            jdbc.execute();
            return true;
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null, "Error Updating Equipment");
            return false;
            }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(EquipmentDto eq) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("delete from EQUIPMENT where EQUIPMENT.CODE_EQ = ?  ");
            jdbc.setString(1,eq.getCode());
            jdbc.execute();
            return true;
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null, "Error Deleting Equipment");
            return false;
            }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<EquipmentDto> viewAll() {
    List<EquipmentDto> equip = null;
    try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
        jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
        jdbc.setUsername("lta");
        jdbc.setPassword("lta");
        jdbc.setCommand("select EQUIPMENT.ID_EQ, EQUIPMENT.CODE_EQ, EQUIPMENT.ID_EQ_TYPE, EQUIPMENT.COUNTRY_EQ , EQ_TYPE.ID_EQ_TYPE , EQ_TYPE.CODE_EQ_TYPE , EQ_TYPE.NAME_EQ_TYPE , EQ_TYPE.NO_OF_EQ " + 
                        "from EQUIPMENT , EQ_TYPE where EQUIPMENT.ID_EQ_TYPE = EQ_TYPE.ID_EQ_TYPE order by ID_EQ ");
        jdbc.execute();
        EquipmentDto e = null;
        EquipmentTypeDto et = null;
        while(jdbc.next()){
            if(equip == null){
            equip = new ArrayList<>();
            }
            et = new EquipmentTypeDto();
            et.setId(jdbc.getInt("ID_EQ_TYPE"));
            et.setCode(jdbc.getString("CODE_EQ_TYPE"));
            et.setName(jdbc.getString("NAME_EQ_TYPE"));
            et.setNo_of_equip(jdbc.getInt("NO_OF_EQ"));
            e= new EquipmentDto();
            e.setId(jdbc.getInt("ID_EQ"));
            e.setCode(jdbc.getString("CODE_EQ"));
            e.setType(et);
            e.setCountry(jdbc.getString("COUNTRY_EQ"));
            equip.add(e);
            e= null;
        }
    }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null, "Error Listing Equipments");
            }
    catch(Exception e){
            e.printStackTrace();
        }
    return equip;
    }

    public Boolean createNew(EquipmentDto eq) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) 
        {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta"); 
            jdbc.setCommand(" insert into EQUIPMENT  ( ID_EQ , CODE_EQ , ID_EQ_TYPE , COUNTRY_EQ ) values( ? , ? , ? , ? ) ");
            try{jdbc.setInt(1,eq.getId());}
            catch(NumberFormatException e){
                    jdbc.setInt(1,-1);
                }
            jdbc.setString(2,eq.getCode());
            try{jdbc.setInt(3,eq.getType().getId());}
            catch(NumberFormatException e){
                    jdbc.setInt(3,-1);
                }
            jdbc.setString(4,eq.getCountry());
            jdbc.execute();
        return true;   
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null, "Error Inserting Equipment");
            return false;
            }
        catch(Exception e){
            e.printStackTrace();
        return false;
        }
    }

    public Boolean isExist(EquipmentDto eq) {
        boolean flag = false;
                try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) 
                {
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("lta");
                    jdbc.setPassword("lta"); 
                    jdbc.setCommand("SELECT EQUIPMENT.ID_EQ FROM EQUIPMENT where EQUIPMENT.ID_EQ=?  ");
                    jdbc.setInt(1,eq.getId());
                    jdbc.execute();
                    while(jdbc.next()){
                        flag = true;
                        break;
                        }
                    return flag;
                }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null, "Error Finding Equipment");
            return false;
            }
                catch(Exception e){
                    e.printStackTrace();
                    return false;
                    }
    }
    
    public List<EquipmentDto> searchFor(EquipmentDto eq) {
        List<EquipmentDto> equip = null;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("select EQUIPMENT.ID_EQ, EQUIPMENT.CODE_EQ, EQUIPMENT.ID_EQ_TYPE, EQUIPMENT.COUNTRY_EQ " + 
                            "from EQUIPMENT where EQUIPMENT.ID_EQ=? OR EQUIPMENT.CODE_EQ=? OR EQUIPMENT.ID_EQ_TYPE=? OR EQUIPMENT.COUNTRY_EQ=? ");
            try{jdbc.setInt(1,Integer.parseInt(eq.getSearch()));}
            catch(NumberFormatException e){                 
                            jdbc.setInt(1,-1);
                        }
            jdbc.setString(2,eq.getSearch());
            try{jdbc.setInt(3,Integer.parseInt(eq.getSearch()));}
            catch(NumberFormatException e){                 
                            jdbc.setInt(3,-1);
                        }
            jdbc.setString(4,eq.getSearch());
            jdbc.execute();
            EquipmentDto e = null;
            while(jdbc.next())
            {
                if(equip == null){
                equip = new ArrayList<>();
                }
                e= new EquipmentDto();
                e.setId(jdbc.getInt("ID_EQ"));
                e.setCode(jdbc.getString("CODE_EQ"));
                e.setType(new EquipmentTypeDto(jdbc.getInt("ID_EQ_TYPE")));
                e.setCountry(jdbc.getString("COUNTRY_EQ"));
                equip.add(e);
                e= null;
            }
            
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null, "Error Searching For Equipment");
            }
        catch(Exception e){
            e.printStackTrace();
            }
        return equip;
    }
}
