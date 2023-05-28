package org.elecciones.interfaces;

import org.elecciones.entidades.*;

import java.util.List;

public interface AccionesPresidente {

    /**
     * El presidente introduce el sobre en la urna
     * @param sobre
     * @param urna
     */
    public void introducirSobreUrna(Sobre sobre, Urna urna);

    /**
     * El presidente comprueba que el ciudadano está en el censo electoral de la mesa
     * y que no esté en la lista de los que ya han votado
     * En caso afirmativo, añade al ciudadano a la lista que han votado
     * no vote más de una vez
     * y devuelve el sobre que contiene el ciudadano
     * @param ciudadano
     * @param mesa
     * @return
     */
    public Sobre comprobarCiudadano(Ciudadano ciudadano, MesaElectoral mesa);

    /**
     * El presidente comprueba que el sobre es válido,
     * para ello debemos asegurarnos que el contenido
     * del sobre es un objeto de tipo Papeleta
     * @param sobre
     * @return Papeleta del sobre si es válida,
     * en caso contrario una devuelve una papeleta vacía
     */
    public Papeleta comprobarSobre(Sobre sobre );

}
