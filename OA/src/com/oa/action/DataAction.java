package com.oa.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oa.dao.inf.DataDao;
import com.oa.dao.pojo.TData;

public class DataAction extends BaseAction {
	private TData data;
	private DataDao dataDaoid;
	private int did;
	private int pid;
	private int type;
	private int big;
	private List<Object[]> datalist;
	private Map<Integer, String> maps;
	private String dataname;

	// 添加数据
	public String addData() {
		TData dat = dataDaoid.selectData(big);
		data.setData(dat);
		if(big==0){
			data.setType(type);
		}else{
			if(dat.getType()==1){
				data.setType(2);
			}else if(dat.getType()==3){
				data.setType(4);
			}
		}
		
		boolean bool = dataDaoid.addData(data);
		if (bool) {
			return "addData";
		}
		return ERROR;
	}

	// 删除数据
	public String delData() {
		boolean bool = dataDaoid.deldata(did, pid);
		if (bool) {
			return "delData";
		}
		return ERROR;

	}

	// 修改数据
	public String updataData() {
		// data.s
		TData dat = dataDaoid.selectData(big);
		data.setData(dat);
		System.out.println(type);
		boolean bool = dataDaoid.updatedate(data);

		if (bool) {
			return "updateData";
		}
		return ERROR;

	}

	// 查询所有数据
	public String selectDatas() {

		datalist = dataDaoid.selectDatas(type);
		if (type == 1) {
			return "selectAllDate";
		} else if (type == 3) {
			return "selectAllDate";
		}
		return ERROR;
	}

	// 查询单个数据
	public String selectData() {
		data = dataDaoid.selectData(did);

		big = data.getData().getDataid();

		if (pid != 0) {

			maps = dataDaoid.selectMap(type);
		} else {
			maps = new HashMap<Integer, String>();
			maps.put(0, "父类");
		}
		return "updatedata";
	}

	// 进入添加页面
	public String selectaddData() {
		maps = dataDaoid.selectMap(type);
		return "adddata";

	}

	//AJAX
	public String selectSameName(){
		boolean bool = dataDaoid.selectDelName(dataname, pid);
		String message = null;
		if(bool){
			TData data = dataDaoid.selectNameData(dataname, pid);
			data.setDel(0);
			dataDaoid.updatedate(data);
		}else{
			boolean bool2 = dataDaoid.selectSameName(dataname, pid);
			if(bool2){
				message = "该名字已使用";
			}
		}
		
		
		return NONE;
	}
	public TData getData() {
		return data;
	}

	public void setData(TData data) {
		this.data = data;
	}

	public DataDao getDataDaoid() {
		return dataDaoid;
	}

	public void setDataDaoid(DataDao dataDaoid) {
		this.dataDaoid = dataDaoid;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getBig() {
		return big;
	}

	public void setBig(int big) {
		this.big = big;
	}

	public List<Object[]> getDatalist() {
		return datalist;
	}

	public void setDatalist(List<Object[]> datalist) {
		this.datalist = datalist;
	}

	public Map<Integer, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<Integer, String> maps) {
		this.maps = maps;
	}
}
