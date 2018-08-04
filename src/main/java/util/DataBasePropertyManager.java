package util;

import java.util.ResourceBundle;

public class DataBasePropertyManager {
	private static final ResourceBundle rb;

	static {
		rb = ResourceBundle.getBundle("db_config");
	}

	public static String getProperty(String propertyName) {
		return rb.getString(propertyName);
	}

	public static String getDBURL() {
		return rb.getString("db.url");
	}

	public static String getPass() {
		return rb.getString("db.password");
	}

	public static String getLogin() {
		return rb.getString("db.login");
	}
}
