package a.b;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ConvertitoreHTML extends Convertitore {

	@Override
	public String converti(ResultSet results) throws SQLException {
	
			StringBuilder sb = new StringBuilder();
			ResultSetMetaData metadata = results.getMetaData();

			int nCol = metadata.getColumnCount();

			sb.append("<TABLE>");
			sb.append("<TR>");

			for (int i = 1; i <= nCol; i++) {

				sb.append("<TH>");
				sb.append(metadata.getColumnLabel(i));
				sb.append("</TH>");
			}
			sb.append("</TR>\n");

			sb.setLength(sb.length());

			while (results.next()) {
				sb.append("<TR>");
				nCol = metadata.getColumnCount();
				for (int i = 1; i <= nCol; i++) {
					sb.append("<TD>");
					sb.append(results.getString(i));
					sb.append("</TD>");

				}
				sb.setLength(sb.length());
				sb.append("</TR>\n");

			}
			sb.append("<TABLE>");
			return sb.toString();
		}

		

}
