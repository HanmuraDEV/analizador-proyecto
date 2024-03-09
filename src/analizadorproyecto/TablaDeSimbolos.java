/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorproyecto;

import java.util.HashMap;

public class TablaDeSimbolos {
    private HashMap<String, Simbolo> tabla;

    public TablaDeSimbolos() {
        this.tabla = new HashMap<>();
    }

    public void agregarSimbolo(String nombre, Simbolo simbolo) {
        tabla.put(nombre, simbolo);
    }

    public void imprimirTabla() {
        System.out.println("Tabla de Simbolos:");
        for (String nombre : tabla.keySet()) {
            Simbolo simbolo = tabla.get(nombre);
            System.out.println("Nombre: " + nombre +
                               ", Tipo: " + simbolo.getTipo() +
                               ", Ambito: " + simbolo.getAmbito() +
                               ", Visibilidad: " + simbolo.getVisibilidad() +
                               ", Tamaño/Valor: " + simbolo.getTamañoValor() +
                               ", Posicion: " + simbolo.getPosicion() +
                               ", Rol: " + simbolo.getRol());
        }
    }
}

