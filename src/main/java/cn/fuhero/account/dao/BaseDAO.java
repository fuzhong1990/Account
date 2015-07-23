package cn.fuhero.account.dao;

/**
 * Created by Fu Zhong on 2015/7/4.
 */
public interface BaseDAO<T> {
    void create (T t);
    T getById (String id);
}
