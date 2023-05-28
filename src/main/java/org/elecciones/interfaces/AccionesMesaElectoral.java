package org.elecciones.interfaces;

import org.elecciones.entidades.Ciudadano;
import org.elecciones.excepciones.ExceptionElementoRepetido;

public interface AccionesMesaElectoral {

    /**
     * Añade un Ciudadano como presidente a la mesa electoral
     * Solo puede haber un presidente en cada mesa electoral
     * @param ciudadano Ciudadano que se añade como presidente
     * @return true si se añade correctamente, false si no se añade
     */
     boolean agnadirPresidente(Ciudadano ciudadano) throws ExceptionElementoRepetido;

    /**
     * Añade un Ciudadano como vocal o interventor a la mesa electoral
     * No puede haber dos vocales iguales en una misma mesa electoral
     * @param ciudadano Ciudadano que se añade como vocal
     * @return true si se añade correctamente, false si no se añade
     */
     boolean agnadirMiembroMesa(Ciudadano ciudadano) throws ExceptionElementoRepetido;

    /**
     * Busca un ciudadano en la mesa electoral
     *
     * @param ciudadano Ciudadano que se busca
     * @return Indice del ciudadano en la mesa electoral,
     * si no lo encuentra devuelve -1
     */
     int buscarComponente(Ciudadano ciudadano);

    /**
     * Busca un presidente en la mesa electoral
     * @param ciudadano Ciudadano que se busca
     * @return Índice del presidente en la mesa electoral,
     * si no lo encuentra devuelve -1
     */
     int buscarPresidente(Ciudadano ciudadano);

    }
