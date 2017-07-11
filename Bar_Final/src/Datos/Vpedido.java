/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Cristian
 */
public class Vpedido {
    // nose si irian mesa producto empleado
    private int idpedido;
    private String numero;
    private String hora;
    private String mesa;
    private String producto;
    private String empleado;

    public Vpedido() {
    }

    public Vpedido(int idpedido, String numero, String hora, String mesa, String producto, String empleado) {
        this.idpedido = idpedido;
        this.numero = numero;
        this.hora = hora;
        this.mesa = mesa;
        this.producto = producto;
        this.empleado = empleado;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

   
    
}
