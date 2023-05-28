package org.elecciones.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class ConstructoresTest {

    private MesaElectoral mesaElectoral;
    private Ciudadano ciudadano;
    private Papeleta papeleta;

    private Sobre sobre;
    private Urna urna;

    @BeforeEach
    void setUp() {
        mesaElectoral = new MesaElectoral();
        papeleta = new Papeleta();
        sobre = new Sobre();
        urna = new Urna();
        ciudadano = new Ciudadano("Test Name", "12345678Z");
    }

    @Test
    void ciudadanoWithParameters() {
        assertEquals("test name", ciudadano.getNombre());
        assertEquals("12345678Z", ciudadano.getDni());
    }

    @Test
    void ciudadanoWithoutParameters() {
        ciudadano = new Ciudadano();
        assertEquals("", ciudadano.getNombre());
        assertEquals("", ciudadano.getDni());
    }

    @Test
    void ciudadanoWithNullParameters() {
        ciudadano = new Ciudadano(null, null);
        assertEquals("", ciudadano.getNombre());
        assertEquals("", ciudadano.getDni());
    }

    @Test
    void mesaElectoralWithoutParameters() {
        assertNotNull(mesaElectoral);
        assertEquals("", mesaElectoral.getDireccion());
    }

    @Test
    void mesaElectoralWithParameters() {
        List<Ciudadano> ciudadanos = new ArrayList<>();
        ciudadanos.add(ciudadano);
        Urna urna = new Urna();

        MesaElectoral mesaElectoral = new MesaElectoral("Test address", ciudadanos, urna);

        assertNotNull(mesaElectoral);
        assertEquals("test address", mesaElectoral.getDireccion());
        assertNotNull(mesaElectoral.getComponentes());
        assertEquals(5, mesaElectoral.getComponentes().length);
        assertNotNull(mesaElectoral.getUrna());
        assertEquals(0, mesaElectoral.getCiudadanosQueHanVotado().size());
        assertEquals(1, mesaElectoral.getCensoElectoral().size());

    }

    @Test
    void papeletaSinParametros() {
        assertEquals(Papeleta.PartidoPolitico.VACIO, papeleta.getPartidoPolitico());
        assertTrue(papeleta.getCandidatos().isEmpty());
    }

    @Test
    void papeletaConParametros() {
        Candidato candidato1 = new Candidato("María de la o", "81736071M", 1);
        Candidato candidato2 = new Candidato("Paco López", "04079086J", 2);
        Candidato candidato3 = new Candidato("Lola Garcia", "69998776R", 3);
        Collection candidatos = new HashSet<>();
        candidatos.add(candidato1);
        candidatos.add(candidato2);
        candidatos.add(candidato3);

        papeleta = new Papeleta(Papeleta.PartidoPolitico.PSOE, candidatos);

        assertEquals(Papeleta.PartidoPolitico.PSOE, papeleta.getPartidoPolitico());
        assertEquals(3, papeleta.getCandidatos().size());
        assertTrue(papeleta.getCandidatos().contains(candidato1));
        assertTrue(papeleta.getCandidatos().contains(candidato2));
        assertTrue(papeleta.getCandidatos().contains(candidato3));
    }

    @Test
    void urnaWithoutParameters() {
        assertNotNull(urna);
        assertNotNull(urna.getVotos());
        assertNotNull(urna.getSobres());
        assertTrue(urna.getSobres().isEmpty());
        assertTrue(urna.getVotos().isEmpty());
    }

    @Test
    void sobreSinParametros() {
        assertNotNull(sobre);
        assertNotNull(sobre.getContenido());

    }

    @Test
    void sobreConParametros() {
        sobre = new Sobre(papeleta);
        papeleta.setPartidoPolitico(Papeleta.PartidoPolitico.PP);
        Candidato candidato= new Candidato("María de la o", "81736071M", 1);

        papeleta.addCandidato(candidato);
        assertNotNull(sobre);
        assertEquals(papeleta, sobre.getContenido());
        Object papeletaNoValidad = new Object();
        sobre = new Sobre(papeletaNoValidad);
        assertNotNull(sobre);
        assertEquals(papeletaNoValidad, sobre.getContenido());
    }

}