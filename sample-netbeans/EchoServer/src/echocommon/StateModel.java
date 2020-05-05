/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echocommon;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author yasu
 */
public class StateModel {

    //---- 接続ボタン ----
    private final StringProperty _cxt_cmd = new SimpleStringProperty();
    
    {
        _cxt_cmd.set("Connect");
    }

    public StringProperty cxtCmdProperty() {
        return _cxt_cmd;
    }

    //---- Textページ ----
    private final ObservableList<String> _message_list = FXCollections.observableArrayList();
    private final StringProperty _message = new SimpleStringProperty();

    public ObservableList<String> getMessageList() {
        return _message_list;
    }

    public StringProperty messageProperty() {
        return _message;
    }

    public String getMessage() {
        return messageProperty().get();
    }

    public void setMessage(String message) {
        messageProperty().set(message);
    }

    //---- TCPコマンド ----
    private final ObservableList<ComboFormat> _tcp_cmd_data_a_list = FXCollections.observableArrayList();

    {
        _tcp_cmd_data_a_list.add(new ComboFormat(32, "0x00000000", "Hello, "));
        _tcp_cmd_data_a_list.add(new ComboFormat(32, "0x00000001", "Goodbye, "));
    }
    private final ObservableList<ComboFormat> _tcp_cmd_data_b_list = FXCollections.observableArrayList();

    {
        _tcp_cmd_data_b_list.add(new ComboFormat(32, "0x00000000", "Mark!"));
        _tcp_cmd_data_b_list.add(new ComboFormat(32, "0x00000001", "Nancy!"));
    }
    private final ObjectProperty<ComboFormat> _tcp_cmd_data_a = new SimpleObjectProperty<>();
    private final ObjectProperty<ComboFormat> _tcp_cmd_data_b = new SimpleObjectProperty<>();

    public ObservableList<ComboFormat> getTcpCmdMsgDataAList() {
        return _tcp_cmd_data_a_list;
    }

    public ObservableList<ComboFormat> getTcpCmdMsgDataBList() {
        return _tcp_cmd_data_b_list;
    }

    public ObjectProperty<ComboFormat> getTcpCmdMsgDataA() {
        return _tcp_cmd_data_a;
    }

    public ObjectProperty<ComboFormat> getTcpCmdMsgDataB() {
        return _tcp_cmd_data_b;
    }

    //---- UDPステータス ----
    private final ObservableList<ComboFormat> _udp_alm_list = FXCollections.observableArrayList();

    {
        _udp_alm_list.add(new ComboFormat(1, "0x00", "Good"));
        _udp_alm_list.add(new ComboFormat(1, "0x01", "Bad"));
    }
    private final ObjectProperty<ComboFormat> _udp_alm_a1 = new SimpleObjectProperty<>();
    private final ObjectProperty<ComboFormat> _udp_alm_a2 = new SimpleObjectProperty<>();
    private final ObjectProperty<ComboFormat> _udp_alm_b1 = new SimpleObjectProperty<>();
    private final ObjectProperty<ComboFormat> _udp_alm_b2 = new SimpleObjectProperty<>();

    public ObservableList<ComboFormat> getUdpAlarmList() {
        return _udp_alm_list;
    }

    public ObjectProperty<ComboFormat> getUdpAlarmA1() {
        return _udp_alm_a1;
    }

    public ObjectProperty<ComboFormat> getUdpAlarmA2() {
        return _udp_alm_a2;
    }

    public ObjectProperty<ComboFormat> getUdpAlarmB1() {
        return _udp_alm_b1;
    }

    public ObjectProperty<ComboFormat> getUdpAlarmB2() {
        return _udp_alm_b2;
    }

    public void dispMessage(String str) {

        this.getMessageList().add(str);

        if (this.getMessageList().size() > 10) {
            this.getMessageList().remove(0);
        }
    }
}
