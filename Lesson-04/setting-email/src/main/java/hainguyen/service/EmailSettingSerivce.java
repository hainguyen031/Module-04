package hainguyen.service;

import hainguyen.dao.IEmailSettingDao;
import hainguyen.model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSettingSerivce implements IEmailSettingService{
    @Autowired
    private IEmailSettingDao iEmailSettingDao;
@Override
    public Setting getSetting() {
        return this.iEmailSettingDao.getSetting();
    }

@Override
    public void save(Setting setting) {
        this.iEmailSettingDao.save(setting);

    }
}
