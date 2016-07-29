package com.javaassistant.action;

import java.util.List;

import com.javaassistant.dao.KnowledgeDAO;
import com.javaassistant.model.Knowledge;
import com.opensymphony.xwork2.ActionSupport;

public class LoadKnowledgeAction extends ActionSupport {
	private KnowledgeDAO dao;
	private List<Knowledge> list;
	private int pageCount = 1;
	private int id;
	private int pageSize = 15;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
        if(this.id<0){
        	id=0;
        }
        long count = dao.getKnowledgeCount();
        pageCount = (int) (count % pageSize == 0 ? count / pageSize : count
				/ pageSize + 1);
        if(this.id>=count){
        	this.id=(pageCount-1)*pageSize;
        }
		list = dao.loadKnowledgeByPage(id, pageSize);
		return ActionSupport.SUCCESS;
	}

	public KnowledgeDAO getDao() {
		return dao;
	}

	public void setDao(KnowledgeDAO dao) {
		this.dao = dao;
	}

	public List<Knowledge> getList() {
		return list;
	}

	public void setList(List<Knowledge> list) {
		this.list = list;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
