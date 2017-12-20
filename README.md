# financing
#### 背景
计算机课设，同时复习整理框架知识。
#### 系统介绍
1. 基于ssm的个人理财小系统
1. 基本功能
  + a)记一笔：记录消费记录以及收入记录
  + b)财务管理，通过消费以及收入记录做出数据统计，月以及年统计，给用户最直观的数据
  + c)心愿单：在系统内记录想购买的物品
3. 系统模块划分
  + a)用户管理模块：包括用户登录、登出、修改密码
  + b)财务数据管理：收入与支出的数据的录入、月和年收支情况的图表显示
  + c）标注：用到的第三方插件有，日期插件、图表显示插件(推荐用 [Hightcharts](https://www.hcharts.cn/demo/highcharts))

4. ##### 扩展功能：
  + a)邮箱验证：给用户发邮件提醒月收支情况
  + b)提醒功能：在心愿单设置到期 提醒功能
  + c)分享到微信：至于要分享什么，到时候在想
  + d)可以用第三方社交id登录系统：比如微信、qq等

5. ### 数据库设计
  ```create database financing;
  use finacing;
  a)用户表
      create table user(
      id int not null primary key auto_increment comment '用户id主键',
      username varchar(255) not null comment '用户名',
      password varchar(50) not null comment '密码',
      email varchar(100) comment '邮箱'
      )Engine=Innodb default charset=utf8;
      
  b)消费类别表
      create table spend_category(
        id int not null primary key auto_increment comment '主键',
        name varchar(100) not null comment '类别名称'
      )engine InnoDB default charset=utf8;
      
  c)消费记录表
    create table spend_record(
      id int not null primary key auto_increment,
      spendnum int not null comment '消费金额',
      date Date not null comment '消费日期',
      s_comment varchar(255) comment '消费备注',
      user_id int,
      s_category_id,
      foreign key (user_id) references user(id),
      foreign key (s_category_id) references spend_category(id)
      )Engine=InnoDB default charset=utf8;
      
   d) 收入类别表
      create table income_category(
        id int not null primary key auto_increment,
        name varchar(255) not null comment '收入分类名'
      )Engine=Innodb default charset=utf8;
      
   e)收入记录表
    create table income_record(
    id int not null primary key auto_increment,
    incomenum int not null comment '收入金额',
    i_comment varchar(255) comment '输入备注',
    date Date not null,
    user_id int comment '属于哪个用户',
    i_category_id int comment '属于哪个收入类型',
    foreign key (user_id) references user(id),
    foreign key (i_category_id) references income_category(id)
    )Engine=InnoDB default charset=utf8;
    
  f)月消费记录表
  create table month_spend_record(
    id int not null primary key auto_increment,
    totalnum int not null comment '月消费总额',
    date Date not null,
    s_category_id int comment '消费类别',
    user_id int comment '属于哪个用户',
    foreign key (s_category_id) references spend_category(id),
    foreign key (user_id) references user(id)
   )Engine=InnoDB default charset=utf8;
   
   g)年消费记录表
   create table year_spend_record(
    id int not null primary key auto_increment,
    totalnum int not null comment '年消费总额',
    date Date not null,
    s_category_id int comment '消费类别',
    user_id int comment '属于哪个用户',
    foreign key (s_category_id) references spend_category(id),
    foreign key (user_id) references user(id)
   )Engine=InnoDB default charset=utf8;
   
  h)年收入记录表
  create table year_income_record(
  id int not null primary key auto_increment,
  totalnum int not null comment '年收入总额',
  date Date not null,
  i_category_id int comment '收入类别',
  user_id int comment '属于哪个用户',
  foreign key (i_category_id) references income_category(id),
  foreign key (user_id) references user(id)
  )Engine=InnoDB default charset=utf8;
  
 i)心愿单表
 create table wishlist(
  id int not null primary key auto_increment,
  w_comment varchar(255) comment '心愿单说明',
  date Date not null,
  user_id int not null,
  foreign key (user_id) references user(id)
  )engine=InnoDb default charset=utf8;```
