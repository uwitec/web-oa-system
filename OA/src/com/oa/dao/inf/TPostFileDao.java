package com.oa.dao.inf;
import java.util.List;
import com.oa.dao.pojo.TPostFile;

public interface TPostFileDao {
	/*
	 * �����ļ������ӡ�ͨ��Idɾ�����鿴�ļ��б�
	 */
	public boolean addPostFile(TPostFile tPostFile);
	public boolean deletePostFile(int id);
	public List<TPostFile> selectTPostFiles(int postId);
	public TPostFile selectSingleTPostFile(int id);
	public List findAll();
}
