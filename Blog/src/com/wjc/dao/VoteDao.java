package com.wjc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.wjc.form.VoteForm;
import com.wjc.tool.JDBConnection;

public class VoteDao {

	private JDBConnection connection = null;

	public VoteDao() {
		connection = new JDBConnection();
	}

	public boolean operationVote(String operation, VoteForm voteForm) {
		boolean flag = false;
		String sql = null;
		if (operation.equals("ɾ��"))
			sql = "delete from tb_vote where id='" + voteForm.getId() + "'";
		if (operation.equals("���"))
			sql = "insert into tb_vote values('" + voteForm.getVoteName()
					+ "','" + voteForm.getVoteNumber() + "')";
		if (operation.equals("ͶƱ"))
			sql = "update tb_vote set voteNumber=voteNumber+1 where id='"
					+ voteForm.getId() + "'";
		if (connection.executeUpdate(sql))
			flag = true;
		return flag;
	}

	public List queryVoteList() {
		List list = new ArrayList();
		String sql = "select * from tb_vote";
		ResultSet rs = connection.executeQuery(sql);
		VoteForm form = null;
		try {
			while (rs.next()) {
				form = new VoteForm();
				form.setId(Integer.valueOf(rs.getString(1)));
				form.setVoteName(rs.getString(2));
				form.setVoteNumber(Integer.valueOf(rs.getString(3)));
				list.add(form);
			}
		} catch (SQLException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
		return list;

	}


}
