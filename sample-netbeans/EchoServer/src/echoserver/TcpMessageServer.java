/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import echocommon.StateModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 *
 * @author yasu
 */
public class TcpMessageServer {

    /**
     * TCP受信用スレッド
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

                    try {
                        //通信設定
                        ServerSocket listener = new ServerSocket(SERVER_PORT);

                        while (true) {
                            try {
                                //別スレッドでクライアント接続要求を待受
                                Socket server = listener.accept();
                                //クライアントから送られてきたデータを一時保存するバッファ（受信バッファ）
                                BufferedReader txt_reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
                                //サーバがクライアントへ送るデータを一時保存するバッファ（送信バッファ）
                                PrintWriter txt_writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(server.getOutputStream())));

                                while (true) {
                                    try {
                                        //別スレッドでメッセージを待受
                                        String message = txt_reader.readLine();
                                        txt_writer.write(message);
                                        txt_writer.flush();

                                        //受信メッセージを表示（UIスレッドに委譲）
                                        //UIコンポーネントを操作する場合はUIスレッドに委譲が必要
                                        Platform.runLater(() -> serverStateModel.dispMessage("TCP:Recv:" + message));

                                    } catch (Exception e) {
                                        try {
                                            txt_reader.close();
                                            txt_writer.close();
                                            server.close();
                                            break;

                                        } catch (Exception ee) {
                                            ee.printStackTrace();
                                        }

                                    }
                                }

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
    private final StateModel serverStateModel;

    //ソケット通信関連
    private final static String SERVER_HOST = "127.0.0.1";
    private final static String CLIENT_HOST = "127.0.0.1";
    private final static Integer SERVER_PORT = 50000;
    private final static Integer CLIENT_PORT = 50010;

    public TcpMessageServer(StateModel serverStateModel) {

        //モデル格納
        this.serverStateModel = serverStateModel;
        //受信スレッド開始
        this.service.start();
    }

}
