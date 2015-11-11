package org.topclouders.chesscloud.controller;

import com.toupclouders.chesscloud.controller.PreLoadReply;
import com.toupclouders.chesscloud.controller.PreLoadRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by kokeny on 10/11/15.
 */
@RestController
@RequestMapping("/welcome")
public class WelcomeController extends ViewController {

    /**
     *
     * @param preLoadRequest The received request object from the client.
     * @return Return the welcome pre load reply object
     */
    @Override
    public PreLoadReply preLoad(PreLoadRequest preLoadRequest) {
        PreLoadReply preLoadReply = new PreLoadReply();
        return preLoadReply;
    }
}
