package com.omp.dictionary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.omp.dictionary.domain.VideoDM;
import com.omp.util.ConnectionPool;
import com.omp.util.JdbcUtil;

public class VideoDAO {
	// 동영상 등록
	public void insertVideo (VideoDM video) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into t97_video(no, title, video_org_name, "
					+ "video_system_name, video_path, video_size, nick_name) ");
			sql.append("values(s_video_no.nextval, ?, ?, ?, ?, ?, ?)");
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, video.getTitle());
			stmt.setString(2, video.getVideoOrgName());
			stmt.setString(3, video.getVideoSystemName());
			stmt.setString(4, video.getVideoPath());
			stmt.setLong(5, video.getVideoSize());
			stmt.setString(6, video.getNick_name());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	// 동영상 보여주기
	public List<VideoDM> videoList () {
		Connection con = null;
		PreparedStatement stmt = null;
		List<VideoDM> list = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from t97_video ");
			sql.append(" order by no desc ");
			stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				VideoDM video = new VideoDM();
				video.setNo(rs.getInt("no"));
				video.setTitle(rs.getString("title"));
				video.setVideoOrgName(rs.getString("video_org_name"));
				video.setVideoSystemName(rs.getString("video_system_name"));
				video.setVideoPath(rs.getString("video_path"));
				video.setVideoSize(rs.getLong("video_size"));
				video.setNick_name(rs.getString("nick_name"));
				list.add(video);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	
	// 동영상 삭제
	public void deleteVideo(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete t97_video ");
			sql.append(" where no = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
}
