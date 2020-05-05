/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import echocommon.StateModel;

/**
 *
 * @author yasu
 */
public class TcpMessageServer {

    private final StateModel serverStateModel;

    public TcpMessageServer(StateModel serverStateModel) {
        
        // モデル格納
        this.serverStateModel = serverStateModel;
    }

}
