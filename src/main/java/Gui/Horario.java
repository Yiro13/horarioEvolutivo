/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author aleja
 */
class Horario {

    private Hora[] horas;
    private Profesor[] profesores;
    public final static int HORAS_CLASE_X_PROFESOR = 5;
    public final static int MAX_PRIORIDAD_PROFESOR = 4;
    private int mayorCantidadHorasJuntas;

    public Horario(int cantidadHoras, int cantidadProfesores, int cantidadSalones) {
        this.horas = new Hora[cantidadHoras * 5]; // 5 dias de la semana
        this.profesores = new Profesor[cantidadProfesores];

        for (int i = 0; i < cantidadHoras * 5; i++) {
            horas[i] = new Hora(cantidadSalones);
        }

        Random rand = new Random();

        for (int i = 0; i < cantidadProfesores; i++) {
            int prioridad = rand.nextInt(4); // prioridad 0 a 3
            String nombre = "profesor" + String.valueOf(i);
            this.profesores[i] = new Profesor(nombre, prioridad, HORAS_CLASE_X_PROFESOR);
        }

        // ordenar profesores por prioridad (METODO BURBUJA)
        for (int i = 0; i < cantidadProfesores; i++) {
            for (int j = cantidadProfesores - 1; j >= i; j--) {
                if (profesores[j].getPrioridad() > profesores[i].getPrioridad()) {
                    Profesor temp = profesores[j];
                    profesores[j] = profesores[i];
                    profesores[i] = temp;
                }
            }
        }

        

        llenarSalones(cantidadHoras, cantidadProfesores, cantidadSalones); // 5 -> 5 dias de la semana
    }

    private void llenarSalones(int cantidadHoras, int cantidadProfesores, int cantidadSalones) {
        Random rand = new Random();
        int cantidadElementos = 5 * cantidadHoras * cantidadSalones;
        int prioridad = rand.nextInt(cantidadElementos); // prioridad 0 a 3

        List<Integer> horasDisponibles = new ArrayList<>();
        for (int i = 0; i < cantidadElementos; i++) {
            horasDisponibles.add(i);
        }

        for (int i = 0; i < cantidadProfesores; i++) {
            for (int j = 0; j < profesores[i].getCantidadHoras(); j++) {
                if (cantidadElementos > 0) {
                    int index = rand.nextInt(cantidadElementos);
                    int horario = horasDisponibles.get(index);
                    horasDisponibles.remove(index);
                    cantidadElementos--;
                    horas[horario / cantidadSalones].setSalonProfesor(horario % cantidadSalones, i);
                }
            }

        }

        imprimirHorario();
    }
    
    public void hacerEvaluacion(){
        this.mayorCantidadHorasJuntas = 0;
        int j = 0;
        for (Hora hora : horas) {
            
            for (int i = 0; i < hora.getCantidadSalones(); i++) {
                if (hora.getSalonProfesor(i) >= 0) {
                    System.out.println(j + " Dia " + (j / (horas.length / 5)) + " hora " + (j % (horas.length / 5)) + " salon " + i + " profesor " + profesores[hora.getSalonProfesor(i)].getNombre());
                }
            }
            j++;
        }
    }

    public void imprimirHorario() {
        int j = 0;
        for (Hora hora : horas) {

            for (int i = 0; i < hora.getCantidadSalones(); i++) {
                if (hora.getSalonProfesor(i) >= 0) {
                    System.out.println(j + " Dia " + (j / (horas.length / 5)) + " hora " + (j % (horas.length / 5)) + " salon " + i + " profesor " + profesores[hora.getSalonProfesor(i)].getNombre());
                }
            }
            j++;
        }
    }

}
