package cars;

public interface Produs {
	
	String insertCar(int anFabricare,String dotari,double pret,String combustibil, String marca);
	String deleteCar(int anFabricare,String dotari,double pret,String combustibil, String marca);
	String updateCar(int anFabricare,String dotari,double pret,String combustibil, String marca);
}
