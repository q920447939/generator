/**
 * @Project:
 * @Author: leegoo
 * @Date: 2021年12月29日
 */
package com.baomidou.mybatisplus.generator.samples;

import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import org.jetbrains.annotations.NotNull;

/**
 * ClassName: NameConver
 * @Description:
 * @author leegoo
 * @date 2021年12月29日
 */
public interface NameConvert {
    NameConvert match (ConvertInput input);
    @NotNull
    String entityNameConvert(StrategyConfig strategyConfig,@NotNull TableInfo tableInfo);
    @NotNull
    String propertyNameConvert(StrategyConfig strategyConfig,@NotNull TableField field);
}
