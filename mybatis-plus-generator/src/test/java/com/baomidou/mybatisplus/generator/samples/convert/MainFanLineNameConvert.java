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
 * @Description:线路表
 * @author leegoo
 * @date 2022年01月10日
 */
public class MainFanLineNameConvert implements NameConvert {
    public  static final Map<String,String> MAP = new HashMap<>();
    static {
        MAP.put("a1","id");
        MAP.put("a2","cityCode");
        MAP.put("a3","lineCode");
        MAP.put("a4","metroLineCode");
        MAP.put("a5","lineName");
        MAP.put("a6","metroLineName");
        MAP.put("a7","lineColor");
        MAP.put("a8","sort");
        MAP.put("a9","isEnable");
        MAP.put("a10","createTime");
    }

    @Override
    public NameConvert match(ConvertInput input) {
        boolean b = StrUtil.equals(input.getDataBase(), "main_fan") && StrUtil.equals(input.getTableName(), "tz_table2");
        return b ? this : null;
    }

    @Override
    public @NotNull String entityNameConvert(StrategyConfig strategyConfig, @NotNull TableInfo tableInfo) {
        System.out.println("entityNameConvert==>" + tableInfo);
        //return new INameConvert.DefaultNameConvert(strategyConfig).entityNameConvert(tableInfo);
        return "Line";
    }

    @Override
    public @NotNull String propertyNameConvert(StrategyConfig strategyConfig,@NotNull TableField field) {
        System.out.println("propertyNameConvert==>" + field);
        //return new INameConvert.DefaultNameConvert(strategyConfig).propertyNameConvert(field);
        String convertName = MAP.get(field.getName());
        return StrUtil.isNotBlank(convertName) ? convertName : new INameConvert.DefaultNameConvert(strategyConfig).propertyNameConvert(field);
    }
}
