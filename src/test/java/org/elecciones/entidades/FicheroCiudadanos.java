package org.elecciones.entidades;

import org.elecciones.excepciones.ExceptionElementoRepetido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FicheroCiudadanos {

    private MesaElectoral mesaElectoral;
    private ArrayList<Ciudadano> ciudadanos;

    private final String FICHERO = "src/test/resources/ciudadanos.csv";
    @BeforeEach
    void setUp() {
        mesaElectoral = new MesaElectoral();

        ciudadanos = new ArrayList<>();
        ciudadanos.add(new Ciudadano("Test Name 1", "35229152Y"));
        ciudadanos.add(new Ciudadano("Test Name 2", "05516797V"));
        ciudadanos.add(new Ciudadano("Test Name 3", "26021734V"));
        ciudadanos.add(new Ciudadano("Test Name 4", "55820245G"));
        ciudadanos.add(new Ciudadano("Test Name 5", "78701793W"));
        ciudadanos.add(new Ciudadano("Test Name 6", "64307861E"));
        ciudadanos.add(new Ciudadano("Test Name 7", "65516756Z"));

    }

    @Test
    void testLeerFicheroNoExiste() {
        List<Ciudadano> ciudadanos;
        ciudadanos = mesaElectoral.leerCiudadanos("FICHERO_NO_EXISTE");
        assertTrue(ciudadanos.isEmpty());
    }

    @Test
    void testEscribirFichero() {
        mesaElectoral.guardarCiudadanos(FICHERO,ciudadanos);
        File file = new File(FICHERO);
        assertTrue(file.exists());
    }

    @Test
    void testLeerFichero() {
        List<Ciudadano> ciudadanosLeidos;
        mesaElectoral.guardarCiudadanos(FICHERO,ciudadanos);
        ciudadanosLeidos = mesaElectoral.leerCiudadanos(FICHERO);
        assertFalse(ciudadanosLeidos.isEmpty());
        System.out.println(ciudadanosLeidos);
        for (Ciudadano ciudadano: ciudadanosLeidos) {
              assertTrue(ciudadanos.contains(ciudadano));
        }

        }
    }


