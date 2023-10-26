/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

/**
 *
 * @author aleja
 */
public class Hora {
    private int[] salones;

    public Hora(int cantidadSalones) {
        salones = new int[cantidadSalones];
        for (int i = 0; i < cantidadSalones; i++) {
            salones[i] = -1; // No tiene profesor asignado
        }
    }

    public int getSalonProfesor(int index) {
        return salones[index];
    }

    public void setSalonProfesor(int pos, int profesorIndex) {
        this.salones[pos] = profesorIndex;
    }
    
    public int getCantidadSalones(){
        return salones.length;
    }
    
    public int[] getSalones(){
        return salones;
    }
    
    
}
