/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro.de.aluno;

import java.util.Calendar;

/**
 *
 * @author Fabricio Junior
 */
abstract public class Pessoa {
    
    protected String nome;
    protected String sobrenome;
    protected String email;
    protected Data data;

    /**
     *
     */
    protected String nomeCompleto() {
        return nome + " " + sobrenome;
    }

    protected int idade() {
        int idade;
        Calendar c = Calendar.getInstance();
        if (c.get(Calendar.MONTH) + 1 < data.mês) {
            idade = c.get(Calendar.YEAR) - 1 - data.ano;
        } else if (c.get(Calendar.MONTH) + 1 == data.mês) {
            if (Calendar.DAY_OF_MONTH < data.dia) {
                idade = c.get(Calendar.YEAR) - 1 - data.ano;
            } else {
                idade = c.get(Calendar.YEAR) - data.ano;
            }
        } else {
            idade = c.get(Calendar.YEAR) - data.ano;
        }
        return idade;
    }

    /**
     *
     * @return
     */
    protected String getDataDeNascimento() {
        return data.toString();
    }

    public class Data {

        public int dia;
        public int mês;
        public int ano;

        @Override
        public String toString() {
            return dia + "/" + mês + "/" + ano;
        }
    }

}
