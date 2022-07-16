package com.example.ppt02_2072029;

import com.example.ppt02_2072029.Model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

public class HelloController {
    @FXML
    private TableView<Student> table1;
    @FXML
    private TableColumn<Integer, Student> colNrp;
    @FXML
    private TableColumn<String, Student> colNama;
    @FXML
    private TableColumn<Float, Student> colIpa;
    @FXML
    private TableColumn<Float, Student> colIps;
    @FXML
    private TextField txtNrp;
    @FXML
    private TextField txtNama;
    @FXML
    private TextField txtIpa;
    @FXML
    private TextField txtIps;
    public Button btnAdd;
    public Button btnUpd;
    public Button btnDel;
    public ObservableList<Student> sList;
    private JOptionPane JOptionPane;

    public void initialize() {
        sList = FXCollections.observableArrayList();
        table1.setItems(sList);
        colNrp.setCellValueFactory(new PropertyValueFactory<>("nrp"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colIpa.setCellValueFactory(new PropertyValueFactory<>("ipa"));
        colIps.setCellValueFactory(new PropertyValueFactory<>("ips"));
    }

    public void reset() {
        txtNrp.clear();
        txtNama.clear();
        txtIpa.clear();
        txtIps.clear();
        btnAdd.setDisable(false);
    }

    @FXML
    public void OnAdd(ActionEvent actionEvent) {
        int sNrp = Integer.parseInt(txtNrp.getText());
        String sName = txtNama.getText();
        float sIpa = Float.parseFloat(txtIpa.getText());
        float sIps = Float.parseFloat(txtIps.getText());
        sList.add(new Student(sNrp, sName, sIpa, sIps));
        reset();
    }

    @FXML
    public void OnUpd(ActionEvent actionEvent) {
        int sNrp = Integer.parseInt(txtNrp.getText());
        String sName = txtNama.getText();
        float sIpa = Float.parseFloat(txtIpa.getText());
        float sIps = Float.parseFloat(txtIps.getText());
        sList.set(table1.getSelectionModel().getSelectedIndex(), new Student(sNrp, sName, sIpa, sIps));
        reset();
    }

    @FXML
    public void OnDel(ActionEvent actionEvent) {
        int res = JOptionPane.showConfirmDialog(
                null,"Apakah Anda Yakin ?","Confirm Box",JOptionPane.YES_NO_OPTION
        );
        if(res == 0) {
            sList.remove(table1.getSelectionModel().getSelectedItem());
            reset();
        }
    }

    public void OnClick(MouseEvent mouseEvent) {
        if (!table1.getSelectionModel().getSelectedCells().isEmpty()){
            btnAdd.setDisable(true);
            btnUpd.setDisable(false);
            btnDel.setDisable(false);
        }
        txtNrp.setText(String.valueOf(table1.getSelectionModel().getSelectedItem().getNrp()));
        txtNama.setText(table1.getSelectionModel().getSelectedItem().getNama());
        txtIpa.setText(String.valueOf(table1.getSelectionModel().getSelectedItem().getIpa()));
        txtIps.setText(String.valueOf(table1.getSelectionModel().getSelectedItem().getIps()));
    }
}