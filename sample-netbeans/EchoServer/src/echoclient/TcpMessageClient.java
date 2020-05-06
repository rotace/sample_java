/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoclient;

import echocommon.StateModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author yasu
 */
public class TcpMessageClient {

    //状態管理及びUI関連
    private final StateModel clientStateModel;

    //ソケット通信関連
    private final static String SERVER_HOST = "127.0.0.1";
    private final static String CLIENT_HOST = "127.0.0.1";
    private final static Integer SERVER_PORT = 50000;
    private final static Integer CLIENT_PORT = 50010;
    private Socket client = null;

    public TcpMessageClient(StateModel clientStateModel) {

        //インスタンス生成
        this.client = new Socket();

        //モデル格納
        this.clientStateModel = clientStateModel;
    }

    public boolean ToggleConnection() {

        try {

            if (this.client.isClosed()) {
                //ソケットが閉じている場合は、新規作成
                this.client = new Socket();
            }

            if (this.client.isConnected()) {

                //切断
                this.client.close();

            } else {

                //通信設定
                InetAddress server_addr = InetAddress.getByName(SERVER_HOST);
                InetSocketAddress server_ep = new InetSocketAddress(server_addr, SERVER_PORT);

                //接続要求
                this.client.connect(server_ep, SERVER_PORT);
            }

        } catch (Exception e) {

            this.client = new Socket();
            e.printStackTrace();
        }

        if (client.isConnected() && !client.isClosed()) {
            this.clientStateModel.dispMessage("Connected");
            this.clientStateModel.cxtCmdProperty().set("Disconnect");
        } else {
            this.clientStateModel.dispMessage("Disconnected");
            this.clientStateModel.cxtCmdProperty().set("Connect");

        }

        return true;
    }

    public void SendCommand(String message) {

        try {

            if (this.client.isClosed()) {

                //ソケットが閉じている場合は、新規作成
                this.client = new Socket();

            }

            if (this.client.isConnected()) {
                //クライアントから送られてきたデータを一時保存するバッファ（受信バッファ）
                BufferedReader txt_reader = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
                //サーバがクライアントへ送るデータを一時保存するバッファ（送信バッファ）
                PrintWriter txt_writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.client.getOutputStream())));

                try {
                    //メッセージを送信
                    txt_writer.write(message + "\n");
                    txt_writer.flush();

                    //メッセージを表示
                    clientStateModel.dispMessage("TCP:Send:" + message);

                } catch (Exception e) {
                    try {
                        txt_reader.close();
                        txt_writer.close();
                        this.client.close();
                        this.client = null;

                    } catch (Exception ee) {
                        ee.printStackTrace();
                    }

                }

            } else {
                this.clientStateModel.dispMessage("Not Connected");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
