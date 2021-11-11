package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private TextField strField;


    @FXML
    private PasswordField password;

    @FXML
    private CheckBox isEnabled;

    @FXML
    private ToggleGroup sexGroup;
    @FXML
    private RadioButton maleBtn;
    @FXML
    private RadioButton femaleBtn;

    @FXML
    private DatePicker birthday;

    @FXML
    private ColorPicker hairColor;

    @FXML
      private  ComboBox <String> countries;


    @FXML
    private TextArea allStrs;

    @FXML
    private  TextField newCountry;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    sexGroup=new ToggleGroup();
            maleBtn.setToggleGroup(sexGroup);
            femaleBtn.setToggleGroup(sexGroup);

        ObservableList<String> items = countries.getItems();
        items.add("Belarus");
        items.add("Ukraine");
        items.add("Russia");
    }

    public  void addCountryBtnPressed (){

        String country =newCountry.getText();
        ObservableList<String> allCountries = countries.getItems();
        allCountries.add(country);
    }

    public void saveBtnPressed() {
        String text = strField.getText();
        addTextToTextArea(text);

        String passwordText = password.getText();
        addTextToTextArea(passwordText);

        boolean selected = isEnabled.isSelected();
        addTextToTextArea(Boolean.toString(selected));

        boolean maleSelected = maleBtn.isSelected();
        if (maleSelected) {
            addTextToTextArea("MALE was selected!");
        }
        boolean femaleSelected = femaleBtn.isSelected();
        if (femaleSelected) {
            addTextToTextArea("FEMALE was selected!");
        }

        LocalDate birthdayDate =birthday.getValue();
        addTextToTextArea(birthdayDate.toString());

        Color color =hairColor.getValue();
        addTextToTextArea(color.toString());

        addTextToTextArea("-------------------------------------");
        addTextToTextArea("\n");

        clearForm();


    }

    private void addTextToTextArea(String text) {

    String allStrsText = allStrs.getText();
    if(allStrsText!=null&&allStrsText.length()>0)

    {
        allStrs.appendText("\n");
    }
        allStrs.appendText(text);
    }

    private  void clearForm () {
    strField.setText("");
    password.setText("");
    isEnabled.setSelected(false);
    maleBtn.setSelected(false);
    femaleBtn.setSelected(false);
    birthday.setValue(null);
    hairColor.setValue(null);

    }


}
