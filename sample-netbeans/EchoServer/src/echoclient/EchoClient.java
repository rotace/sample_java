/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoclient;

import echocommon.StateModel;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author yasu
 */
public class EchoClient extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //画面構築
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLClient.fxml"));
        Parent root = loader.load();
        
        //その他インスタンス生成
        StateModel clientStateModel = new StateModel();
        TcpMessageClient tcpMessageClient = new TcpMessageClient(clientStateModel);
        UdpMessageClient udpMessageClient = new UdpMessageClient(clientStateModel);
        FXMLClientController controller = (FXMLClientController) loader.getController();
        controller.setModel(clientStateModel);

        Scene scene = new Scene(root);

        stage.setTitle("EchoClient");
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
