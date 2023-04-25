/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rocio r
 */
public class ItemCarrito {
	private Carrito carro;
	private Producto prod;
	private int cantidad;
	private double montoItem;
	private int numeroC;
	
	public ItemCarrito(Carrito num, Producto p, int cantidad) {
		carro= num;
		prod = p;
		this.cantidad=cantidad;
		montoItem= prod.un_precio() * cantidad;	
	}
	public int dameCantidad() {
		return cantidad;
	}
	
	public double dameMontoItem() {
		return montoItem;
	}
	public int dameProducto() {
		return prod.un_codigo();
	}
	public void mostrarItem() {
		
		System.out.println(cantidad+"\t"+montoItem+"\t"+String.format("%.2f",montoItem ));
	}
	public void mostrarItemTitulo() {
		System.out.println("Carro num: "+carro.dameNum());
		System.out.println("Cant:\tPrecio:\tSub Total:\tProd:");
	}


}
