package com.nttdata.springt1.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring Taller 1
 *
 * Dao de la clase Building (Implementacion)
 *
 * @author Daniel Alberto Cosa Cosias
 */

@Repository
public class BuildingDaoImpl implements BuildingDaoI{
    @Override
    public void insertResident(Building building, Resident resident) {
        //Se comprueba que ell indice del array se encuentre vacio
        if (building.getFloorAndFlatIndex(resident.getFloor()-1, resident.getFlat()-1) == null) {
            //Se consume el metodo con -1 para encajar los indices de los arrays
            building.setFloorAndFlatIndex(resident, resident.getFloor()-1, resident.getFlat()-1);
        } else {
            System.err.println("Ya hay un residente en este piso, si lo que quiere es actualizar la informacion asociada a este piso, utilice el metodo updateResident");
        }
    }

    @Override
    public void updateResident(final Building building, Resident resident){
        building.setFloorAndFlatIndex(resident, resident.getFloor()-1, resident.getFlat()-1);
    }

    @Override
    public List<Resident> getAllResidents(Building building) {
        //Se crea un array bidimensional donde se vuelcan los datos del edificio
        Resident[][] tempResidents = building.getFloorAndFlat();
        //Se crea una lista
        List<Resident> residents = new ArrayList<>();
        //El bucle recorre los residentes y los inserta en la lista
        for (int i = 0; i < tempResidents.length; i++) {
            for (int j = 0; j < tempResidents[i].length; j++) {
                if (tempResidents[i][j] != null){
                    residents.add(tempResidents[i][j]);
                }
            }
        }
        //Devuelve la lista
        return residents;
    }

    @Override
    public List<Resident> getByNameAndSurnameStrict(Building building, String name, String surnames) {
        //Se crea un array bidimensional donde se vuelcan los datos del edificio
        Resident[][] tempResidents = building.getFloorAndFlat();
        //Se crea una lista
        List<Resident> residents = new ArrayList<>();
        //El bucle recorre los residentes
        for (int i = 0; i < tempResidents.length; i++) {
            for (int j = 0; j < tempResidents[i].length; j++) {
                //Si el residente no es nulo y su nombre y apellido son los especificados, se guarda en la lista
                if (tempResidents[i][j] != null && (tempResidents[i][j].getName().equals(name) && tempResidents[i][j].getSurnames().equals(surnames))){
                    residents.add(tempResidents[i][j]);
                }
            }
        }
        //Devuelve la lista
        return residents;
    }

    @Override
    public List<Resident> getByNameAndSurnameFlexible(Building building, String name, String surnames) {
        //Se crea un array bidimensional donde se vuelcan los datos del edificio
        Resident[][] tempResidents = building.getFloorAndFlat();
        //Se crea una lista
        List<Resident> residents = new ArrayList<>();
        //El bucle recorre los residentes
        for (int i = 0; i < tempResidents.length; i++) {
            for (int j = 0; j < tempResidents[i].length; j++) {
                //Si el residente no es nulo y su nombre o apellido son los especificados, se guarda en la lista
                if (tempResidents[i][j] != null && (tempResidents[i][j].getName().equals(name) || tempResidents[i][j].getSurnames().equals(surnames))){
                    residents.add(tempResidents[i][j]);
                }
            }
        }
        //Devuelve la lista
        return residents;
    }

    @Override
    public List<Resident> getByFloor(Building building, int floor) {
        //Se crea un array bidimensional donde se vuelcan los datos del edificio
        Resident[][] tempResidents = building.getFloorAndFlat();
        //Se crea una lista
        List<Resident> residents = new ArrayList<>();
        //El bucle recorre los residentes
        for (int i = 0; i < tempResidents.length; i++) {
            for (int j = 0; j < tempResidents[i].length; j++) {
                //Si el residente no es nulo y vive en la planta espeficicada, se guarda en la lista
                if (tempResidents[i][j] != null && tempResidents[i][j].getFloor() == floor) {
                    residents.add(tempResidents[i][j]);
                }
            }
        }
        //Devuelve la lista
        return residents;
    }

    @Override
    public List<Resident> getByFlat(Building building, int flat) {
        //Se crea un array bidimensional donde se vuelcan los datos del edificio
        Resident[][] tempResidents = building.getFloorAndFlat();
        //Se crea una lista
        List<Resident> residents = new ArrayList<>();
        //El bucle recorre los residentes
        for (int i = 0; i < tempResidents.length; i++) {
            for (int j = 0; j < tempResidents[i].length; j++) {
                //Si el residente no es nulo y vive en el piso espeficicado, se guarda en la lista
                    if (tempResidents[i][j] != null && tempResidents[i][j].getFlat() == flat) {
                        residents.add(tempResidents[i][j]);
                    }
            }
        }
        //Devuelve la lista
        return residents;
    }

    @Override
    public Resident getByFloorAndFlat(Building building, int floor, int flat) {
        //Se crea un array bidimensional donde se vuelcan los datos del edificio
        Resident[][] tempResidents = building.getFloorAndFlat();
        //Si el residente del piso no es nulo este se devuelve
        if (tempResidents[floor-1][flat-1] != null) {
            return tempResidents[floor-1][flat-1];
        } else {
            return null;
        }
    }
}
