package mang.tools.config.dao.impl;

import java.util.List;

import org.hibernate.Query;

import mang.tools.config.dao.MgConfigDAO;
import mang.tools.config.entity.MgConfig;
import mang.tools.config.tools.Constant;

public class MgConfigDAOImpl extends BaseDAOImpl<MgConfig> implements MgConfigDAO {

	@Override
	public List<MgConfig> queryByClassify(String classify) {
		String hql="from MgConfig t where t.classify=:classify and t.enabled=:enabled";
		Query query=this.getSession().createQuery(hql);
		query.setString("classify", classify);
		query.setString("enabled", Constant.enabled);
		List<MgConfig> lis=query.list();
		return lis;
	}

}
