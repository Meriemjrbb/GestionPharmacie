package DAO;
import java.sql.Connection;
import Métiers.Client;
import Métiers.Ordonnance;


public class test {

	public static void main(String[] args) {
		Connection conn=SingletonConnection.getInstance();		
		MedicamentDAO med=new MedicamentDAO();
		System.out.println(med.delete(200));
		//ClientDAO clidao=new ClientDAO();
		//Client c=new Client(177,"wajih",122.0);
		//System.out.println(clidao.getid(144));
		//System.out.println(clidao.add(c));
		//ord.addOrdonnance(new Ordonnance (11,12,c));
		
		
		
}}
