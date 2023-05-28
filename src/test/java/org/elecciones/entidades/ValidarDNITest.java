package org.elecciones.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidarDNITest {

    private Ciudadano ciudadano;

    @BeforeEach
    void setUp() {
        ciudadano = new Ciudadano();
    }




    @Test
    void testSetDniWithInvalidLength() {
        String dni = "12345678";
        ciudadano.setDni(dni);
        assertEquals("", ciudadano.getDni());
    }

    @Test
    void testSetDniWithInvalidFormat() {
        String dni = "12345678A";
        ciudadano.setDni(dni);
        assertEquals("", ciudadano.getDni());
    }

    @Test
    void testValidarDNI() {

        assertTrue(ciudadano.validarDNI("12345678Z"));
        assertTrue(ciudadano.validarDNI("94038729d"));
        assertTrue(ciudadano.validarDNI("00219591X"));
        assertTrue(ciudadano.validarDNI("73204793w"));

    }

    @Test
    void testValidarDNIInvalidLength() {
        assertFalse(ciudadano.validarDNI("12345678"));
        assertFalse(ciudadano.validarDNI("123456789A"));
        assertFalse(ciudadano.validarDNI("1234567B"));
        assertFalse(ciudadano.validarDNI(""));
    }

    @Test
    void testValidarDNIInvalidFormat() {

        assertFalse(ciudadano.validarDNI("12345678A"));
        assertFalse(ciudadano.validarDNI("84038729d"));
        assertFalse(ciudadano.validarDNI("00319591X"));
        assertFalse(ciudadano.validarDNI("73204693w"));
    }

    @Test
    void testConstructorWithParameters() {
        Ciudadano c = new Ciudadano("Test Name", "12345678Z");
        assertEquals("test name", c.getNombre());
        assertEquals("12345678Z", c.getDni());
    }

}