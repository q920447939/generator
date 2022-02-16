/**
 * @Project:
 * @Author: leegoo
 * @Date: 2022年01月13日
 */
package com.baomidou.mybatisplus.generator.samples.table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * ClassName: TableInfo
 * @Description:
 * @author leegoo
 * @date 2022年01月13日
 */
@Setter
@Getter
@Builder
public class TableInfo {
    private String databaseName;
    private String tableName;
    private String xmlName;

}
