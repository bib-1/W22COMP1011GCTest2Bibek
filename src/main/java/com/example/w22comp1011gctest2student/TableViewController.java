package com.example.w22comp1011gctest2student;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Bibek Poudel
 * 200455715
 */
public class TableViewController implements Initializable {
    @FXML
    private Label saleLabel;

    @FXML
    private Label msrpLabel;

    @FXML
    private Label savingsLabel;

    @FXML
    private Label rowsInTableLabel;

    @FXML
    private TableView<Customer> tableView;

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private TableColumn<Customer, String> firstNameColumn;

    @FXML
    private TableColumn<Customer, String> lastNameColumn;

    @FXML
    private TableColumn<Customer, String> phoneColumn;

    @FXML
    private TableColumn<Customer, String> totalPurchaseColumn;

    @FXML
    private ListView<Product> purchaseListView;

    @FXML
    private ImageView imageView;

    @FXML
    private void top10Customers()
    {
        System.out.println("called method top10Customers()");
    }

    @FXML
    private void customersSavedOver5()
    {
        System.out.println("called method customersSavedOver5()");
        tableView.getItems().clear();
        ArrayList<Customer> customers = ReadJson.getCustomerFromJson("customers.json").getCustomers();
        tableView.getItems().addAll(customers.stream().filter(e-> e.savedMoreThanFive() == true).collect(Collectors.toSet()));
        rowsInTableLabel.setText(String.format("Rows Returned: %d", tableView.getItems().size()));

    }

    @FXML
    private void loadAllCustomers()
    {
        System.out.println("called method loadAllCustomers");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Customer> customers = ReadJson.getCustomerFromJson("customers.json").getCustomers();
        tableView.getItems().addAll(customers);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        totalPurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("totalPurchase"));

        //returning rows
        rowsInTableLabel.setText(String.format("Rows Returned: %d", tableView.getItems().size()));

        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, typeSelected)->{
            purchaseListView.getItems().clear();
            ArrayList<Product> items= typeSelected.getPurchases();
            if(items!= null)
                purchaseListView.getItems().addAll(items);

            msrpLabel.setText("Total Regular Price: $" + typeSelected.totalRegularPrice());
            saleLabel.setText("Total Regular Price: $" + typeSelected.totalPurchase());
            savingsLabel.setText("Total Regular Price: $" + typeSelected.totalSavings());


        });


    }
}
