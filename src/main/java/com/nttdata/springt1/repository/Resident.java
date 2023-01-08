package com.nttdata.springt1.repository;

import java.io.Serial;
import java.io.Serializable;

/**
 * Spring Taller 1
 *
 * Clase Resident
 *
 * @author Daniel Alberto Cosa Cosias
 */

public class Resident implements Serializable {

    /**Serial Version*/
    @Serial
    private static final long serialVersionUID = 1L;

    /**Nombre*/
    private String name;

    /**Apellidos*/
    private String surnames;

    /**Planta*/
    private int floor;

    /**Piso*/
    private int flat;

    /**Metodo constructor*/
    public Resident(String name, String surnames, int floor, int flat){
        setName(name);
        setSurnames(surnames);
        setFloor(floor);
        setFlat(flat);
    }

    /**
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name String name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return String surnames
     */
    public String getSurnames() {
        return surnames;
    }

    /**
     *
     * @param surnames String surnames to set
     */
    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    /**
     *
     * @return int floor
     */
    public int getFloor() {
        return floor;
    }

    /**
     *
     * @param floor int floor to set
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     *
     * @return int flat
     */
    public int getFlat() {
        return flat;
    }

    /**
     *
     * @param flat int flat to set
     */
    public void setFlat(int flat) {
        this.flat = flat;
    }

    /**
     *
     * @return String Resident{Nombre=name, Apellidos=surnames, Planta= floor, Piso= flat}
     */
    @Override
    public String toString() {
        return "Resident{" +
                "Nombre='" + name + '\'' +
                ", Apellidos='" + surnames + '\'' +
                ", Planta=" + floor +
                ", Piso=" + flat +
                '}';
    }
}
