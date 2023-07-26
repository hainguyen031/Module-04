package dao;

import model.Setting;
import org.springframework.stereotype.Repository;

@Repository
public class EmailSettingDao implements IEmailSettingDao {
    private Setting setting = new Setting();

    @Override
    public Setting getSetting() {
        return setting;
    }

    @Override
    public void save(Setting setting) {
        this.setting = setting;
    }
}
