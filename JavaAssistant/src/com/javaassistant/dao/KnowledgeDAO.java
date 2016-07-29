package com.javaassistant.dao;

import java.util.List;

import com.javaassistant.model.Knowledge;

public interface KnowledgeDAO {
	/**
	 * 保存知识点信息
	 * 
	 * @param knowledge
	 * @return true---操作成功 false---操作失败
	 */
	boolean save(Knowledge knowledge);

	/**
	 * 更新知识点信息
	 * 
	 * @param knowledge
	 * @return true:操作成功 false:操作失败
	 */
	boolean update(Knowledge knowledge);

	/**
	 * 加载所有的知识点信息
	 * 
	 * @return
	 */
	List<Knowledge> loadAllKnowledge();

	/**
	 * 根据Id获取知识点信息
	 * 
	 * @param id
	 *            知识点Id
	 * @return
	 */
	Knowledge loadKnowledgeById(int id);

	/**
	 * 根据知识点类型获取知识点信息
	 * 
	 * @param type
	 *            知识点类型
	 * @return
	 */
	List<Knowledge> loadKnowledgeByType(int type);

	/**
	 * 分页得到知识点信息
	 * 
	 * @param startId
	 *            知识点起始Id
	 * @param pageSize
	 *            每页的大小
	 * @return
	 */
	List<Knowledge> loadKnowledgeByPage(int startId, int pageSize);

	/**
	 * 获取记录条数
	 * 
	 * @return
	 */
	long getKnowledgeCount();

	/**
	 * 根据类型获取记录条数
	 * 
	 * @param type
	 *            知识点类型
	 * @return
	 */
	long getKnowledgeCountByType(int type);
}
