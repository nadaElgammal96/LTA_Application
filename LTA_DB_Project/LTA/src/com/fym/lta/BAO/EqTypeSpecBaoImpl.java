package com.fym.lta.BAO;

import com.fym.lta.DAO.DaoFactory;
import com.fym.lta.DAO.EqTypeSpecDao;
import com.fym.lta.DTO.EquipSpecificationDto;
import com.fym.lta.DTO.EquipTypeSpecDetailsDto;
import com.fym.lta.DTO.EquipmentTypeDto;

import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class EqTypeSpecBaoImpl implements EqTypeSpecBao {
    private EqTypeSpecDao dao = new DaoFactory().createEqTypeSpecDao();
    public EqTypeSpecBaoImpl() {
        super();
    }

    public boolean add(EquipTypeSpecDetailsDto type_spec) {
        boolean addFlag = false;
        try{
            if(dao.isExist(type_spec)){
                JOptionPane.showMessageDialog(null,"Record Already Exists");
            }
            else{
                addFlag=dao.insert(type_spec);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    return addFlag;
    }

    public boolean delete(EquipTypeSpecDetailsDto type_spec) {
        boolean deleteFlag = false;
        try{
            if(dao.isExist(type_spec))
                deleteFlag = dao.delete(type_spec);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return deleteFlag;
    }

    public List<EquipTypeSpecDetailsDto> viewAll() {
        List<EquipTypeSpecDetailsDto> type_sp = null;
        try{
            type_sp=dao.listAll();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return type_sp;
    }

    public List<EquipSpecificationDto> viewAllSpecif(EquipmentTypeDto type) {
        List<EquipSpecificationDto> eq_sp = null;
        try{
            eq_sp= dao.loadAllSpecif(type);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return eq_sp;
    }
}
