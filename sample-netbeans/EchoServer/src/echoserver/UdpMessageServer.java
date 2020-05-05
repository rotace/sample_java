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
public class UdpMessageServer {

    private final StateModel serverStateModel;

    public UdpMessageServer(StateModel serverStateModel) {

        //モデル格納
        this.serverStateModel = serverStateModel;
    }

}
