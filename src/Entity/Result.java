package Entity;
import java.util.Map;

public class Result {
	
	private Integer contClient; //variável para contar a quantidade de clientes
	private Integer contSalesman; //variavel para contar a quantidade de vendedores
	private String nameSalesman; //variável para guardar o nome do vendedor
	private Integer iDSaleValueMax; //variável para guardar o ID da venda mais alta 
	private Double saleValueMax; //Variável para guardar o valor da venda mais alta
	private Double saleValueMin; //Variável para guardar o menor valor de venda
	private Map<String, Double> salesmanSaleValue; //variável para guardar o nome do vendedor e a soma das suas vendas
	public Integer getContClient() {
		return contClient;
	}
	public void setContClient(Integer contClient) {
		this.contClient = contClient;
	}
	public Integer getContSalesman() {
		return contSalesman;
	}
	public void setContSalesman(Integer contSalesman) {
		this.contSalesman = contSalesman;
	}
	public String getNameSalesman() {
		return nameSalesman;
	}
	public void setNameSalesman(String nameSalesman) {
		this.nameSalesman = nameSalesman;
	}
	public Integer getiDSaleValueMax() {
		return iDSaleValueMax;
	}
	public void setiDSaleValueMax(Integer iDSaleValueMax) {
		this.iDSaleValueMax = iDSaleValueMax;
	}
	public Double getSaleValueMax() {
		return saleValueMax;
	}
	public void setSaleValueMax(Double saleValueMax) {
		this.saleValueMax = saleValueMax;
	}
	public Double getSaleValueMin() {
		return saleValueMin;
	}
	public void setSaleValueMin(Double saleValueMin) {
		this.saleValueMin = saleValueMin;
	}
	public Map<String, Double> getSalesmanSaleValue() {
		return salesmanSaleValue;
	}
	public void setSalesmanSaleValue(Map<String, Double> salesmanSaleValue) {
		this.salesmanSaleValue = salesmanSaleValue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contClient == null) ? 0 : contClient.hashCode());
		result = prime * result + ((contSalesman == null) ? 0 : contSalesman.hashCode());
		result = prime * result + ((iDSaleValueMax == null) ? 0 : iDSaleValueMax.hashCode());
		result = prime * result + ((nameSalesman == null) ? 0 : nameSalesman.hashCode());
		result = prime * result + ((saleValueMax == null) ? 0 : saleValueMax.hashCode());
		result = prime * result + ((saleValueMin == null) ? 0 : saleValueMin.hashCode());
		result = prime * result + ((salesmanSaleValue == null) ? 0 : salesmanSaleValue.hashCode());
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
		Result other = (Result) obj;
		if (contClient == null) {
			if (other.contClient != null)
				return false;
		} else if (!contClient.equals(other.contClient))
			return false;
		if (contSalesman == null) {
			if (other.contSalesman != null)
				return false;
		} else if (!contSalesman.equals(other.contSalesman))
			return false;
		if (iDSaleValueMax == null) {
			if (other.iDSaleValueMax != null)
				return false;
		} else if (!iDSaleValueMax.equals(other.iDSaleValueMax))
			return false;
		if (nameSalesman == null) {
			if (other.nameSalesman != null)
				return false;
		} else if (!nameSalesman.equals(other.nameSalesman))
			return false;
		if (saleValueMax == null) {
			if (other.saleValueMax != null)
				return false;
		} else if (!saleValueMax.equals(other.saleValueMax))
			return false;
		if (saleValueMin == null) {
			if (other.saleValueMin != null)
				return false;
		} else if (!saleValueMin.equals(other.saleValueMin))
			return false;
		if (salesmanSaleValue == null) {
			if (other.salesmanSaleValue != null)
				return false;
		} else if (!salesmanSaleValue.equals(other.salesmanSaleValue))
			return false;
		return true;
	}

	
	
}
