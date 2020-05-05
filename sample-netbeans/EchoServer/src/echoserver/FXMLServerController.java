/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import echocommon.ComboFormat;
import echocommon.StateModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author yasu
 */
public class FXMLServerController implements Initializable {

    private StateModel model;
    @FXML
    private ComboBox<ComboFormat> cmbBoxUdpAlmA1;
    @FXML
    private ComboBox<ComboFormat> cmbBoxUdpAlmA2;
    @FXML
    private ComboBox<ComboFormat> cmbBoxUdpAlmB1;
    @FXML
    private ComboBox<ComboFormat> cmbBoxUdpAlmB2;
    @FXML
    private ListView<String> messageListView;
    @FXML
    private Button connectBtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void setModel(StateModel model){
        this.model = model;
        
        //---- 接続ボタン ----
        // 接続ボタンをモデルとバインド（ビューとモデルの双方向）
        connectBtn.textProperty().bindBidirectional(this.model.cxtCmdProperty());
        
        //---- Textページ ----
        // リストビューのアイテムをモデルとバインド
        messageListView.setItems(this.model.getMessageList());
        
        // ---- UDPステータス ----
        //コンボボックスの選択肢をモデルとバインド
        cmbBoxUdpAlmA1.setItems(this.model.getUdpAlarmList());
        cmbBoxUdpAlmA2.setItems(this.model.getUdpAlarmList());
        cmbBoxUdpAlmB1.setItems(this.model.getUdpAlarmList());
        cmbBoxUdpAlmB2.setItems(this.model.getUdpAlarmList());
        //コンボボックスの選択をモデルとバインド（ビューからモデルへ片方向）
        this.model.getUdpAlarmA1().bind(cmbBoxUdpAlmA1.getSelectionModel().selectedItemProperty());
        this.model.getUdpAlarmA2().bind(cmbBoxUdpAlmA2.getSelectionModel().selectedItemProperty());
        this.model.getUdpAlarmB1().bind(cmbBoxUdpAlmB1.getSelectionModel().selectedItemProperty());
        this.model.getUdpAlarmB2().bind(cmbBoxUdpAlmB2.getSelectionModel().selectedItemProperty());
        //初期値を設定
        cmbBoxUdpAlmA1.getSelectionModel().select(0);
        cmbBoxUdpAlmA2.getSelectionModel().select(0);
        cmbBoxUdpAlmB1.getSelectionModel().select(0);
        cmbBoxUdpAlmB2.getSelectionModel().select(0);
    }

    @FXML
    private void ConnectBtn_OnAction(ActionEvent event) {
    }
    
}
