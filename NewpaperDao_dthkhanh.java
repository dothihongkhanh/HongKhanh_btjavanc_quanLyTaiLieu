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
import quanlytailieu.Newpaper_dthkhanh;

/**
 *
 * @author DELL
 */
public class NewpaperDao_dthkhanh {
     public List<Newpaper_dthkhanh> getAllUsers() throws SQLException{
        List<Newpaper_dthkhanh> newpapers = new ArrayList<Newpaper_dthkhanh>();

        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();

        String sql = "SELECT * FROM TaiLieu_dthkhanh";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Newpaper_dthkhanh newpaper = new Newpaper_dthkhanh();
                newpaper.setMaTaiLieu(rs.getInt("MATAILIEU"));
                newpaper.setTenNhaXuatBan(rs.getString("TENNHAXUATBAN"));
                newpaper.setSoBanPhatHanh(rs.getInt("SOBANPHATHANH"));
                newpaper.setNgayPhatHanh(rs.getInt("NGAYPHATHANH"));

                newpapers.add(newpaper);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newpapers;

    }
    
    public void addNewpaper(Newpaper_dthkhanh newpaper) throws SQLException {
        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();
        String sql = "INSERT INTO TaiLieu_dthkhanh ( TENNHAXUATBAN, SOBANPHATHANH, NGAYPHATHANH) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newpaper.getTenNhaXuatBan());
            preparedStatement.setInt(2, newpaper.getSoBanPhatHanh());
            preparedStatement.setInt(3, newpaper.getNgayPhatHanh());


            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateNewpaper(Newpaper_dthkhanh newpaper) throws SQLException {
        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();
        String sql = "UPDATE TaiLieu_dthkhanh SET MATAILIEU = ?, TENNHAXUATBAN = ?, SOBANPHATHANH = ?, "
                + "SOPHATHANH = ?, THANGPHATHANH = ?,";
                
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newpaper.getMaTaiLieu());
            preparedStatement.setString(2, newpaper.getTenNhaXuatBan());
            preparedStatement.setInt(3, newpaper.getSoBanPhatHanh());
            preparedStatement.setInt(4, newpaper.getNgayPhatHanh());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNewpaper(int id) throws SQLException {
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
