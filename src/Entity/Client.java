package Entity;

public class Client {
	private String CNPJ;
	private String name;
	private String workArea;
	
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWorkArea() {
		return workArea;
	}
	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CNPJ == null) ? 0 : CNPJ.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((workArea == null) ? 0 : workArea.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (CNPJ == null) {
			if (other.CNPJ != null)
				return false;
		} else if (!CNPJ.equals(other.CNPJ))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (workArea == null) {
			if (other.workArea != null)
				return false;
		} else if (!workArea.equals(other.workArea))
			return false;
		return true;
	}
	
	
}
