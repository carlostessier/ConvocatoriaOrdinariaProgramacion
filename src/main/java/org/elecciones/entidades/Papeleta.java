package org.elecciones.entidades;

import java.util.*;

public class Papeleta {

    public enum PartidoPolitico {
        PP, PSOE, PODEMOS, CIUDADANOS, VOX, MASMADRID, VACIO}

    private PartidoPolitico partidoPolitico;
    private Collection<Candidato> candidatos;

    public Papeleta() {
        partidoPolitico = PartidoPolitico.VACIO;
        candidatos = new HashSet<>();
    }

    public Papeleta(PartidoPolitico partidoPolitico, Collection<Candidato> candidatos) {
        this.partidoPolitico = partidoPolitico;
        this.candidatos = candidatos;
    }

    public PartidoPolitico getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(PartidoPolitico partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public Collection<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(Collection<Candidato>candidatos) {
        this.candidatos = candidatos;
    }

    public void addCandidato(Candidato candidato) {
        candidatos.add(candidato);
    }

    public void removeCandidato(Candidato candidato) {
        candidatos.remove(candidato);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Papeleta papeleta = (Papeleta) o;

        return partidoPolitico == papeleta.partidoPolitico;
    }

    @Override
    public int hashCode() {
        return partidoPolitico != null ? partidoPolitico.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(partidoPolitico).append("\n");
        sb.append("Candidatos:\n");
        for (Candidato candidato : candidatos) {
            sb.append(candidato.getNumeroLista()).append(": ")
                    .append(candidato.getNombre()).append("\n");
        }

        return sb.toString();
    }

}
