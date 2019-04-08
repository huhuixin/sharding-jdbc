package com.hhx.shard.algorithm;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

/**
 * 根据ID分片
 *
 * @author hhx
 */
@Slf4j
public class PreciseShardTable implements PreciseShardingAlgorithm<Long> {

    /**
     * 数据分表
     * @param collection 表名
     * @param preciseShardingValue 分表
     * @return tableName
     */
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        // 计算分到哪个表
        int hash = preciseShardingValue.getValue().intValue()%collection.size();
        String tableName = preciseShardingValue.getLogicTableName() + "_" + hash;
        log.info("{} router to table {}", preciseShardingValue.getValue(), tableName);
        return tableName;
    }
}
