package cn.fuhero.account.service.impl;

import cn.fuhero.account.dao.UserDAO;
import cn.fuhero.account.entity.User;
import cn.fuhero.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Fu Zhong on 2015/7/4.
 */
@Service
public class IUserService implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public void addUser(User user){
        userDAO.create(user);
    }

    @Override
    public User getUserDetailInfo(String id){
        return userDAO.getById(id);
    }
}
