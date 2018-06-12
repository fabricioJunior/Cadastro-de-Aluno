/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro.de.aluno;

import java.time.LocalDate;

/**
 * @author Fabricio Junior
 */
public class Aluno extends Pessoa {

    private String curso;
    private String matricula;
    private float nota1;
    private float nota2;
    private float nota3;
    
    
    /**
     *Método para calcular a média do aluno
     * @return média das três notas: nota1, nota2, nota3
     */
    public float getMedia() {
        return (getNota1() + getNota2() + getNota3()) / 3;
    }

    /**
     *Método para a situação final do aluno
     * @return "Aprovado por média", "Reprovado" ou "De AF"
     */
    public String getSituação() {
        if (getMedia() >= 7) {
            return "Aprovado por média";
        } else if (getMedia() <= 6.9 && getMedia() >= 4) {
            return "De AF";
        }
        return "Reprovado";
    }

   
    /**
     *
     */
    public Aluno (){
      
    }
    
    
    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    
    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    
    /**
     * @return the nota1
     */
    public float getNota1() {
        return nota1;
    }

    /**
     * @param nota1 the nota1 to set
     */
    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    
    /**
     * @return the nota2
     */
    public float getNota2() {
        return nota2;
    }

    /**
     * @param nota2 the nota2 to set
     */
    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    
    /**
     * @return the nota3
     */
    public float getNota3() {
        return nota3;
    }

    /**
     * @param nota3 the nota3 to set
     */
    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }


    /**
     *Método equals sobrescrito
     * verifica se dois objetos do tipo Aluno são iguais a partir da matrícula
     * @param x
     * @return 
     */
    @Override
    public boolean equals(Object x) {

        if (x instanceof Aluno) {
            Aluno a = (Aluno) x;
            if (this.getMatricula() == null ? a.getMatricula() == null : this.getMatricula().equals(a.getMatricula())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método toString sobrescrito
     * @return exibição dos dados fornecidos pelo usúario
     */
    @Override
    public String toString() {
        String formatado
                = "Nome: " + nomeCompleto() + "\n"
                + "E-mail: " + getEmail() + "\n"
                + "Idade: " + idade() + "\n"
                + "Data De Nascimento: " + getDataDeNascimento() + "\n"
                + "Curso: " + getCurso() + "\n"
                + "Matrícula: " + getMatricula() + "\n"
                + "Notas: " + getNota1() + ", " + getNota2() + ", " + getNota3() + "\n"
                + "Média: " + getMedia() + "\n"
                + "Situação: " + getSituação();
        return formatado;
    }
}
