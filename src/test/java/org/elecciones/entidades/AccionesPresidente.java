package org.elecciones.entidades;

import org.elecciones.excepciones.ExceptionElementoRepetido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AccionesPresidente {

    private MesaElectoral mesaElectoral;
    private ArrayList<Ciudadano> ciudadanos;
    private Collection candidatos;
    private Papeleta papeleta;
    @BeforeEach
    void setUp() {
        ciudadanos = new ArrayList<>();

        ciudadanos.add(new Ciudadano("Test Name 1", "35229152Y"));
        ciudadanos.add(new Ciudadano("Test Name 2", "05516797V"));
        ciudadanos.add(new Ciudadano("Test Name 3", "26021734V"));
        ciudadanos.add(new Ciudadano("Test Name 4", "55820245G"));
        ciudadanos.add(new Ciudadano("Test Name 5", "78701793W"));
        ciudadanos.add(new Ciudadano("Test Name 6", "64307861E"));
        ciudadanos.add(new Ciudadano("Test Name 7", "65516756Z"));

        Urna urna = new Urna();

        mesaElectoral = new MesaElectoral("Calle de la piruleta, 1", ciudadanos, urna);

        Ciudadano presidente = new Presidente("Presidente Pepe", "06864546N");
        Ciudadano vocal1 = new Ciudadano("Vocal Paco", "74906860T");
        Ciudadano vocal2 = new Ciudadano("Vocal María", "19685259L");
        Ciudadano vocal3 = new Ciudadano("Vocal Lola", "79915253M");

        try {
            mesaElectoral.agnadirMiembroMesa(vocal1);
            mesaElectoral.agnadirMiembroMesa(vocal2);
            mesaElectoral.agnadirMiembroMesa(vocal3);
        } catch (ExceptionElementoRepetido e) {
            System.err.println(e.getMessage());
        }

        mesaElectoral.agnadirPresidente(presidente);

        candidatos = new HashSet<>();
        candidatos.add(new Candidato("María de la o", "81736071M", 1));
        candidatos.add(new Candidato("Paco López", "04079086J", 2));
        candidatos.add(new Candidato("Lola Garcia", "69998776R", 3));

        papeleta = new Papeleta(Papeleta.PartidoPolitico.MASMADRID, candidatos);



    }

    @Test
    void testComprobarCiudadano() {
        Ciudadano ciudadano = new Ciudadano("Test Name 1", "35229152Y");

        Sobre sobre = new Sobre(papeleta);
        ciudadano.setSobre(sobre);

        Presidente presidente =  (Presidente) mesaElectoral.getComponentes()[3];

        sobre =  presidente.comprobarCiudadano(ciudadano,mesaElectoral);
        assertEquals(((Papeleta)sobre.getContenido()).getPartidoPolitico(), Papeleta.PartidoPolitico.MASMADRID);

    }

    @Test
    void testComprobarCiudadanoVotaDosVeces() {
        Ciudadano ciudadano = new Ciudadano("Test Name 1", "35229152Y");

        Sobre sobre = new Sobre(papeleta);
        ciudadano.setSobre(sobre);

        Presidente presidente =  (Presidente) mesaElectoral.getComponentes()[3];

        sobre =  presidente.comprobarCiudadano(ciudadano,mesaElectoral);
        assertEquals(((Papeleta)sobre.getContenido()).getPartidoPolitico(), Papeleta.PartidoPolitico.MASMADRID);
        sobre =  presidente.comprobarCiudadano(ciudadano,mesaElectoral);
        assertEquals(new Sobre(), sobre) ;
        assertFalse(sobre.getContenido() instanceof Papeleta);
    }

    @Test
    void testComprobarSobreValido() {

        Sobre sobre = new Sobre(papeleta);
        Presidente presidente =  (Presidente) mesaElectoral.getComponentes()[3];
        Papeleta papeletaSacada =  presidente.comprobarSobre(sobre);

        assertNotEquals(new Papeleta(), papeletaSacada);
        assertEquals(papeleta, papeletaSacada);
    }

    @Test
    void testComprobarSobreNoValido() {
        Object chorizo = new Object();
        Sobre sobre = new Sobre(chorizo);
        Presidente presidente =  (Presidente) mesaElectoral.getComponentes()[3];
        Papeleta papeletaSacada =  presidente.comprobarSobre(sobre);

        assertEquals(new Papeleta(), papeletaSacada);
    }

    @Test
    void testIntroducirSobreUrna() {

        Ciudadano ciudadano = new Ciudadano("Test Name 1", "35229152Y");

        Sobre sobre = new Sobre(papeleta);
        ciudadano.setSobre(sobre);

        Presidente presidente =  (Presidente) mesaElectoral.getComponentes()[3];

        sobre =  presidente.comprobarCiudadano(ciudadano,mesaElectoral);
        presidente.introducirSobreUrna(sobre,mesaElectoral.getUrna());
        assertEquals(mesaElectoral.getUrna().getSobres().size(), 1);

    }
}