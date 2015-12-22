package com.mihailsergeevichs.imageboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Overlord on 22.12.2015.
 */
@Controller
public class IndexController {

    private final static String VIEW_NAME_INDEX_PAGE = "index";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage(){
        return VIEW_NAME_INDEX_PAGE;
    }
}
