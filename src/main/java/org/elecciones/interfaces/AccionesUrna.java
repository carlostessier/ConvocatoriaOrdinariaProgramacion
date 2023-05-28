package org.elecciones.interfaces;

import org.elecciones.entidades.Ciudadano;
import org.elecciones.entidades.Papeleta;
import org.elecciones.entidades.Sobre;
import org.elecciones.excepciones.ExceptionElementoRepetido;

import java.util.TreeMap;

public interface AccionesUrna {
    /**
     * Se introduce un sobre en la urna
     * @param sobre
     */
    public void introducirSobre(Sobre sobre);

    /**
     * Se obtienen todos los votos contabilizados de una papeleta
     * @param papeleta
     * @return
     */
    public int getVotos(Papeleta papeleta);


    /**
     * Se contabiliza un voto en el diccionario (Map) de votos
     * @param papeleta
     */
    public void contabilizarVoto(Papeleta papeleta);

    /**
     * Se imprimen los resultados de la votación
     * @return
     */
    public String obtenerResultados();

    }
