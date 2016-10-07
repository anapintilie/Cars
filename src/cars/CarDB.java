package cars;

import java.sql.Date;

public class CarDB{
	
	private int anFabricare;
	private String dotari;
	private double pret;
	private String combustibil;
	private String marca;
	private int id;
	private String createdAt;
	private String updatedAt;
	
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public CarDB(int anFabricare, String dotari, double pret, String combustibil, String marca, int id,
			String createdAt, String updatedAt) {
		super();
		this.anFabricare = anFabricare;
		this.dotari = dotari;
		this.pret = pret;
		this.combustibil = combustibil;
		this.marca = marca;
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public CarDB() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarDB(int id)
	{
		this.id=id;
	}
	public CarDB(int id,String dotari,String createdAt, String updatedAt){
		super();
		this.id=id;
		this.dotari=dotari;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
	}
	
	public CarDB(int id,double pret,String createdAt, String updatedAt){
		super();
		this.id=id;
		this.pret=pret;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
	}
	
	public CarDB(int id,String dotari,double pret,String createdAt, String updatedAt)
{
	super();
	this.id=id;
	this.dotari=dotari;
	this.pret=pret;
	this.createdAt=createdAt;
	this.updatedAt=updatedAt;
}
	
	public String insertCar(int anFabricare,String dotari,double pret,String combustibil, String marca,int id,String createdAt,String updatedAt)
	{
		return anFabricare+dotari+pret+combustibil+marca+id+createdAt+updatedAt;
	};
	
	String deleteCar(int anFabricare,String dotari,double pret,String combustibil, String marca,int id,String createdAt,String updatedAt)
	{
		return anFabricare+dotari+pret+combustibil+marca+id+createdAt+updatedAt;
	};
	
	String updateCar(int anFabricare,String dotari,double pret,String combustibil, String marca,int id,String createdAt,String updatedAt)
	{
		return anFabricare+dotari+pret+combustibil+marca+id+createdAt+updatedAt;
	}

	@Override
	public String toString() {
		return "CarDB [anFabricare=" + anFabricare + ", dotari=" + dotari + ", pret=" + pret + ", combustibil="
				+ combustibil + ", marca=" + marca + ", id=" + id + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	};
	
}
