package a.b;

import java.lang.reflect.InvocationTargetException;

public class ConvertitoreFactory {

	public static Convertitore createConvertitore(String format) {

		/*
		 * if (format.toUpperCase().equals("HTML")) { return new ConvertitoreHTML(); }
		 * if (format.toUpperCase().equals("CSV")) { return new ConvertitoreCSV(); }
		 * 
		 * return null; }
		 */

		try {
			try {
				//String pkg = Convertitore.class.getPackage().getName(); EQUIVALENTE A QUELLO SOTTO !!!
				String pkg = Convertitore.class.getPackageName();
				return (Convertitore) 
						Class.forName(pkg+".Convertitore" + format.toUpperCase())
						.getDeclaredConstructor().newInstance();
				
			} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException
					| SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
