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
 * @Description:离线导入记录表
 * @author leegoo
 * @date 2022年01月10日
 */
public class MainFanOfflinePacketImportHistoryNameConvert implements NameConvert {
    public  static final Map<String,String> MAP = new HashMap<>();
    static {
        MAP.put("a1","id");
        MAP.put("a2","packetPath");
        MAP.put("a3","packetName");
        MAP.put("a4","packetId");
        MAP.put("a5","cityCode");
        MAP.put("a6","lineCode");
        MAP.put("a7","station");
        MAP.put("a8","fanCode");
        MAP.put("a9","importStatus");
        MAP.put("a10","curImportResultCode");
        MAP.put("a11","latestCode");
        MAP.put("a12","failCnt");
        MAP.put("a13","createTime");
        MAP.put("a14","updateTime");
    }

    @Override
    public NameConvert match(ConvertInput input) {
        boolean b = StrUtil.equals(input.getDataBase(), TableInfoHandle.MAN_FAN_DATA_BASE) && StrUtil.equals(input.getTableName(), "tz_table31_2021");
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
