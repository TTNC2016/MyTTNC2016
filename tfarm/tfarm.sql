
set character_set_client=utf8;
set character_set_connection=utf8;
set character_set_database=utf8;
set character_set_results=utf8;
set character_set_server=utf8;


select * from t_bigclassfy;

delete from t_bigclassfy;
drop database if exists tfarm;--如果tfarm数据库存在就删除
create database tfarm Character Set  UTF8;--设置数据库字符集为utf8
use tfarm;--当前数据库改为他farm;


-- ----------------------------
-- Table structure for `t_accept`
-- ----------------------------
DROP TABLE IF EXISTS `t_accept`;
CREATE TABLE `t_accept` (
  `facc_id` varchar(30) NOT NULL COMMENT '收件地址编号',
  `facc_name` varchar(30) NOT NULL COMMENT '收件人',
  `facc_city` varchar(30) NOT NULL COMMENT '所在地区 湖北武汉  上海',
  `facc_adress` varchar(20) NOT NULL COMMENT '收件地址',
  `facc_telephone` varchar(11) NOT NULL COMMENT '收件人手机号码',
  `facc_tel` varchar(10) DEFAULT NULL COMMENT '固话',
  `facc_email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `facc_othername` varchar(20) DEFAULT NULL COMMENT '收件地址别名',
  PRIMARY KEY (`facc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_accept
-- ----------------------------

-- ----------------------------
-- Table structure for `t_article`
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `fart_id` varchar(30) NOT NULL COMMENT '文章编号',
  `fart_name` varchar(100) NOT NULL COMMENT '文章名称',
  `fart_category` varchar(20) NOT NULL COMMENT '文章分类：绿色故事  试吃报告',
  `fart_comment` varchar(255) NOT NULL COMMENT '文章内容',
  `fart_owner` varchar(20) NOT NULL COMMENT '文章作者',
  `fart_time` datetime NOT NULL COMMENT '文章上传时间',
  `fart_readnum` int(11) NOT NULL DEFAULT '0' COMMENT '阅读人数',
  `fart_likenum` int(11) NOT NULL DEFAULT '0' COMMENT '点赞人数',
  `fart_flag` int(11) DEFAULT '0' COMMENT '  是否展示  默认0不展示  1展示  需要客服人员审核',
  `fart_pic` varchar(255) DEFAULT NULL,
  `fart_bak` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`fart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章信息表';

-- ----------------------------
-- Records of t_article
-- ----------------------------

-- ----------------------------
-- Table structure for `t_bigclassfy`
-- ----------------------------
DROP TABLE IF EXISTS `t_bigclassfy`;
CREATE TABLE `t_bigclassfy` (
  `fbclass_id` varchar(30) NOT NULL COMMENT '大分类编号',
  `fbclass_name` varchar(32) NOT NULL COMMENT '分类名称 名称唯一',
  `fbclass_bak` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`fbclass_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='大分类表 ：干活、鲜货...';

-- ----------------------------
-- Records of t_bigclassfy
-- ----------------------------

-- ----------------------------
-- Table structure for `t_cattle`
-- ----------------------------
DROP TABLE IF EXISTS `t_cattle`;
CREATE TABLE `t_cattle` (
  `fcat_id` varchar(30) NOT NULL COMMENT ' 牛产品编号',
  `fcat_name` varchar(30) NOT NULL COMMENT '肉名称',
  `fcat_total` int(11) NOT NULL COMMENT '总库存',
  `fcat_sellnum` int(11) NOT NULL DEFAULT '0' COMMENT '销量',
  `fcat_price` float NOT NULL COMMENT '销售价格',
  `fres_id` varchar(30) NOT NULL COMMENT '抢购产品id 外键',
  PRIMARY KEY (`fcat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='整牛销售表';

-- ----------------------------
-- Records of t_cattle
-- ----------------------------

-- ----------------------------
-- Table structure for `t_collection`
-- ----------------------------
DROP TABLE IF EXISTS `t_collection`;
CREATE TABLE `t_collection` (
  `fcol_id` varchar(30) NOT NULL COMMENT '产品收藏编号',
  `fpro_id` varchar(30) NOT NULL COMMENT '收藏的产品编号',
  `fuser_id` varchar(30) NOT NULL COMMENT '收藏产品的用户编号',
  `fcol_bak` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`fcol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品收藏表';

-- ----------------------------
-- Records of t_collection
-- ----------------------------

-- ----------------------------
-- Table structure for `t_comment`
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `fcom_id` varchar(30) NOT NULL COMMENT '评论编号',
  `forder_id` varchar(30) NOT NULL COMMENT '评论的订单号',
  `fuser_id` varchar(30) NOT NULL COMMENT '评论用户编号',
  `fcom_level` varchar(10) NOT NULL COMMENT '评论等级： 好 中 差或者星级评定',
  `fcom_title` varchar(50) NOT NULL COMMENT '评论标题',
  `fcom_comtent` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `fcom_likenum` int(11) NOT NULL DEFAULT '0' COMMENT '点赞人数',
  PRIMARY KEY (`fcom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单评论表';

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `t_department`
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `fdepart_id` varchar(30) NOT NULL COMMENT '部门编号,主键唯一',
  `fdepart_name` varchar(20) NOT NULL COMMENT '部门名称 非空',
  `fdepart_bak` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`fdepart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息表';

-- ----------------------------
-- Records of t_department
-- ----------------------------

-- ----------------------------
-- Table structure for `t_discuss`
-- ----------------------------
DROP TABLE IF EXISTS `t_discuss`;
CREATE TABLE `t_discuss` (
  `fdis_id` varchar(30) NOT NULL COMMENT '评论编号',
  `fart_id` varchar(30) NOT NULL COMMENT '评论的文章编号',
  `fuser_id` varchar(30) NOT NULL COMMENT '评论用户的编号',
  `fdis_title` varchar(100) NOT NULL COMMENT '评论标题',
  `fdis_comment` varchar(255) NOT NULL COMMENT '评论内容',
  `fdis_time` datetime NOT NULL COMMENT '评论时间',
  `fdis_bak` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`fdis_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章评论表';

-- ----------------------------
-- Records of t_discuss
-- ----------------------------

-- ----------------------------
-- Table structure for `t_employee`
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `femp_id` varchar(30) NOT NULL COMMENT '员工编号 主键',
  `femp_username` varchar(20) NOT NULL COMMENT '登录账号',
  `femp_password` varchar(20) NOT NULL COMMENT '登录密码',
  `femp_realname` varchar(20) NOT NULL COMMENT '真实姓名',
  `femp_birthday` datetime NOT NULL COMMENT ' 出生日期',
  `femp_idcard` varchar(18) NOT NULL COMMENT '身份证号码',
  `femp_telephone` varchar(11) NOT NULL COMMENT '手机号码',
  `femp_adress` varchar(20) NOT NULL COMMENT '籍贯  省份+市+县',
  `femp_pic` varchar(255) DEFAULT NULL COMMENT '照片',
  `femp_email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `femp_edu` varchar(20) DEFAULT NULL COMMENT '学历',
  `femp_major` varchar(255) DEFAULT NULL COMMENT '专业',
  `femp_school` varchar(255) DEFAULT NULL COMMENT '毕业学校',
  `femp_intime` datetime NOT NULL COMMENT '入职时间',
  `femp_rolename` varchar(30) NOT NULL COMMENT '职位名称',
  `fdepart_id` varchar(30) NOT NULL COMMENT '部门编号 和部门表进行对应',
  `femp_bak` varchar(255) DEFAULT NULL,
  `femp_bak1` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`femp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工信息表';

-- ----------------------------
-- Records of t_employee
-- ----------------------------

-- ----------------------------
-- Table structure for `t_integral`
-- ----------------------------
DROP TABLE IF EXISTS `t_integral`;
CREATE TABLE `t_integral` (
  `fint_id` varchar(30) NOT NULL COMMENT '积分id',
  `fuser_id` varchar(30) NOT NULL COMMENT '用户编号',
  `fint_value` varchar(30) NOT NULL COMMENT '积分加减个数',
  `fint_record` varchar(255) NOT NULL COMMENT '积分变更内容',
  `fint_time` datetime NOT NULL COMMENT '积分变更时间',
  `fint_bak` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`fint_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分记录表';

-- ----------------------------
-- Records of t_integral
-- ----------------------------

-- ----------------------------
-- Table structure for `t_invoice`
-- ----------------------------
DROP TABLE IF EXISTS `t_invoice`;
CREATE TABLE `t_invoice` (
  `finv_id` varchar(30) NOT NULL COMMENT '发票记录编号',
  `forder_id` varchar(30) NOT NULL COMMENT '发票对应的订单id',
  `fuser_id` varchar(30) NOT NULL COMMENT '该发票对应的用户',
  `finv_type` varchar(30) NOT NULL COMMENT '发票类型',
  `finv_state` varchar(20) NOT NULL DEFAULT '增值税普通发票' COMMENT '发票状态审核   提交 开具中  已寄出  已完成',
  `finv_money` float NOT NULL COMMENT '发票金额',
  `finv_bak` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`finv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票记录表';

-- ----------------------------
-- Records of t_invoice
-- ----------------------------

-- ----------------------------
-- Table structure for `t_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `fmes_id` varchar(30) NOT NULL COMMENT '消息编号',
  `fmes_type` varchar(30) NOT NULL COMMENT '消息类型',
  `fmes_sendman` varchar(30) NOT NULL COMMENT '发件人',
  `fuser_acceptman` varchar(30) NOT NULL COMMENT '收件人',
  `fmes_theme` varchar(50) NOT NULL COMMENT '消息主题',
  `fmes_comment` varchar(255) NOT NULL COMMENT '消息内容',
  `fmes_sendtime` datetime NOT NULL COMMENT '发送时间',
  `fmes_bak` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`fmes_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息记录表';

-- ----------------------------
-- Records of t_message
-- ----------------------------

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `forder_id` varchar(30) NOT NULL COMMENT '订单编号',
  `fpro_id` varchar(30) NOT NULL COMMENT '订单产品编号',
  `fuser_id` varchar(30) NOT NULL COMMENT '订单用户编号',
  `forder_num` int(11) NOT NULL COMMENT '订单产品数量',
  `forder_money` float NOT NULL COMMENT '订单产品总价',
  `forder_payway` varchar(20) NOT NULL COMMENT '订单支付方式',
  `forder_time` datetime NOT NULL COMMENT '订单提交时间',
  `finv_name` varchar(30) DEFAULT NULL COMMENT '发票抬头',
  `facc_id` varchar(30) NOT NULL COMMENT '收件人ID',
  `forder_bak` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`forder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单信息表';

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for `t_owner`
-- ----------------------------
DROP TABLE IF EXISTS `t_owner`;
CREATE TABLE `t_owner` (
  `fowner_id` varchar(30) NOT NULL COMMENT '拥有着编号',
  `fowner_name` varchar(20) NOT NULL COMMENT '拥有者姓名',
  `fowner_telephone` varchar(11) NOT NULL COMMENT '拥有着电话号码',
  `fowner_adress` varchar(255) NOT NULL COMMENT '拥有者地址',
  `fowner_bak` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`fowner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品拥有者表 商家';

-- ----------------------------
-- Records of t_owner
-- ----------------------------

-- ----------------------------
-- Table structure for `t_panic`
-- ----------------------------
DROP TABLE IF EXISTS `t_panic`;
CREATE TABLE `t_panic` (
  `fpan_id` varchar(30) NOT NULL COMMENT '抢购产品编号',
  `fpro_id` varchar(30) NOT NULL COMMENT '抢购产品主表id',
  `fpan_starttime` datetime NOT NULL COMMENT '抢购开始时间',
  PRIMARY KEY (`fpan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_panic
-- ----------------------------

-- ----------------------------
-- Table structure for `t_pig`
-- ----------------------------
DROP TABLE IF EXISTS `t_pig`;
CREATE TABLE `t_pig` (
  `fpig_id` varchar(30) NOT NULL COMMENT '整猪销售编号',
  `fpig_name` varchar(30) NOT NULL COMMENT '分产品名称',
  `fpig_total` int(11) NOT NULL COMMENT '总库存',
  `fpig_sellnum` int(11) NOT NULL DEFAULT '0' COMMENT '销量',
  `fpig_price` float NOT NULL COMMENT '价格',
  `fres_id` varchar(255) NOT NULL COMMENT '预购产品id  外键',
  PRIMARY KEY (`fpig_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='整猪销售';

-- ----------------------------
-- Records of t_pig
-- ----------------------------

-- ----------------------------
-- Table structure for `t_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `fpro_id` varchar(30) NOT NULL COMMENT ' 产品编号',
  `fpro_name` varchar(255) NOT NULL COMMENT '产品名称',
  `fpro_weight` varchar(30) NOT NULL COMMENT '产品总量',
  `fpro_total` int(11) NOT NULL,
  `fpro_sellnum` int(11) NOT NULL DEFAULT '0' COMMENT '产品销量',
  `fpro_place` varchar(100) NOT NULL COMMENT '产品产地',
  `fpro_guaranteetime` int(11) NOT NULL COMMENT '保质期',
  `fpro_store` varchar(120) NOT NULL COMMENT '存储条件',
  `fpro_unit` varchar(10) NOT NULL COMMENT '销售单位',
  `fpro_package` varchar(20) NOT NULL COMMENT '包装规格',
  `fpro_advise` varchar(255) DEFAULT NULL COMMENT '食用建议',
  `fpro_note` varchar(255) DEFAULT NULL COMMENT '温馨提示',
  `fpro_ontime` datetime NOT NULL COMMENT '录入时间',
  `fpro_selltime` datetime NOT NULL COMMENT '产品可销售时间',
  `fpro_detail` varchar(255) NOT NULL COMMENT '产品详情',
  `fpro_flag` int(11) NOT NULL DEFAULT '0' COMMENT '是否广告现实 0：不显示',
  `femp_id` varchar(30) NOT NULL COMMENT '上传产品人员id',
  `fowner_id` varchar(30) DEFAULT NULL COMMENT '产品拥有着id',
  `fowner_bak` varchar(255) DEFAULT NULL,
  `fowner_bak1` varchar(255) DEFAULT NULL,
  `fsclass_id` varchar(30) NOT NULL COMMENT ' 产品类别id',
  PRIMARY KEY (`fpro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品主表';

-- ----------------------------
-- Records of t_product
-- ----------------------------

-- ----------------------------
-- Table structure for `t_record`
-- ----------------------------
DROP TABLE IF EXISTS `t_record`;
CREATE TABLE `t_record` (
  `frec_id` varchar(30) NOT NULL COMMENT '操作记录编号',
  `fuser_id` varchar(30) NOT NULL COMMENT '操作用户id',
  `frec_type` varchar(20) NOT NULL COMMENT '操作类型',
  `frec_comment` varchar(255) NOT NULL COMMENT '操作内容',
  `frec_time` datetime NOT NULL COMMENT '操作时间',
  `frec_idadress` varchar(100) DEFAULT NULL COMMENT '公网ip地址',
  PRIMARY KEY (`frec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站后台操作记录表';

-- ----------------------------
-- Records of t_record
-- ----------------------------

-- ----------------------------
-- Table structure for `t_refunds`
-- ----------------------------
DROP TABLE IF EXISTS `t_refunds`;
CREATE TABLE `t_refunds` (
  `fref_id` varchar(30) NOT NULL COMMENT '退货编号',
  `forder_id` varchar(30) NOT NULL DEFAULT '退货订单编号',
  `fuser_id` varchar(30) NOT NULL COMMENT '退货用户编号',
  `fref_reason` varchar(255) NOT NULL COMMENT '退货理由',
  `fref_money` float NOT NULL COMMENT '退货金额',
  `fref_position` varchar(255) DEFAULT '个人账户' COMMENT '退回位置',
  `fref_state` varchar(20) NOT NULL COMMENT '退回状态0:申请中  1：处理核实中 （2:退回申请 3:财务打款中） 4:处理成功',
  `fref_bak` varchar(255) DEFAULT NULL COMMENT '备用',
  PRIMARY KEY (`fref_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_refunds
-- ----------------------------

-- ----------------------------
-- Table structure for `t_reserve`
-- ----------------------------
DROP TABLE IF EXISTS `t_reserve`;
CREATE TABLE `t_reserve` (
  `fres_id` varchar(30) NOT NULL COMMENT '产品预定编号',
  `fpro_id` varchar(30) NOT NULL COMMENT '主表id  外键关联',
  `fres_starttime` datetime NOT NULL COMMENT '开始预定时间  由工作人员确定',
  `fres_endtime` datetime NOT NULL COMMENT '预定截止时间  工作人员设置',
  `fres_mode` int(11) NOT NULL DEFAULT '0' COMMENT '0:普通商品 1:整牛 2：整猪 3：整羊',
  PRIMARY KEY (`fres_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品预定表';

-- ----------------------------
-- Records of t_reserve
-- ----------------------------

-- ----------------------------
-- Table structure for `t_sheep`
-- ----------------------------
DROP TABLE IF EXISTS `t_sheep`;
CREATE TABLE `t_sheep` (
  `fshe_id` varchar(30) NOT NULL COMMENT '整羊销售编号',
  `fshe_name` varchar(30) NOT NULL COMMENT '羊肉分产品名称',
  `fshe_total` int(11) NOT NULL COMMENT '总库存',
  `fshe_sellnum` int(11) NOT NULL DEFAULT '0' COMMENT '销量',
  `fshe_price` float NOT NULL COMMENT '销售价格',
  `fres_id` varchar(30) NOT NULL COMMENT '预购产品id 外键',
  PRIMARY KEY (`fshe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sheep
-- ----------------------------

-- ----------------------------
-- Table structure for `t_smallclassfy`
-- ----------------------------
DROP TABLE IF EXISTS `t_smallclassfy`;
CREATE TABLE `t_smallclassfy` (
  `fsclass_id` varchar(30) NOT NULL COMMENT '小分类id',
  `fslcass_name` varchar(32) NOT NULL COMMENT '小分类名称',
  `fbclass_id` varchar(30) NOT NULL COMMENT '大分类id  外键关系',
  `fsclass_bak` varchar(255) DEFAULT NULL COMMENT '小分类备用字段',
  PRIMARY KEY (`fsclass_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品小分类：手工干货  苹果梨子  青菜';

-- ----------------------------
-- Records of t_smallclassfy
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `tuser_id` varchar(30) NOT NULL COMMENT '用户编号',
  `tuser_username` varchar(30) NOT NULL COMMENT '用户登录账号',
  `tuser_nickname` varchar(30) DEFAULT NULL COMMENT '用户昵称',
  `tuser_password` varchar(30) NOT NULL COMMENT '用户密码',
  `tuser_realname` varchar(10) DEFAULT NULL COMMENT '真实姓名',
  `tuser_idcard` varchar(18) DEFAULT NULL COMMENT '身份证号码',
  `tuser_sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `tuser_hometown` varchar(30) NOT NULL COMMENT '家乡   注册必填 后期无法修改 页面提示',
  `tuser_email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `tuser_birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `tuser_telephone` varchar(11) NOT NULL COMMENT '手机号码',
  `tuser_pic` varchar(100) DEFAULT NULL COMMENT '头像图片地址',
  `tuser_paypass` varchar(30) NOT NULL COMMENT '支付密码',
  `fuser_count` float NOT NULL DEFAULT '0' COMMENT '账户余额',
  `fuser_integral` int(11) NOT NULL DEFAULT '0' COMMENT '账户积分',
  `fuser_bak` varchar(255) DEFAULT NULL COMMENT '备用字段',
  `fuser_bak1` varchar(255) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`tuser_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
