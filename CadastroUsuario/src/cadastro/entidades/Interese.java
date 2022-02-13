package cadastro.entidades;

public class Interese {

	private Integer id;
	private String area;

	public Interese(Integer id, String area) {
		super();
		this.id = id;
		this.area = area;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
