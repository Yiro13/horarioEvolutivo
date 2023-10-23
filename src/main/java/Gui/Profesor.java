/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

/**
 *
 * @author aleja
 */
public class Profesor {
    String nombre;
    int prioridad; // 0 mayor prioridad
    int cantidadHoras;

    public Profesor(String nombre, int prioridad, int cantidadHoras) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.cantidadHoras = cantidadHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    @Override
    public String toString() {
        return "Profesor{" + "nombre=" + nombre + ", prioridad=" + prioridad + ", cantidadHoras=" + cantidadHoras + '}';
    }
    
    
}
