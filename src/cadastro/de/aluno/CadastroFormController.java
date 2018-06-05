/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro.de.aluno;

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
    private ArrayList<TextField> fields = new ArrayList<TextField>();
    private DaHelpsCadastroFormulário help = new DaHelpsCadastroFormulário();

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

    /**
     *
     */
    public void cadastraBtn_Clicked() {

        if (!textFieldVazio(fields)) {
            Aluno novo = new Aluno();
            novo.nome = nomeText.getText();
            novo.sobrenome = sobrenomeText.getText();
            novo.email = emailText.getText();
            novo.data.dia = Integer.parseInt(diaText.getText());
            novo.data.mês = Integer.parseInt(mêsText.getText());
            novo.data.ano = Integer.parseInt(anoText.getText());
            novo.curso = cursoBox.getSelectionModel().getSelectedItem().toString();
            novo.matricula = matriculaText.getText();
            novo.nota1 = Float.parseFloat(nota1Text.getText());
            novo.nota2 = Float.parseFloat(nota2Text.getText());
            novo.nota3 = Float.parseFloat(nota3Text.getText());
            if (!help.getAlunos().contains(novo)) {
                help.getAlunos().add(novo);
                informaçõesText.setText(help.getUltimoAlunoInformações());
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Aluno já cadastrado, verifique o número de matrícula", "erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Dados(s) inválidos(s).Confira os dados fornecidos", "erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     *
     * @param e
     */
    public void cadastraBtn_KeyPressed(KeyEvent e) {
        if (e.getCode() == ENTER) {
            cadastraBtn_Clicked();
        }
    }

    /**
     *
     */
    public void proximoBtn_Clicked() {
        informaçõesText.setText(help.AlunoProximo());
    }

    /**
     *
     */
    public void anteriorBtn_Clicked() {
        informaçõesText.setText(help.AlunoAnterior());
    }

    /**
     *
     * @param e
     */
    public void proximoBtn_KeyPressed(KeyEvent e) {
        if (e.getCode() == ENTER) {
            proximoBtn_Clicked();
        }
    }

    /**
     *
     * @param e
     */
    public void anteriorBtn_KeyPressed(KeyEvent e) {
        if (e.getCode() == ENTER) {
            anteriorBtn_Clicked();
        }
    }

    /**
     *
     */
    public void excluirBtn_Clicked() {
        if (!help.deleteAluno()) {
            JOptionPane.showMessageDialog(null, "Lista vazia", "erro", JOptionPane.ERROR_MESSAGE);
        }
        informaçõesText.setText(help.getUltimoAlunoInformações());
    }

    /**
     *
     * @param e
     */
    public void excluirBtn_KeyPressed(KeyEvent e) {
        if (e.getCode() == ENTER) {
            excluirBtn_Clicked();
        }
    }
    
    /**
     *
     */
    public void limparCampos(){
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
}
