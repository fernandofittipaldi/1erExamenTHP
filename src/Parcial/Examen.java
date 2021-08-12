package Parcial;
import java.util.Scanner;

public class Examen {
	
	private static Scanner input = new Scanner (System.in);

	public static void main(String[] args) {
		final int MIN_PICO=9;
		final int MAX_PICO=18;
		final int TARIFA_MOTO=50;
		final int TARIFA_AUTO=100;
		final int TARIFA_CAMIONETA=150;
		final int MIN_HORA=0;
		final int MAX_HORA=23;
		final String FIN= "FIN";
		final double PORC_HORA_PICO=0.5;
		
		String patente="";
		String tipo="";
		int hora=0;
		int tarifa=0;
		int contadorM=0;
		int contadorA=0;
		int contadorC=0;
		int totalVehiculos=0;
		boolean horaPico=false;
		int recaudacion=0;
		double porcAutos=0;
					
		do {
			System.out.println("Ingrese la patente del vehiculo, (Fin para finalizar la carga)");
			patente=input.nextLine().toUpperCase();
		} while (patente.equals("")); 
		
		
		while (!patente.equals(FIN)) {
			
			System.out.println("Ingrese tipo de vehiculo, (M - Moto, A - Automovil, C - Camioneta) ");
			tipo=input.nextLine().toUpperCase();
			while ( !tipo.equals("M") && !tipo.equals("A") && !tipo.equals("C")) {
				System.out.println("Error, ingrese un tipo de vehiculo correcto (M - Moto, A - Automovil, C - Camioneta)");
				tipo=input.nextLine().toUpperCase();
			}
		
			System.out.println("Ingrese la hora, solo de 0 a 23: ");
			hora=Integer.parseInt(input.nextLine());
			while (hora<MIN_HORA || hora>MAX_HORA ) {
				System.out.println("Ingrese una hora correcta entre las 0 y las 23: ");
				hora=Integer.parseInt(input.nextLine());
			}
			
			switch (tipo) {
			case "M":
				contadorM++;
				tarifa=TARIFA_MOTO;
				break;
			case "A":
				contadorA++;
				tarifa=TARIFA_AUTO;
				break;
			case "C":
				contadorC++;
				tarifa=TARIFA_CAMIONETA;
				break;
			}
						
			horaPico=hora>=MIN_PICO && hora<=MAX_PICO;
			
			if (horaPico) {
				tarifa=(int) (tarifa + tarifa * PORC_HORA_PICO);
				System.out.println("La tarifa de la " + patente + " es de " + tarifa);
			} else { System.out.println("La tarifa de la " + patente + " es de " + tarifa);
			}
			recaudacion=recaudacion+tarifa;
			
			System.out.println("Ingrese la patente del vehiculo, (Fin para finalizar la carga)");
			patente=input.nextLine().toUpperCase();
				
		}
		
		totalVehiculos=contadorM+contadorA+contadorC;

		if (totalVehiculos>0) {
			porcAutos=contadorA*100/totalVehiculos;
			System.out.println("La recaudación total es de: " + recaudacion);
			System.out.println("El porcentaje de autos es de % " + porcAutos);
		} else {
			System.out.println("No se ingresaron vehículos");
		}
		
				
		input.close();

	}

}
