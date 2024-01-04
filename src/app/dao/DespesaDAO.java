package app.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import app.model.Despesa;
import app.model.Pessoa;
import app.dao.ConnectionMVC;

public class DespesaDAO {
	public void cadastrarDespesa(Despesa despesa) throws ExceptionDAO {
		java.sql.Date sqlDate = new java.sql.Date(despesa.getData().getTime());
        String sql = "insert into personal.despesa(descricao, categoria, valor, data) values (?,?,?,?)";
		PreparedStatement pStatement = null;
		Connection connection = null;
		ConnectionMVC connectionMVC = new ConnectionMVC();

		try {
			connection = connectionMVC.getConnection();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1,despesa.getDescricao());
			pStatement.setString(2,despesa.getCategoria());
			pStatement.setFloat(3,despesa.getValor());
			
			pStatement.setDate(4, sqlDate);
			pStatement.execute();
		}catch(SQLException e) {
			throw new ExceptionDAO("Erro ao cadastras despesa " + e);
		} finally {
			
			try {
				if(pStatement!=null) { pStatement.close(); }
			}catch(SQLException e) {
				throw new ExceptionDAO("Erro ao fechar Statement: " + e);
			}try {
				if(connection!=null) {connection.close();}
			
			}catch(SQLException e) {
				throw new ExceptionDAO("Erro ao fechar a conexao: " + e);			
			}
		}
	}
}
