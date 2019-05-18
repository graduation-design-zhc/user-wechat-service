create table `t_user`
(
  id           BIGINT UNSIGNED not null AUTO_INCREMENT comment '主键ID',
  uid      char (32) not null default '' comment '用户ID',
  user_name    varchar (30) not null default '' comment '登录名',
  password     varchar (30) not null default '' comment '密码',
  create_time  timestamp default current_timestamp comment '创建时间',
  update_time  timestamp default current_timestamp on update current_timestamp comment '更新时间',
  primary key (`id`),
  KEY `IDX_UID` (`uid`) using BTREE,
  KEY `IDX_CREATE_TIME` (`create_time`) using BTREE,
  KEY `IDX_UPDATE_TIME` (`update_time`) using BTREE
) ENGINE = InnoDB
  DEFAULT charset = utf8 comment '后台用户表';

create table `t_member`
(
  id bigint unsigned not null auto_increment comment '主键ID',
  member_id   char (32) not null default '' comment '会员ID',
  open_id char (32) not null default '' comment 'openId',
  avatar varchar (612) not null default  '' comment '头像',
  gender tinyint not null default 1 comment '性别',
  phone varchar (11) not null default '' comment '电话',
  nickname varchar(255) character set utf8mb4 collate utf8mb4_unicode_ci not null default '' COMMENT '昵称',
  birthday date not null default '2002-01-01',
  create_time  timestamp default current_timestamp comment '创建时间',
  update_time  timestamp default current_timestamp on update current_timestamp comment '更新时间',
  primary key (`id`),
  key `IDX_USER_ID` (`user_id`) using BTREE,
  key `IDX_OPEN_ID` (`open_id`) using BTREE,
  key `IDX_CREATE_TIME` (`create_time`) using BTREE,
  key `IDX_UPDATE_TIME` (`update_time`) using BTREE
) ENGINE = InnoDBÒ
  DEFAULT charset = utf8 comment '会员表';

create table `product_category` (
    id bigint unsigned not null auto_increment comment '主键ID',
    category_id char (32) not null default '' comment '类目id',
    category_name varchar(64) not null comment '类目名字',
    category_type int not null default 0 comment '类目编号',
    create_time timestamp not null default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (`id`),
    key `IDX_CATEGORY_ID`(`category_id`) using BTREE,
    key `IDX_CATEGORY_TYPE`(`category_type`) using BTREE
) ENGINE = InnoDB
  DEFAULT charset = utf8 comment '商品类目表';

create table `product_info` (
    id bigint unsigned not null auto_increment comment '主键ID',
    product_id char (32) not null default '' comment '商品id',
    product_name varchar(64) not null default '' comment '商品名称',
    product_price decimal(8,2) not null default 0.0 comment '单价',
    product_stock int not null default 0 comment '库存',
    product_description varchar(64) default '' comment '描述',
    product_img varchar(512) not null default '' comment '小图',
    product_status tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
    category_type int not null default 0 comment '类目编号',
    create_time timestamp not null default current_timestamp comment '创建时间',
    update_time timestamp not null default current_timestamp on update current_timestamp comment '更新时间',
    primary key (`id`),
    key `IDX_PRODUCT_ID`(`product_id`) using BTREE,
    key `IDX_CATEGORY_TYPE` (`category_type`) USING BTREE
) ENGINE = InnoDB
  DEFAULT charset = utf8 comment '商品信息表';

create table `t_order`
(
  id bigint unsigned not null auto_increment comment '主键ID',
  order_id varchar(32) not null default '' comment '订单id',
  member_id   char (32) not null default '' comment '会员id',
  buyer_name varchar(32) not null comment '买家名字',
  buyer_phone varchar(32) not null comment '买家电话',
  buyer_openid varchar(64) not null comment '买家微信openid',
  pay_type tinyint(3) not null DEFAULT 1 COMMENT '支付方式,0会员卡支付，1 现金支付',
  order_price decimal(8,2) not null default 0.0 comment '订单总价',
  order_integral double not null default 0 comment '订单积分',
  operator varchar(32) not null default '' comment '操作人',
  create_time timestamp not null default current_timestamp comment '创建时间',
  update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`),
  key `IDX_MEMBER_ID`(`member_id`) using BTREE,
  key `IDX_ORDER_ID`(`order_id`) using BTREE,
  key `IDX_BUYER_PHONE`(`buyer_phone`) using BTREE,
  KEY `IDX_CREATE_TIME` (`create_time`) using BTREE,
  KEY `IDX_UPDATE_TIME` (`update_time`) using BTREE
) ENGINE = InnoDB
  DEFAULT charset = utf8 comment '订单表';

create table `t_order_detail`
(
  id bigint unsigned not null auto_increment comment '主键ID',
  order_id varchar(32) not null default '' comment '订单id',
  product_id char (32) not null default '' comment '商品id',
  product_name varchar(64) not null default '' comment '商品名称',
  product_price decimal(8,2) not null default 0.0 comment '单价',
  product_count int not null default 0 comment '商品数量',
  create_time timestamp not null default current_timestamp comment '创建时间',
  update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`),
  key `IDX_ORDER_ID`(`order_id`) using BTREE,
  KEY `IDX_CREATE_TIME` (`create_time`) using BTREE,
  KEY `IDX_UPDATE_TIME` (`update_time`) using BTREE
) ENGINE = InnoDB
  DEFAULT charset = utf8 comment '订单商品详情表';

create table `t_member_card` (
  id bigint unsigned not null auto_increment comment '主键ID',
  member_card_id char (32) not null default '' comment '会员卡id',
  member_id   char (32) not null default '' comment '会员id',
  member_balance decimal(8,2) not null default 0.0 comment '会员卡余额',
  member_integral double not null default 0 comment '会员积分',
  create_time timestamp not null default current_timestamp comment '创建时间',
  update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`),
  key `IDX_MEMBER_ID`(`member_id`) using BTREE,
  key `IDX_MEMBER_CARD_ID`(`member_card_id`) using BTREE,
  KEY `IDX_CREATE_TIME` (`create_time`) using BTREE,
  KEY `IDX_UPDATE_TIME` (`update_time`) using BTREE
) ENGINE = InnoDB
  DEFAULT charset = utf8 comment '会员卡';

create table `t_member_card_log` (
  id bigint unsigned not null auto_increment comment '主键ID',
  member_card_id char (32) not null default '' comment '会员卡id',
  member_id   char (32) not null default '' comment '会员id',
  add_balance decimal(8,2) not null default 0.0 comment '充值金额',
  operator varchar(32) not null default '' comment '操作人',
  create_time timestamp not null default current_timestamp comment '创建时间',
  update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`),
  key `IDX_MEMBER_ID`(`member_id`) using BTREE,
  KEY `IDX_CREATE_TIME` (`create_time`) using BTREE,
  KEY `IDX_UPDATE_TIME` (`update_time`) using BTREE
) ENGINE = InnoDB
  DEFAULT charset = utf8 comment '会员卡充值记录';