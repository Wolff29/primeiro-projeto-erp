/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.primeiroProjeto.modelo.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexaoMySql{
    
    private final String USUARIO = "root";
    private final String SENHA = "admin123!";
    private final String URL = "jdbc:mysql://localhost:3306/gestao_venda01";

    public Connection obterConexao() throws SQLException {
        Connection conn = null; 
        try {
            conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
        return conn;
    }
}
