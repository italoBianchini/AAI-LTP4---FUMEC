package dao;

import Exception.ClienteExcption;
import Exception.PersistenciaException;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.ClienteModel;

/**
 * A classe <b>ClienteDAO</b> implementa os metodos de acesso ao banco
 * relacionados ao objeto <b>ClienteModel</b>. Pacote dao.
 *
 * @author Ítalo Bianchini
 * @since Maio, 2016
 * @version 1.0
 */
public class ClienteDAO implements GenericDAO<ClienteModel> {

    private final String SQL_BASE = "SELECT codCliente, nome, endereco, bairro, cidade, uf, cep, telefone, e_mail, data_cad_cliente from Clientes ";

    @Override
    public boolean inserir(ClienteModel clienteModel) throws PersistenciaException {

        boolean inseriuCorretamente = false;

        Connection connection;

        try {
            connection = Conexao.getInstance().getConnection();

            String sql = "INSERT INTO Clientes (codCliente, Nome, Endereco, Bairro, Cidade, Uf, Cep, Telefone, E_mail, data_Cad_Cliente)" + "VALUES(?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, clienteModel.getCodigoCliente());
            statement.setString(2, clienteModel.getNome());
            statement.setString(3, clienteModel.getEndereco());
            statement.setString(4, clienteModel.getBairro());
            statement.setString(5, clienteModel.getCidade());
            statement.setString(6, clienteModel.getUf());
            statement.setString(7, clienteModel.getCep());
            statement.setString(8, clienteModel.getTelefone());
            statement.setString(9, clienteModel.getEmail());
            statement.setDate(10, clienteModel.getDataDeCadastro());

            statement.execute();
            connection.close();

            inseriuCorretamente = true;

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return inseriuCorretamente;
    }

    @Override
    public ClienteModel recuperarPorId(int idCliente) throws PersistenciaException {
        Connection connection;
        ClienteModel clienteModel = ClienteModel.CriarClienteVazio();

        try {
            connection = Conexao.getInstance().getConnection();

            String sql = SQL_BASE + "WHERE codCliente = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, idCliente);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                clienteModel.setCodigoCliente(idCliente);
                clienteModel.setNome(resultSet.getString("Nome"));
                clienteModel.setEndereco(resultSet.getString("Endereco"));
                clienteModel.setBairro(resultSet.getString("Bairro"));
                clienteModel.setCidade(resultSet.getString("Cidade"));
                clienteModel.setUf(resultSet.getString("Uf"));
                clienteModel.setCep(resultSet.getString("Cep"));
                clienteModel.setTelefone(resultSet.getString("Telefone"));
                clienteModel.setEmail(resultSet.getString("E_mail"));
                clienteModel.setDataDeCadastro(resultSet.getDate("data_cad_cliente"));
            } else {
                clienteModel = null;
            }
            connection.close();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return clienteModel;
    }

    @Override
    public boolean delete(int codigoCliente) throws PersistenciaException {
        Connection connection;
        boolean excluiuCorretamente = false;

        try {

            connection = conexao.Conexao.getInstance().getConnection();

            String sql = "DELETE FROM Clientes WHERE codCliente = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, codigoCliente);

            statement.executeUpdate();

            excluiuCorretamente = true;

            connection.close();

        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return excluiuCorretamente;
    }

    @Override
    public boolean alterar(ClienteModel clienteModel) throws PersistenciaException {
        Connection connection;
        boolean alterouCorretamente = false;

        try {
            connection = conexao.Conexao.getInstance().getConnection();

            String sql = "UPDATE Clientes SET Nome = ? , Endereco = ?, Bairro = ?, Cidade = ?, Uf = ?, Cep = ?, Telefone = ?, e_mail = ?, data_cad_cliente = ?"
                    + " WHERE codCliente = ? ";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, clienteModel.getNome());
            statement.setString(2, clienteModel.getEndereco());
            statement.setString(3, clienteModel.getBairro());
            statement.setString(4, clienteModel.getCidade());
            statement.setString(5, clienteModel.getUf());
            statement.setString(6, clienteModel.getCep());
            statement.setString(7, clienteModel.getTelefone());
            statement.setString(8, clienteModel.getEmail());
            statement.setDate(9, clienteModel.getDataDeCadastro());
            statement.setInt(10, clienteModel.getCodigoCliente());

            statement.executeUpdate();
            alterouCorretamente = true;

            connection.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            throw new PersistenciaException(e.getMessage());

        }
        return alterouCorretamente;
    }

    @Override
    public ArrayList recuperarPorNome(String nomeInformado) throws PersistenciaException {
        Connection connection;
        ArrayList<ClienteModel> listaClientes = new ArrayList<>();
        ClienteModel clienteModel = ClienteModel.CriarClienteVazio();

        try {
            connection = conexao.Conexao.getInstance().getConnection();

            String sql = SQL_BASE + "WHERE nome LIKE ? ORDER BY nome";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, "%" + nomeInformado + "%");
            statement.executeQuery();
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                while (resultSet.next()) {

                    clienteModel.setCodigoCliente(resultSet.getInt("codCliente"));
                    clienteModel.setNome(resultSet.getString("Nome"));
                    clienteModel.setEndereco(resultSet.getString("Endereco"));
                    clienteModel.setBairro(resultSet.getString("Bairro"));
                    clienteModel.setCidade(resultSet.getString("Cidade"));
                    clienteModel.setUf(resultSet.getString("Uf"));
                    clienteModel.setCep(resultSet.getString("Cep"));
                    clienteModel.setTelefone(resultSet.getString("Telefone"));
                    clienteModel.setEmail(resultSet.getString("E_mail"));
                    clienteModel.setDataDeCadastro(resultSet.getDate("data_cad_cliente"));

                    listaClientes.add(clienteModel);
                }

            } else {
                listaClientes = null;
                throw new ClienteExcption("Nenhum Cliente encontrado");
            }

            connection.close();
            
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return listaClientes;
    }

    @Override
    public ArrayList recuperarTodosRegistros() throws PersistenciaException {
        Connection connection;
        ArrayList<ClienteModel> listaClientes = new ArrayList<>();

        try {
            connection = conexao.Conexao.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_BASE);
            statement.executeQuery();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                ClienteModel cliente = ClienteModel.CriarClienteVazio();
                
                cliente.setCodigoCliente(resultSet.getInt("codCliente"));
                cliente.setNome(resultSet.getString("Nome"));
                cliente.setEndereco(resultSet.getString("Endereco"));
                cliente.setBairro(resultSet.getString("Bairro"));
                cliente.setCidade(resultSet.getString("Cidade"));
                cliente.setUf(resultSet.getString("Uf"));
                cliente.setCep(resultSet.getString("Cep"));
                cliente.setTelefone(resultSet.getString("Telefone"));
                cliente.setEmail(resultSet.getString("E_mail"));
                cliente.setDataDeCadastro(resultSet.getDate("data_cad_cliente"));

                listaClientes.add(cliente);
            }
            connection.close();
            
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e);
        }
        return listaClientes;
    }

}
