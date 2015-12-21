package com.mihailsergeevichs.imageboard.controller;

import org.springframework.stereotype.Controller;

/**
 * Created by Overlord on 22.12.2015.
 */
@Controller
public class IndexController {

    private final static String VIEW_NAME_INDEX_PAGE = "index";


    public String getIndexPage(){
        return VIEW_NAME_INDEX_PAGE;
    }
}
