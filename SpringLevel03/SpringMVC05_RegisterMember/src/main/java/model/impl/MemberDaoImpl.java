package model.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.MemberDao;
import model.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao {

	
	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public void registerMember(MemberVO vo) throws SQLException {
		
		sqlsession.insert("memberMapper.registerMember",vo);
				
	}

	@Override
	public Object idcheck(String id) throws SQLException {
		
		return sqlsession.selectOne("memberMapper.idcheck", id);
	}

	@Override
	public MemberVO login(MemberVO vo) throws SQLException {
		
		return sqlsession.selectOne("memberMapper.login",vo);
	}

	@Override
	public void updateMember(MemberVO vo) throws SQLException {
		sqlsession.update("memberMapper.updateMember",vo);
		
	}

	@Override
	public List<MemberVO> findByAddress(String address) throws SQLException {
		
		return sqlsession.selectList("memberMapper.findByAddress", address);
	}

	@Override
	public List<String> getAddressKind() throws SQLException {
		
		return sqlsession.selectList("memberMapper.getAddressKind");
	}

	@Override
	public List<MemberVO> getAllMember() throws SQLException {
		
		return sqlsession.selectList("memberMapper.getAllMember");
	}
	
}
