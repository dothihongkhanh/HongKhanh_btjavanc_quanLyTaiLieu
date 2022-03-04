/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTaiLieu.service;

import QLTaiLieu.dao.NewpaperDao_dthkhanh;
import java.sql.SQLException;
import java.util.List;
import quanlytailieu.Journal_dthkhanh;
import quanlytailieu.Newpaper_dthkhanh;

/**
 *
 * @author DELL
 */
public class NewpaperService_dthkhanh {
   private NewpaperDao_dthkhanh newpaperDao;

    public NewpaperService_dthkhanh() {
        newpaperDao = new NewpaperDao_dthkhanh();
    }

    public List<Newpaper_dthkhanh> getAllUsers() throws SQLException {
        return newpaperDao.getAllUsers();
    }

    public void addNewpaper(Newpaper_dthkhanh newpaper) throws SQLException {
        newpaperDao.addNewpaper(newpaper);
    }

    public void deleteNewpaper(int id) throws SQLException {
        newpaperDao.deleteNewpaper(id);
    }

    
}
