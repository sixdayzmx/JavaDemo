package com.zmx.recruit.dao;

import com.zmx.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{

    //也可以使用specification那就麻烦多了，但原理是一样的。
    public List<Recruit> findTop6ByState(String state); //where state=? order by createTime
    public List<Recruit> findTop6ByStateNot(String state); //where state!=? order by createTime
	
}
