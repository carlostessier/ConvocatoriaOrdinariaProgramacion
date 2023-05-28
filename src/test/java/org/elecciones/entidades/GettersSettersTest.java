package org.elecciones.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GettersSettersTest {
    private Ciudadano ciudadano;
    private Candidato candidato;
    private Papeleta papeleta;
    private MesaElectoral mesa;
    @BeforeEach
    void setUp() {
        ciudadano = new Ciudadano();
        candidato = new Candidato();
        papeleta = new Papeleta();
        mesa = new MesaElectoral();
    }

    @Test
    void setSetCiudadanoNombre() {
        String nombre = "Test Name";
        ciudadano.setNombre(nombre);
        assertEquals("test name", ciudadano.getNombre());
    }

    @Test
    void setCiudadanoNombreWithNull() {
        ciudadano.setNombre(null);
        assertEquals("", ciudadano.getNombre());
    }

    @Test
    void setSetCandidato() {
        int numeroLista = 1;
        candidato = new Candidato("Test Name", "12345678A", numeroLista);
        assertEquals(1, candidato.getNumeroLista());
        candidato.setNumeroLista(-1);
        assertEquals(numeroLista, candidato.getNumeroLista());
        numeroLista = 50;
        candidato.setNumeroLista(numeroLista);
        assertEquals(numeroLista, candidato.getNumeroLista());
        candidato.setNumeroLista(Candidato.MAX_NUMERO_LISTA + 1);
        assertEquals(numeroLista, candidato.getNumeroLista());
    }

    @Test
    void setMesaElectoralDireccion() {
        String direccion = "Calle de la piruleta ";
        mesa.setDireccion(direccion);
        assertEquals("calle de la piruleta", mesa.getDireccion());
    }

    @Test
    void setMesaElectoralWithNull() {
        mesa.setDireccion(null);
        assertEquals("", mesa.getDireccion());
    }

    @Test
    void setGetCiudadanoDni() {
        String dni = "12345678Z";
        ciudadano.setDni(dni);
        assertEquals(dni, ciudadano.getDni());
    }

    @Test
    void testAddPapeletaCandidato() {
        Candidato candidato = new Candidato("Candidato 1", "84038729d", 1);
        papeleta.addCandidato(candidato);
        assertEquals(1, papeleta.getCandidatos().size());
        assertTrue(papeleta.getCandidatos().contains(candidato));
    }

    @Test
    void testRemovePapeletaCandidato() {
        Candidato candidato = new Candidato("Candidato 1", "84038729d", 1);
        papeleta.addCandidato(candidato);
        papeleta.removeCandidato(candidato);
        assertTrue(papeleta.getCandidatos().isEmpty());
    }

    @Test
    void getPartidoPoliticoPapeletaVacia() {
        assertEquals(Papeleta.PartidoPolitico.VACIO, papeleta.getPartidoPolitico());
    }
}

















