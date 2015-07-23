package cn.fuhero.account.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Fu Zhong on 2015/7/4.
 */
@Controller
@RequestMapping("/api")
public class BaseController {
    protected static Logger logger = Logger.getLogger(BaseController.class);
}
