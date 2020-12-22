package com.bestbright.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bestbright.common.DatabaseManager;
import com.bestbright.model.Doctor;

public class DoctorDao {
	
	public void saveDoctor(Doctor doc) {
		try {
			Connection con=DatabaseManager.getConnection();
			String sql="insert into doctor(name,phone) values(?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, doc.getName());
			pstmt.setString(2, doc.getPhone());
			pstmt.executeUpdate();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
