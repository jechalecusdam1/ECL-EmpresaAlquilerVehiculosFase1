package alquileres.modelo;

/**
 * Una furgoneta es un vehículo que añade la característica del volumen de
 * carga (valor de tipo double)
 * 
 * El coste de alquiler de una furgoneta no solo depende del nº de días de
 * alquiler Tendrá un incremento que dependerá de su volumen de carga: hasta 5
 * m3 exclusive ( metros cúbicos) de volumen el incremento sobre el precio
 * final será de 10€, entre 5 y 10 (inclusive) el incremento sobre el precio
 * final será de 15€, si volumen > 10 el incremento sobre el precio final
 * será de 25€
 * @author Jaione Echalecu
 */
public class Furgoneta extends Vehiculo {
	private double volumen;

	public Furgoneta(String matricula, String marca, String modelo, double precioDia, double volumen) {
		super(matricula, marca, modelo, precioDia);
		this.volumen = volumen;
	}

	public int compare(Vehiculo uno, Vehiculo otro) {
		return super.compare(uno, otro);
	}

	public double calcularPrecioAlquiler(int dias)
	{
		if(volumen < 5)
		{
		return dias * super.getPrecioDia() + 10;
		}
		else if(volumen >= 5 && volumen <= 10)
		{
		return dias * super.getPrecioDia() + 15;
		}
		else
		{
		return dias * super.getPrecioDia() + 25;
		}
		
	}
	public double getVolumen() {
		return volumen;
	}

	public String toString()
	{
		return "Furgoneta\n" + super.toString() + "| Volumen: " + volumen;
	}
}
