package com.entity.users;

/**
 * Класс Админ наделенный дополнительными возможностями для работы.
 * Наследуют все поля USER.
 * @author qny4ix
 *
 */
public class Admin extends User {

    @Override
    public String toString() {
        return "Admin ["+super.toString()+"]";
    }
    //TODO придумать методы для его работы
}
