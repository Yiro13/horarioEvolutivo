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
public class AlgoritmoEvolutivo {

    private List<Horario> muestra;
    private int tamanoMuestra;
    private int numeroGeneracion;
    private int cantidadHoras;
    private int cantidadProfesores;
    private int cantidadSalones;

    public AlgoritmoEvolutivo(int tamanoMuestra, int numeroGeneracion, int cantidadHoras, int cantidadProfesores, int cantidadSalones) {
        this.tamanoMuestra = tamanoMuestra;
        this.numeroGeneracion = numeroGeneracion;
        this.muestra = new ArrayList<>();
        this.cantidadHoras = cantidadHoras;
        this.cantidadProfesores = cantidadProfesores;
        this.cantidadSalones = cantidadSalones;
    }

    public void ejecutar() {
        inicializarMuestra(cantidadHoras, cantidadProfesores, cantidadSalones);
        
        for (int i = 0; i < numeroGeneracion; i++) {
            
            List<Horario> seleccionados = seleccionar();
            // Utilizada para cruzar los horarios seleccionados
            System.out.println("GENERACION: " + (i + 1));
            
            // Se cruzan los 2 horarios seleccionados
            List<Horario> hijos = cruzar(seleccionados, cantidadHoras, cantidadProfesores, cantidadSalones);
            mutar(hijos);
            reemplazarMuestra(hijos);
            Horario mejorHorario = getMejorHorario();
            if(mejorHorario != null){
                System.out.println("Puntaje: " + mejorHorario.getPuntaje());
            }
            System.out.println("----------------------------------------");
        }
        Horario mejorHorario = getMejorHorario();//Se imprime el mejor horario al finalizar el algoritmo
        if(mejorHorario != null){
            System.out.println("\n\n////////////////////////////////////////");
            System.out.println("PUNTAJE FINAL: " + mejorHorario.getPuntaje());
            System.out.println("////////////////////////////////////////");
        }else {
            System.out.println("\n\n////////////////////////////////////////");
            System.out.println("ERROR");
            System.out.println("////////////////////////////////////////");
        }
        // Imprimir el mejor horario
       
    }

    private void inicializarMuestra(int cantidadHoras, int cantidadProfesores, int cantidadSalones) {
        for (int i = 0; i < tamanoMuestra; i++) {
            Horario horario = new Horario(cantidadHoras, cantidadProfesores, cantidadSalones); // Generar un horario aleatorio
            
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

    private List<Horario> cruzar(List<Horario> seleccionados, int cantidadHoras, int cantidadProfesores, int cantidadSalones) {
        Random random = new Random();
        List<Horario> hijos = new ArrayList<>();//Lista de hijos
        Horario a = seleccionados.get(0);//Se seleccionan los mejores 2 horarios de la generacion anterior
        Horario b = seleccionados.get(1);
        Horario hijo = new Horario(cantidadHoras, cantidadProfesores, cantidadSalones);//Se inicializa el nuevo horario hijo de manera aleatoria
        
        for (int i = 0; i < a.getHoras().length; i++) {
            for (int j = 0; j < a.getHoras()[i].getSalones().length; j++) {
                int numeroAleatorio = random.nextInt(2);//En caso de ser 1 se tomara el dato del padre, en caso de ser 0 se toma de la madre
                if(numeroAleatorio == 1){
                    hijo.getHoras()[i].getSalones()[j] = a.getHoras()[i].getSalones()[j];
                }else {
                    hijo.getHoras()[i].getSalones()[j] = b.getHoras()[i].getSalones()[j];
                }
            }
        }
        
        for (int k = 0; k < 5; k++){
            hijo.hacerEvaluacion();
            hijos.add(hijo);//Se guardan 5 hijos iguales para mutarlos
        }
                
        return hijos;
    }

    private void mutar(List<Horario> hijos) {
        Random random = new Random();
        // Implementar la mutación de los horarios
        for(Horario hijo : hijos){
            for(int i = 0; i < 1; i++){//Por cada horario se hacen tres mutaciones aleatorias en horas y salones aleatorios
                int horaAleatoria = random.nextInt(hijo.getHoras().length);
                int salonAleatorio = random.nextInt(hijo.getHoras()[0].getSalones().length);
                int datoAleatorio = random.nextInt(0, 4);
                hijo.getHoras()[horaAleatoria].getSalones()[salonAleatorio] = datoAleatorio;
            }
        }
    }

    private void reemplazarMuestra(List<Horario> hijos) {
        // Reemplazar la población actual con los hijos
        muestra.clear();
        muestra.addAll(hijos);
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
