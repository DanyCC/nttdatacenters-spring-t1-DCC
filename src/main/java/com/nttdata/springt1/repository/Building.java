package com.nttdata.springt1.repository;

import java.io.Serial;
import java.io.Serializable;

/**
 * Spring Taller 1
 *
 * Clase Building
 *
 * @author Daniel Alberto Cosa Cosias
 */
public class Building implements Serializable {

    /**Serial Version*/
    @Serial
    private static final long serialVersionUID = 1L;

    /**Metodo Constructor*/
    public Building (Resident[][] floorAndFlat) {
        setFloorAndFlat(floorAndFlat);
    }

    /**Array bidimensional que representara el edificio*/
    private Resident[][] floorAndFlat;

    /**
     * @return Resident[][] floorAndFlat
     */
    public Resident[][] getFloorAndFlat() {
        return floorAndFlat;
    }

    /**
     * @param floorAndFlat Resident[][] floorAndFlat to set
     */
    public void setFloorAndFlat(Resident[][] floorAndFlat) {
        this.floorAndFlat = floorAndFlat;
    }

    /**
     * @param floor int floor you want the index from
     * @param flat int flat you want the index from
     * @return Resident floorAndFlat[floor][flat]
     */
    public Resident getFloorAndFlatIndex(int floor, int flat) {
        return floorAndFlat[floor][flat];
    }

    /**
     * @param resident Resident resident to set
     * @param floor int floor you want the index from
     * @param flat int flat you want the index from
     */
    public void setFloorAndFlatIndex(Resident resident, int floor, int flat) {
        this.floorAndFlat[floor][flat] = resident;
    }
}
