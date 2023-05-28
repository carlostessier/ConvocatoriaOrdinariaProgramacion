package org.elecciones.interfaces;

import org.elecciones.entidades.Papeleta;
import org.elecciones.entidades.Sobre;


public interface AccionesUrna {
    /**
     * Se introduce un sobre en la urna
     * @param sobre Sobre que se introduce en la urna
     */
     void introducirSobre(Sobre sobre);

    /**
     * Se obtienen todos los votos contabilizados de una papeleta
     * @param papeleta Papeleta de la que se quiere obtener el número de votos
     * @return Número de votos de la papeleta
     */
     int getVotos(Papeleta papeleta);


    /**
     * Se contabiliza un voto en el diccionario (Map) de votos
     * @param papeleta Papeleta de la que se quiere contabilizar un voto
     */
     void contabilizarVoto(Papeleta papeleta);

    /**
     * Devuelve un String con los resultados de la votación
     * Ordenados por número de votos de mayor a menor. Ejemplo:
     *   MASMADRID 25
     *   PP 24
     *   PSOE 12
     *   VOX 1
     * @return String con los resultados de la votación
     */
     String obtenerResultados();

    }
