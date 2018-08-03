
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Entity.Client;
import Entity.Employee;
import Entity.Result;
import Entity.Sale;

/*
 * 
1. Dados de Vendedores: (001;CPF;nome;salário)
2. Dados de Clientes: (002;CNPJ;nome;ramo de atividade)
3. Dados de Vendas: (003;ID da venda;ID do item;qtde do item;preço do item;Nome do Vendedor)
 * 
 * Exemplo:
001;1234567891234;Diego;5000.00
002;2345675434544345;Jose da Silva;Rural
002;2345675433444345;Eduardo Gonsalvez Pereira;Rural
001;3245678865434;Renato;4000.00
003;10;11010;300;3403.30;Diego
003;08;13410;540;2400.10;Renato
*
*
* Resultado:
*1. Quantidade de Clientes:
2. Quantidade de Vendedores:
3. ID da Venda de valor mais alto:
4. Nome do Vendedor que menos vendeu:
*/



public class SoftwareTools {
	
	/*
	 * Variáveis para mudar o caminho
	 */
	final String DIR_IN = "/dados/in/";
	final String DIR_OUT = "/dados/out/";
	
	//Client client;
	//Employee employee;
	Sale sale;
	Result result;
	List<String> filePathName;
	
	public void runner() {
		
		try {
			filePathName = new ArrayList<String>();
			filePathName = recoveryFileName();
			
			for (String fileName : filePathName) {
				
				Scanner scannerFile = new Scanner(System.in);
						   
			    try {
			      FileReader fileRead = new FileReader(DIR_IN + "/" + fileName);
			      BufferedReader readFiler = new BufferedReader(fileRead);
			      
			      inicialization();
			 
			      String line = readFiler.readLine(); 
			      
			     
			      while (line != null) {
			    	  if(line != null) {
				        	List<String> lines =  Arrays.asList(line.split(";"));
					        
					        if(lines.get(0).equals("001")) {
					        	//if(lines.size() == 4) {
					        		/*this.employee = new Employee();
						        	this.employee.setCPF(lines.get(1));
						        	this.employee.setName(lines.get(2));
						        	this.employee.setSalary(Double.parseDouble(lines.get(3)));*/
									countSalesman();
					        	//}
							}else if(lines.get(0).equals("002")) {
								//if(lines.size() == 4) {
									/*this.client = new Client();
						        	this.client.setCNPJ(lines.get(1));
						        	this.client.setName(lines.get(2));
						        	this.client.setWorkArea(lines.get(3));*/
									countClient();
								//}
							}else {
								if(lines.size() == 6) {
									this.sale = new Sale();
									this.sale.setId(Integer.parseInt(lines.get(1)));
									this.sale.setIdItem(Integer.parseInt(lines.get(2)));
									this.sale.setQtdeItem(Integer.parseInt(lines.get(3)));
									this.sale.setPriceItem(Double.parseDouble(lines.get(4)));
									this.sale.setNameSalesman(lines.get(5));
									
									countSaleValue(this.sale.getNameSalesman(), this.sale.getPriceItem());
									checkMaximumSaleValue(this.sale.getId(), this.sale.getPriceItem());
								}
							}
					        
					        line = readFiler.readLine();
			        }
			        
			      }     
			      fileRead.close();
			 
			      FileWriter fileWriter = new FileWriter(DIR_OUT + "/" + fileName+".proc");
			      PrintWriter printFiler = new PrintWriter(fileWriter);
			   
			      printFiler.println("Quantidade de funcionários: "+ result.getContSalesman());
			      printFiler.println("Quantidade de clientes: "+ result.getContClient());
			      printFiler.println("ID da Venda de valor mais alto: "+ result.getiDSaleValueMax());
			      printFiler.println("Nome do Vendedor que menos vendeu: " + result.getNameSalesman());
			      fileWriter.close();
			    } catch (IOException e) {
			        System.err.printf("Erro na abertura do arquivo: %s.\n",
			          e.getMessage());
			    }	
				
			}
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	public void inicialization() {
		
		result = new Result();
		result.setContClient(0);
		result.setContSalesman(0);
		result.setiDSaleValueMax(null);
		result.setNameSalesman(null);
		result.setSalesmanSaleValue(null);
		result.setSaleValueMax(null);
		result.setSaleValueMin(null);
		result.setSalesmanSaleValue(new HashMap<String, Double>());
		
	}
	
	//Método para contar a quantidade de clientes
	public void countClient() {
		result.setContClient(result.getContClient()+1);;
	}
	
	//Método para contar a quantidade de vendedor
	public void countSalesman() {
		result.setContSalesman(result.getContSalesman()+1);
	}
	
	//Método para guardar o nome do vendedor e somar a quantidade que ele vendeu 
	public void countSaleValue(String nameSalesmanAux, Double saleValueAux) {
		Double aux = 0.0;
		if(result.getSalesmanSaleValue().containsKey(nameSalesmanAux)){
			aux = result.getSalesmanSaleValue().get(nameSalesmanAux) + saleValueAux;
			result.getSalesmanSaleValue().put(nameSalesmanAux, aux);
			this.checkMinimumSaleValue(nameSalesmanAux, aux);
		}else {
			result.getSalesmanSaleValue().put(nameSalesmanAux, saleValueAux);
			this.checkMinimumSaleValue(nameSalesmanAux, saleValueAux);
		}
	}
	
	//Método para verificar quem vendeu menos e setar a variável do nome do vendedor
	public void checkMinimumSaleValue(String nameSalesmanAux, Double saleValueAux) {
		if(result.getSaleValueMin() == null) {
			result.setNameSalesman(nameSalesmanAux);
			result.setSaleValueMin(saleValueAux);
		}else {
			if(result.getSaleValueMin() > saleValueAux) {
				result.setNameSalesman(nameSalesmanAux);
				result.setSaleValueMin(saleValueAux);
			}
		}
	}
	
	public void checkMaximumSaleValue(Integer iDSaleValueMaxAux, Double saleValueMaxAux) {
		if(result.getSaleValueMax() == null) {
			result.setiDSaleValueMax(iDSaleValueMaxAux);
			result.setSaleValueMax(saleValueMaxAux);
		} else {
			if(result.getSaleValueMax() < saleValueMaxAux) {
				result.setiDSaleValueMax(iDSaleValueMaxAux);
				result.setSaleValueMax(saleValueMaxAux);
			}
		} 
	}
	
	//método para ver o nome de todos os arquivos que estão no diretório in
	public List<String> recoveryFileName() throws IOException {
		
		List<String> pathFile = new ArrayList<String>();
		File file = new File(DIR_IN);
		File afile[] = file.listFiles();
		
		for (File fileAux : afile) {
			File arquivos = fileAux;
			pathFile.add(arquivos.getName());
		} 
		return pathFile;
	}
	
}
