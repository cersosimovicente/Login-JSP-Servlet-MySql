/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.laboratorioderedes.dao;

import net.laboratorioderedes.bean.LoginBean;

/**
 *
 * @author cerso
 */
public interface LoginDao {

    //Verificacion de usuario.
    String authenticateUser(LoginBean loginBean);

}
