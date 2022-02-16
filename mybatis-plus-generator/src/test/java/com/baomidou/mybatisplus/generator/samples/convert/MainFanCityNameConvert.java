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
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MainFanOfflineAlarmHistoryNameConvert
 * @Description:城市表
 * @author leegoo
 * @date 2022年01月10日
 */
public class MainFanCityNameConvert implements NameConvert {
    public  static final Map<String,String> MAP = new HashMap<>();
    static {
        MAP.put("a1","cityId");
        MAP.put("a2","cityCode");
        MAP.put("a3","metroCityCode");
        MAP.put("a4","cityName");
        MAP.put("a5","metroCityName");
        MAP.put("a6","displayIndex");
        MAP.put("a7","isUsed");
        MAP.put("a8","isBlack");
    }

    @Override
    public NameConvert match(ConvertInput input) {
        boolean b = StrUtil.equals(input.getDataBase(), "main_fan") && StrUtil.equals(input.getTableName(), "tz_table1");
        return b ? this : null;
    }

    @Override
    public @NotNull String entityNameConvert(StrategyConfig strategyConfig, @NotNull TableInfo tableInfo) {
        System.out.println("entityNameConvert==>" + tableInfo);
        //return new INameConvert.DefaultNameConvert(strategyConfig).entityNameConvert(tableInfo);
        return "OfflinePacketImportHistory";
    }

    @Override
    public @NotNull String propertyNameConvert(StrategyConfig strategyConfig,@NotNull TableField field) {
        System.out.println("propertyNameConvert==>" + field);
        //return new INameConvert.DefaultNameConvert(strategyConfig).propertyNameConvert(field);
        String convertName = MAP.get(field.getName());
        return StrUtil.isNotBlank(convertName) ? convertName : new INameConvert.DefaultNameConvert(strategyConfig).propertyNameConvert(field);
    }
}
