/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echocommon;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author yasu
 */
public final class ComboFormat {

    private int _bits;
    private StringProperty _data = new SimpleStringProperty();
    private StringProperty _info = new SimpleStringProperty();

    public int getBits() {
        return _bits;
    }

    public void setBits(int bits) {
        this._bits = bits;
    }

    public StringProperty dataProperty() {
        return _data;
    }

    public String getData() {
        return dataProperty().get();
    }

    public void setData(String data) {
        dataProperty().set(data);
    }

    public StringProperty infoProperty() {
        return _info;
    }

    public String getInfo() {
        return infoProperty().get();
    }

    public void setInfo(String info) {
        infoProperty().set(info);
    }

    public ComboFormat(int bits, String data, String info) {
        this.setBits(bits);
        this.setData(data);
        this.setInfo(info);
    }

    @Override
    public String toString() {
        // return "ComboFormat{" + "bits=" + _bits + ", data=" + dataProperty().get() + ", info=" + infoProperty().get() + '}';
        // コンボボックスに表示される文字列
        return infoProperty().get();
    }

}
