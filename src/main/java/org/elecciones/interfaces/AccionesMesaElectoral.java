package org.elecciones.interfaces;

import org.elecciones.entidades.Ciudadano;
import org.elecciones.excepciones.ExceptionElementoRepetido;

public interface AccionesMesaElectoral {

    /**
     * Añade un presidente a la mesa electoral
     * Solo puede haber un presidente en cada mesa electoral
     * @param ciudadano
     * @return
     */
    public boolean agnadirPresidente(Ciudadano ciudadano) throws ExceptionElementoRepetido;

    /**
     * Añade un vocal a la mesa electoral
     * No puede haber dos vocales iguales en una misma mesa electoral
     * @param ciudadano
     * @return
     */
    public boolean agnadirVocal(Ciudadano ciudadano) throws ExceptionElementoRepetido;

    /**
     * Busca un ciudadano en la mesa electoral
     *
     * @param ciudadano
     * @return Indice del ciudadano en la mesa electoral,
     * si no lo encuentra devuelve -1
     */
    public int buscarComponente(Ciudadano ciudadano);

    /**
     * Busca un presidente en la mesa electoral
     * @param ciudadano
     * @return Indice del presidente en la mesa electoral,
     * si no lo encuentra devuelve -1
     */
    public int buscarPresidente(Ciudadano ciudadano);

    }
