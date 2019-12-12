package a.b;

public class Main {

	public static void main(String[] args) throws Exception {
		
		QueryExecutor testDbConnection = new QueryExecutor();	
		String query = "select * from province";
		String format = "HtMl";
		System.out.println(testDbConnection.eseguiQuery(query,
														ConvertitoreFactory.createConvertitore(format)));
	}

}
