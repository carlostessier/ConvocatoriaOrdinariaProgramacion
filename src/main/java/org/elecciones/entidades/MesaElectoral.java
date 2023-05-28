package org.elecciones.entidades;

import org.elecciones.excepciones.ExceptionElementoRepetido;
import org.elecciones.interfaces.AccionesMesaElectoral;
import org.elecciones.interfaces.FicheroCiudadanos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MesaElectoral implements AccionesMesaElectoral, FicheroCiudadanos {

    final static int NUM_COMPONENTES = 5;

    private String direccion;
    private Ciudadano [] componentes;
    private Urna urna;
    private List<Ciudadano> censoElectoral;
    private List<Ciudadano> ciudadanosQueHanVotado;

    public MesaElectoral(){
        this.censoElectoral = new ArrayList<>();
        this.ciudadanosQueHanVotado = new ArrayList<>();
        this.urna = new Urna();
        setDireccion("");
        componentes = new Ciudadano[NUM_COMPONENTES];
        for (int i = 0; i < NUM_COMPONENTES; i++) {
            componentes[i] = new Ciudadano();
        }
    }

    public MesaElectoral(String direccion, List<Ciudadano> censoElectoral, Urna urna) {
        setDireccion(direccion);
        this.censoElectoral = censoElectoral;
        this.ciudadanosQueHanVotado = new ArrayList<>();
        this.urna = urna;
        componentes = new Ciudadano[NUM_COMPONENTES];
        for (int i = 0; i < NUM_COMPONENTES; i++) {
            componentes[i] = new Ciudadano();
        }

    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if(direccion != null) {
            this.direccion = direccion.trim().toLowerCase();
        }
        if (this.direccion == null)
            this.direccion = "";
    }

    public Ciudadano[] getComponentes() {
        return componentes;
    }



    public Urna getUrna() {
        return urna;
    }



    public List<Ciudadano> getCensoElectoral() {
        return censoElectoral;
    }



    public List<Ciudadano> getCiudadanosQueHanVotado() {
        return ciudadanosQueHanVotado;
    }



    @Override
    public boolean agnadirPresidente(Ciudadano ciudadano) {
        if(buscarPresidente(ciudadano)==-1){
            int hueco = buscarComponente(new Ciudadano());
            if(hueco != -1){
                componentes[hueco] = ciudadano;
                return true;
            }

        }
        return false;
    }



    @Override
    public boolean agnadirMiembroMesa(Ciudadano ciudadano) throws ExceptionElementoRepetido {
        int posicion = buscarComponente(ciudadano);
        if(posicion == -1) {
            int hueco = buscarComponente(new Ciudadano());
            if (hueco != -1) {
                componentes[hueco] = ciudadano;
                return true;
            } else {
                System.err.println("No hay huecos");
            }
        }else{
            throw new ExceptionElementoRepetido("El ciudadano ya es vocal");
        }
        return false;
    }



    public int buscarPresidente(Ciudadano ciudadano){
        for (int i = 0; i < NUM_COMPONENTES; i++) {
            if (componentes[i] instanceof Presidente){
                return i;
            }
        }
        return -1;
    }
    public int buscarComponente(Ciudadano ciudadano){
        for (int i = 0; i < NUM_COMPONENTES; i++) {
            if (componentes[i].equals(ciudadano)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Ciudadano> leerCiudadanos(String nombreFichero) {
        ArrayList<Ciudadano> ciudadanos = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(nombreFichero))){
            String linea;
            while((linea = br.readLine())!=null){
                String[] datos = linea.split(";");
                Ciudadano ciudadano = new Ciudadano(datos[0],datos[1]);
                ciudadanos.add(ciudadano);
            }
        }catch (FileNotFoundException e){
            System.err.println("Fichero no encontrado");

        }catch (IOException e){
            System.err.println("Error al leer el fichero");
        }
        return ciudadanos;
    }

    @Override
    public void guardarCiudadanos(String nombreFichero, List<Ciudadano> ciudadanos) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero))){
            for(Ciudadano ciudadano: ciudadanos) {
                bw.write(ciudadano.toString());
                bw.newLine();
            }

        }catch (IOException e){
            System.err.println("Error al leer el fichero");
        }
    }
}
