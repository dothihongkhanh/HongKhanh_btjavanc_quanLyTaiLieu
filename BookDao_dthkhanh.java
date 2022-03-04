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
import quanlytailieu.Book_dthkhanh;

/**
 *
 * @author DELL
 */
public class BookDao_dthkhanh {
     public List<Book_dthkhanh> getAllUsers() throws SQLException{
        List<Book_dthkhanh> books = new ArrayList<Book_dthkhanh>();

        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();

        String sql = "SELECT * FROM TaiLieu_dthkhanh";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Book_dthkhanh book = new Book_dthkhanh();
                book.setMaTaiLieu(rs.getInt("MATAILIEU"));
                book.setTenNhaXuatBan(rs.getString("TENNHAXUATBAN"));
                book.setSoBanPhatHanh(rs.getInt("SOBANPHATHANH"));
                book.setTenTacGia(rs.getString("TENTACGIA"));
                book.setSoTrang(rs.getInt("SOTRANG"));
                

                books.add(book);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;

    }
    
    public void addBook(Book_dthkhanh book) throws SQLException {
        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();
        String sql = "INSERT INTO TaiLieu_dthkhanh (TENNHAXUATBAN, SOBANPHATHANH, TENTACGIA, SOTRANG) VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTenNhaXuatBan());
            preparedStatement.setInt(2, book.getSoBanPhatHanh());
            preparedStatement.setString(3, book.getTenTacGia());
            preparedStatement.setInt(4, book.getSoTrang());


            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Book_dthkhanh book) throws SQLException {
        Connection connection = ConnectDB_dthkhanh.getJBDCConnection();
        String sql = "UPDATE TaiLieu_dthkhanh SET MATAILIEU = ?, TENNHAXUATBAN = ?, SOBANPHATHANH = ?, "
                + "TENTACGIA = ? ,SOTRANG = ?" ;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book.getMaTaiLieu());
            preparedStatement.setString(2, book.getTenNhaXuatBan());
            preparedStatement.setInt(3, book.getSoBanPhatHanh());
            preparedStatement.setString(4, book.getTenTacGia());
            preparedStatement.setInt(5, book.getSoTrang());

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int id) throws SQLException {
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
