package com.mihailsergeevichs.imageboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Overlord on 22.12.2015.
 */
@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private final static String VIEW_NAME_INDEX_PAGE = "index";

    /*
    *This method returns index page view
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage(){
        logger.info("Rendering index page");
        return VIEW_NAME_INDEX_PAGE;
    }
}
