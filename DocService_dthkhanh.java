/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTaiLieu.service;

import QLTaiLieu.dao.DocDao_dthkhanh;
import java.sql.SQLException;
import java.util.List;
import quanlytailieu.Document_dthkhanh;

/**
 *
 * @author DELL
 */
public class DocService_dthkhanh {
    private DocDao_dthkhanh docDao;

    public DocService_dthkhanh() {
        docDao = new DocDao_dthkhanh();
    }

    public List<Document_dthkhanh> getAllUsers() throws SQLException {
        return docDao.getAllUsers();
    }

    public void addDocument(Document_dthkhanh doc) throws SQLException {
        docDao.addDocument(doc);
    }

    public void deleteDocument(int id) throws SQLException {
        docDao.deleteDocument(id);
    }
}
