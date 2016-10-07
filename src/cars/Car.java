package cars;

public class Car implements Produs {

	private CarDB adaptee = new CarDB();
	private int anFabricare;
	private String dotari;
	private double pret;
	private String combustibil;
	private String marca;

	public CarDB getAdaptee() {
		return adaptee;
	}

	public void setAdaptee(CarDB adaptee) {
		this.adaptee = adaptee;
	}

	public int getAnFabricare() {
		return anFabricare;
	}

	public void setAnFabricare(int anFabricare) {
		this.anFabricare = anFabricare;
	}

	public String getDotari() {
		return dotari;
	}

	public void setDotari(String dotari) {
		this.dotari = dotari;
	}

	public double getPret() {
		return pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}

	public String getCombustibil() {
		return combustibil;
	}

	public void setCombustibil(String combustibil) {
		this.combustibil = combustibil;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Car(CarDB adaptee, int anFabricare, String dotari, double pret, String combustibil, String marca) {
		super();
		this.adaptee = adaptee;
		this.anFabricare = anFabricare;
		this.dotari = dotari;
		this.pret = pret;
		this.combustibil = combustibil;
		this.marca = marca;
	}

	public Car(int anFabricare, String dotari, double pret, String combustibil, String marca, int id, String createdAt,
			String updatedAt) {
		adaptee = new CarDB(anFabricare, dotari, pret, combustibil, marca, id, createdAt, updatedAt);
	}

	public Car(int i) {
		super();
		adaptee = new CarDB(i);
		// TODO Auto-generated constructor stub
	}
	
	public Car(int id,String dotari,String createdAt, String updatedAt){
		adaptee = new CarDB(id,dotari,createdAt,updatedAt);
	}
	
	public Car(int id,double pret,String createdAt, String updatedAt){
		adaptee = new CarDB(id,pret,createdAt,updatedAt);
	}
	
	public Car(int id,String dotari,double pret,String createdAt, String updatedAt)
	{
		adaptee=new CarDB(id,dotari,pret,createdAt,updatedAt);
	}

	@Override
	public String insertCar(int anFabricare, String dotari, double pret, String combustibil, String marca) {
		return adaptee.insertCar(anFabricare, dotari, pret, combustibil, marca, adaptee.getId(), adaptee.getCreatedAt(),
				adaptee.getUpdatedAt());
	}

	@Override
	public String deleteCar(int anFabricare, String dotari, double pret, String combustibil, String marca) {
		return adaptee.insertCar(anFabricare, dotari, pret, combustibil, marca, adaptee.getId(), adaptee.getCreatedAt(),
				adaptee.getUpdatedAt());

	}

	@Override
	public String updateCar(int anFabricare, String dotari, double pret, String combustibil, String marca) {
		return adaptee.insertCar(anFabricare, dotari, pret, combustibil, marca, adaptee.getId(), adaptee.getCreatedAt(),
				adaptee.getUpdatedAt());

	}

}
// cardb va fi adaptee cu metoda insert(cele 8 proprietati)=PrintableListAdapter
// interfata: 3 met insertCar(),deleteCar(),updateCar();
// car va fi adapter,care va avea un atribut de tip cardb si ii apelez
// metodele(3 met)