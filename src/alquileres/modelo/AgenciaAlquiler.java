package alquileres.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import alquileres.test.Utilidades;

/**
 * La clase guarda en una colección List (un ArrayList) la flota de vehículos
 * que una agencia de alquiler posee
 * 
 * Los vehículos se modelan como un interface List que se instanciará como una
 * colección concreta ArrayList
 * @author Jaione Echalecu 
 */
public class AgenciaAlquiler {
	private String nombre; // el nombre de la agencia
	private List<Vehiculo> flota; // la lista de vehículos

	/**
	 * Constructor
	 * 
	 * @param nombre el nombre de la agencia
	 */
	public AgenciaAlquiler(String nombre) {
		this.nombre = nombre;
		this.flota = new ArrayList<>();
	}

	/**
	 * añade un nuevo vehículo solo si no existe
	 * 
	 */
	public void addVehiculo(Vehiculo v) {
		if(!flota.contains(v))
		{
			flota.add(v);
		}
	}

	/**
	 * Extrae los datos de una línea, crea y devuelve el vehículo
	 * correspondiente
	 * 
	 * Formato de la línea:
	 * C,matricula,marca,modelo,precio,plazas para coches
	 * F,matricula,marca,modelo,precio,volumen para furgonetas
	 * 
	 * 
	 * Asumimos todos los datos correctos. Puede haber espacios antes y después
	 * de cada dato
	 */
	private Vehiculo obtenerVehiculo(String enunciado) {
		String[] lista = enunciado.split(",");
		String tipo = lista[0].trim();
		if(tipo.equals("C"))
		{
		return new Coche(lista[1].trim(),lista[2].trim(),lista[3].trim(),Double.parseDouble(lista[4].trim()),Integer.parseInt(lista[5].trim()));
		}
		else
		{
			return new Furgoneta(lista[1].trim(),lista[2].trim(),lista[3].trim(),Double.parseDouble(lista[4].trim()),Double.parseDouble(lista[5].trim()));
		}
	}

	/**
	 * La clase Utilidades nos devuelve un array con las líneas de datos
	 * de la flota de vehículos  
	 */
	public void cargarFlota() {
		String[] datos = Utilidades.obtenerLineasDatos();
		String error = null;
		try {
			for (String linea : datos) {
				error = linea;
				Vehiculo vehiculo = obtenerVehiculo(linea);
				this.addVehiculo(vehiculo);

			}
		}
		catch (Exception e) {
			System.out.println(error);
		}

	}

	/**
	 * Representación textual de la agencia
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		Iterator<Vehiculo> it = flota.iterator();
		str.append("Vehiculos en alquiler de la agencia " + nombre + "\nTotal vehiculos " + flota.size());
		while(it.hasNext())
		{
			Vehiculo v = it.next();
			str.append(v.toString() + "\n---------------------------\n");
		}
		
		return str.toString();

	}

	/**
	 * Busca todos los coches de la agencia
	 * Devuelve un String con esta información y lo que
	 * costaría alquilar cada coche el nº de días indicado * 
	 *  
	 */
	public String buscarCoches(int dias) {
		Iterator<Vehiculo> it = flota.iterator();
		String info = "";
		while(it.hasNext())
		{
			Vehiculo v = it.next();
			if(v instanceof Coche)
			{
				info += v.toString() + "\nCoste alquiler: " + dias + "dias" + v.calcularPrecioAlquiler(dias) + "\n---------------------------\n";
			}
		}
		return info;

	}

	/**
	 * Obtiene y devuelve una lista de coches con más de 4 plazas ordenada por
	 * matrícula - Hay que usar un iterador
	 * 
	 */
	public List<Coche> cochesOrdenadosMatricula() {
		Iterator<Vehiculo> it = flota.iterator();
		List<Coche> lista = new ArrayList<>();
		while(it.hasNext())
		{
			Vehiculo v = it.next();
			if(v instanceof Coche)
			{
				lista.add((Coche) v);
			}
		}
		Collections.sort(lista, new Comparator<Vehiculo>() {
			public int compare(Vehiculo uno, Vehiculo otro) {
				if (Integer.parseInt(uno.getMatricula().substring(0, 4)) > Integer
						.parseInt(otro.getMatricula().substring(0, 4))) {
					return -1;
				}
				if (Integer.parseInt(uno.getMatricula().substring(0, 4)) == Integer
						.parseInt(otro.getMatricula().substring(0, 4))) {
					return 0;
				}
				return 1;

			}
		});
		return lista;
	}

	/**
	 * Devuelve la relación de todas las furgonetas ordenadas de
	 * mayor a menor volumen de carga
	 * 
	 */
	public List<Furgoneta> furgonetasOrdenadasPorVolumen() {

		Iterator<Vehiculo> it = flota.iterator();
		List<Furgoneta> furgonetas = new ArrayList<>();
		while(it.hasNext())
		{
			Vehiculo v = it.next();
			if(v instanceof Furgoneta)
			{
				furgonetas.add((Furgoneta) v);
			}
		}
		Collections.sort(furgonetas, new Comparator<Vehiculo>() {
			public int compare(Vehiculo uno, Vehiculo otro) {
				if (((Furgoneta) uno).getVolumen() > ((Furgoneta) otro).getVolumen()) {
					return -1;
				}
				if (((Furgoneta) uno).getVolumen() == ((Furgoneta) otro).getVolumen()) {
					return 0;
				}
				return 1;

			}
		});
		return furgonetas;

	}

	/**
	 * Genera y devuelve un map con las marcas (importa el orden) de todos los
	 * vehículos que hay en la agencia como claves y un conjunto (importa el orden) 
	 * de los modelos en cada marca como valor asociado
	 */
	public Map<String, Set<String>> marcasConModelos() {
		return null;
	}

}
