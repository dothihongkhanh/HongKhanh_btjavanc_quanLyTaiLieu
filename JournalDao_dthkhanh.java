/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTaiLieu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quanlytailieu.Journal_dthkhanh;

/**
 *
 * @author DELL
 */
public class JournalDao_dthkhanh {
    public List<Journal_dthkhanh> getAllUsers() throws SQLException{
        List<Journal_dthkhanh> journals = new ArrayList<Journal_dthkhanh>();

        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();

        String sql = "SELECT * FROM TaiLieu_dthkhanh";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Journal_dthkhanh journal = new Journal_dthkhanh();
                journal.setMaTaiLieu(rs.getInt("MATAILIEU"));
                journal.setTenNhaXuatBan(rs.getString("TENNHAXUATBAN"));
                journal.setSoBanPhatHanh(rs.getInt("SOBANPHATHANH"));
                journal.setSoPhatHanh(rs.getInt("SOPHATHANH"));
                journal.setThangPhatHanh(rs.getString("THANGPHATHANH"));

                journals.add(journal);

            }
        } catch (SQLException e) {
        }
        return journals;

    }
    
    public void addJournal(Journal_dthkhanh journal) throws SQLException {
        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();
        String sql = "INSERT INTO TaiLieu_dthkhanh (TENNHAXUATBAN, SOBANPHATHANH, SOPHATHANH, THANGPHATHANH) VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,journal.getTenNhaXuatBan());
            preparedStatement.setInt(2,journal.getSoBanPhatHanh());
            preparedStatement.setInt(3,journal.getSoPhatHanh());
            preparedStatement.setString(4,journal.getThangPhatHanh());


            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
        }
    }

    public void updateJournal(Journal_dthkhanh journal) throws SQLException {
        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();
        String sql = "UPDATE TaiLieu_dthkhanh SET MATAILIEU = ?, TENNHAXUATBAN = ?, SOBANPHATHANH = ?, "
                + "SOPHATHANH = ?, THANGPHATHANH = ?,";
                
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, journal.getMaTaiLieu());
            preparedStatement.setString(2, journal.getTenNhaXuatBan());
            preparedStatement.setInt(3, journal.getSoBanPhatHanh());
            preparedStatement.setInt(4, journal.getSoPhatHanh());
            preparedStatement.setString(5, journal.getThangPhatHanh());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
        }
    }

    public void deleteJournal(int id) throws SQLException {
        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();

        String sql = "delete from TaiLieu_dthkhanh where MATAILIEU = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
        }
    }
}
