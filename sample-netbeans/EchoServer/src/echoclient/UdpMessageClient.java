/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoclient;

import echocommon.StateModel;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 *
 * @author yasu
 */
public class UdpMessageClient {

    /**
     * UDP受信用スレッド
     *
     * ソケット通信はブロッキングモードかつ別スレッドで実施する
     *
     * TheradはJavaのスレッド TaskはThreadをJavaFXで使いやすいようにしたクラス
     * ServiceはTaskを再利用可能にしたファクトリクラス call()内で、別スレッド実行される処理を記述
     *
     * 以下参考
     *
     * JavaFX Worker, Task, Service
     * https://qiita.com/opengl-8080/items/51bef25aa05ecd929a3d
     *
     * ノンブロッキングI/OとマルチスレッドブロッキングIO
     * https://takezoe.hatenablog.com/entry/2014/10/12/000000
     *
     * Javaソケット通信 https://qiita.com/akatsubaki/items/aaca7664c5b881415bf5
     *
     */
    private Service<Void> service = new Service<Void>() {
        @Override
        protected Task<Void> createTask() {

            return new Task<Void>() {
                @Override
                protected Void call() throws Exception {

                    byte buffer[] = new byte[256];

                    try {
                        //自分ポート確保
                        DatagramSocket client = new DatagramSocket(CLIENT_PORT);

                        //受信用バッファ作成
                        DatagramPacket message = new DatagramPacket(buffer, buffer.length);

                        while (true) {
                            try {
                                //別スレッドでサーバからのメッセージを待受
                                client.receive(message);
                                String str = new String(Arrays.copyOf(message.getData(), message.getLength()), "UTF-8");
                                Platform.runLater(() -> clientStateModel.dispMessage("UDP:Recv:" + str));

                            } catch (Exception e) {
                                e.printStackTrace();
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return null;
                }
            };
        }
    };

    //状態管理及びUI関連
    private final StateModel clientStateModel;

    //ソケット通信関連
    private final static String SERVER_HOST = "127.0.0.1";
    private final static String CLIENT_HOST = "127.0.0.1";
    private final static Integer SERVER_PORT = 50001;
    private final static Integer CLIENT_PORT = 50011;

    public UdpMessageClient(StateModel clientStateModel) {

        //モデル格納
        this.clientStateModel = clientStateModel;
        //受信スレッド開始
        this.service.start();
    }

}
