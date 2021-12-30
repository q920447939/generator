/**
 * @Project:
 * @Author: leegoo
 * @Date: 2021年12月29日
 */
package com.baomidou.mybatisplus.generator.samples;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: ConvertInput
 * @Description:
 * @author leegoo
 * @date 2021年12月29日
 */
@Setter
@Getter
@Builder
public class ConvertInput {
    private String dataBase;
    private String tableName;


}
