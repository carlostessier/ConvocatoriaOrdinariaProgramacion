package org.elecciones.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StringEqualsTest {

    private Ciudadano ciudadano1;
    private Ciudadano ciudadano2;
    private Papeleta papeleta;
    private Collection<Candidato> candidatos;
    @BeforeEach
    void setUp() {
        Candidato candidato1 = new Candidato("Candidato 1", "81736071M", 1);
        Candidato candidato2 = new Candidato("Candidato 2", "04079086J", 2);
        candidatos = new HashSet<>();
        candidatos.add(candidato1);
        candidatos.add(candidato2);

        papeleta = new Papeleta(Papeleta.PartidoPolitico.PSOE, candidatos);

        ciudadano1 = new Ciudadano("test name 1", "12345678Z");
        ciudadano2 = new Ciudadano("test name 1", "87654321A");
    }

    @Test
    void testEqualsCiudadano() {
        Ciudadano copia = new Ciudadano(ciudadano1);
        Ciudadano alias = ciudadano1;

        assertEquals(copia, ciudadano1);
        assertEquals(alias, ciudadano1);
        assertNotEquals(ciudadano1, ciudadano2);
    }

    @Test
    void testToStringCiudadano() {
        assertEquals(0,new Ciudadano().toString().compareTo(";"));
        assertEquals(0,ciudadano1.toString().compareTo("test name 1;12345678Z") );
        assertEquals(0,ciudadano1.toString().compareTo("test name 1;12345678Z") );

    }

    @Test
    void testToStringPapeleta() {
        String contenido = "PSOE\n";
        contenido+= "Candidatos:\n";
        contenido+= "1: candidato 1\n";
        contenido+= "2: candidato 2\n";
        System.out.println(contenido);
        System.out.println(papeleta.toString());
        assertEquals(0,contenido.compareTo(papeleta.toString()));
    }

    @Test
    void testEqualsPapeleta() {

        Papeleta papeletaCopia = new Papeleta(Papeleta.PartidoPolitico.PSOE, candidatos);
        Papeleta alias = papeleta;

        assertEquals(papeletaCopia, papeleta);
        assertEquals(alias, papeleta);
        papeletaCopia.setPartidoPolitico(Papeleta.PartidoPolitico.PP);
        assertNotEquals(papeletaCopia, papeleta);
    }

    @Test
    void testEqualsSobre() {
        Papeleta papeleta = new Papeleta(Papeleta.PartidoPolitico.PSOE, candidatos);
        Sobre sobre1 = new Sobre(papeleta);
        Sobre alias = sobre1;
        Sobre sobre2 = new Sobre("chorizo");

        assertEquals(alias, sobre1);
        assertEquals(sobre1, sobre1);
        assertEquals(new Sobre(), new Sobre());
        assertNotEquals(sobre1, sobre2);
    }












}