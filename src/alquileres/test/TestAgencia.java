package alquileres.test;

import java.util.Map;
import java.util.Set;

import alquileres.modelo.AgenciaAlquiler;
import alquileres.modelo.Coche;
import alquileres.modelo.Furgoneta;

/**
 *    @author Jaione Echalecu
 */
public class TestAgencia {

	private AgenciaAlquiler agencia;

	/**
	 * Constructor demo cargarFlota(), obtenerVehiculo(), addVehiculo()
	 * demo toString()
	 */
	public TestAgencia(String nombre) {
		agencia = new AgenciaAlquiler(nombre);
		agencia.cargarFlota();
		System.out.println(agencia.toString()); 
		hacerPausa();

	}

	/**
	 * test buscarCoches()
	 */
	public void testBuscarCoches() {

		int dias = 7;
		System.out.println("Coches de alquiler en la agencia\n");
		System.out.println(agencia.buscarCoches(dias));
		System.out.println();
		hacerPausa();

	}

	/**
	 * demo cochesOrdenadosMatricula()
	 */
	public void testCochesOrdenadosMatricula() {
		System.out.println(
		        "Coches de m�s de 4 plazas ordenados por matr�cula (de < a >)\n");
		for (Coche coche : agencia.cochesOrdenadosMatricula()) {
			System.out.println(coche.toString());
			System.out.println("--------------------");
		}
		hacerPausa();

	}

	/**
	 * demo furgonetasOrdenadasPorVolumen()
	 */
	public void testFurgonetasOrdenadasPorVolumen() {
		System.out.println("Furgonetas ordenadas de mayor a menor volumen\n");

		for (Furgoneta furgoneta : agencia.furgonetasOrdenadasPorVolumen()) {
			System.out.println(furgoneta.toString());
			System.out.println("--------------------");
		}
		System.out.println();
		hacerPausa();

	}

	/**
	 * demo marcasConModelos()
	 */
	public void testMarcasConModelos() {
		System.out.println("Marcas y modelos de veh�culos por marca\n");
		Map<String, Set<String>> marcasModelos = agencia.marcasConModelos();
		for (Map.Entry<String, Set<String>> entrada : marcasModelos
		        .entrySet()) {
			System.out.println("Marca: " + entrada.getKey() + "\n\tModelos : "
			        + entrada.getValue());
		}

	}

	/**
	 * hacer una pausa en la salida por pantalla
	 */
	public void hacerPausa() {
		@SuppressWarnings("resource")
		java.util.Scanner teclado = new java.util.Scanner(System.in);
		System.out.println("Pulsar <intro> para continuar");
		teclado.nextLine();
	}

	/**
	 * inicio de la aplicaci�n
	 */
	public static void main(String[] args) {
		TestAgencia test = new TestAgencia(args[0]);

		test.testBuscarCoches();
		test.testCochesOrdenadosMatricula();
		test.testFurgonetasOrdenadasPorVolumen();

		test.testMarcasConModelos();

	}
}
