/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTaiLieu.service;

import QLTaiLieu.dao.BookDao_dthkhanh;
import java.sql.SQLException;
import java.util.List;
import quanlytailieu.Book_dthkhanh;

/**
 *
 * @author DELL
 */
public class BookService_dthkhanh {
    private BookDao_dthkhanh bookDao;

    public BookService_dthkhanh() {
        bookDao = new BookDao_dthkhanh();
    }

    public List<Book_dthkhanh> getAllUsers() throws SQLException {
        return bookDao.getAllUsers();
    }

    public void addBook(Book_dthkhanh book) throws SQLException {
        bookDao.addBook(book);
    }

    public void deleteBook(int id) throws SQLException {
        bookDao.deleteBook(id);
    }
}
