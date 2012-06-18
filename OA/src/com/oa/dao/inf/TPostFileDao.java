package com.oa.dao.inf;
import java.util.List;
import com.oa.dao.pojo.TPostFile;

public interface TPostFileDao {
	/*
	 * 公告文件的增加、通过Id删除、查看文件列表
	 */
	public boolean addPostFile(TPostFile tPostFile);
	public boolean deletePostFile(int id);
	public List<TPostFile> selectTPostFiles(int postId);
	public TPostFile selectSingleTPostFile(int id);
	public List findAll();
}
