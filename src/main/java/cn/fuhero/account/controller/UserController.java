package cn.fuhero.account.controller;

import cn.fuhero.account.entity.User;
import cn.fuhero.account.model.Result;
import cn.fuhero.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Fu Zhong on 2015/7/4.
 */
@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/user/register")
    public Result registerUser (User user) {
        userService.addUser(user);
        return new Result(Result.STATE_FAIL, user);
    }

    @ResponseBody
    @RequestMapping("/user/info/{id}")
    public Result getUser (@PathVariable String id) {
        User user = userService.getUserDetailInfo(id);
        return Result.setSuccessResultData(user);
    }

}
