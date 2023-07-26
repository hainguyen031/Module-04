package service;

import model.Setting;

public interface IEmailSettingService {
    Setting getSetting();
    void save(Setting setting);
}
