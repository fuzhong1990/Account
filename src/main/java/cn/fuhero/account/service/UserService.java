package cn.fuhero.account.service;

import cn.fuhero.account.entity.User;

/**
 * Created by Fu Zhong on 2015/7/4.
 */
public interface UserService {
    void addUser (User user);
    User getUserDetailInfo (String id);
}
