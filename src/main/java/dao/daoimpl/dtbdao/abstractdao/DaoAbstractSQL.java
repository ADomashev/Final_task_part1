package dao.daoimpl.dtbdao.abstractdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static util.DataBasePropertyManager.*;

public abstract class DaoAbstractSQL {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet result;

	public Connection openConnection() {
		try {
			connection = DriverManager.getConnection(getDBURL(), getLogin(), getPass());
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return connection;
	}

	public PreparedStatement getPreparedStatement(String sqlRequest) {
		try {
			preparedStatement = connection.prepareStatement(sqlRequest);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}

	public void setString(int index, String param) {
		try {
			preparedStatement.setString(index, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setInt(int index, int param) {
		try {
			preparedStatement.setInt(index, param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setDate(int index, Date date) {
		try {
			preparedStatement.setDate(index, date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setNull(int index, int sqlType) {
		try {
			preparedStatement.setNull(index, sqlType);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void executeQuery() {
		try {
			result = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void execute() {
		try {
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet getResultSet() {

		return result;
	}

	public boolean resNext() {
		boolean resultTmp = false;
		try {
			resultTmp = result.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultTmp;
	}

	public int getInt(String paramName) {
		int intTmp = 0;
		try {
			intTmp = result.getInt(paramName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return intTmp;
	}

	public String getString(String paramName) {
		String strTmp = null;
		try {
			strTmp = result.getString(paramName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return strTmp;
	}

	public Date getDate(String paramName) {
		Date date = null;
		try {
			date = result.getDate(paramName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return date;
	}

	public void closePreparedStatement(PreparedStatement preparedStatement) {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeAll() {
		try {
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
