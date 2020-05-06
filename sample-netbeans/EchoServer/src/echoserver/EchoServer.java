/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import echocommon.StateModel;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * EchoServer本体
 * 
 * JavaFXの実装の参考文献
 * https://qiita.com/opengl-8080/items/51bef25aa05ecd929a3d
 *
 * @author yasu
 */
public class EchoServer extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //画面構築
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLServer.fxml"));
        Parent root = loader.load();

        //その他インスタンス生成
        StateModel serverStateModel = new StateModel();
        TcpMessageServer tcpMessageServer = new TcpMessageServer(serverStateModel);
        UdpMessageServer udpMessageServer = new UdpMessageServer(serverStateModel);
        FXMLServerController controller = (FXMLServerController) loader.getController();
        controller.setModel(serverStateModel);

        Scene scene = new Scene(root);

        stage.setTitle("EchoServer");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
