package com.nttdata.springt1;

import com.nttdata.springt1.repository.Building;
import com.nttdata.springt1.repository.Resident;
import com.nttdata.springt1.services.BuildingManagementServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;

/**
 * Taller 1 - Spring
 *
 * Clase Main
 *
 * @author Daniel Alberto Cosa Cosias
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class NttdatacentersSpringT1DccApplication implements CommandLineRunner {
    //Servicio el cual se consumira
    @Autowired
    private BuildingManagementServiceI buildingService;
    public static void main(String[] args) {
        SpringApplication.run(NttdatacentersSpringT1DccApplication.class, args);
    }

    @Override
    public void run(String... args) {
        //Creacion de edificio y residentes
        Building e1 = new Building(new Resident[8][4]);
        Resident r1 = new Resident("Daniel", "Cosa Cosias", 4, 4);
        Resident r2 = new Resident("Juan Alejandro", "Tellez  Rubio", 7, 2);
        Resident r3 = new Resident("Daniel", "Saucedo Jimenez", 7, 4);
        //Consumicion del servicio y sus metodos
        buildingService.insertResident(e1, r1);
        buildingService.insertResident(e1, r2);
        buildingService.insertResident(e1, r3);
        List<Resident> todosLosResidentes = buildingService.getAllResidents(e1);
        List<Resident> residentesPorNombreEstricto = buildingService.getByNameAndSurnameStrict(e1, "Daniel", "Cosa Cosias");
        List<Resident> residentesPorNombreFlexible = buildingService.getByNameAndSurnameFlexible(e1, "Daniel", "Cosa Cosias");
        List<Resident> residentesPorPiso = buildingService.getByFloor(e1, 7);
        List<Resident> residentesPorPlanta = buildingService.getByFlat(e1, 4);
        Resident residentePorPlantaYPiso = buildingService.getByFloorAndFlat(e1, 7, 2);
        //Impresion de resultados
        for (Resident resident : todosLosResidentes) {
            System.out.println("Resultado de getAllResidents: " + resident.toString());
        }
        for (Resident resident : residentesPorNombreEstricto) {
            System.out.println("Resultado de getByNameAndSurnameStrict: " + resident.toString());
        }
        for (Resident resident : residentesPorNombreFlexible) {
            System.out.println("Resultado de getByNameAndSurnameFlexible: " + resident.toString());
        }
        for (Resident resident : residentesPorPiso) {
            System.out.println("Resultado de getByFloor: " + resident.toString());
        }
        for (Resident resident : residentesPorPlanta) {
            System.out.println("Resultado de getByFlat: " + resident.toString());
        }
        System.out.println("Resultado de getByFloorAndFlat: " + residentePorPlantaYPiso.toString());
    }

}
