package model;

import java.sql.Date;

/**
 * A classe <b>ClienteModel</b> é responsável pelos atributos e formatações do
 * objeto <b>Cliente.</b>
 *
 * @author Ítalo Bianchini
 * @since Maio, 2016
 * @version 1.0
 */
public class ClienteModel {

    private Integer codigoCliente;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String telefone;
    private String email;
    private Date dataDeCadastro;

    public ClienteModel() {

    }
    
    /**
     *Construtor sobrecarregado com atributos obrigatórios para a classe <b>ClienteModel</b>
     * 
     * @param codigoCliente
     * @param nome
     * @param endereco
     * @param bairro
     * @param cidade
     * @param uf
     * @param cep
     * @param dataDeCadastro
     * @since Maio, 2016
     */
    public ClienteModel(Integer codigoCliente, String nome, String endereco, String bairro, String cidade, String uf, String cep, Date dataDeCadastro) {
        this.codigoCliente = codigoCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.telefone = null;
        this.email = null;
        this.dataDeCadastro = dataDeCadastro;
    }

    
     /**
     *Construtor sobrecarregado com todos os atributos para a classe <b>ClienteModel</b>
     * 
     * @param codigoCliente
     * @param nome
     * @param endereco
     * @param bairro
     * @param cidade
     * @param uf
     * @param cep
     * @param telefone
     * @param email
     * @param dataDeCadastro
     * @since Maio, 2016
     */
    public ClienteModel(Integer codigoCliente, String nome, String endereco, String bairro, String cidade, String uf, String cep, String telefone, String email, Date dataDeCadastro) {
        this.codigoCliente = codigoCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.dataDeCadastro = dataDeCadastro;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    @Override
    public String toString() {
        return "ClienteModel{" + "codigoCliente=" + codigoCliente + ", nome=" + nome + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + ", telefone=" + telefone + ", email=" + email + ", dataDeCadastro=" + dataDeCadastro + '}';
    }

    
    
    
}
