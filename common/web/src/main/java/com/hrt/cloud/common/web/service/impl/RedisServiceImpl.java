package com.hrt.cloud.common.web.service.impl;

import com.hrt.cloud.common.web.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author David Hong
 * @version 1.0
 * @description redisService实现类
 */
@Slf4j
@Service
public class RedisServiceImpl implements RedisService {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 写入缓存
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	@Override
    public boolean set(String key, Object value) {
		boolean result = false;
		try {
			ValueOperations<String, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			result = true;
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return result;
	}

	/**
	 * 写入缓存设置时效时间
	 * 
	 * @param key
	 * @param value
	 * @param expireTime 以秒为单位
	 * @return
	 */
	@Override
    public boolean set(String key, Object value, Long expireTime) {
		boolean result = false;
		try {
			ValueOperations<String, Object> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return result;
	}

	/**
	 * 读取缓存
	 * 
	 * @param key
	 * @return
	 */
	@Override
    public Object get(String key) {
		log.info("拉取缓存：key->{}", key);
		Object result = null;
		ValueOperations<String, Object> operations = redisTemplate.opsForValue();
		result = operations.get(key);
		log.info("拉取内容：{}", result);
		return result;
	}

	/**
	 * 判断缓存中是否有对应的value
	 * 
	 * @param key
	 * @return
	 */
	@Override
    public boolean exists(String key) {
		return redisTemplate.hasKey(key);
	}

	/**
	 * 删除对应的value
	 * 
	 * @param key
	 */
	@Override
    public void remove(String key) {
		if (exists(key)) {
			redisTemplate.delete(key);
		}
	}

	/**
	 * 批量删除对应的value
	 * 
	 * @param keys
	 */
	@Override
    public void remove(final String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}

	/**
	 * 批量删除key
	 * 
	 * @param pattern
	 */
	@Override
    public void removePattern(final String pattern) {
		Set<String> keys = redisTemplate.keys(pattern);
		if (keys.size() > 0) {
			redisTemplate.delete(keys);
		}
	}

	/**
	 * 哈希 添加
	 * 
	 * @param key
	 * @param hashKey
	 * @param value
	 */
	@Override
    public void hmSet(String key, Object hashKey, Object value) {
		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
		hash.put(key, hashKey, value);
	}

	/**
	 * 哈希获取数据
	 * 
	 * @param key
	 * @param hashKey
	 * @return
	 */
	@Override
    public Object hmGet(String key, Object hashKey) {
		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
		return hash.get(key, hashKey);
	}

	/**
	 * 列表添加
	 *
	 * @author David Hong
	 *
	 * @param key
	 * @param v
	 * @return void
	 */
	@Override
    public void lPush(String key, Object v) {
		ListOperations<String, Object> list = redisTemplate.opsForList();
		list.rightPush(key, v);
	}

	/**
	 * 列表获取
	 * 
	 * @param key
	 * @param l
	 * @param l1
	 * @return
	 */
	@Override
    public List<Object> lRange(String key, long l, long l1) {
		ListOperations<String, Object> list = redisTemplate.opsForList();
		return list.range(key, l, l1);
	}

	/**
	 * 集合添加
	 * 
	 * @param key
	 * @param value
	 */
	@Override
    public void add(String key, Object value) {
		SetOperations<String, Object> set = redisTemplate.opsForSet();
		set.add(key, value);
	}

	/**
	 * 集合获取
	 * 
	 * @param key
	 * @return
	 */
	@Override
    public Set<Object> setMembers(String key) {
		SetOperations<String, Object> set = redisTemplate.opsForSet();
		return set.members(key);
	}

	/**
	 * 有序集合添加
	 * 
	 * @param key
	 * @param value
	 * @param scoure
	 */
	@Override
    public void zAdd(String key, Object value, double scoure) {
		ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
		zset.add(key, value, scoure);
	}
	
	/**
	 * 有序集合获取
	 * 
	 * @param key
	 * @param scoure
	 * @param scoure1
	 * @return
	 */
	@Override
    public Set<Object> rangeByScore(String key, double scoure, double scoure1) {
		ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
		return zset.rangeByScore(key, scoure, scoure1);
	}

}
