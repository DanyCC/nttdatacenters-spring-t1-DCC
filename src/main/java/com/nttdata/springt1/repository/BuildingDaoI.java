package com.nttdata.springt1.repository;

import java.util.List;

/**
 * Spring Taller 1
 *
 * Dao de la clase Building
 *
 * @author Daniel Alberto Cosa Cosias
 */

public interface BuildingDaoI {

    /**
     * Inserta un residente en un edificio
     *
     * @param building
     * @param resident
     */
    public void insertResident(final Building building, Resident resident);

    /**
     * Actualiza un residente en un edificio
     *
     * @param building
     * @param resident
     */
    public void updateResident(final Building building, Resident resident);

    /**
     * Devuelve todos los residentes de un eficicio
     *
     * @param building
     * @return List<Resident>
     */
    public List<Resident> getAllResidents(final Building building);

    /**
     * Devuelve los residentes que tengan el mismo nombre y apellido proporcionado en el metodo
     *
     * @param building
     * @param name
     * @param surnames
     * @return List<Resident>
     */
    public List<Resident> getByNameAndSurnameStrict(final Building building, String name, String surnames);

    /**
     * Devuelve los residentes que tengan el mismo nombre o apellido proporcionado en el metodo
     *
     * @param building
     * @param name
     * @param surnames
     * @return List<Resident>
     */
    public List<Resident> getByNameAndSurnameFlexible(final Building building, String name, String surnames);

    /**
     * Devuelve los residentes que vivan en la planta indicada de un edificio
     *
     * @param building
     * @param floor
     * @return List<Resident>
     */
    public List<Resident> getByFloor(final Building building, int floor);

    /**
     * Devuelve los residentes que vivan en el piso indicado de un edificio
     *
     * @param building
     * @param flat
     * @return List<Resident>
     */
    public List<Resident> getByFlat(final Building building, int flat);

    /**
     * Devuelve los residentes que vivan en la planta y el piso indicados de un edificio
     *
     * @param building
     * @param floor
     * @param flat
     * @return Resident
     */
    public Resident getByFloorAndFlat(final Building building, int floor, int flat);
}
