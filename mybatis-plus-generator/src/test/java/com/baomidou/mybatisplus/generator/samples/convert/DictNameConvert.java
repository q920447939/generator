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
 * @Description:离线温度记录表
 * @author leegoo
 * @date 2022年01月10日
 */
public class DictNameConvert implements NameConvert {
    public  static final Map<String,String> MAP = new HashMap<>();
    static {
        MAP.put("a1","id");
        MAP.put("a2","type");
        MAP.put("a3","code");
        MAP.put("a4","name");
        MAP.put("a5","value1");
        MAP.put("a6","value2");
        MAP.put("a7","value3");
        MAP.put("a8","status");
        MAP.put("a9","createDate");
    }

    @Override
    public NameConvert match(ConvertInput input) {
        boolean b = StrUtil.equals(input.getDataBase(), TableInfoHandle.TZ450_DATA1) && StrUtil.equals(input.getTableName(), "tz_table53");
        return b ? this : null;
    }

    @Override
    public @NotNull String entityNameConvert(StrategyConfig strategyConfig, @NotNull TableInfo tableInfo) {
        return "SysDict";
    }

    @Override
    public @NotNull String propertyNameConvert(StrategyConfig strategyConfig,@NotNull TableField field) {
        String convertName = MAP.get(field.getName());
        return StrUtil.isNotBlank(convertName) ? convertName : new INameConvert.DefaultNameConvert(strategyConfig).propertyNameConvert(field);
    }
}
