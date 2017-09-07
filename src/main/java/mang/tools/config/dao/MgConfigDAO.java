package mang.tools.config.dao;

import java.util.List;

import mang.tools.config.entity.MgConfig;

public interface MgConfigDAO {
	public List<MgConfig> queryByClassify(String classify);
	
	public MgConfig queryConfig(String classify,String codeName);
	
	
	public List<MgConfig> queryAllConfig();
}
