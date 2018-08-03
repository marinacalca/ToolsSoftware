package Entity;

public class Sale {
	
	private Integer id;
	private Integer idItem;
	private Integer qtdeItem;
	private Double priceItem;
	private String nameSalesman;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdItem() {
		return idItem;
	}
	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}
	public Integer getQtdeItem() {
		return qtdeItem;
	}
	public void setQtdeItem(Integer qtdeItem) {
		this.qtdeItem = qtdeItem;
	}
	public Double getPriceItem() {
		return priceItem;
	}
	public void setPriceItem(Double priceItem) {
		this.priceItem = priceItem;
	}
	public String getNameSalesman() {
		return nameSalesman;
	}
	public void setNameSalesman(String nameSalesman) {
		this.nameSalesman = nameSalesman;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idItem == null) ? 0 : idItem.hashCode());
		result = prime * result + ((nameSalesman == null) ? 0 : nameSalesman.hashCode());
		result = prime * result + ((priceItem == null) ? 0 : priceItem.hashCode());
		result = prime * result + ((qtdeItem == null) ? 0 : qtdeItem.hashCode());
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
		Sale other = (Sale) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idItem == null) {
			if (other.idItem != null)
				return false;
		} else if (!idItem.equals(other.idItem))
			return false;
		if (nameSalesman == null) {
			if (other.nameSalesman != null)
				return false;
		} else if (!nameSalesman.equals(other.nameSalesman))
			return false;
		if (priceItem == null) {
			if (other.priceItem != null)
				return false;
		} else if (!priceItem.equals(other.priceItem))
			return false;
		if (qtdeItem == null) {
			if (other.qtdeItem != null)
				return false;
		} else if (!qtdeItem.equals(other.qtdeItem))
			return false;
		return true;
	}
	
	

}
