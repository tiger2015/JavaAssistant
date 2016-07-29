package com.javaassistant.dao;

import java.util.List;

import com.javaassistant.model.Question;

public interface QuestionDAO {

	/**
	 * 保存题目信息
	 * 
	 * @param question
	 *            题目信息
	 * @return true:操作成功，false:操作失败
	 */
	boolean save(Question question);

	/**
	 * 更新题目信息
	 * 
	 * @param question
	 * @return true:操作成功，false:操作失败
	 */
	boolean update(Question question);

	/**
	 * 获取所有的题目
	 * 
	 * @return
	 */
	List<Question> loadAllQuestion();

	/**
	 * 根据Id获取题目信息
	 * 
	 * @param id
	 *            题目的Id
	 * @return
	 */
	Question loadQuestionById(int id);

	/**
	 * 根据类型获取题目
	 * 
	 * @param type
	 *            题目类型
	 * @return
	 */
	List<Question> loadQuestionByType(int type);

	/**
	 * 随机获取某种类型的题目
	 * 
	 * @param type
	 *            题目类型
	 * @param count
	 *            题目数量
	 * @return
	 */
	List<Question> loadQuestionByRandomAndType(int type, int count);

	/**
	 * 获取题目数量
	 * 
	 * @return
	 */
	long getQuestionCount();

	/**
	 * 获取指定类型的题目数量
	 * 
	 * @param type
	 *            题目类型
	 * @return
	 */
	long getQuestionCountByType(int type);

	/**
	 * 根据类型分页获取题目信息
	 * 
	 * @param type
	 *            题目类型
	 * @param startId
	 *            题目起始编号
	 * @param pageSize
	 *            每页数目
	 * @return
	 */
	List<Question> loadQuestionByTypeAndPage(int type, int startId, int pageSize);

	/**
	 * 分页获取题目信息
	 * 
	 * @param startId
	 *            题目起始Id
	 * @param pageSize
	 *            每页题目大小
	 * 
	 * @return
	 */
	List<Question> loadQuestionByPage(int startId, int pageSize);

}
