package idv.shaowei.BootH2.entity;

public class Billionaire {
	private int id;
	private String firstName;
	private String lastName;
	private String career;
	private int value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}
	

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Billionaire [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", career=" + career + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Billionaire) {
			Billionaire another = (Billionaire) obj;
            if (this.id == another.getId()) {
                    return true;
            }
        }
        return false;
	}
}
