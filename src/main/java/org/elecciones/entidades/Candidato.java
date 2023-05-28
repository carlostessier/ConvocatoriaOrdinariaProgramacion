package org.elecciones.entidades;

import java.util.Objects;

public class Candidato extends Ciudadano {

    private int numeroLista;
    public static int MAX_NUMERO_LISTA = 50;
    public Candidato(){
        this("","",0);
    }

    public Candidato(String nombre, String dni, int numeroLista) {
        super(nombre,dni);
        this.numeroLista = numeroLista;
    }


    public int getNumeroLista() {
        return numeroLista;
    }

    public void setNumeroLista(int numeroLista) {
        if(numeroLista > 0 && numeroLista <= MAX_NUMERO_LISTA)
            this.numeroLista = numeroLista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidato)) return false;
        if (!super.equals(o)) return false;
        Candidato candidato = (Candidato) o;

        if (!candidato.dni.equals(this.dni))
            return false;

        return numeroLista == candidato.numeroLista;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numeroLista);
    }
}
