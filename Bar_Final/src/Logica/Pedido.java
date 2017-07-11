/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Vpedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cristian
 */
public class Pedido {
    
    private Conexion mysql = new Conexion();
    private Connection cn=mysql.conectar();
    private String SQL="";
    public int totalderegistro;
    
    
    
    public DefaultTableModel mostrar(String buscar)
    {
        DefaultTableModel modelo;
        //Titulos de las Columnas
        String [] titulo = {"ID","Numero","Hora","Producto","Empleado","Mesa"}; 
    
        String [] registro =new String [8];
        totalderegistro=0;
        modelo = new DefaultTableModel(null,titulo);
        //sentencia Sql para obtener los registro
        SQL="select * from pedido where numero like '%"+buscar+"%'order by idpedido";
        try {
            Statement st = cn.createStatement();
            //Ejecuta el Statement
            ResultSet  rs=st.executeQuery(SQL);
            //almaceno los resultados obtenidos
            while(rs.next()){
                registro[0]=rs.getString("idPedido");
                registro[1]=rs.getString("numero");
                registro[2]=rs.getString("hora");
                //no estos seguro de esto jaja
                registro[3]=rs.getString("EMPLEADO_idEmpleado");
                registro[4]=rs.getString("PRODUCTO_idProducto");
                registro[5]=rs.getString("MESA_idMesa");
                totalderegistro=totalderegistro+1;
                //a la Fila le pongo el registro
                modelo.addRow(registro);    
            }
            return modelo;
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null,e);
        return null;
        }
    
    }
    //me va a devolver true o false
    public boolean insertar(Vpedido p)
    {
        //no estoy seguro
        SQL="insert into pedido (numero,hora)"+ "values (?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            //envio 1 a 1 los valores por cada ?
            ps.setString(1, p.getNumero());
            ps.setString(2, p.getHora());
            int n=ps.executeUpdate();
            //compruebo que se hayan insertado los registro
            if(n!=0)
            {
                return true;
            }else{
                return false;
            }
            
            
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null,e);
        return false;
        }        
    }
    public boolean editar(Vpedido p)
    {
        SQL="update pedido set numero=?,hora=? "+"where idpedido=?";
        try {
         PreparedStatement ps = cn.prepareStatement(SQL);
            //envio 1 a 1 los valores por cada ?
            ps.setString(1, p.getNumero());
            ps.setString(2, p.getHora());
            ps.setInt(3, p.getIdpedido());
            int n=ps.executeUpdate();
            //compruebo que se hayan insertado los registro
            if(n!=0)
            {
                return true;
            }else{
                return false;
            }   
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null,e);
        return false;
        }
    }
    public boolean eliminar(Vpedido p)
    {
        SQL="delete from pedido where idpedido=?";
        try {
            PreparedStatement ps = cn.prepareStatement(SQL);
            //envio 1 a 1 los valores por cada ?
            ps.setInt(1, p.getIdpedido());
            int n=ps.executeUpdate();
            //compruebo que se hayan insertado los registro
            if(n!=0)
            {
                return true;
            }else{
                return false;
            }   
        } catch (Exception e) {
        JOptionPane.showConfirmDialog(null,e);
        return false;
        }
    }
}
