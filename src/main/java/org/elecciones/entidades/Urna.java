package org.elecciones.entidades;

import org.elecciones.interfaces.AccionesUrna;

import java.util.*;

public class Urna implements AccionesUrna {

    private List<Sobre> sobres;
    private Map<Papeleta, Integer> votos;

    public Urna() {
        sobres = new ArrayList<>();
        votos = new HashMap<>();
    }

    @Override
    public void introducirSobre(Sobre sobre) {
        sobres.add(sobre);
    }

    @Override
    public int getVotos(Papeleta papeleta) {
        if(votos.containsKey(papeleta)) {
            return votos.get(papeleta);
        } else {
            return 0;
        }
    }

    public List<Sobre> getSobres() {
        return sobres;
    }

    public void setSobres(List<Sobre> sobres) {
        this.sobres = sobres;
    }

    public Map<Papeleta, Integer> getVotos() {
        return votos;
    }


    @Override
    public void contabilizarVoto(Papeleta papeleta){
        if(votos.containsKey(papeleta)){
            votos.put(papeleta, votos.get(papeleta) + 1);
        }
        else{
            votos.put(papeleta, 1);
        }
    }

    public String obtenerResultados() {
        TreeMap<Integer,Papeleta.PartidoPolitico> diccionario = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Papeleta, Integer> entry : votos.entrySet()) {
            diccionario.put(entry.getValue(),((Papeleta) entry.getKey()).getPartidoPolitico());
        }
        String resultado = "";
        for (  Map.Entry<Integer, Papeleta.PartidoPolitico> entry : diccionario.entrySet()) {
            resultado += entry.getValue() + " " + entry.getKey() + "\n";
        }

        return resultado;
    }

}
