/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoclient;

import echocommon.StateModel;

/**
 *
 * @author yasu
 */
public class UdpMessageClient {

    private final StateModel clientStateModel;
    
    public UdpMessageClient(StateModel clientStateModel) {
    
        //モデル格納
        this.clientStateModel = clientStateModel;
    }
    
}
