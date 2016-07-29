package com.javaassistant.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.javaassistant.dao.KnowledgeDAO;
import com.javaassistant.model.Knowledge;
import com.javaassistant.tools.UUIDTool;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateKnowledgeAction extends ActionSupport {
	private Knowledge knowledge;
	private KnowledgeDAO dao;
	private String imageFileName;
	private File image;
	private String imageContentType;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if (image != null) {
			Knowledge temp = dao.loadKnowledgeById(knowledge.getId());
			String oldPath = ServletActionContext.getServletContext()
					.getRealPath("/");
			// 删除原来的文件
			File oldFile = new File(oldPath, temp.getImageUrl());
			if (oldFile.exists()) {
				oldFile.delete();
			}
            //保存新文件
			String filePath = ServletActionContext.getServletContext()
					.getRealPath("/knowledgeImage");
			String staff = imageFileName.substring(imageFileName
					.lastIndexOf("."));
			String name = UUIDTool.getUUID() + staff;
			File file = new File(filePath, name);
			image.renameTo(file);
			knowledge.setImageUrl("/knowledgeImage/" + name);
		}
		dao.update(knowledge);
		return ActionSupport.SUCCESS;
	}

	public Knowledge getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	public KnowledgeDAO getDao() {
		return dao;
	}

	public void setDao(KnowledgeDAO dao) {
		this.dao = dao;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		// super.validate();
		if (imageFileName != null && imageFileName.trim().length() > 0) {
			String name = imageFileName.trim().toLowerCase();
			if (name.endsWith("png") || name.endsWith("jpeg")
					|| name.endsWith("jpg") || name.endsWith("bmp")) {

			} else {
				this.addFieldError("image", "文件格式不正确！");
				return;
			}
		}

		if (image != null) {
			if (image.length() > 1024 * 1024) {
				this.addFieldError("image", "文件超过1MB！");
			}

		}

	}
}
