package org.elecciones.entidades;

import org.elecciones.excepciones.ExceptionElementoRepetido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccionesMesaElectoralTest {

    private MesaElectoral mesaElectoral;
    private ArrayList<Ciudadano> ciudadanos;
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
    void testAgnadirPresidente() {
        Presidente presidente = new Presidente("Presidente Name", "98765432R");
        assertTrue(mesaElectoral.agnadirPresidente(presidente));
    }

    @Test
    void testAgnadirVariosPresidentes() {
        Presidente presidente = new Presidente("Presidente Name", "98765432R");
        assertTrue(mesaElectoral.agnadirPresidente(presidente));
        assertFalse(mesaElectoral.agnadirPresidente(ciudadanos.get(0)));
    }

    @Test
    void testAgnadirVocal() {
        for(int i = 0; i < MesaElectoral.NUM_COMPONENTES; i++) {
            final int index = i;
            assertDoesNotThrow(() -> assertTrue(mesaElectoral.agnadirVocal(ciudadanos.get(index))));
        }

    }

    @Test
    void testAgnadirVocalMesaLLena() {
        for(int i = 0; i < MesaElectoral.NUM_COMPONENTES; i++) {
            final int index = i;
            assertDoesNotThrow(() -> mesaElectoral.agnadirVocal(ciudadanos.get(index)));
        }
        Ciudadano ciudadano = new Ciudadano("Test Name", "06982976S");
        assertDoesNotThrow(() -> assertFalse(mesaElectoral.agnadirVocal(ciudadano)));


    }

    @Test
    void testAgnadirVocalRepetido() {

        assertDoesNotThrow(() -> mesaElectoral.agnadirVocal(ciudadanos.get(0)));
        assertDoesNotThrow(() -> mesaElectoral.agnadirVocal(ciudadanos.get(1)));
        assertDoesNotThrow(() -> mesaElectoral.agnadirVocal(ciudadanos.get(2)));

        assertThrows(ExceptionElementoRepetido.class, () -> mesaElectoral.agnadirVocal(ciudadanos.get(2)));

    }

    @Test
    void testBuscarPresidente() {
        for (int i = 0; i < MesaElectoral.NUM_COMPONENTES - 1; i++) {
            try {
                assertTrue(mesaElectoral.agnadirVocal(ciudadanos.get(i)));
            } catch (ExceptionElementoRepetido e) {
                System.err.println("Error al añadir vocal ");
            }
        }
        Presidente presidente = new Presidente("Presidente Name", "98765432R");
        mesaElectoral.agnadirPresidente(presidente);
        assertNotEquals(-1, mesaElectoral.buscarPresidente(presidente));
    }

    @Test
    void testBuscarComponente() {
        for(int i = 0; i < MesaElectoral.NUM_COMPONENTES; i++) {
            final int index = i;
            assertDoesNotThrow(() -> assertTrue(mesaElectoral.agnadirVocal(ciudadanos.get(index))));
        }
        Ciudadano ciudadano = new Ciudadano("Ciudadano Name", "71234773R");

        assertEquals(-1, mesaElectoral.buscarComponente(ciudadano));
        for(int i = 0; i < MesaElectoral.NUM_COMPONENTES; i++) {
            assertEquals(i, mesaElectoral.buscarComponente(ciudadanos.get(i)));
        }
    }




}