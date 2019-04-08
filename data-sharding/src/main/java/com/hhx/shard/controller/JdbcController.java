package com.hhx.shard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author hhx
 */
@RestController
public class JdbcController {

    @Autowired
    private JdbcTemplate template;

    @GetMapping("/select")
    public ResponseEntity<?> select(String sql){
        return ResponseEntity.ok(template.queryForList(sql));
    }

    @PutMapping("/execute")
    public ResponseEntity<?> execute(String sql){
        template.execute(sql);
        return ResponseEntity.ok().build();
    }

}
