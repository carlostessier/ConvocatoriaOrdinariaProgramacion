package org.elecciones.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AccionesUrna {

    private Urna urna;
    private ArrayList<Papeleta> papeletas;
    private Collection candidatos;
    @BeforeEach
    void setUp() {

        urna = new Urna();
        papeletas = new ArrayList<>();

        candidatos = new HashSet<>();
        candidatos.add(new Candidato("María de la o", "81736071M", 1));
        candidatos.add(new Candidato("Paco López", "04079086J", 2));
        candidatos.add(new Candidato("Lola Garcia", "69998776R", 3));


        papeletas.add(new Papeleta(Papeleta.PartidoPolitico.MASMADRID, candidatos));
        papeletas.add(new Papeleta(Papeleta.PartidoPolitico.PP, candidatos));
        papeletas.add(new Papeleta(Papeleta.PartidoPolitico.PSOE, candidatos));
        papeletas.add(new Papeleta(Papeleta.PartidoPolitico.VOX, candidatos));


    }

    @Test
    void testIntroducirSobre() {

        assertTrue(urna.getSobres().isEmpty());
        int numeroSobres = 100;
        for (int i = 0; i < numeroSobres; i++) {
            int random = (int) (Math.random() * 4);
            Sobre sobre = new Sobre(papeletas.get(random));
            urna.introducirSobre(sobre);
        }

        assertEquals(numeroSobres,urna.getSobres().size());
    }
    @Test
    void testContabilizarVoto() {
       int votos1 = 20;
       int votos2 = 15;
       int votos3 = 10;

        assertTrue(urna.getVotos().isEmpty());

        for (int i = 0; i < votos1; i++) {
            Sobre sobre = new Sobre(papeletas.get(0));
            urna.introducirSobre(sobre);
        }

        for (int i = 0; i < votos2; i++) {
            Sobre sobre = new Sobre(papeletas.get(1));
            urna.introducirSobre(sobre);
        }

        for (int i = 0; i < votos3; i++) {
            Sobre sobre = new Sobre(papeletas.get(2));
            urna.introducirSobre(sobre);
        }

        for (Sobre sobre: urna.getSobres()) {
            urna.contabilizarVoto((Papeleta) sobre.getContenido());
        }
        int votosTotales = urna.getVotos().values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(votos1+votos2+votos3,votosTotales);
    }

    @Test
    void testGetVotos() {
        int votos1 = 20;
        int votos2 = 15;
        int votos3 = 10;

        assertTrue(urna.getVotos().isEmpty());

        for (int i = 0; i < votos1; i++) {
            Sobre sobre = new Sobre(papeletas.get(0));
            urna.introducirSobre(sobre);
        }

        for (int i = 0; i < votos2; i++) {
            Sobre sobre = new Sobre(papeletas.get(1));
            urna.introducirSobre(sobre);
        }

        for (int i = 0; i < votos3; i++) {
            Sobre sobre = new Sobre(papeletas.get(2));
            urna.introducirSobre(sobre);
        }

        for (Sobre sobre: urna.getSobres()) {
            urna.contabilizarVoto((Papeleta) sobre.getContenido());
        }

        assertEquals(votos1,urna.getVotos(papeletas.get(0)));
        assertEquals(votos2,urna.getVotos(papeletas.get(1)));
        assertEquals(votos3,urna.getVotos(papeletas.get(2)));

    }

    @Test
    void testObtenerResultado() {
        int votos1 = 33;
        int votos2 = 17;
        int votos3 = 28;

        assertTrue(urna.getVotos().isEmpty());

        for (int i = 0; i < votos1; i++) {
            Sobre sobre = new Sobre(papeletas.get(0));
            urna.introducirSobre(sobre);
        }

        for (int i = 0; i < votos2; i++) {
            Sobre sobre = new Sobre(papeletas.get(1));
            urna.introducirSobre(sobre);
        }

        for (int i = 0; i < votos3; i++) {
            Sobre sobre = new Sobre(papeletas.get(2));
            urna.introducirSobre(sobre);
        }

        for (Sobre sobre: urna.getSobres()) {
            urna.contabilizarVoto((Papeleta) sobre.getContenido());
        }

        String resultado = urna.obtenerResultados();

        String resultadoEsperado = "MASMADRID 33\n"+
                                    "PSOE 28\n"+
                                    "PP 17\n";

        assertEquals(resultadoEsperado,resultado);


    }

}