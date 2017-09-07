package mang.tools.config.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import mang.tools.config.dao.MgConfigDAO;
import mang.tools.config.entity.MgConfig;
import mang.tools.config.service.ConfigService;

@Transactional
public class ConfigServiceImpl implements ConfigService {

	private MgConfigDAO mgConfigDAO;
	
	@Override
	public List<MgConfig> queryConfig(String classify) {
		List<MgConfig> lis=mgConfigDAO.queryByClassify(classify);
		return lis;
	}
	


	@Override
	public Map<String, String> queryConfigMap(String classify) {
		List<MgConfig> lis=mgConfigDAO.queryByClassify(classify);
		Map<String,String> map=this.list2Map(lis);
		return map;
	}
	
	@Override
	public List<MgConfig> queryAllConfig(String classify) {
		List<MgConfig> list=mgConfigDAO.queryAllConfig();
		return list;
	}



	@Override
	public Map<String, String> queryAllConfigMap(String classify) {
		List<MgConfig> lis=mgConfigDAO.queryAllConfig();
		Map<String,String> map=this.list2Map(lis);
		return map;
	}
	
	
	private Map<String,String> list2Map(List<MgConfig> lis){
		Map<String,String> map=new HashMap<String, String>();
		if(lis!=null && lis.size()>0){
			for(MgConfig mgConfig:lis){
				String codeName=mgConfig.getCodeName();
				String codeValue=mgConfig.getCodeValue();
				map.put(codeName, codeValue);
			}
		}
		return map;
		
	}
	

	@Override
	public String queryConfig(String classify, String codeName) {
		MgConfig config=mgConfigDAO.queryConfig(classify, codeName);
		if(config!=null){
			return config.getCodeValue();
		}
		return null;
	}
	
	public MgConfigDAO getMgConfigDAO() {
		return mgConfigDAO;
	}
	public void setMgConfigDAO(MgConfigDAO mgConfigDAO) {
		this.mgConfigDAO = mgConfigDAO;
	}





}
