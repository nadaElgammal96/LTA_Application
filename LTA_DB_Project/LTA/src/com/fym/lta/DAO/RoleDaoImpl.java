package com.fym.lta.DAO;


import com.fym.lta.DTO.EquipTypeSpecDetailsDto;
import com.fym.lta.DTO.EquipmentDto;
import com.fym.lta.DTO.EquipmentTypeDto;
import com.fym.lta.DTO.RoleDto;

import com.fym.lta.DTO.UserDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.management.relation.Role;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import javax.swing.JOptionPane;

public class RoleDaoImpl implements RoleDao {
    public Boolean update(RoleDto r) {
        try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
            jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
            jdbc.setUsername("lta");
            jdbc.setPassword("lta");
            jdbc.setCommand("update ROLE " + "set NAME_ROLE=?, DESCRIPTION_ROLE=? "
                            + "where ID_ROLE = ? ");
            jdbc.setString(1,r.getName());
            jdbc.setString(2,r.getDescription());
            try{jdbc.setInt(3,r.getId());}
            catch(NumberFormatException e){                 
                            jdbc.setInt(3,-1);
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

    public Boolean createNew(RoleDto r) {
        try{JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();
    
                  jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                  jdbc.setUsername("lta");
                  jdbc.setPassword("lta");
                  jdbc.setCommand(" insert into ROLE ( ROLE.ID_ROLE, ROLE.NAME_ROLE, ROLE.DESCRIPTION_ROLE ) values(?, ?, ?) ");
            try{jdbc.setInt(1,r.getId());}
            catch(NumberFormatException e){
                    jdbc.setInt(1,-1);
                }
                  jdbc.setString(2,r.getName());
                  jdbc.setString(3,r.getDescription());
                  jdbc.execute();
                  return true;
        }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null,"Error Inserting Employee");
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
        return false;
        }
    }
    public Boolean isExist(RoleDto r) {
        boolean flag = false;
               try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) 
               {
                   jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                   jdbc.setUsername("lta");
                   jdbc.setPassword("lta"); 
                   jdbc.setCommand("SELECT ROLE.ID_ROLE FROM ROLE where ROLE.ID_ROLE=?");
                   jdbc.setInt(1,r.getId());
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
    public List<RoleDto> viewAll() {
        List<RoleDto> role = null;
        try{JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();
            
                  jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                  jdbc.setUsername("lta");
                  jdbc.setPassword("lta");
                  jdbc.setCommand("select ID_ROLE , NAME_ROLE , DESCRIPTION_ROLE " +
                      "from ROLE ");
                  jdbc.execute();
                  RoleDto ro = null;
                  while(jdbc.next()){
                      if(role == null){
                    role = new ArrayList<>();
        }
                      ro= new RoleDto();
                      ro.setId(jdbc.getInt("ID_ROLE"));
                      ro.setName(jdbc.getString("NAME_ROLE"));
                      ro.setDescription(jdbc.getString("DESCRIPTION_ROLE"));
                      role.add(ro);
                      ro= null;
        }
              }
        catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null, "Error Listing Roles");
        }
              catch(Exception e){
                  e.printStackTrace();
              }
              return role;
        }
         public List<RoleDto> searchFor(RoleDto role) {
              List<RoleDto> roles = null;
            
                try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
                    jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
                    jdbc.setUsername("lta");
                    jdbc.setPassword("lta");
                    jdbc.setCommand("select ID_ROLE, NAME_ROLE, DESCRIPTION_ROLE " + "from ROLE where ID_ROLE = ? OR NAME_ROLE = ? OR DESCRIPTION_ROLE=?");
                    try{jdbc.setInt(1,Integer.parseInt(role.getSearch()));
                    }catch(NumberFormatException e){
                        jdbc.setInt(1,-1);
                    }
                    jdbc.setString(2,role.getSearch());
                    jdbc.setString(3,role.getSearch());
                    jdbc.execute();
                    RoleDto R = null;
                    while(jdbc.next()) {
                        if (roles == null){
                        roles = new ArrayList<>();   
                        }
                        R = new RoleDto();
                        
                    R.setId(jdbc.getInt("ID_ROLE"));
                    R.setName(jdbc.getString("NAME_ROLE"));
                    R.setDescription(jdbc.getString("DESCRIPTION_ROLE"));
                          roles.add(R);
                           R= null;
          }
 }
                catch(java.sql.SQLException e){
                    JOptionPane.showConfirmDialog(null, "Error Searching For Role");
                }
                   catch(Exception e){
                    e.printStackTrace();
                    }
                return roles;
            }

             public Boolean delete(RoleDto r) {
    try(JdbcRowSet jdbc = RowSetProvider.newFactory().createJdbcRowSet();) {
        jdbc.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
        jdbc.setUsername("lta");
        jdbc.setPassword("lta");
                   jdbc.setCommand("delete from ROLE where ID_ROLE = ?  ");
        try{jdbc.setInt(1,r.getId());
        }catch(NumberFormatException e){
            jdbc.setInt(1,-1);
        }
                   jdbc.execute();
                   return true;
               }
    catch(java.sql.SQLException e){
        JOptionPane.showConfirmDialog(null, "Error Deleting Role");
        return false;
        }
               catch(Exception e){
                   e.printStackTrace();
                   return false;
    }
}

    }