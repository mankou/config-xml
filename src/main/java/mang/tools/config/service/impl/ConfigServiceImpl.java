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
		Map<String,String> map=new HashMap<String, String>();
		List<MgConfig> lis=mgConfigDAO.queryByClassify(classify);
		
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
