package org.elecciones.interfaces;

import org.elecciones.entidades.Ciudadano;

import java.util.List;

public interface FicheroCiudadanos {

    /**
     * Lee los ciudadanos del fichero dado.
     * En caso de no existir el fichero devuelve una lista vacia
     * @param nombreFichero
     * @return
     */
    public List<Ciudadano> leerCiudadanos(String nombreFichero);

    /**
     * Guarda los ciudadanos en el fichero dado
     * @param nombreFichero
     * @param ciudadanos
     */
    public void guardarCiudadanos(String nombreFichero, List<Ciudadano> ciudadanos);
}
