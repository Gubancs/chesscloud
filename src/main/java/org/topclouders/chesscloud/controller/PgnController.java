package org.topclouders.chesscloud.controller;

import com.toupclouders.chesscloud.base.GetPgnReply;
import com.toupclouders.chesscloud.base.GetPgnRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.topclouders.chesscloud.service.PgnService;

/**
 * Created by kokeny on 11/11/15.
 */
@RestController
public class PgnController {

    @Autowired
    private PgnService pgnService;

    /**
     * @param pgnRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "pgn", method = RequestMethod.GET)
    public GetPgnReply getPgn(@RequestBody(required = false) GetPgnRequest pgnRequest) {
        GetPgnReply pgnReply = new GetPgnReply();
        return pgnReply;
    }
}
