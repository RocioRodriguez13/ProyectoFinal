/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rocio r
 */
public abstract  class Descuento {
	
    private double montoDesc;
	
	public double dameMonto() {
		return montoDesc;
	}
	public void asignaMonto(double montoFijo) {
		montoDesc = montoFijo;
	}
	
	public abstract double montoFinal(double montoInicial);

}
