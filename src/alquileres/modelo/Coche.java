package alquileres.modelo;

/**
 * @author Jaione Echalecu
 * Un coche es un veh�culo que a�ade un n� de plazas
 * 
 * El coste final de alquiler depende no solo del n� de d�as de alquiler 
 * sino tambi�n del n� de plazas. Si el n� de plazas es > 4 se a�aden 5� m�s por d�a
 */
public class Coche extends Vehiculo{
	private int nPlazas;
	public Coche(String matricula, String marca, String modelo, double precioDia, int nPlazas) {
		super(matricula, marca, modelo, precioDia);
		this.nPlazas = nPlazas;
	}
	@Override
	public int compare(Vehiculo uno, Vehiculo otro) { 
		return super.compare(uno, otro); 
	}
	public double calcularPrecioAlquiler(int dias)
	{
		if (nPlazas > 4)
		{
		return dias * (super.getPrecioDia() +  5);
		}
		else
		{
		return super.calcularPrecioAlquiler(dias);
		}
	}
	public int getnPlazas() {
		return nPlazas;
	}
	public void setnPlazas(int nPlazas) {
		this.nPlazas = nPlazas;
	}
	public String toString()
	{
		return "Coche\n" + super.toString() + "| Plazas: " + nPlazas; 
	}
}
