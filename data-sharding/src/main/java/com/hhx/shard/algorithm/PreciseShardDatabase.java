package com.hhx.shard.algorithm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * 根据ID分片
 *
 * @author hhx
 */
@Slf4j
public class PreciseShardDatabase implements PreciseShardingAlgorithm<Long> {

    @Autowired
    private ObjectMapper mapper;

    /**
     * 数据分库
     * @param collection 数据库名
     * @param preciseShardingValue 分库策略
     * @return
     */
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        // 要求分库的数量必须能够被1024整除
        // 先将数据分成1024份
        // 根据分库的数量计算出每个库的区间, 判断在不在这个区间即可
        int hash = preciseShardingValue.getValue().intValue()%1024;
        int range = 1024/collection.size();
        // 计算出应该分到的数据库下标 hash/range
        String databaseName = preciseShardingValue.getLogicTableName() + "_" + hash/range;
        log.info("{} router to database {}", preciseShardingValue.getValue(), databaseName);
        return databaseName;
    }
}
