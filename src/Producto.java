/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rocio r
 */
public class Producto {
  
    private String nombre;
    private double precio;
    private int codigo;
	
	public Producto (String nom, double pre, int cod) {
		nombre = nom;
		precio = pre;
		codigo = cod;
	}
	///metodos getter

	public String un_nombre() {
		return nombre;
	}

	public double un_precio() {
		return precio;
	}
	
	public int un_codigo() {
		return codigo;
	}
	
}


    
    
    
    

