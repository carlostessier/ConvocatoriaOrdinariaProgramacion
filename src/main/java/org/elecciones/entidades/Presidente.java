package org.elecciones.entidades;

import org.elecciones.interfaces.AccionesPresidente;

import java.util.List;


public class Presidente extends Ciudadano implements AccionesPresidente {

    public Presidente(){
        this("","");
    }

    public Presidente(String nombre, String dni) {
        super(nombre,dni);
    }

    @Override
    public void introducirSobreUrna(Sobre sobre, Urna urna) {
        urna.introducirSobre(sobre);
    }

    @Override
    public Sobre comprobarCiudadano(Ciudadano ciudadano, MesaElectoral mesa){
       Sobre sobre = new Sobre();
        if(mesa.getCensoElectoral().contains(ciudadano) && !mesa.getCiudadanosQueHanVotado().contains(ciudadano)){
            sobre = ciudadano.getSobre();
            mesa.getCiudadanosQueHanVotado().add(ciudadano);
        }
        return sobre;
    }

    @Override
    public Papeleta comprobarSobre(Sobre sobre) {
        if (sobre.getContenido() instanceof Papeleta) {
            return (Papeleta) sobre.getContenido();
        } else {
            return new Papeleta();
        }
    }

}
