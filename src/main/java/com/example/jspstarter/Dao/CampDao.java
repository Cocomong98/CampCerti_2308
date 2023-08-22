package com.example.jspstarter.Dao;

import com.example.jspstarter.Vo.CampVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CampDao {

    @Autowired
    SqlSession sqlSession;

    public int insertUser(CampVo vo) {
        int result = sqlSession.insert("User.insertUser", vo);
        return result;
    }

    public int updateUser(CampVo vo) {
        int result = sqlSession.update("User.updateUser", vo);
        return result;
    }

    public int deleteUser(CampVo vo) {
        int result = sqlSession.delete("User.deleteUser", vo);
        return result;
    }

    public CampVo getOneUser(int id) {
        CampVo result = sqlSession.selectOne("User.getOneUser", id);
        return result;
    }

    public List<CampVo> getAllUser() {
        List<CampVo> result = sqlSession.selectList("User.getAllUser");
        return result;
    }
}
