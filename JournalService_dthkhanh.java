/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTaiLieu.service;

import QLTaiLieu.dao.BookDao_dthkhanh;
import QLTaiLieu.dao.JournalDao_dthkhanh;
import java.sql.SQLException;
import java.util.List;
import quanlytailieu.Book_dthkhanh;
import quanlytailieu.Journal_dthkhanh;

/**
 *
 * @author DELL
 */
public class JournalService_dthkhanh {
    private JournalDao_dthkhanh journalDao;

    public JournalService_dthkhanh() {
        journalDao = new JournalDao_dthkhanh();
    }

    public List<Journal_dthkhanh> getAllUsers() throws SQLException {
        return journalDao.getAllUsers();
    }

    public void addJournal(Journal_dthkhanh journal) throws SQLException {
        journalDao.addJournal(journal);
    }

    public void deleteJournal(int id) throws SQLException {
        journalDao.deleteJournal(id);
    }
}
