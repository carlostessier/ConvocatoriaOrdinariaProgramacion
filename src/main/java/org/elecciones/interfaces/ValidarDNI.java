package org.elecciones.interfaces;

public interface ValidarDNI {

    /**
     * El dni debe tener una longitud de 9 caracteres.
     * Los 8 primeros caracteres son números
     * El último carácter es una letra que se guardará en mayúsculas.
     * Para comprobar que un DNI es válido, hay que calcular
     * el módulo del número del dni por 23.
     * La última letra debe coincidir con la posición de la
     * siguiente secuencia de letras:
     * TRWAGMYFPDXBNJZSQVHLCKE
     *
     * @param dni DNI a validar
     * @return true si el dni es válido, false en caso contrario
     */
     boolean validarDNI(String dni);
    }
