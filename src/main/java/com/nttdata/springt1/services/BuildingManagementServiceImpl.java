package com.nttdata.springt1.services;

import com.nttdata.springt1.repository.Building;
import com.nttdata.springt1.repository.BuildingDaoI;
import com.nttdata.springt1.repository.Resident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Spring Taller 1
 *
 * Servicio de edificios (Implementacion)
 *
 * @author Daniel Alberto Cosa Cosias
 */

@Service
public class BuildingManagementServiceImpl implements BuildingManagementServiceI{

    /**Dao de edificios*/
    @Autowired
    private BuildingDaoI buildingDao;
    @Override
    public void insertResident(Building building, Resident resident) {
        //Se hace un try/catch para comprobar que los indices indicados estan dentro del array
        try{
            //Se consume el dao
            buildingDao.insertResident(building, resident);
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("La planta y/o piso en el que esta intentando insertar al residente no existe en el edificio actual");
        }
    }

    public void updateResident(final Building building, Resident resident) {
        try{
            //Se consume el dao
            buildingDao.updateResident(building, resident);
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("La planta y/o piso en el que esta intentando actualizar al residente no existe en el edificio actual");
        }
    }

    @Override
    public List<Resident> getAllResidents(Building building) {
        //Se consume el dao
        return buildingDao.getAllResidents(building);
    }

    @Override
    public List<Resident> getByNameAndSurnameStrict(Building building, String name, String surnames) {
        //Se consume el dao
        return buildingDao.getByNameAndSurnameStrict(building, name, surnames);
    }

    @Override
    public List<Resident> getByNameAndSurnameFlexible(Building building, String name, String surnames) {
        //Se consume el dao
        return buildingDao.getByNameAndSurnameFlexible(building, name, surnames);
    }

    @Override
    public List<Resident> getByFloor(Building building, int floor) {
        //Se consume el dao
        return buildingDao.getByFloor(building, floor);
    }

    @Override
    public List<Resident> getByFlat(Building building, int flat) {
        //Se consume el dao
        return buildingDao.getByFlat(building, flat);
    }

    @Override
    public Resident getByFloorAndFlat(Building building, int floor, int flat) {
        //Se consume el dao
        return buildingDao.getByFloorAndFlat(building, floor, flat);
    }
}
