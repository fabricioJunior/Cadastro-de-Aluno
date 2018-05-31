/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro.de.aluno;

import java.util.ArrayList;

/**
 *
 * @author Fabricio Junior
 */
public class DaHelpsCadastroFormulário {

    private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    private int index = 0;

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public String AlunoProximo() {
        index++;
        if (index > alunos.size() - 1) {
            index = 0;
        }
        String addPosi = "Pos:" + (index + 1) + "\n" + alunos.get(index).toString();
        return addPosi;
    }

    public String getUltimoAlunoInformações() {
        int tamanho = alunos.size();
        index = tamanho - 1;
        String addPosi = "Pos:" + (tamanho) + "\n" + alunos.get(tamanho - 1).toString();
        return addPosi;
    }

    public String AlunoAnterior() {
        index--;
        if (index < 0) {
              index = alunos.size() - 1;
        }  
        String addPosi = "Pos:" + (index + 1) + "\n" + alunos.get(index).toString();
            return addPosi;
    }

}
