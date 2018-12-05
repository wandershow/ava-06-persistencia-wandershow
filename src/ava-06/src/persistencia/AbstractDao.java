package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDao<T> {

	private String url = "jdbc:postgresql://localhost/siamelhorado";
	private String user = "postgres";
	private String password = "postgres";
	protected Connection conexao;
	protected PreparedStatement comando;
	
	public void openConnection() throws SQLException {
	 conexao = DriverManager.getConnection(url, user, password);
		 
	}
	
	public void preparado(String sql) throws SQLException {
		PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		this.comando = comando;
	}
	

	abstract void insert(T o);

	abstract void update(T o); 
	

	abstract void delete(int o); 

	

	abstract T select(Integer id);

	abstract List<T> select();

}
