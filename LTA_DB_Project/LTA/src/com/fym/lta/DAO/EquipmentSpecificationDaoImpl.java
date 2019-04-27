package com.fym.lta.DAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DTO.EquipSpecificationDto;

import com.fym.lta.DTO.EquipmentDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class EquipmentSpecificationDaoImpl implements EquipmentSpecificationDao {
    
    public Boolean update(EquipSpecificationDto es) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("update EQ_SPECIFICATION" + "set (NAME,VALUE) values(?,?) ");
            jdbc.setString(1,es.getName());
            jdbc.setString(2,es.getValue());
            jdbc.execute();
            return true;
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
            jdbc.setCommand("insert into EQ_SPECIFICATION  (NO,NAME,VALUE) values(?,?,?)");
            jdbc.setInt(1,es.getId());
            jdbc.setString(2,es.getName());
            jdbc.setString(3,es.getValue());
            jdbc.execute();
        return true;   
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
            jdbc.setCommand("delete from EQ_SPECIFICATION where EQ_SPECIFICATION.NAME = ?  ");
            jdbc.setString(1,es.getName());
            jdbc.execute();
            return true;
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
            jdbc.setCommand("select EQ_SPECIFICATION.NO, EQ_SPECIFICATION.NAME, EQ_SPECIFICATION.VALUE" + "from EQ_SPECIFICATION where EQ_SPECIFICATION.NO=?|EQ_SPECIFICATION.NAME=?|EQ_SPECIFICATION.VALUE=?");
            jdbc.setInt(1,Integer.parseInt(es.getSearch()));
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
                    jdbc.setCommand("select EQ_SPECIFICATION.NO, EQ_SPECIFICATION.NAME, EQ_SPECIFICATION.VALUE" + "from EQ_sPECIFICATION" );
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
                    jdbc.setCommand("SELECT EQ_SPECIFICATION.NAME FROM EQ_SPECIFICATION where EQ_SPECIFICATION.NAME=?  ");
                    jdbc.setString(1,es.getName());
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
}
