package com.fym.lta.DAO;

import com.fym.lta.DTO.StageScheduleDto;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class StageScheduleDaoImpl implements StageScheduleDao {
    public StageScheduleDaoImpl() {
        super();
    }

    public Boolean update(StageScheduleDto ss) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            
            // start connection with database using resourses 
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
            // database query to perform update action 
            jdbc.setCommand("update SCHEDULE_STAGE " + "set CODE_STAGE=? where ID_SCHEDULE = ? ");
            
            // passing object attributes as inputs to the query
            jdbc.setString(1,ss.getStage_code());
            jdbc.setInt(2,ss.getSchedule_id());
            // query execution
            jdbc.execute();
            return true;
        }
        catch(java.sql.SQLException e){
                // show message if any sql error occured

            JOptionPane.showMessageDialog(null, "Error Updating Data");
            return false;
            }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean isExist(StageScheduleDto ss) {
        boolean existFlag = false;
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            
        //open connection with database using resources
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
        //query to select the record using its id
            jdbc.setCommand("select ID_SCHEDULE , CODE_STAGE from SCHEDULE_STAGE where ID_SCHEDULE=? AND CODE_STAGE=? ");
           
        //pass id to query
            try{
                jdbc.setInt(1,ss.getSchedule_id());
            }catch(NumberFormatException e){
                jdbc.setInt(1,-1);
                }
            jdbc.setString(2,ss.getStage_code());
            
            jdbc.execute();
            while(jdbc.next()){
                
        // set flag to true if record is found then return falg
            existFlag=true;
                break;
            }
        }
        catch(java.sql.SQLException e){
            
        //show message if any sql error occured
            JOptionPane.showMessageDialog(null,"Error Finding Data"); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return existFlag;
    }

    public Boolean createNew(StageScheduleDto ss) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            
            //open connection with dataase using resources
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
            //query to insert staff id and its user id in database 
            jdbc.setCommand("insert into SCHEDULE_STAGE ( ID_SCHEDULE , CODE_STAGE  ) VALUES ( ? , ? ) ");
            
        //pass objects from dto object to query as input to be inserted
            try{
                jdbc.setInt(1,ss.getSchedule_id());
            }catch(NumberFormatException e){
                jdbc.setInt(1,-1);
            }
                jdbc.setString(2,ss.getStage_code());
            
        //query execution
            jdbc.execute();
            return true;
        }
        catch(java.sql.SQLException e){
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(StageScheduleDto ss) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            
        // open connection with database using resources
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            
        // query to delete record using its id
            jdbc.setCommand("delete from SCHEDULE_STAGE where CODE_STAGE = ? ");
          
          //pass id from dto object parameter to the query
            jdbc.setString(1,ss.getStage_code());
        // query execution
            jdbc.execute();
            return true;
            }
        catch(java.sql.SQLException e){
            
        //show message when any sql error occurs
            JOptionPane.showMessageDialog(null,"Error Deleting Data");
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;}
    }
}
