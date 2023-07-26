package hainguyen.service;

import hainguyen.model.Setting;

public interface IEmailSettingService {
    Setting getSetting();
    void save(Setting setting);
}
