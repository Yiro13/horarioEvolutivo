/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
            
            List<Horario> seleccionados = seleccionar();
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
        Horario[] horariosOrdenados = muestra.toArray(Horario[]::new); //Se convierte la mestra a un array
        List<Horario> horariosSeleccionados = new ArrayList<>();
   
        for(int i = 0; i < horariosOrdenados.length - 1; i++){ //Se ordena el array horariosOrdenados descendentemente
            for(int j = 0; j < horariosOrdenados.length - 1; j++){
                if(horariosOrdenados[j].getPuntaje() < horariosOrdenados[j + 1].getPuntaje()){
                    Horario temp = horariosOrdenados[j];
                    horariosOrdenados[j] = horariosOrdenados[j + 1];
                    horariosOrdenados[j + 1] = temp;
                }
            }
        }
        
        horariosSeleccionados.add(horariosOrdenados[0]);//Se agregan los primeros 2 horarios con el puntaje mas alto a horariosSeleccionados
        horariosSeleccionados.add(horariosOrdenados[1]);
        
        return horariosSeleccionados;
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
        return mejorHorario; //Se obtiene el horario con mayor puntuacion de la muestra
    }

}
