package app.controller;
import app.dao.ExceptionDAO;
import app.model.Despesa;
import java.util.Date; // Import the Date class

public class DespesaController {
    
    public boolean cadastrarDespesa(String descricao, String categoria, float valor, Date data) throws ExceptionDAO {
        
        if (descricao != null && categoria != null && valor > 0 && data != null 
                && !descricao.isEmpty() && !categoria.isEmpty()) {
            
            Despesa despesa = new Despesa(descricao, categoria, valor, data);
            despesa.cadastrarDespesa(despesa);
            return true;
        }
        return false;
    }
}

