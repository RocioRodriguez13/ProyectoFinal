/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rocio r
 */
public class Cliente {
    private int id;
	private int dni;
	private String nombre;
	private String dire;
	
	public Cliente(int id,int dni, String nom, String dire) {
		this.id= id;
		this.dni= dni;
		nombre = nom;
		this.dire = dire;		
	}
	public int dameId() {
		return id;
	}
	public int dameDni() {
		return dni;
	}
	public String dameNombre() {
		return nombre;
	}
	public String dameDire() {
		return dire;
	}

}
