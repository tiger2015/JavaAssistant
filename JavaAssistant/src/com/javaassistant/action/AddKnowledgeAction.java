package com.javaassistant.action;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.javaassistant.dao.KnowledgeDAO;
import com.javaassistant.model.Knowledge;
import com.javaassistant.tools.UUIDTool;
import com.opensymphony.xwork2.ActionSupport;

public class AddKnowledgeAction extends ActionSupport {
	private Knowledge knowledge;
	private KnowledgeDAO dao;
	private String imageFileName;
	private File image;
	private String imageContentType;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(knowledge.getContent());
		System.out.println(imageFileName);
		if (image != null) {
			String filePath = ServletActionContext.getServletContext()
					.getRealPath("/knowledgeImage");
			String staff = imageFileName.substring(imageFileName
					.lastIndexOf("."));
			String name = UUIDTool.getUUID() + staff;
			File file = new File(filePath, name);
			image.renameTo(file);
			knowledge.setImageUrl("/knowledgeImage/" + name);
		}
		dao.save(knowledge);
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

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
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
