CREATE TABLE t_user
(
  id           BIGINT UNSIGNED  not null AUTO_INCREMENT COMMENT '主键ID',
  uid      char (32)         not null default '' COMMENT '用户ID',
  user_name    varchar (30)      not null default '' COMMENT '登录名',
  password     varchar (30)       not null default '' COMMENT '密码',
  create_time  timestamp                 default CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time  timestamp                 default CURRENT_TIMESTAMP on update current_timestamp COMMENT '更新时间',
  primary key (`id`),
  KEY `IDX_UID` (`uid`) using BTREE,
  KEY `IDX_CREATE_TIME` (`create_time`) using BTREE,
  KEY `IDX_UPDATE_TIME` (`update_time`) using BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '后台用户表';

create table t_member
(
  id bigint unsigned not null auto_increment comment '主键ID',
  member_id   char (32) not null default '' comment '用户ID',
  open_id char (32) not null default '' comment 'openId',
  avatar varchar (100) not null default  '' comment '头像',
  gender tinyint not null default 1 comment '性别',
  phone varchar (11) not null default '' comment '电话',
  nick_name varchar (50) not null default '' comment '昵称',
  birthday date not null default '2002-01-01',
  create_time  timestamp default CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time  timestamp default CURRENT_TIMESTAMP on update current_timestamp COMMENT '更新时间',
  primary key (`id`),
  key `IDX_USER_ID` (`user_id`) using BTREE,
  key `IDX_OPEN_ID` (`open_id`) using BTREE,
  KEY `IDX_CREATE_TIME` (`create_time`) using BTREE,
  KEY `IDX_UPDATE_TIME` (`update_time`) using BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '会员表';

