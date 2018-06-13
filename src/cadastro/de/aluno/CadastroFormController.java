/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro.de.aluno;

import java.awt.HeadlessException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.*;
import static javafx.scene.input.KeyCode.ENTER;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Fabricio Junior
 */
public class CadastroFormController implements Initializable {

    @FXML
    private TextField nomeText;
    @FXML
    private TextField sobrenomeText;
    @FXML
    private TextField emailText;
    @FXML
    private TextField diaText;
    @FXML
    private TextField mêsText;
    @FXML
    private TextField anoText;
    @FXML
    private ComboBox cursoBox;
    @FXML
    private TextField matriculaText;
    @FXML
    private TextField nota1Text;
    @FXML
    private TextField nota2Text;
    @FXML
    private TextField nota3Text;
    @FXML
    private TextArea informaçõesText;
    @FXML
    private Label qtdInfoLabel;
    
    private final ArrayList<TextField> fields = new ArrayList<>();
    private final DaHelpsCadastroFormulário help = new DaHelpsCadastroFormulário();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fields.add(nomeText);
        fields.add(sobrenomeText);
        fields.add(emailText);
        fields.add(diaText);
        fields.add(mêsText);
        fields.add(anoText);
        fields.add(matriculaText);
        fields.add(nota1Text);
        fields.add(nota2Text);
        fields.add(nota3Text);
        cursoBox.getItems().addAll("Ciências Econômicas", "Engenharia da Computação",
                "Engenharia Elétrica", "Finanças", "Medicina", "Música", "Odontologia", "Psicologia");
        cursoBox.getSelectionModel().selectFirst();
    }

    private boolean textFieldVazio(ArrayList<TextField> textsFields) {

        for (int x = 0; x < fields.size(); x++) {
            if (fields.get(x) == null || fields.get(x).getText().length() == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean idadeValida(Aluno teste) {
        try {
            int x = teste.idade();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    /**
     * Método para cadastrar o aluno atual e receber inforações do usuário
     * seguinte
     */
    public void cadastraBtn_Clicked() {

        try {
            if (!textFieldVazio(fields)) {
                Aluno novo = new Aluno();
                novo.setNome(nomeText.getText());
                novo.setSobrenome(sobrenomeText.getText());
                novo.setEmail(emailText.getText());
                novo.setDia(Integer.parseInt(diaText.getText()));
                novo.setMês(Integer.parseInt(mêsText.getText()));
                novo.setAno(Integer.parseInt(anoText.getText()));
                novo.setCurso(cursoBox.getSelectionModel().getSelectedItem().toString());
                novo.setMatricula(matriculaText.getText());
                novo.setNota1(Float.parseFloat(help.filtro(nota1Text.getText())));
                novo.setNota2(Float.parseFloat(help.filtro(nota2Text.getText())));
                novo.setNota3(Float.parseFloat(help.filtro(nota3Text.getText())));
                if (!idadeValida(novo)) {
                    JOptionPane.showMessageDialog(null, "Data de nascimento invalida", "erro", JOptionPane.ERROR_MESSAGE);
                } else if (!help.getAlunos().contains(novo)) {
                    help.getAlunos().add(novo);
                    informaçõesText.setText(help.getUltimoAlunoInformações());
                    atualizarQuantidade();
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Aluno já cadastrado, verifique o número de matrícula", "erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Dados(s) inválidos(s).Confira os dados fornecidos", "erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Dados(s) inválidos(s).Confira os dados fornecidos", "erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Cadastro dos dados do usuário
     *
     * @param e
     */
    public void cadastraBtn_KeyPressed(KeyEvent e) {
        if (e.getCode() == ENTER) {
            cadastraBtn_Clicked();
        }
    }

    /**
     * Exibe os dados do próximo usuário da lista
     */
    public void proximoBtn_Clicked() {
        informaçõesText.setText(help.AlunoProximo());
    }

    /**
     * Exibe os dados do usuário anterior da lista
     */
    public void anteriorBtn_Clicked() {
        informaçõesText.setText(help.AlunoAnterior());
    }

    /**
     * Exibe os dados do próximo usuário da lista
     *
     * @param e
     */
    public void proximoBtn_KeyPressed(KeyEvent e) {
        if (e.getCode() == ENTER) {
            proximoBtn_Clicked();
        }
    }

    /**
     * Exibe os dados do usuário anterior da lista
     *
     * @param e
     */
    public void anteriorBtn_KeyPressed(KeyEvent e) {
        if (e.getCode() == ENTER) {
            anteriorBtn_Clicked();
        }
    }

    /**
     * Exclui o usuário atual da lista
     */
    public void excluirBtn_Clicked() {
        if (!help.deleteAluno()) {
            JOptionPane.showMessageDialog(null, "Lista vazia", "erro", JOptionPane.ERROR_MESSAGE);
        } else if (help.getUltimoAlunoInformações() != null) {
            informaçõesText.setText(help.getUltimoAlunoInformações());
        } else {
            informaçõesText.setText("");
        }
        atualizarQuantidade();
    }

    /**
     * Exclui o usuário atual da lista
     *
     * @param e
     */
    public void excluirBtn_KeyPressed(KeyEvent e) {
        if (e.getCode() == ENTER) {
            excluirBtn_Clicked();
        }
    }

    /**
     * Exclui todos os dados digitados na área de texto
     */
    public void limparCampos() {
        nomeText.clear();
        sobrenomeText.clear();
        emailText.clear();
        diaText.clear();
        mêsText.clear();
        anoText.clear();
        matriculaText.clear();
        nota1Text.clear();
        nota2Text.clear();
        nota3Text.clear();
    }

    /**
     * Função que verifica se a String passada no paramêtro correção não contem
     * nenhum caractere não númerico
     *
     * @param correção String para ser analisada
     * @return false caso a string contenha apenas números
     */
    private boolean ContemLetras(String correção) {
        float valor;
        if (correção != null) {
            try {
                valor = Float.parseFloat(correção);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite um valor válido na segunda área de texto", "Informação", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        return false;
    }

    /**
     * Procedimento que atualiza Label na parte superior da interface gráfica
     * responsável por informa a quantidade de alunos cadastrados
     *
     */
    public void atualizarQuantidade() {
        int qtd = help.getAlunos().size();
        if (qtd == 0) {
            qtdInfoLabel.setText("Controle de Alunos- Nenhum aluno cadastrado");
        } else if (qtd == 1) {
            qtdInfoLabel.setText("Controle de Alunos- 1 aluno cadastrado");
        } else {
            qtdInfoLabel.setText("Controle de Alunos- " + qtd + " alunos cadastrados");
        }
    }
}
