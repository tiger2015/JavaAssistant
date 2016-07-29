package com.javaassistant.action;

import com.javaassistant.dao.KnowledgeDAO;
import com.javaassistant.model.Knowledge;
import com.opensymphony.xwork2.ActionSupport;

public class LoadKnowledgeByIdAction extends ActionSupport {
	private int id;
	private KnowledgeDAO dao;
	private Knowledge knowledge;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		knowledge = dao.loadKnowledgeById(id);
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public KnowledgeDAO getDao() {
		return dao;
	}

	public void setDao(KnowledgeDAO dao) {
		this.dao = dao;
	}

	public Knowledge getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

}
