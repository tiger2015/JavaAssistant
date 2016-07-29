package com.javaassistant.dao;

import java.util.List;

import com.javaassistant.model.UserInfo;

public interface UserInfoDAO {
	/**
	 * 保存用户信息
	 * 
	 * @return true:操作成功 false:操作失败
	 */
	boolean save(UserInfo userInfo);

	/**
	 * 更新用户信息
	 * 
	 * @param userInfo
	 * @return true:操作车成功 false:操作失败
	 */
	boolean update(UserInfo userInfo);

	/**
	 * 获取所有用户信息
	 * 
	 * @return
	 */
	List<UserInfo> loadAllUserInfo();

	/**
	 * 根据Id获取用户信息
	 * 
	 * @param id
	 *            用户Id
	 * @return
	 */
	UserInfo loadUserInfoById(int id);

	/**
	 * 根据用户名获取用户信息
	 * 
	 * @param name
	 *            用户名
	 * @return
	 */
	UserInfo loadUserByName(String name);

	/**
	 * 分页获取用户信息
	 * 
	 * @param startId
	 *            起始Id号
	 * @param pageSize
	 *            每一页数量
	 * @return
	 */
	List<UserInfo> loadUserInfoByPage(int startId, int pageSize);

	/**
	 * 获取用户的数量
	 * 
	 * @return
	 */
	long getUserInfoCount();

}
