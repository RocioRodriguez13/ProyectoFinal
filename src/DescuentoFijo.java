/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rocio r
 */
public class DescuentoFijo extends Descuento {
	
        
	public double montoFinal(double montoInicial) {
		return montoInicial - this.dameMonto();
	}

       
}