/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


  

public class CompraListasColeccionesDB {

	public static void main(String[] args) {
	try {
		//hacemos la conex
		Connection cX = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado", "root", "root");
		Statement sT = cX.createStatement();
		String consulta = "select * from clientes";
		
		ResultSet sql = sT.executeQuery(consulta);
		
		System.out.println("CODIGO\tDNI\tNOMBRE\tDIRECCION");
		while (sql.next()) {
			System.out.println(sql.getInt(1)+"\t"+sql.getInt(2)+"\t"+sql.getString(3)+"\t"+sql.getString(4));
		}
		///el cliente tiene que elegir un id
		
		System.out.println("\n\t\t SELECCIONE UN CODIGO DE CLIENTE:  ");
		Scanner entrada = new Scanner(System.in);
		int cod = entrada.nextInt();
		
		//BUSCAR EN LA TABLA CLIENTES EL ID INGRESADO POR CONSOLA
		
        consulta = String.format("select * from clientes WHERE idC = %s", cod);
		
		sql = sT.executeQuery(consulta);
		int idC=0,dniC=0;
		String nomC="", direC = "";
	
		while (sql.next()) {	
			idC=sql.getInt(1);
			dniC=sql.getInt(2);
			nomC = sql.getString(3);
			direC= sql.getString(4);
		}
		
		Cliente c1 = new Cliente(idC,dniC,nomC,direC);
		
		System.out.println("\n\t\t INGRESE EL NUMERO DEL CARRITO:  ");
		cod = entrada.nextInt();		
		Carrito carro1 = new Carrito(c1,cod);
		
		
		//listar productos desde la bd
	/*	boolean datos = true;
		while (datos) {
			System.out.println("ingrese el codigo del producto:");
			int prod = entrada.nextInt();
			System.out.println("ingrese la cantidad: ");
			int cant = entrada.nextInt();
//TENDRIA QUE EJEMPLARIZAR ITEMCARRITO			
			System.out.println("Desea ingresar otro producto?  s-n");
			entrada.nextLine();
			String respu = entrada.nextLine();			
			
			if (respu.equals("n"))
				datos= false;			
		}//while*/
		
		Producto p1 = new Producto("Atum",150.3,001);
		Producto p2 = new Producto("Mermelada",215.3,002);
		Producto p3 = new Producto("Leche",190.8,003);
		Producto p4 = new Producto("Pan",200.5,004);
		Producto p5 = new Producto("Aceite",450.3,005);
		Producto p6 = new Producto("Manteca",315.3,006);
		Producto p7 = new Producto("Azucar",290.8,007);
		Producto p8 = new Producto("Pollo",800.5,010);
		
		ItemCarrito item1 = new ItemCarrito(carro1,p1,3);
		ItemCarrito item2 = new ItemCarrito(carro1,p3,2);
		ItemCarrito item3 = new ItemCarrito(carro1,p2,5);
		ItemCarrito item4 = new ItemCarrito(carro1,p4,3);
		ItemCarrito item5 = new ItemCarrito(carro1,p5,1);
		ItemCarrito item6 = new ItemCarrito(carro1,p6,1);
		ItemCarrito item7 = new ItemCarrito(carro1,p7,2);
		ItemCarrito item8 = new ItemCarrito(carro1,p8,2);
	
		List<ItemCarrito> item;
		item = new ArrayList<ItemCarrito>();
		item.add(item1);
		item.add(item2);
		item.add(item3);
		item.add(item4);
		item.add(item5);
		item.add(item6);
		item.add(item7);
		item.add(item8);
				
	
		System.out.println("Cliente: "+c1.dameNombre());
		item4.mostrarItemTitulo();
		Iterator<ItemCarrito> iterador = item.iterator();
									
		String insertT = "insert into itemcarrito (idCA,numCA,idP,canIC,montoIC,fechaIC) values(?,?,?,?,?,?)";		                                         
		PreparedStatement updaIC = cX.prepareStatement(insertT);
		LocalDate fecha1 = LocalDate.now();
				

		while (iterador.hasNext()) {
		ItemCarrito items = iterador.next();		
		items.mostrarItem();
		
		updaIC.setInt(1,1);//le damos un valor nosotros por el momento solo para probar el insert
		updaIC.setInt(2,carro1.dameNum());
		updaIC.setInt(3,items.dameProducto());
		updaIC.setInt(4,items.dameCantidad());
		updaIC.setDouble(5,items.dameMontoItem());
		updaIC.setString(6,fecha1.toString());

		updaIC.executeUpdate();
		
		carro1.sumarMonto(items);
		}
		System.out.println("\nTotal: "+String.format("%.2f",carro1.dameMontoTotal()));

		DescuentoFijo dFijo = new DescuentoFijo();
		dFijo.asignaMonto(100);
		System.out.println("MontoTotal con descuento: "
		+ String.format("%.2f",dFijo.montoFinal(carro1.dameMontoTotal())));
		LocalDate fecha = LocalDate.now();
		
		//cargar la tabla carrito
		consulta ="insert into carrito (idCA,numCA,idC,montoCA,descuCA,fechaCA) values(idCA,?,?,?,?,?)";
    	
    	PreparedStatement ins = cX.prepareStatement(consulta);		
		
//    	ins.setInt(1,idCA);
        ins.setInt(1,carro1.dameNum());
        ins.setInt(2,c1.dameId());
                ins.setDouble(4,carro1.dameMontoTotal());
        ins.setDouble(3,carro1.dameMontoTotal());
        ins.setString(5,fecha.toString());

        // Indicamos que comience la actualización de la tabla en nuestra base de datos
        ins.executeUpdate();
		
		entrada.close();
		cX.close();
		
	}catch(SQLException obj) {
		System.out.println("Error en la conexion");
		System.out.println(obj.fillInStackTrace());
	}			
	}
}