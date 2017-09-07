package mang.tools.config.service;

import java.util.List;
import java.util.Map;

import mang.tools.config.entity.MgConfig;

public interface ConfigService {
	public List<MgConfig> queryConfig(String classify);
	
	public Map<String/*codeName*/,String/*codeValue*/> queryConfigMap(String classify);
	
	
	public String queryConfig(String classify,String codeName);
}
