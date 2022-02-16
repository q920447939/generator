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
 * @Description:冲击振动温度联合趋势
 * @author leegoo
 * @date 2022年01月10日
 */
public class MainFanOfflineEntiretrendNameConvert implements NameConvert {
    public  static final Map<String,String> MAP = new HashMap<>();
    static {
        MAP.put("a1","id");
        MAP.put("a2","packetId");
        MAP.put("a3","cityCode");
        MAP.put("a4","lineCode");
        MAP.put("a5","station");
        MAP.put("a6","fanCode");
        MAP.put("a7","shaftCode");
        MAP.put("a8","pointCode");
        MAP.put("a9","monitorLocationCode");
        MAP.put("a10","sampleTime");
        MAP.put("a11","rpmStart");
        MAP.put("a12","rpmEnd");
        MAP.put("a13","equalSpeed");
        MAP.put("a14","sampleKilometer");
        MAP.put("a15","sampleType");
        MAP.put("a16","alarmType");
        MAP.put("a17","alarmLocation");
        MAP.put("a18","diagnosticDb");
        MAP.put("a19","regressDb");
        MAP.put("a20","vibrationEigenfactor");
        MAP.put("a21","impactSv");
        MAP.put("a22","dcComponent");
        MAP.put("a23","sampleChannel");
        MAP.put("a24","sampleTrustLevel");
        MAP.put("a25","alarmLevel");
        MAP.put("a26","createTime");
    }

    @Override
    public NameConvert match(ConvertInput input) {
        boolean b = StrUtil.equals(input.getDataBase(), TableInfoHandle.MAN_FAN_DATA_BASE) && StrUtil.equals(input.getTableName(), "tz_table33_2022");
        return b ? this : null;
    }

    @Override
    public @NotNull String entityNameConvert(StrategyConfig strategyConfig, @NotNull TableInfo tableInfo) {
        return "OfflineEntiretrendHistory";
    }

    @Override
    public @NotNull String propertyNameConvert(StrategyConfig strategyConfig,@NotNull TableField field) {
        String convertName = MAP.get(field.getName());
        return StrUtil.isNotBlank(convertName) ? convertName : new INameConvert.DefaultNameConvert(strategyConfig).propertyNameConvert(field);
    }
}
