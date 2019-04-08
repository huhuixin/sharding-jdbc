package com.hhx.shard.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hhx.shard.entity.User;
import com.hhx.shard.service.IUserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制
 *
 * @author hhx
 */
@RestController
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping("/user/page")
    public ResponseEntity<IPage<User>> getPage(int number, int size){
        return ResponseEntity.ok(service.getPage(number, size));
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getOne(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/user")
    public ResponseEntity<?> add(@RequestBody User user){
        user.setCard(RandomStringUtils.randomNumeric(23));
        user.setName(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(3, 8)));
        return ResponseEntity.ok(service.save(user));
    }

    @PutMapping("/user")
    public ResponseEntity<?> update(@RequestBody User user){
        assert user.getId() != null;
        return ResponseEntity.ok(service.saveOrUpdate(user));
    }
}
