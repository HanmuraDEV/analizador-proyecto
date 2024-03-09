/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorproyecto;

/**
 *
 * @author hanmura
 */
public class Simbolo {
        private String tipo;
    private String ambito;
    private String visibilidad;
    private String tamañoValor;
    private String posicion;
    private String rol;

    public Simbolo(String tipo, String ambito, String visibilidad, String tamañoValor, String posicion, String rol) {
        this.tipo = tipo;
        this.ambito = ambito;
        this.visibilidad = visibilidad;
        this.tamañoValor = tamañoValor;
        this.posicion = posicion;
        this.rol = rol;
    }

    public String getTipo() {
        return tipo;
    }

    public String getAmbito() {
        return ambito;
    }

    public String getVisibilidad() {
        return visibilidad;
    }

    public String getTamañoValor() {
        return tamañoValor;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getRol() {
        return rol;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    public void setTamañoValor(String tamañoValor) {
        this.tamañoValor = tamañoValor;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
}
