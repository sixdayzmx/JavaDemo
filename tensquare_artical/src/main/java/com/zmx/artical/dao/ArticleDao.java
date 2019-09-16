package com.zmx.artical.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zmx.artical.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{

    /**
     * 所有可能产生线程的问题的sql语句都要加上@Modifying
     */
    @Modifying
    @Transactional
    @Query(value="update tb_article set state=1 where id=?",nativeQuery = true)
    public void updateState(String id);

    @Modifying
    @Transactional
    @Query(value="update tb_article set thumbup=thumbup+1 where id=?",nativeQuery = true)
    public void addThumbup(String id);
}
