/**
 * @Project:
 * @Author: leegoo
 * @Date: 2022年01月10日
 */
package com.baomidou.mybatisplus.generator.samples.convert;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.generator.config.INameConvert;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.samples.ConvertInput;
import com.baomidou.mybatisplus.generator.samples.NameConvert;
import com.baomidou.mybatisplus.generator.samples.table.TableInfoHandle;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MainFanOfflineAlarmHistoryNameConvert
 * @Description:
 * @author leegoo
 * @date 2022年01月10日
 */
public class MainFanOfflineAlarmHistoryNameConvert implements NameConvert {
    public  static final Map<String,String> MAP = new HashMap<>();
    static {
        MAP.put("a1","id");
        MAP.put("a2","packetName");
        MAP.put("a3","packetId");
        MAP.put("a4","cityCode");
        MAP.put("a5","lineCode");
        MAP.put("a6","station");
        MAP.put("a7","fanCode");
        MAP.put("a8","shaftCode");
        MAP.put("a9","pointCode");
        MAP.put("a10","monitorLocationCode");
        MAP.put("a11","alarmTemperature");
        MAP.put("a12","alarmReferenceTemperature");
        MAP.put("a13","alarmTime");
        MAP.put("a14","rpmStart");
        MAP.put("a15","rpmEnd");
        MAP.put("a16","equalSpeed");
        MAP.put("a17","mileage");
        MAP.put("a18","alarmFlag");
        MAP.put("a19","alarmOutputType");
        MAP.put("a20","alarmType");
        MAP.put("a21","alarmTinyType");
        MAP.put("a22","alarmLevel");
        MAP.put("a23","createTime");
    }

    @Override
    public NameConvert match(ConvertInput input) {
        boolean b = StrUtil.equals(input.getDataBase(), TableInfoHandle.MAN_FAN_DATA_BASE) && StrUtil.equals(input.getTableName(), "tz_table30_2021");
        return b ? this : null;
    }

    @Override
    public @NotNull String entityNameConvert(StrategyConfig strategyConfig, @NotNull TableInfo tableInfo) {
        return "OfflineAlarmHistory";
    }

    @Override
    public @NotNull String propertyNameConvert(StrategyConfig strategyConfig,@NotNull TableField field) {
        String convertName = MAP.get(field.getName());
        return StrUtil.isNotBlank(convertName) ? convertName : new INameConvert.DefaultNameConvert(strategyConfig).propertyNameConvert(field);
    }
}
