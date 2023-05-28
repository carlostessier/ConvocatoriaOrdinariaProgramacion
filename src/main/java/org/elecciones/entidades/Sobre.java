package org.elecciones.entidades;

import java.util.Objects;

public class Sobre {
    private Object contenido;

    public Sobre() {
        contenido = "";
    }

    public Sobre(Object contenido) {
        this.contenido = contenido;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sobre)) return false;
        Sobre sobre = (Sobre) o;
        return Objects.equals(contenido, sobre.contenido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contenido);
    }
}
