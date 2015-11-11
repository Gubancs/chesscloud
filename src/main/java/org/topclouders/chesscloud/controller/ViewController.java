package org.topclouders.chesscloud.controller;

import com.toupclouders.chesscloud.controller.PreLoadReply;
import com.toupclouders.chesscloud.controller.PreLoadRequest;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.nio.charset.Charset;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by kokeny on 11/11/15.
 */
public abstract class ViewController {


    /**
     * A view controller must be implement the pre load method.
     *
     * @param preLoadRequest The received request object from the client.
     * @return Return the reply object that includes all necessary data for the client.
     * @see PreLoadReply
     * @see PreLoadRequest
     */
    public abstract PreLoadReply preLoad(PreLoadRequest preLoadRequest);


    /**
     * @param preLoadRequest
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/preload", method = RequestMethod.GET)
    public PreLoadReply preLoadView(@RequestBody(required = false) PreLoadRequest preLoadRequest) { //FIXME Must be remove required 'false' paremeter from the RequestBody annotation
        PreLoadReply preLoadReply = preLoad(preLoadRequest);

        //TODO It is not the best solution
        preLoadReply.setSystemDate(GregorianCalendar.getInstance());
        preLoadReply.setCharacterEncoding(Charset.defaultCharset().name());
        preLoadReply.setTimeZone(TimeZone.getDefault().getID());
        preLoadReply.setLanguage(LocaleContextHolder.getLocale().getLanguage());

        return preLoadReply;
    }
}
