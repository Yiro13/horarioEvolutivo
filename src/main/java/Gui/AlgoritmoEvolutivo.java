/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleja
 */
public class AlgoritmoEvolutivo {

    private List<Horario> muestra;
    private int tamanoMuestra;
    private int numeroGeneracion;
    private int cantidadHoras;
    private int cantidadProfesores;
    private int cantidadSalones;

    public AlgoritmoEvolutivo(int tamanoMuestra, int numeroGeneracion) {
        this.tamanoMuestra = tamanoMuestra;
        this.numeroGeneracion = numeroGeneracion;
        this.muestra = new ArrayList<>();
    }

    public void ejecutar() {
        inicializarMuestra();
        
        for (int i = 0; i < numeroGeneracion; i++) {
            
            //List<Horario> seleccionados = seleccionar();
            // Utilizada para cruzar los horarios seleccionados
            //List<Horario> nodo = cruzar(seleccionados);
            //mutar(nodo);
            //reemplazarMuestra(nodo);
        }
        Horario mejorHorario = getMejorHorario();
        if(mejorHorario != null){
            System.out.println("Mejor horario: " + mejorHorario + " Puntaje: " + mejorHorario.getPuntaje());
        }else {
            System.out.println(muestra.size());
        }
        // Imprimir el mejor horario
       
    }

    private void inicializarMuestra() {
        for (int i = 0; i < tamanoMuestra; i++) {
            Horario horario = new Horario(10, 5, 5); // Generar un horario aleatorio
            
            muestra.add(horario);
        }
    }

    private List<Horario> seleccionar() {
        // Implementar horarios basada en aptitud
        for (Horario horario : muestra) {
            
        }
        return null;
    }

    private List<Horario> cruzar(List<Horario> seleccionados) {
        List<Horario> nodo = new ArrayList<>();
        // Implementar el cruce de horarios
        return nodo;
    }

    private void mutar(List<Horario> nodo) {
        // Implementar la mutación de los horarios
    }

    private void reemplazarMuestra(List<Horario> nodo) {
        // Reemplazar la población actual con los hijos
        muestra.clear();
        muestra.addAll(nodo);
    }

    private Horario getMejorHorario() {
        double mejorPuntuacion = 0.0;
        Horario mejorHorario = null;
        for(Horario horario : muestra){
            if(horario.getPuntaje() >= mejorPuntuacion){
                mejorPuntuacion = horario.getPuntaje();
                mejorHorario = horario;
            }
        }
        return mejorHorario;
    }

}
