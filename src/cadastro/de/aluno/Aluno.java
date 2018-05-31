/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro.de.aluno;

/**
 *
 * @author Fabricio Junior
 */
public class Aluno extends Pessoa {

    public String curso;
    public String matricula;
    public float nota1;
    public float nota2;
    public float nota3;
   
    public Aluno (){
      data = new Data();
    }
    public float getMedia() {
        return (nota1 + nota2 + nota3) / 3;
    }

    public String getSituação() {
        if (getMedia() >= 7) {
            return "Aprovado por média";
        } else if (getMedia() <= 6.9 && getMedia() <= 4) {
            return "De AF";
        }
        return "Reprovado";
    }

    @Override
    public boolean equals(Object x) {

        if (x instanceof Aluno) {
            Aluno a = (Aluno) x;
            if (this.matricula == null ? a.matricula == null : this.matricula.equals(a.matricula)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        String formatado
                = "Nome: " + nomeCompleto() + "\n"
                + "E-mail: " + email + "\n"
                + "Idade: " + idade() + "\n"
                + "Data De Nascimento:" + getDataDeNascimento() + "\n"
                + "Curso: " + curso + "\n"
                + "Matrícula: " + matricula + "\n"
                + "Notas: " + nota1 + "," + nota2 + "," + nota3 + "\n"
                + "Média:" + getMedia() + "\n"
                + "Situação:" + getSituação();
        return formatado;
    }
}
