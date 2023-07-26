package dao;

import model.Setting;

public interface IEmailSettingDao {
    Setting getSetting();

    void save(Setting setting);
}
