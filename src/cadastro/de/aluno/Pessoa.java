/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro.de.aluno;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Fabricio Junior
 */
abstract public class Pessoa {

   
    
    /**
     *
     */
    private String nome;

    /**
     *
     */
    private String sobrenome;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private LocalDate data;
    
    private int dia;
    private int mês;
    private int ano;
   
    /**
     *
     * @return @return
     */
    protected String nomeCompleto() {
        return getNome() + " " + getSobrenome();
    }
   
    /**
     * Codigo baseado na logica na resposta de utluiz 
     * https://pt.stackoverflow.com/questions/69270/calcular-idade-por-dia-mes-e-ano
     * @return idade da pessoa a parti das informações da váriavel
     * @see data
     */
    protected int idade() {
        LocalDate dataDeAniversário = LocalDate.of(ano, mês, dia);
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataDeAniversário, dataAtual);
        return periodo.getYears();
    }

    /**
     *
     * @return
     */
    protected String getDataDeNascimento() {
        return dia + "/" + mês + "/" + ano;
    }
   
    protected void setDia(int dia) {
       this.dia = dia;
    }

    protected void setMês(int mês) {
       this.mês = mês;
    } 


    protected void setAno(int ano) {
       this.ano = ano;
    }

    /**
     * @return the dia
     */
    protected int getDia() {
        return dia;
    }

    /**
     * @return the mês
     */
    protected int getMês() {
        return mês;
    }

    /**
     * @return the ano
     */
    protected int getAno() {
        return ano;
    }
     /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;

    }

}
