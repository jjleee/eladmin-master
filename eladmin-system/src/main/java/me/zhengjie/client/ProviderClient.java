package me.zhengjie.client;

import me.zhengjie.modules.data.domain.ProcessData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by forezp on 2019/5/11.
 */
@FeignClient("eladmin-hbase")
public interface ProviderClient {
    /**
     * 查询过程数据
     * @param tableName
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/hi")
    List<ProcessData> hi(@RequestParam(value = "tableName",required = true)String tableName,@RequestParam(value = "start", required = true) String start, @RequestParam(value = "end", required = true) String end);
}


