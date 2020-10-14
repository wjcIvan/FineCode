package com.imooc.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.imooc.employee.dao.DepartmentDao;
import com.imooc.employee.domain.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public int findCount() {
		String hql = "select count(*)from Department";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Department> findByPage(int begin,int pageSize) {
		DetachedCriteria critertia = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(critertia, begin, pageSize);
		return list;
	}
	@Override
	public void save(Department department) {
		
		this.getHibernateTemplate().save(department);
	}

	
	//DAO�и�ݲ��ŵ�ID��ѯ���ŵķ���
	@Override
	public Department finById(int did) {
		
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	//DAO���޸Ĳ��ŵķ���
	public void update(Department department) {
		
		this.getHibernateTemplate().update(department);
	}

	@Override
	//DAO��ɾ���ŵķ���
	public void delete(Department department) {

		this.getHibernateTemplate().delete(department);
	}

	//DAO�еĲ�ѯ���в��ŵķ���
	@Override
	public List<Department> findAll() {
		return this.getHibernateTemplate().find("from Department");
	}

	
	
}
