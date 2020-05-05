/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoclient;

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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author yasu
 */
public class FXMLClientController implements Initializable {

    private StateModel model;
    @FXML
    private ComboBox<ComboFormat> cmbBoxDataA;
    @FXML
    private ComboBox<ComboFormat> cmbBoxDataB;
    @FXML
    private TextField messageTextField;
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

    public void setModel(StateModel model) {
        this.model = model;

        //---- 接続ボタン ----
        // 接続ボタンをモデルとバインド（ビューとモデルの双方向）
        connectBtn.textProperty().bindBidirectional(this.model.cxtCmdProperty());
        
        //---- Textページ ----
        // リストビューのアイテムをモデルとバインド
        messageListView.setItems(this.model.getMessageList());
        // テキストフィールドの文字列をモデルとバインド（ビューとモデルの双方向）
        this.model.messageProperty().bindBidirectional(messageTextField.textProperty());
        
        // ---- TCPコマンド ----
        //コンボボックスの選択肢をモデルとバインド
        cmbBoxDataA.setItems(this.model.getTcpCmdMsgDataAList());
        cmbBoxDataB.setItems(this.model.getTcpCmdMsgDataBList());
        //コンボボックスの選択をモデルとバインド（ビューからモデルへ片方向）
        this.model.getTcpCmdMsgDataA().bind(cmbBoxDataA.getSelectionModel().selectedItemProperty());
        this.model.getTcpCmdMsgDataB().bind(cmbBoxDataB.getSelectionModel().selectedItemProperty());
        //初期値を設定
        cmbBoxDataA.getSelectionModel().select(0);
        cmbBoxDataB.getSelectionModel().select(0);
    }

    @FXML
    private void MsgSendBtn_OnAction(ActionEvent event) {
        this.model.dispMessage(this.model.getMessage());
    }

    @FXML
    private void ConnectBtn_OnAction(ActionEvent event) {
    }

    @FXML
    private void TcpSetMsgBtn_OnAction(ActionEvent event) {
    }

    @FXML
    private void TcpGetMsgBtn_OnAction(ActionEvent event) {
    }

}
