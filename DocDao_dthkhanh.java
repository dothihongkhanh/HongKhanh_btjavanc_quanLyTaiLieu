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
import quanlytailieu.Document_dthkhanh;

/**
 *
 * @author DELL
 */
public class DocDao_dthkhanh {
    public List<Document_dthkhanh> getAllUsers() throws SQLException{
        List<Document_dthkhanh> documents = new ArrayList<Document_dthkhanh>();

        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();

        String sql = "SELECT * FROM TaiLieu_dthkhanh";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Document_dthkhanh document = new Document_dthkhanh();
                document.setMaTaiLieu(rs.getInt("MATAILIEU"));
                document.setTenNhaXuatBan(rs.getString("TENNHAXUATBAN"));
                document.setSoBanPhatHanh(rs.getInt("SOBANPHATHANH"));

                documents.add(document);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documents;

    }
    
    public void addDocument(Document_dthkhanh document) throws SQLException {
        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();
        String sql = "INSERT INTO TaiLieu_dthkhanh (TENNHAXUATBAN, SOPHATHANH) VALUES(?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, document.getTenNhaXuatBan());
            preparedStatement.setInt(2, document.getSoBanPhatHanh());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDocument(Document_dthkhanh document) throws SQLException {
        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();
        String sql = "UPDATE TaiLieu_dthkhanh SET MATAILIEU = ?, TENNHAXUATBAN = ?, SOBANPHATHANH = ?, "
                + "TENTACGIA = ? ,SOTRANG = ?,"
                + "SOPHATHANH = ?, THANGPHATHANH = ?,"
                + "NGAYPHATHANH = ?" ;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, document.getMaTaiLieu());
            preparedStatement.setString(2, document.getTenNhaXuatBan());
            preparedStatement.setInt(3, document.getSoBanPhatHanh());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDocument(int id) throws SQLException {
        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();

        String sql = "delete from TaiLieu_dthkhanh where MATAILIEU = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
