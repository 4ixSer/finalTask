package com.entity.users;

import com.entity.Entity;

/**
 * ����� �������� ��� ������������� ������� �������.
 * @author qny4i
 *
 */
public class User extends Entity {
    /**
     * ���� �����. ��� ������ ��� ��. ����� ���������� ��������� � �������.
     *
     */
    private Integer id;

    /**
     * Login �����. ��� ������ � ��. ����� �������� � ��.
     */
    private String login;

    /**
     * password �����. ����������� ������ � ������� ��������� ����������� (������ ��������� - SHA-256; SHA-512 � ��.)
     */
    private String password;

    /**
     * ��� ������������.
     */
    private String name;

    /**
     * Email ������������.
     */
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    //TODO ����������� �������� email ����� ������� �������� ������� [A-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$
    public void setEmail(String email) {
        this.email = email;
    }

    public User() {

    }

    public User( String login, String password, String name, String email) {

        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "id=" + id + ", login=" + login + ", password=" + password + ", name=" + name + ", email=" + email;
    }





}
