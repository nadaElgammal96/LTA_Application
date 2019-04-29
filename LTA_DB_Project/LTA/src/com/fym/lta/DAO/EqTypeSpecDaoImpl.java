package com.fym.lta.DAO;

/**
 *
 * @author Nada El-Gammal
 */

import com.fym.lta.DTO.EquipSpecificationDto;
import com.fym.lta.DTO.EquipTypeSpecDetailsDto;

import com.fym.lta.DTO.EquipmentTypeDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class EqTypeSpecDaoImpl implements EqTypeSpecDao {
    public EqTypeSpecDaoImpl() {
        super();
    }

    public boolean insert(EquipTypeSpecDetailsDto type_spec) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("insert into SPECIFICATION_EQ_TYPE ( ID , ID_EQ_TYPE , NO ) VALUES ( ? , ? , ? ) ");
            try{
                jdbc.setInt(1,type_spec.getId());
            }catch(NumberFormatException e){
                jdbc.setInt(1,-1);
            }
            try{
                jdbc.setInt(2,type_spec.getType_id());
            }catch(NumberFormatException e){
                jdbc.setInt(2,-1);
            }
            try{
                jdbc.setInt(3,type_spec.getSpecification_id());
            }catch(NumberFormatException e){
                jdbc.setInt(1,-1);
            }
            jdbc.execute();
            return true;
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null,"Error Inserting Data");
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(EquipTypeSpecDetailsDto type_spec) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("delete from SPECIFICATION_EQ_TYPE where ID = ? ");
            try{jdbc.setInt(1,type_spec.getId());
            }catch(NumberFormatException e){
                jdbc.setInt(1,-1);
            }
            jdbc.execute();
            return true;
            }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null,"Error Deleting Data");
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;}
    }

    public List<EquipTypeSpecDetailsDto> listAll() {
        List<EquipTypeSpecDetailsDto> eq = null;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("select ID , ID_EQ_TYPE , NO from SPECIFICATION_EQ_TYPE order by ID ");
            jdbc.execute();
            EquipTypeSpecDetailsDto eq_t_sp = null;
            while(jdbc.next()){
                if(eq==null)
                    eq = new ArrayList<>();
                eq_t_sp = new EquipTypeSpecDetailsDto();
                eq_t_sp.setId(jdbc.getInt("ID"));
                eq_t_sp.setType_id(jdbc.getInt("ID_EQ_TYPE"));
                eq_t_sp.setSpecification_id(jdbc.getInt("NO"));
                eq.add(eq_t_sp);
                eq_t_sp = null; 
            }
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null,"Error Viewing Data");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return eq;
    }

    public List<EquipSpecificationDto> loadAllSpecif(EquipmentTypeDto type) {
        List<EquipSpecificationDto> eq_sp = null;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("select EQ_SPEECIFICATION.NO , EQ_SPEECIFICATION.NAME , EQ_SPEECIFICATION.VALUE " +
                "from EQ_SPEECIFICATION , SPECIFICATION_EQ_TYPE " +
                "where (SPECIFICATION_EQ_TYPE.NO = EQ_SPEECIFICATION.NO) AND (SPECIFICATION_EQ_TYPE.ID_EQ_TYPE = ? ) ");
            jdbc.setInt(1,type.getId());
            jdbc.execute();
            EquipSpecificationDto e = null;
            while(jdbc.next()){
                if(eq_sp==null)
                    eq_sp = new ArrayList<>();
                e = new EquipSpecificationDto();
                e.setId(jdbc.getInt("NO"));
                e.setName(jdbc.getString("NAME"));
                e.setValue(jdbc.getString("VALUE"));
                eq_sp.add(e);
                e = null;
            }
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null,"Error Viewing Data");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return eq_sp;
    }
    
    public boolean isExist (EquipTypeSpecDetailsDto type_spec){
        boolean existFlag = false;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("select ID from SPECIFICATION_EQ_TYPE where ID = ? ");
            try{
                jdbc.setInt(1,type_spec.getId());
            }catch(NumberFormatException e){
                jdbc.setInt(1,-1);
            }
            jdbc.execute();
            while(jdbc.next()){
            existFlag=true;
                break;
            }
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null,"Error Finding Data"); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return existFlag;

    }
}
