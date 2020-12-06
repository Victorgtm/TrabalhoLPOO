/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Conexao.ConnectionFactory;
import Modelo.bean.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class ProdutoDAO {
    
    // Metodo Salvar
    public void create(Produto p){
        // Abringo ceonexao
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        // Passando valores para os paramentros
        try {
            stmt = con.prepareStatement("INSERT INT produto (descricao, qtd, preco)VALUES(?, ? ?)");
            stmt.setString(1, p.getDescricao());
            stmt.setInt(2, p.getQtd());
            stmt.setDouble(3, p.getPreco());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    
    }

 
    
}
