create schema `shard` default character set utf8mb4 ;

create schema `shard_0` default character set utf8mb4 ;

create schema `shard_1` default character set utf8mb4 ;

create table `user` (
  `id` bigint(11) not null,
  `name` varchar(30) not null,
  `card` char(23) not null,
  primary key (`id`),
  unique (`card`)
) engine=InnoDB default charset=utf8mb4;


create table `user_0` (
  `id` bigint(11) not null,
  `name` varchar(30) not null,
  `card` char(23) not null,
  primary key (`id`),
  unique (`card`)
) engine=InnoDB default charset=utf8mb4;

create table `user_1` (
  `id` bigint(11) not null,
  `name` varchar(30) not null,
  `card` char(23) not null,
  primary key (`id`),
  unique (`card`)
) engine=InnoDB default charset=utf8mb4;

create table `order` (
  `id` bigint(11) not null,
  `order_number` varchar(30) not null,
  `user_id` bigint(11) not null,
  `price` bigint(11) not null,
  primary key (`id`),
  unique (`order_number`),
  key 'user_id' (`user_id`)
) engine=InnoDB default charset=utf8mb4;