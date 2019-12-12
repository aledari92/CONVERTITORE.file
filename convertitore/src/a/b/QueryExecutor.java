package a.b;

import java.sql.Connection; //interface
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class QueryExecutor {
	
	public String eseguiQuery(String query,Convertitore convertitore) throws Exception {
		Scanner input = new Scanner(System.in);
		Connection connection = null;
		Statement statement = null;
		ResultSet results = null;

		try {
			connection = ConnectionFactory.getConnection();
			// caricare driver in memoria (Opzionale dopo la versione del driver 4.0)
			
			statement = connection.createStatement(
					ResultSet.TYPE_SCROLL_SENSITIVE,// si può scorrere il RS avanti e
					ResultSet.CONCUR_READ_ONLY// indietro
					); // read only RS, don't change
			// eseguire una query
			
			results = statement.executeQuery(query);
			return convertitore.converti(results);

		}

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new Exception("Errore durante l'accesso al DB!");

		} finally { // ENTRO QUI SIA CHE SIA STATA TROVATA UN'ECC, SIA CHE SIA ANDATO TUTTO BENE
			// shutdown risorse
			try { 
				results.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
