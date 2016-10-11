/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.32 : Database - xqb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xqb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `xqb`;

/*Table structure for table `b_banner` */

DROP TABLE IF EXISTS `b_banner`;

CREATE TABLE `b_banner` (
  `id` varchar(32) NOT NULL,
  `img_url` varchar(200) DEFAULT NULL COMMENT 'bannner图url',
  `flag` int(2) DEFAULT NULL COMMENT '标识',
  `param` varchar(200) DEFAULT NULL COMMENT '参数，专题id/帖子id/h5页面url',
  `create_date` datetime DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  `del_status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `b_banner` */

insert  into `b_banner`(`id`,`img_url`,`flag`,`param`,`create_date`,`upd_date`,`del_status`) values ('29d0cdbf659740b598939948a835f5ca','http://qiniuweb.beizhiyuan.com.cn/1476067858514',1,'37a6cc329f40427eafae662e5f17f29c','2016-10-10 10:51:03','2016-10-10 10:51:03',0),('ed089f94e57b4728b0c422014dc943f5','http://qiniuweb.beizhiyuan.com.cn/1476068044211',0,'http://192.168.3.110:8066/api/res/info?id=803a4df12d2c49f0b1a303cde43b9f25','2016-10-10 10:54:06','2016-10-10 10:54:06',0);

/*Table structure for table `n_notice` */

DROP TABLE IF EXISTS `n_notice`;

CREATE TABLE `n_notice` (
  `id` varchar(32) NOT NULL,
  `title` varchar(200) DEFAULT NULL COMMENT '消息标题',
  `profile` varchar(200) DEFAULT NULL COMMENT '简介',
  `detail_url` varchar(200) DEFAULT NULL COMMENT '详情页链接',
  `content` text COMMENT '详情页内容',
  `category` int(2) DEFAULT NULL COMMENT '类型0：普通1：有详情页',
  `del_status` int(2) DEFAULT NULL COMMENT '0正常1删除',
  `create_date` datetime DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `n_notice` */

insert  into `n_notice`(`id`,`title`,`profile`,`detail_url`,`content`,`category`,`del_status`,`create_date`,`upd_date`) values ('624afaa352f54089a532f10d5c8668bb','测试22','放到了萨芬就撒附件三',NULL,NULL,0,0,'2016-09-26 11:00:07','2016-09-26 11:00:07'),('783a8897ab8945d083349bb8074bdf16','测试333','法法师法范德萨发',NULL,'<p>这是一个详情页的东东<img src=\"http://qiniuweb.beizhiyuan.com.cn/Fg1vVJGlcBtUIvOlARK_Bpc04vnO\"/></p>',1,0,'2016-09-26 11:00:54','2016-09-26 11:00:54');

/*Table structure for table `n_user_notice` */

DROP TABLE IF EXISTS `n_user_notice`;

CREATE TABLE `n_user_notice` (
  `id` varchar(32) NOT NULL,
  `user_account` varchar(100) DEFAULT NULL,
  `notice_id` varchar(32) DEFAULT NULL,
  `read_status` int(2) DEFAULT NULL COMMENT '0未读1已读',
  `create_date` datetime DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  `del_status` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `n_user_notice` */

insert  into `n_user_notice`(`id`,`user_account`,`notice_id`,`read_status`,`create_date`,`upd_date`,`del_status`) values ('dff8b11c468244aebf009a897c3beab5','18035147802','783a8897ab8945d083349bb8074bdf16',0,'2016-09-28 15:36:12','2016-09-28 15:36:12','0000-00-00 00:00:00'),('a3faf82da37e476192391e2beccdf33e','18035147802','783a8897ab8945d083349bb8074bdf16',1,'2016-09-28 15:36:13','2016-09-28 16:00:13','0000-00-00 00:00:00');

/*Table structure for table `r_res_info` */

DROP TABLE IF EXISTS `r_res_info`;

CREATE TABLE `r_res_info` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标题',
  `profiles` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '简介',
  `res_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '资源url',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin COMMENT '内容',
  `res_type` int(2) DEFAULT NULL COMMENT '类型0：视频1：音频2：照片',
  `sorts` int(2) DEFAULT NULL COMMENT '分类',
  `thumb_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '缩略图url',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `upd_date` datetime DEFAULT NULL COMMENT '修改时间',
  `del_status` int(2) DEFAULT NULL COMMENT '删除状态1：删除',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `r_res_info` */

insert  into `r_res_info`(`id`,`title`,`profiles`,`res_url`,`content`,`res_type`,`sorts`,`thumb_url`,`create_date`,`upd_date`,`del_status`) values ('0278ad267af94628a1fcd969c0ab0d1c','dd','dkk','http://qiniuweb.beizhiyuan.com.cn/1473065173808','<p>ccc</p>',1,0,'http://qiniuweb.beizhiyuan.com.cn/1473065176783','2016-09-05 16:46:20','2016-09-05 16:46:20',0),('4007db6e5334434a980799abc84141dd','eeeee','eee','http://qiniuweb.beizhiyuan.com.cn/1473065192058','<p>ee</p>',2,1,'http://qiniuweb.beizhiyuan.com.cn/1473065194318','2016-09-05 16:46:36','2016-09-05 16:46:36',0),('4844b51b65ba441a8e78a48d59004d6e','eeer4gggg','gfg','http://qiniuweb.beizhiyuan.com.cn/1473065293028','<p>gfdg</p>',0,0,'http://qiniuweb.beizhiyuan.com.cn/1473065295042','2016-09-05 16:48:17','2016-09-05 16:48:17',0),('569ec6912b65429583a4a8e2f42f7e03','efefe','fefe','http://qiniuweb.beizhiyuan.com.cn/1473065227187','<p>fefefefe</p>',1,1,'http://qiniuweb.beizhiyuan.com.cn/1473065229289','2016-09-05 16:47:10','2016-09-05 16:47:10',0),('6618c9fce9e4481286b1f717e3533ef4','bbbti2222','你好','http://qiniuweb.beizhiyuan.com.cn/1473061076392','<p>mmmjheheh</p>',1,1,'http://qiniuweb.beizhiyuan.com.cn/1473061078808','2016-09-05 15:38:01','2016-09-05 15:38:01',0),('74773181a7c146628a9e614792c19220','mmm','ddd','http://qiniuweb.beizhiyuan.com.cn/1473065209632','<p>ddd</p>',0,1,'http://qiniuweb.beizhiyuan.com.cn/1473065212427','2016-09-05 16:46:54','2016-09-05 16:46:54',0),('803a4df12d2c49f0b1a303cde43b9f25','家具啊你哦按普通','简介','http://qiniuweb.beizhiyuan.com.cn/1473059556364','<p>内容</p>',NULL,NULL,'http://qiniuweb.beizhiyuan.com.cn/1473059559551','2016-09-05 15:12:50','2016-09-05 15:12:50',0),('8ea9200ea65c4b198f2fdfdda51df2b9','biaoti','jianjie','http://qiniuweb.beizhiyuan.com.cn/1473058979473','<p>neirong</p>',NULL,NULL,NULL,'2016-09-05 15:03:29','2016-09-05 15:03:29',1),('91ea048febf84de3b567e3461a8c22ff','eee22222','fff','http://qiniuweb.beizhiyuan.com.cn/1473065246734','<p>dff</p>',0,1,'http://qiniuweb.beizhiyuan.com.cn/1473065249384','2016-09-05 16:47:30','2016-09-05 16:47:30',0),('a19e28f7718b45028f3f12386d335236','fasfjkdjaskf点附近的拉升放假啦是否加拉斯放假啦市分局','范德萨发','http://qiniuweb.beizhiyuan.com.cn/1473064968539','<p>ddd</p>',0,0,'http://qiniuweb.beizhiyuan.com.cn/1473064972622','2016-09-05 16:42:54','2016-09-05 16:42:54',0),('ca2ca0cf127b4a32945d80ce858572d8','kkkk','yyy','http://qiniuweb.beizhiyuan.com.cn/1473065263437','<p>ffff</p>',0,0,'http://qiniuweb.beizhiyuan.com.cn/1473065266176','2016-09-05 16:47:48','2016-09-05 16:47:48',0),('cac08e387f6546578583edaeea12bd49','大楼附近氨基酸等福利及爱上飞机按时分开就爱上放大到敬爱是浪费就爱上了房间辣是放假了大事就发啦市分局','凤飞飞反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复反复','http://qiniuweb.beizhiyuan.com.cn/1473064915700','<p>ddd</p>',2,3,'http://qiniuweb.beizhiyuan.com.cn/1473064918639','2016-09-05 16:42:01','2016-09-05 16:42:01',0),('d0dd22b6aa0a4c67a2784b09880e6abd','test1','大楼附近的卡上放假啦是否就拉屎地方就对啦是否加拉斯房间里撒发顺丰的结束啦是否','http://qiniuweb.beizhiyuan.com.cn/1473064833264','<p>哦哦房间辣是放假啊</p>',0,2,'http://qiniuweb.beizhiyuan.com.cn/1473064835827','2016-09-05 16:40:39','2016-09-05 16:40:39',0),('e32c778018d5460a878db3865c8ba228','分开打卡上就发了就暗示法','eee','http://qiniuweb.beizhiyuan.com.cn/1473064990325','<p>dfaf</p>',0,1,'http://qiniuweb.beizhiyuan.com.cn/1473064993181','2016-09-05 16:43:14','2016-09-05 16:43:14',0),('506feba95ad34cd99a60bc89481a1ca3','资源标题ooh','djalfjlasfja','http://qiniuweb.beizhiyuan.com.cn/1473329486738','<p>mmkkk</p>',1,1,'http://qiniuweb.beizhiyuan.com.cn/1473329489724','2016-09-08 18:11:32','2016-09-08 18:11:32',0),('2d58a76072904cf58c3dc54aed5e5fc7','真实测试啊这可是','是的，这是真实的测试','http://qiniuweb.beizhiyuan.com.cn/1474185731569','<p>这个游戏好玩啊，就像你个说得对房间爱啦啦<img src=\"http://qiniuweb.beizhiyuan.com.cn/Fg1vVJGlcBtUIvOlARK_Bpc04vnO-thumb\"/>不错哦哦</p><p>真的，这个去对方的建安路附近安抚就</p><p>的激发了司法局拉屎按时发送发送发送机发送发生了非加十分sa</p><p><br/></p>',0,0,'http://qiniuweb.beizhiyuan.com.cn/1474185737086','2016-09-18 16:02:21','2016-09-18 16:02:21',0),('f0ab62eef53546029c56cf68bd6bcdea','这是一个模拟真实的测试','大姐夫拉屎房间辣三姐夫拉丝机发送发','http://qiniuweb.beizhiyuan.com.cn/1474190971077','<p><img src=\"http://qiniuweb.beizhiyuan.com.cn/FnhDfA7f_tfdy0ER1PU77JMvKT3a-thumb\"/>你查到福建垃圾费辣椒粉拉斯附近第三方静安寺放假撒范德萨放假撒放假撒安抚jasny</p><p>福建大厦里附近 发送范德萨发送</p><p>发动机拉斯附近拉斯附近拉萨房间辣三姐夫了撒娇的福利三分按时富家大室啊</p><p>放假啦数据分离的爱上飞机啊</p><p>及地方睡啦放假了爱上飞机das法师法师法</p>',0,1,'http://qiniuweb.beizhiyuan.com.cn/1474190990276','2016-09-18 17:29:52','2016-09-18 17:29:52',0),('b2f83feefaa446e4aebd14d5039c85cc','再来一个真实模拟','的附加拉斯附近爱上飞机','http://qiniuweb.beizhiyuan.com.cn/1474191615206','<p>放大是范德萨发绝对是附件打发送发迹史安抚都是范德萨发萨芬的沙发沙发按时的萨芬的安抚</p><p>富家大室法拉盛啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦分的设计费撒发阿斯蒂芬交三方</p><p>的附加爱上飞机按时放假</p><p>发动机萨菲拉斯发送发</p><p>附近的拉斯附近拉斯附近拉斯附近静安寺废了局按时发送姐夫</p><p>福建师大楼房间爱上了f</p>',0,0,'http://qiniuweb.beizhiyuan.com.cn/1474191635616','2016-09-18 17:40:38','2016-09-18 17:40:38',0),('9aa9b6e696d946378d0d3801863341db','演员','法师法撒旦法第三方','http://qiniuweb.beizhiyuan.com.cn/1474266561477','<p>真的我好久东方拉斯加罚三姐夫爱上飞机爱上飞机拉屎放假爱师范生阿道夫安抚撒飞洒发按时</p><p>福建大厦附近拉屎份打散发发送地方安抚 f</p><p>法拉盛附近的拉升解放啦声姐夫</p><p>范德萨放假啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦是</p>',1,1,'http://qiniuweb.beizhiyuan.com.cn/1474266572554','2016-09-19 14:29:34','2016-09-19 14:29:34',0),('f2f9d8f5b7a54862bf3b8de441a12639','测试哈哈哈','发送发掘的拉屎放假拉屎放假','http://qiniuweb.beizhiyuan.com.cn/1474271970707','<p>你好打飞机阿里发酒疯啊发的房间卡书法家拉屎</p><p><img src=\"http://qiniuweb.beizhiyuan.com.cn/FnhDfA7f_tfdy0ER1PU77JMvKT3a-thumb\"/></p><p>我好好打发了就暗示法按时fd</p><p>福建大厦里附近拉风</p>',0,0,'http://qiniuweb.beizhiyuan.com.cn/1474271976288','2016-09-19 15:59:40','2016-09-19 15:59:40',0),('15fafd6f5b8b4e488438cac907c9f0e8','测试哦哦哦','发大水了房间爱上','http://qiniuweb.beizhiyuan.com.cn/1474278383771','<p><img src=\"http://qiniuweb.beizhiyuan.com.cn/FmX-YLKVC9j-EDhUyD4ph0zrE61l\"/>附近的卡上福建按时缴费</p>',0,0,'http://qiniuweb.beizhiyuan.com.cn/1474278389080','2016-09-19 17:46:30','2016-09-19 17:46:30',0),('beb4d8a37e104f778fb1d134929a34d8','照片测试','你好am打飞机啊发发俺放假啦就放大师傅大师傅发送','http://qiniuweb.beizhiyuan.com.cn/1474337167868','<p>你和胡椒粉垃圾房大厦发送放假富家大室分类爱上飞机安抚as</p><p><br/></p><p>发生地方了拉屎放假jasnyf</p><p>房间爱上了房间爱上福建省af</p><p>放假拉屎放假鞍山路附近拉屎放假爱上了等级安抚</p><p><br/></p>',2,3,'http://qiniuweb.beizhiyuan.com.cn/1474337174952','2016-09-20 10:06:17','2016-09-20 10:06:17',0),('45031da551304c00a82f91cf7626fc73','教育指南测试','放到了洒家附近发生就发啦声姐夫爱上飞机答复第三方','http://qiniuweb.beizhiyuan.com.cn/1474337512198','<p>发送方打算房间爱上了房间爱上放假发送发</p><p>发生了房间大事发送发送发a</p><p>发了啥房间辣是放假了爱上飞机安抚加十分</p>',2,4,'http://qiniuweb.beizhiyuan.com.cn/1474337514605','2016-09-20 10:11:56','2016-09-20 10:11:56',0);

/*Table structure for table `r_user_res` */

DROP TABLE IF EXISTS `r_user_res`;

CREATE TABLE `r_user_res` (
  `id` varchar(32) NOT NULL,
  `res_id` varchar(32) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  `del_status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `r_user_res` */

insert  into `r_user_res`(`id`,`res_id`,`user_id`,`create_date`,`upd_date`,`del_status`) values ('c482cb5332734a07a767a4c28f2381bf','45031da551304c00a82f91cf7626fc73','7e87e53db9e54215a2b356314c6f1a29','2016-09-21 10:53:36','2016-09-21 10:53:36',0),('7b8615a8645441e29e623ad5f8629119','15fafd6f5b8b4e488438cac907c9f0e8','7e87e53db9e54215a2b356314c6f1a29','2016-09-21 10:54:04','2016-09-21 10:54:04',0),('48bd55750e8342d6a04e75c2bc494171','f2f9d8f5b7a54862bf3b8de441a12639','7e87e53db9e54215a2b356314c6f1a29','2016-09-21 10:54:50','2016-09-21 10:54:50',0);

/*Table structure for table `sys_admin` */

DROP TABLE IF EXISTS `sys_admin`;

CREATE TABLE `sys_admin` (
  `id` varchar(32) NOT NULL,
  `account` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  `del_status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `sys_admin` */

insert  into `sys_admin`(`id`,`account`,`password`,`create_date`,`upd_date`,`del_status`) values ('1001','admin','admin','2016-10-08 16:11:25','2016-10-08 16:11:28',0),('1144bc0d1e934ab397f6c3e715694060','chyou','123456','2016-10-08 17:07:03','2016-10-08 17:07:03',0);

/*Table structure for table `sys_dict` */

DROP TABLE IF EXISTS `sys_dict`;

CREATE TABLE `sys_dict` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT 'pk',
  `value` varchar(250) COLLATE utf8mb4_bin NOT NULL COMMENT '数据值',
  `label` varchar(250) COLLATE utf8mb4_bin NOT NULL COMMENT '标签名',
  `type` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '类型',
  `description` varchar(250) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `sort` int(11) NOT NULL COMMENT '排序（升序)',
  `parent_id` varchar(64) COLLATE utf8mb4_bin NOT NULL DEFAULT '0' COMMENT '父级编号',
  `create_by` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) COLLATE utf8mb4_bin DEFAULT '0' COMMENT '是否删除(0.未删除 1.已删除)',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='字典表';

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`id`,`value`,`label`,`type`,`description`,`sort`,`parent_id`,`create_by`,`create_date`,`update_by`,`update_date`,`del_flag`) values ('1001','0','游戏','sorts','资源类别',1,'0','admin','2016-09-05 15:19:12','admin','2016-09-05 15:19:16','0'),('1002','1','故事','sorts','资源类别',2,'0','admin','2016-09-05 15:20:03','admin','2016-09-05 15:20:08','0'),('1003','2','儿歌','sorts','资源类别',3,'0','admin','2016-09-05 15:20:37','admin','2016-09-05 15:20:42','0'),('1004','3','文学','sorts','资源类别',4,'0','admin','2016-09-05 15:21:08','admin','2016-09-05 15:21:12','0'),('1005','0','视频','res_type','资源类型',1,'0','admin','2016-09-05 16:19:35','admin','2016-09-05 16:19:39','0'),('1006','1','音频','res_type','资源类型',2,'0','admin','2016-09-05 16:20:07','admin','2016-09-05 16:20:11','0'),('1007','2','照片','res_type','资源类型',3,'0','admin','2016-09-05 16:20:32','admin','2016-09-05 16:20:36','0'),('1008','0','手机号','user_type','用户类型',1,'0','admin','2016-09-06 16:31:47','admin','2016-09-06 16:31:52','0'),('1009','1','QQ','user_type','用户类型',2,'0','admin','2016-09-06 16:32:19','admin','2016-09-06 16:32:23','0'),('1010','2','微信','user_type','用户类型',3,'0','admin','2016-09-06 16:32:51','admin','2016-09-06 16:32:58','0'),('1011','0','女','sex','性别',1,'0','admin','2016-09-06 16:47:20','admin','2016-09-06 16:47:25','0'),('1012','1','男','sex','性别',2,'0','admin','2016-09-06 16:47:46','admin','2016-09-06 16:47:51','0'),('1013','0','直播','subject_type','专题类型',1,'0','admin','2016-09-08 14:02:58','admin','2016-09-08 14:03:03','0'),('1014','1','点播','subject_type','专题类型',2,'0','admin','2016-09-08 14:03:29','admin','2016-09-08 14:03:33','0'),('1015','0','免费','free_flag','收费状态',1,'0','admin','2016-09-08 14:04:26','admin','2016-09-08 14:04:30','0'),('1016','1','收费','free_flag','收费状态',2,'0','admin','2016-09-08 14:04:58','admin','2016-09-08 14:05:02','0'),('1017','0','未上架','pub_status','上下架状态',1,'0','admin','2016-09-08 14:05:47','admin','2016-09-08 14:05:51','0'),('1018','1','上架','pub_status','上下架状态',2,'0','admin','2016-09-08 14:06:22','admin','2016-09-08 14:06:26','0'),('1019','2','下架','pub_status','上下架状态',3,'0','admin','2016-09-08 16:33:57','admin','2016-09-08 16:34:01','0'),('1020','4','教育指南','sorts','资源类别',4,'0','admin','2016-09-20 10:09:06','admin','2016-09-20 10:09:11','0'),('1021','0','普通消息','notice_category','消息类别',1,'0','admin','2016-09-26 10:33:35','admin','2016-09-26 10:33:39','0'),('1022','1','详情页消息','notice_category','消息类别',2,'0','admin','2016-09-26 10:34:04','admin','2016-09-26 10:34:08','0'),('1023','0','h5页面外部链接','banner_flag','banner标识',1,'0','admin','2016-10-10 10:47:24','admin','2016-10-10 10:47:28','0'),('1024','1','专题详情','banner_flag','banner标识',2,'0','admin','2016-10-10 10:47:34','admin','2016-10-10 10:47:39','0'),('1025','2','帖子详情','banner_flag','banner标识',3,'0','admin','2016-10-10 10:48:19','admin','2016-10-10 10:48:23','0'),('1026','2','保密','sex','性别',3,'0','admin','2016-10-10 11:06:19','admin','2016-10-10 11:06:24','0'),('1027','0','未支付','pay_status','支付状态',1,'0','admin','2016-10-11 10:51:15','admin','2016-10-11 10:51:19','0'),('1028','1','已支付','pay_status','支付状态',2,'0','admin','2016-10-11 10:51:51','admin','2016-10-11 10:51:56','0');

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` varchar(64) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '编号',
  `type` char(1) COLLATE utf8mb4_bin DEFAULT '1' COMMENT '日志类型(1：接入日志；2：错误日志)',
  `title` varchar(255) COLLATE utf8mb4_bin DEFAULT '' COMMENT '日志标题',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `remote_addr` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '请求URI',
  `method` varchar(5) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '操作方式',
  `params` text COLLATE utf8mb4_bin COMMENT '操作提交的数据',
  `exception` text COLLATE utf8mb4_bin COMMENT '异常信息',
  PRIMARY KEY (`id`),
  KEY `sys_log_request_uri` (`request_uri`(191)),
  KEY `sys_log_type` (`type`),
  KEY `sys_log_create_date` (`create_date`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='日志表';

/*Data for the table `sys_log` */

/*Table structure for table `u_circle` */

DROP TABLE IF EXISTS `u_circle`;

CREATE TABLE `u_circle` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `title` varchar(100) DEFAULT NULL,
  `img_url` varchar(100) DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  `del_status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `u_circle` */

insert  into `u_circle`(`id`,`title`,`img_url`,`des`,`create_date`,`upd_date`,`del_status`) values ('qwerqwerqwerqwer','萌萌哒吃货','http://www.osblog.net/33.jpg','萌萌哒吃货','2016-09-08 15:47:55','2016-09-16 15:47:59',1),('r23tweertwretwertewrt','天才宝宝','http://www.osblog.net/123.jpg','如何让宝宝快速成长','2016-09-15 16:34:55','2016-09-08 16:34:51',1),('d63010f01d0f44ca9695b0fd2369bab6','这是个什么圈子','http://qiniuweb.beizhiyuan.com.cn/1473474422375','差的拉菲捡垃圾的弗拉姐夫说','2016-09-10 10:27:04','2016-09-10 10:27:04',0),('91124ae7249f465e84bdb522c6241d1e','呵呵呵','http://qiniuweb.beizhiyuan.com.cn/1473474506567','打死了几分辣椒粉','2016-09-10 10:28:28','2016-09-10 10:28:28',0),('42ccf36882c34c6db2cdf61a577e6ea0','测试哦','http://qiniuweb.beizhiyuan.com.cn/1473474917224','到家啦发顺丰','2016-09-10 10:35:20','2016-09-10 10:35:20',0),('7f04c8904955469f99e36a5011ee50d1','hudaof','http://qiniuweb.beizhiyuan.com.cn/1473475170699','dfsjafd','2016-09-10 10:39:31','2016-09-10 10:39:31',1);

/*Table structure for table `u_circle_list` */

DROP TABLE IF EXISTS `u_circle_list`;

CREATE TABLE `u_circle_list` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `circle_id` varchar(32) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `content` text COMMENT '内容',
  `img_url` varchar(255) DEFAULT NULL,
  `click_num` int(11) DEFAULT NULL COMMENT '查看',
  `like_num` int(11) DEFAULT NULL COMMENT '喜欢,收藏',
  `praise_num` int(11) DEFAULT NULL COMMENT '点赞',
  `create_date` datetime DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  `del_status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `u_circle_list` */

insert  into `u_circle_list`(`id`,`circle_id`,`user_id`,`content`,`img_url`,`click_num`,`like_num`,`praise_num`,`create_date`,`upd_date`,`del_status`) values ('13sdfsfsfdsf','d63010f01d0f44ca9695b0fd2369bab6','7e87e53db9e54215a2b356314c6f1a29','早教的重要性大家知道吗的房间爱立方件大事发送弗拉圣诞节范德萨发送发掘的爱上飞机三大富家大室安居房大煞风景大数据发送附近的萨克附近的卡上父级拉屎富家大室lf','http://qiniuweb.beizhiyuan.com.cn/1473474422375,http://qiniuweb.beizhiyuan.com.cn/1473474506567',13,33,23,'2016-09-09 09:33:56','2016-09-29 15:15:16',0),('fdaskjfsalfj','d63010f01d0f44ca9695b0fd2369bab6','7e87e53db9e54215a2b356314c6f1a29','哈哈的回复就爱上附近拉屎放假爱上飞机按时发第三方','http://qiniuweb.beizhiyuan.com.cn/1473474422375,http://qiniuweb.beizhiyuan.com.cn/1473474506567',12,1,2,'2016-10-10 09:52:30','2016-10-10 09:52:32',0),('fdsafefggg','d63010f01d0f44ca9695b0fd2369bab6','7e87e53db9e54215a2b356314c6f1a29','你猜大姐夫拉丝机法拉盛发','http://qiniuweb.beizhiyuan.com.cn/1473474422375,http://qiniuweb.beizhiyuan.com.cn/1473474506567',1,2,1,'2016-10-10 09:53:04','2016-10-10 09:53:06',0),('kdoaofdfddd','d63010f01d0f44ca9695b0fd2369bab6','7e87e53db9e54215a2b356314c6f1a29','大姐夫家阿里大发按时发安抚按时缴费刷卡放假哦哇姐夫第三方按时发送发撒','http://qiniuweb.beizhiyuan.com.cn/1473474422375,http://qiniuweb.beizhiyuan.com.cn/1473474506567',2,1,1,'2016-10-10 09:53:43','2016-10-10 09:53:45',0);

/*Table structure for table `u_circle_reply` */

DROP TABLE IF EXISTS `u_circle_reply`;

CREATE TABLE `u_circle_reply` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `user_id` varchar(32) DEFAULT NULL,
  `circle_id` varchar(32) DEFAULT NULL,
  `to_user` varchar(32) DEFAULT NULL,
  `reply_id` varchar(32) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  `del_status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `u_circle_reply` */

insert  into `u_circle_reply`(`id`,`user_id`,`circle_id`,`to_user`,`reply_id`,`content`,`create_date`,`upd_date`,`del_status`) values ('1001','1001','13sdfsfsfdsf','7e87e53db9e54215a2b356314c6f1a29',NULL,'这条帖子纯属扯淡','2016-09-10 15:38:19','2016-09-10 15:38:21',0),('1002','1002','13sdfsfsfdsf','1001',NULL,'你说的太对了打发时间法拉盛分鞍山路附近拉屎富家大室发送发大是大非大事发送发送范德萨啊发送的附件考试发送发送放开手飞洒发快来撒分偶发的萨佛安慰范德萨阿佛按时付金额哦放假哦按时发jeopardize附件二发','2016-09-10 15:38:48','2016-09-10 15:38:50',0),('1003','1003','13sdfsfsfdsf','1001',NULL,'aaaa','2016-09-29 10:46:54','2016-09-29 10:46:55',0);

/*Table structure for table `u_code` */

DROP TABLE IF EXISTS `u_code`;

CREATE TABLE `u_code` (
  `id` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `phone` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL,
  `code` varchar(10) CHARACTER SET utf8mb4 DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  `del_status` int(2) DEFAULT NULL,
  `scope` int(2) DEFAULT NULL COMMENT '作用范围0：注册1：绑定2：忘记密码',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `u_code` */

insert  into `u_code`(`id`,`phone`,`code`,`create_date`,`upd_date`,`del_status`,`scope`) values ('1001','222','323','2016-09-27 16:03:09','2016-09-27 16:03:09',0,NULL),('1002','222','323','2016-09-27 16:03:52','2016-09-27 16:03:52',0,NULL),('1003','222','323','2016-09-27 16:05:51','2016-09-27 16:05:51',0,NULL),('4ab045c9d5784c2a844874663973170e','15665766140','8266','2016-09-27 16:11:35','2016-09-27 16:16:59',0,NULL),('f77db2a8140d4d03afb6cf38f8481069','18035147802','9809','2016-09-27 16:17:55','2016-09-27 16:23:18',0,NULL),('3f3baf73237546daa50fb8b8aaaa3cb9','15665766140','0138','2016-09-28 17:11:42','2016-09-28 17:13:24',0,1),('339595e6dbca49dc8b8f36f2df982ae2','15552518607','5960','2016-10-08 15:45:40','2016-10-09 11:09:03',0,0),('3d367d509f5a4b078d95a81fcff9450f','15216410261','4438','2016-10-09 14:44:09','2016-10-09 16:52:06',0,0),('978c47394fa1481e9bf257e9d4a3514a','15552518607','3184','2016-10-11 11:20:28','2016-10-11 11:37:32',0,2);

/*Table structure for table `u_follow` */

DROP TABLE IF EXISTS `u_follow`;

CREATE TABLE `u_follow` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `follow_user_id` varchar(32) DEFAULT NULL COMMENT '被关注人的ID',
  `create_date` datetime DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  `del_status` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `u_follow` */

insert  into `u_follow`(`id`,`user_id`,`follow_user_id`,`create_date`,`upd_date`,`del_status`) values ('281ce3f4ea094e37a288201c2f90c209','1001','7e87e53db9e54215a2b356314c6f1a29','2016-09-30 11:41:36','2016-09-30 11:41:36',1),('663c103d5619470094761d516d2ed783','1001','7e87e53db9e54215a2b356314c6f1a29','2016-09-30 11:37:55','2016-09-30 11:37:55',1);

/*Table structure for table `u_user` */

DROP TABLE IF EXISTS `u_user`;

CREATE TABLE `u_user` (
  `id` varchar(32) NOT NULL,
  `nick` varchar(32) DEFAULT NULL COMMENT '昵称',
  `sex` int(2) DEFAULT NULL COMMENT '性别（0：女1：男）',
  `phone` varchar(20) DEFAULT NULL COMMENT '绑定手机号',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像url',
  `account` varchar(200) DEFAULT NULL COMMENT '账号',
  `type` int(2) DEFAULT NULL COMMENT '账号类型：0:手机号,1:qq,2:微信',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `upd_date` datetime DEFAULT NULL COMMENT '修改时间',
  `del_status` int(2) DEFAULT NULL COMMENT '删除状态0：正常1：删除',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `u_user` */

insert  into `u_user`(`id`,`nick`,`sex`,`phone`,`avatar`,`account`,`type`,`password`,`create_date`,`upd_date`,`del_status`) values ('7e87e53db9e54215a2b356314c6f1a29','刘启',0,'15665766140','http://qiniuweb.beizhiyuan.com.cn/1473474422375','10569874120',2,NULL,'2016-09-08 14:09:15','2016-09-28 17:13:38',0),('1001','我会飞',1,'15665766142','http://qiniuweb.beizhiyuan.com.cn/1473474506567','15669874550',2,NULL,'2016-09-10 15:37:06','2016-09-10 15:37:08',0),('1002','无敌哥',1,'15669875202','http://qiniuweb.beizhiyuan.com.cn/1473475170699','15665766140',2,NULL,'2016-09-10 15:39:22','2016-09-10 15:39:23',0),('b87f99cb11644e65bf008119e64c9908','180****7802',2,'18035147802','0','18035147802',0,'123456','2016-09-27 16:23:33','2016-09-27 16:23:33',0),('11de150f05b5481fb562801cdc229dd5','155****8607',2,'15552518607','0','15552518607',0,'MTIzNDU2','2016-10-08 16:01:04','2016-10-11 11:37:49',0),('0f77818fa55c442b8193a87479b12c40','152****0261',2,'15216410261','0','15216410261',0,'MTIzNDU2','2016-10-09 14:44:21','2016-10-09 14:44:21',0),('30dcfcd048dd42c8a4cbcca05f98faf6','aaa',1,'0','ddd','djfjasf',1,NULL,'2016-10-09 15:23:02','2016-10-09 15:23:02',0),('8a3fd22e92264b809c2b63fe65c08a2a','152****0261',2,'15216410261','0','15216410261',0,'YTEyMDU5OTgxMzE=','2016-10-09 16:52:16','2016-10-09 16:52:16',0),('ebeb7d30f4c641fd8347fb5e890dcfb8','aaa',1,'0','ddd','djfjasf',1,NULL,'2016-10-09 17:52:53','2016-10-09 17:52:53',0);

/*Table structure for table `u_user_circle` */

DROP TABLE IF EXISTS `u_user_circle`;

CREATE TABLE `u_user_circle` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `circle_id` varchar(32) DEFAULT NULL,
  `oper_type` int(2) DEFAULT NULL COMMENT '0:点赞1：收藏',
  `create_date` datetime DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  `del_status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `u_user_circle` */

insert  into `u_user_circle`(`id`,`user_id`,`circle_id`,`oper_type`,`create_date`,`upd_date`,`del_status`) values ('c91bb21fff2b4c738afb2d0ef80bd97a','1001','13sdfsfsfdsf',1,'2016-09-29 15:06:44','2016-09-29 15:06:44',0),('f44cd726888b4b6db912eb10ce8430b5','1002','13sdfsfsfdsf',1,'2016-09-29 15:12:00','2016-09-29 15:12:00',0),('1a6d0581a61e48ab878c9cfec3fd0ce7','1002','13sdfsfsfdsf',0,'2016-09-29 15:13:46','2016-09-29 15:13:46',0);

/*Table structure for table `v_collection` */

DROP TABLE IF EXISTS `v_collection`;

CREATE TABLE `v_collection` (
  `id` varchar(64) NOT NULL,
  `subject_id` varchar(64) DEFAULT NULL COMMENT '专题id',
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `type` int(2) DEFAULT NULL COMMENT '专题类型（0直播1点播）',
  `create_date` datetime DEFAULT NULL,
  `del_status` int(2) DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `v_collection` */

insert  into `v_collection`(`id`,`subject_id`,`user_id`,`type`,`create_date`,`del_status`,`upd_date`) values ('1001','37a6cc329f40427eafae662e5f17f29c','1001',0,'2016-09-13 11:48:14',0,'2016-09-13 11:48:17'),('a66f4ed98ec14062b302305ae170ee35','15bdfb43b85c4f2c83861496f83d1249','1001',NULL,'2016-09-13 11:53:19',0,NULL),('083fc7ddd28648b594a3024530a671b7','37a6cc329f40427eafae662e5f17f29c','1002',NULL,'2016-09-27 14:58:57',0,'2016-09-27 14:58:57');

/*Table structure for table `v_comment` */

DROP TABLE IF EXISTS `v_comment`;

CREATE TABLE `v_comment` (
  `id` varchar(64) NOT NULL,
  `subject_course_id` varchar(64) DEFAULT NULL COMMENT '专题或课程id',
  `content` varchar(500) DEFAULT NULL COMMENT '内容',
  `user_id` varchar(64) DEFAULT NULL COMMENT '评论人id',
  `type` int(2) DEFAULT NULL COMMENT '类型（0:专题评论1课程评论）',
  `create_date` datetime DEFAULT NULL,
  `del_status` int(2) DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `v_comment` */

insert  into `v_comment`(`id`,`subject_course_id`,`content`,`user_id`,`type`,`create_date`,`del_status`,`upd_date`) values ('e88d24cd19b54b039a1d0ed162da6755','15bdfb43b85c4f2c83861496f83d1249','aaaa','1001',0,'2016-09-13 14:07:12',0,'2016-09-13 14:07:12');

/*Table structure for table `v_comment_replay` */

DROP TABLE IF EXISTS `v_comment_replay`;

CREATE TABLE `v_comment_replay` (
  `id` varchar(64) NOT NULL,
  `comment_id` varchar(64) DEFAULT NULL COMMENT '评论id',
  `content` varchar(500) DEFAULT NULL COMMENT '内容',
  `user_id` varchar(64) DEFAULT NULL COMMENT '回复人id',
  `replay_id` varchar(64) DEFAULT NULL COMMENT '被回复人id',
  `create_date` datetime DEFAULT NULL,
  `del_status` int(2) DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `v_comment_replay` */

insert  into `v_comment_replay`(`id`,`comment_id`,`content`,`user_id`,`replay_id`,`create_date`,`del_status`,`upd_date`) values ('7582035d4e604c41a8ed03c91db0615a','e88d24cd19b54b039a1d0ed162da6755','bbb','1002',NULL,'2016-09-13 14:16:50',0,'2016-09-13 14:16:50'),('55be5b4ed7c84ddb9896a3256bbe932c','e88d24cd19b54b039a1d0ed162da6755','bbb','1003','1002','2016-09-13 14:28:20',0,'2016-09-13 14:28:20');

/*Table structure for table `v_course` */

DROP TABLE IF EXISTS `v_course`;

CREATE TABLE `v_course` (
  `id` varchar(64) NOT NULL,
  `title` varchar(100) DEFAULT NULL COMMENT '课程标题',
  `img_url` varchar(100) DEFAULT NULL COMMENT '课程缩略图',
  `teacher_name` varchar(20) DEFAULT NULL COMMENT '讲师名',
  `play_url` varchar(100) DEFAULT NULL COMMENT '播放地址',
  `subject_id` varchar(64) DEFAULT NULL COMMENT '专题id',
  `type` int(2) DEFAULT NULL COMMENT '类型(0直播1点播)',
  `profiles` varchar(200) DEFAULT NULL COMMENT '简介',
  `create_date` datetime DEFAULT NULL,
  `del_status` int(2) DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `v_course` */

insert  into `v_course`(`id`,`title`,`img_url`,`teacher_name`,`play_url`,`subject_id`,`type`,`profiles`,`create_date`,`del_status`,`upd_date`) values ('87a2f86b7e3c4e349184eb9aa1cca1cd','课程1','http://qiniuweb.beizhiyuan.com.cn/1473735253820','发动机撒分开','dfjkasfjkasf ','37a6cc329f40427eafae662e5f17f29c',0,'的叫撒废了局酸辣粉','2016-09-13 10:54:18',1,'2016-09-13 10:54:18'),('5fe0a292aa45451eb03d0c51faf0db89','点播测试','http://qiniuweb.beizhiyuan.com.cn/1473737515294','大师傅','http://qiniuweb.beizhiyuan.com.cn/1473737512557','f894906935a946f389c4d39f0704afa5',1,'大姐夫辣椒粉大','2016-09-13 11:31:57',0,'2016-09-13 11:31:57'),('c714adf3903b4c19bd00b87c12b56e36','真实测试','http://qiniuweb.beizhiyuan.com.cn/1474183731569','范德萨发空间按时','http://qiniuweb.beizhiyuan.com.cn/1474183723869','f894906935a946f389c4d39f0704afa5',1,'你猜的 ','2016-09-18 15:30:13',0,'2016-09-18 15:30:13'),('8a8a13b4c3cb48deb9ff227933b001ee','直播新的测试','http://qiniuweb.beizhiyuan.com.cn/1474968268040','打飞机萨芬的简单说就','http://iiii','b156b4eca57c43af81a07f5fde9e2419',0,'附近的拉萨放假拉屎放假','2016-09-27 17:24:58',0,'2016-09-27 17:24:58'),('327c1676673a43c68618c69080a0a463','直播新的测试','http://qiniuweb.beizhiyuan.com.cn/1474968268040','打飞机萨芬的简单说就','http://iiii','b156b4eca57c43af81a07f5fde9e2419',0,'附近的拉萨放假拉屎放假','2016-09-27 17:30:37',0,'2016-09-27 17:30:37'),('f3934de17e544b0e864f1d4ff3c1650a','新的直播测试哈哈哈哈哈','http://qiniuweb.beizhiyuan.com.cn/1474970052850','的开发商','http://cccc','b156b4eca57c43af81a07f5fde9e2419',0,'的拉屎放假按时发','2016-09-27 17:54:31',0,'2016-09-27 17:54:31'),('8557c75a24314c19a7255fb18332a38f','新的直播测试哈哈哈哈哈','http://qiniuweb.beizhiyuan.com.cn/1474970052850','的开发商','http://cccc','b156b4eca57c43af81a07f5fde9e2419',0,'的拉屎放假按时发','2016-09-27 18:02:18',0,'2016-09-27 18:02:18'),('a1fa0e40e340483199e45b2c4157b8bd','kkkkkk','http://qiniuweb.beizhiyuan.com.cn/1474970709748','fdsf','http:.kkk','b156b4eca57c43af81a07f5fde9e2419',0,'dfaa','2016-09-27 18:05:11',0,'2016-09-27 18:05:11');

/*Table structure for table `v_live` */

DROP TABLE IF EXISTS `v_live`;

CREATE TABLE `v_live` (
  `id` varchar(64) NOT NULL,
  `course_id` varchar(64) DEFAULT NULL COMMENT '课程id',
  `push_url` varchar(200) DEFAULT NULL COMMENT '推流地址',
  `play_status` int(2) DEFAULT NULL COMMENT '播放状态(0：即将开讲 1播放中2已结束)',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `create_date` datetime DEFAULT NULL,
  `del_status` int(2) DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `v_live` */

insert  into `v_live`(`id`,`course_id`,`push_url`,`play_status`,`start_time`,`create_date`,`del_status`,`upd_date`) values ('cff67ca3daed4032bb3b20437418dc30','87a2f86b7e3c4e349184eb9aa1cca1cd','http:fjlafj ',0,'2016-09-22 00:00:00','2016-09-13 10:54:18',0,'2016-09-13 10:54:18'),('f41de6aa45ad4a76912784b8e3cfd423','8557c75a24314c19a7255fb18332a38f','http://aaa',0,'2016-09-30 00:00:00','2016-09-27 18:02:28',0,'2016-09-27 18:02:28'),('95c41e4b339e4ea88ec8e95244806a36','a1fa0e40e340483199e45b2c4157b8bd','http:kkkk',0,'2016-09-30 00:00:00','2016-09-27 18:05:11',0,'2016-09-27 18:05:11');

/*Table structure for table `v_order` */

DROP TABLE IF EXISTS `v_order`;

CREATE TABLE `v_order` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `subject_id` varchar(64) DEFAULT NULL COMMENT '专题id',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `pay_status` int(2) DEFAULT NULL COMMENT '支付状态（0:未支付1已支付）',
  `create_date` datetime DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `del_status` int(2) DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL COMMENT '专题标题',
  `info` varchar(300) DEFAULT NULL COMMENT '专题简介',
  `pay_type` int(2) DEFAULT NULL COMMENT '0:支付宝 1：微信',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `v_order` */

insert  into `v_order`(`id`,`user_id`,`subject_id`,`price`,`pay_status`,`create_date`,`pay_time`,`del_status`,`upd_date`,`title`,`info`,`pay_type`) values ('1001','1001','37a6cc329f40427eafae662e5f17f29c','40.00',1,'2016-09-13 10:26:36','2016-09-13 10:26:37',0,'2016-09-13 10:26:41','发发','dfafdaf',1);

/*Table structure for table `v_pay_notify` */

DROP TABLE IF EXISTS `v_pay_notify`;

CREATE TABLE `v_pay_notify` (
  `id` varchar(64) NOT NULL,
  `order_id` varchar(64) DEFAULT NULL COMMENT '订单id',
  `notify_req` varchar(500) DEFAULT NULL COMMENT '异步调用请求参数',
  `pay_type` int(2) DEFAULT NULL COMMENT '支付类型（0:支付宝1：微信）',
  `create_date` datetime DEFAULT NULL,
  `del_status` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `v_pay_notify` */

/*Table structure for table `v_subject` */

DROP TABLE IF EXISTS `v_subject`;

CREATE TABLE `v_subject` (
  `id` varchar(64) NOT NULL,
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `profiles` varchar(255) DEFAULT NULL COMMENT '简介',
  `img_url` varchar(100) DEFAULT NULL COMMENT '缩略图',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `free_flag` int(2) DEFAULT NULL COMMENT '是否收费（0:免费1收费）',
  `pub_status` int(2) DEFAULT NULL COMMENT '上架状态（0:未上架1上架2下架）',
  `pub_time` datetime DEFAULT NULL COMMENT '上架时间',
  `type` int(2) DEFAULT NULL COMMENT '类型（0:直播1点播）',
  `label` int(2) DEFAULT NULL COMMENT '标签（1:正常2推荐）',
  `start_time` datetime DEFAULT NULL COMMENT '开讲时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `del_status` int(2) DEFAULT NULL,
  `upd_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

/*Data for the table `v_subject` */

insert  into `v_subject`(`id`,`title`,`profiles`,`img_url`,`price`,`free_flag`,`pub_status`,`pub_time`,`type`,`label`,`start_time`,`create_date`,`del_status`,`upd_date`) values ('15bdfb43b85c4f2c83861496f83d1249','发送方打算','发顺丰','http://qiniuweb.beizhiyuan.com.cn/1473732848402','0.00',0,0,NULL,0,NULL,'2016-09-23 00:00:00','2016-09-13 10:14:09',0,'2016-09-13 10:14:09'),('37a6cc329f40427eafae662e5f17f29c','法师法师法','发顺丰的a','http://qiniuweb.beizhiyuan.com.cn/1473732875894','0.00',0,2,'2016-09-13 10:53:33',0,NULL,'2016-09-16 00:00:00','2016-09-13 10:14:37',0,'2016-09-13 10:53:33'),('ac4373172efc4ff4b1b42c9512ac20f2','大而非法','非法非法','http://qiniuweb.beizhiyuan.com.cn/1473732893116','40.00',1,1,'2016-09-13 10:15:03',0,NULL,'2016-10-01 00:00:00','2016-09-13 10:14:54',0,'2016-09-13 10:15:03'),('7951218226e540e8b330cfb61f8abfe3','富家大室开发了敬爱是','范德萨就分散','http://qiniuweb.beizhiyuan.com.cn/1473734326239','0.00',0,1,'2016-09-13 10:39:19',1,NULL,NULL,'2016-09-13 10:38:47',0,'2016-09-13 10:39:19'),('f894906935a946f389c4d39f0704afa5','机发送附件哦按非','范德萨发了就爱上地方','http://qiniuweb.beizhiyuan.com.cn/1473734350726','30.00',1,2,'2016-09-13 11:31:27',1,NULL,NULL,'2016-09-13 10:39:12',0,'2016-09-13 11:31:27'),('b156b4eca57c43af81a07f5fde9e2419','直播标题测试','房间爱上了房间里撒地方就拉屎','http://qiniuweb.beizhiyuan.com.cn/1474967877869','50.00',1,2,'2016-09-27 17:19:00',0,NULL,'2016-09-30 00:00:00','2016-09-27 17:18:23',0,'2016-09-27 17:19:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
