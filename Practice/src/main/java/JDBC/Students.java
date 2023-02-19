package JDBC;

public class Students {

	private int id;
	private String name;
	private double average;
	private String email;
	
	 public Students() {
		
	}
	 public Students(int id ,String name ,Double avg,String email) {
			this.id=id;
			this.name= name;
			this.average= avg;
			this.email= email;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("students [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", average=");
		builder.append(average);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}

}
