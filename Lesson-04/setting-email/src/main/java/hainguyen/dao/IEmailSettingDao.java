package hainguyen.dao;

import hainguyen.model.Setting;

public interface IEmailSettingDao {
    Setting getSetting();

    void save(Setting setting);
}
