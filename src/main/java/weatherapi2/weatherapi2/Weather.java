package weatherapi2.weatherapi2;

public class Weather {
	
	Long id;
	
	String main;
	
	String description;
	
	String icon;
	
	public Weather() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Weather [main=" + main + ", description=" + description + ", icon=" + icon + "]";
	}

	
	
	

}
