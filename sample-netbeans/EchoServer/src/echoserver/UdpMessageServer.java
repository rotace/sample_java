/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import echocommon.StateModel;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 *
 * @author yasu
 */
public class UdpMessageServer {

    /**
     * UDP送信用タイマ
     *
     * Javaのタイマには大きく以下の２通りある。
     *
     * java.util.Timer ：Javaの標準タイマ javafx.animation.Timeline ：JavaFXのUI制御用タイマ
     *
     * いずれも基本はイベント駆動であり、マルチスレッドではないが、 確実にUIスレッドでイベント駆動させるためにJavaFXのタイマを採用する。
     *
     */
    private Timeline timeline = new Timeline(
            new KeyFrame(Duration.millis(1000), (ActionEvent event) -> {

                try {
                    //通信設定
                    InetAddress client_addr = InetAddress.getByName(CLIENT_HOST);

                    //自分ポート確保
                    DatagramSocket server = new DatagramSocket(SERVER_PORT);

                    //パケット作成（宛先、メッセージ）
                    byte buffer[] = ("  A1:" + this.getServerStateModel().getUdpAlarmA1().getValue()
                            + "  A2:" + this.getServerStateModel().getUdpAlarmA2().getValue()
                            + "  B1:" + this.getServerStateModel().getUdpAlarmB1().getValue()
                            + "  B2:" + this.getServerStateModel().getUdpAlarmB2().getValue()).getBytes();

                    DatagramPacket message = new DatagramPacket(buffer, buffer.length, client_addr, CLIENT_PORT);

                    //送信
                    server.send(message);

                    //切断
                    server.close();

                    //ディスプレイ表示
                    this.getServerStateModel().dispMessage(new String(buffer));

                } catch (Exception e) {
                    e.printStackTrace();
                }

            })
    );

    //状態管理及びUI関連
    private final StateModel serverStateModel;

    private StateModel getServerStateModel() {
        return serverStateModel;
    }

    //ソケット通信関連
    private final static String SERVER_HOST = "127.0.0.1";
    private final static String CLIENT_HOST = "127.0.0.1";
    private final static Integer SERVER_PORT = 50001;
    private final static Integer CLIENT_PORT = 50011;

    public UdpMessageServer(StateModel serverStateModel) {

        //モデル格納
        this.serverStateModel = serverStateModel;

        //タイマ（JavaFXのタイマを使用）
        this.timeline.setCycleCount(INDEFINITE);
        this.timeline.play();
    }

}
