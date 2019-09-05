package com.hrt.cloud.common.web.service;

import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: gradual
 * @Date: 2019-07-17 15:30
 */
public interface RedisService {

    boolean set(String key, Object value);

    boolean set(String key, Object value, Long expireTime);

    Object get(String key);

    boolean exists(String key);

    void remove(String key);

    void remove(String... keys);

    void removePattern(String pattern);

    void hmSet(String key, Object hashKey, Object value);

    Object hmGet(String key, Object hashKey);

    void lPush(String key, Object v);

    List<Object> lRange(String key, long l, long l1);

    void add(String key, Object value);

    Set<Object> setMembers(String key);

    void zAdd(String key, Object value, double scoure);

    Set<Object> rangeByScore(String key, double scoure, double scoure1);
}
