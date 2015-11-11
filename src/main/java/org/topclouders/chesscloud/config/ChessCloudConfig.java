package org.topclouders.chesscloud.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kokeny on 10/11/15.
 */
@Configuration
@ComponentScan(basePackages = "org.topclouders", excludeFilters = {@ComponentScan.Filter(
        value = Controller.class,
        type = FilterType.ANNOTATION
), @ComponentScan.Filter(
        value = RestController.class,
        type = FilterType.ANNOTATION
)})
public class ChessCloudConfig {
}
