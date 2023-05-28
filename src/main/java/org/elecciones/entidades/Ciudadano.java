package org.elecciones.entidades;
import org.elecciones.interfaces.ValidarDNI;

public class Ciudadano implements ValidarDNI{

    protected String nombre;
    protected String dni;
    private Sobre sobre;
    public Ciudadano() {
        this("","");
    }

    public Ciudadano(String nombre, String dni, Sobre sobre) {
        setNombre(nombre);
        setDni(dni);
        this.sobre = sobre;
    }
    public Ciudadano(String nombre, String dni) {
        setNombre(nombre);
        setDni(dni);
    }

    public Ciudadano(Ciudadano copia) {
        this(copia.getNombre(), copia.getDni(), copia.getSobre());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre != null) {
            this.nombre = nombre.trim().toLowerCase();
        }
        if (this.nombre == null)
            this.nombre = "";
    }

    public Sobre getSobre() {
        return sobre;
    }

    public void setSobre(Sobre sobre) {
        this.sobre = sobre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {

        // validamos si el dni es valido
        if(dni != null && validarDNI(dni.trim().toUpperCase())) {
            this.dni = dni;
        }
        if (this.dni == null)
            this.dni = "";
    }

    @Override
    public boolean validarDNI(String dni) {
        // Comprobar si la longitud es correcta
        if (dni.length() != 9) {
            return false;
        }

        // Extraer los números y la letra
        String numeros = dni.substring(0, 8);
        char letra = Character.toUpperCase(dni.charAt(8));

        // Comprobar si los primeros 8 caracteres son dígitos
        if (!numeros.matches("[0-9]+")) {
            return false;
        }

        // Calcular la letra esperada
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int dniNumeros = Integer.parseInt(numeros);
        char letraEsperada = letras.charAt(dniNumeros % 23);

        // Comprobar si la letra es correcta
        return letra == letraEsperada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ciudadano ciudadano = (Ciudadano) o;

        return dni.equals(ciudadano.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public String toString() {
        return nombre +";"+  dni;
    }


}
