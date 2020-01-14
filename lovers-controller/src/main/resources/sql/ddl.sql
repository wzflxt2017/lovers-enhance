create table sys_user
(
	user_id int(10) auto_increment,
	user_account varchar(20) not null comment '账号名',
	password varchar(20) comment '用户密码',
	user_name varchar(20) comment '用户昵称',
	full_name varchar(20) comment '用户姓名',
	user_bio varchar(20) comment '个性签名',
	user_gender int(2) comment '用户性别',
	user_level int(2) comment '用户等级',
	user_role varchar(20) comment '用户在家庭的角色',
	user_email varchar(30) comment '用户邮箱',
	user_birthday timestamp (3) null comment '用户生日',
	user_address varchar(50) comment '用户地址',
	user_location varchar(50) comment '用户所在地',
	user_photo int(10) comment '用户头像',
	user_state int(2) comment '用户状态:1为可用，2为不可用',
	create_time timestamp (3) null comment '创建时间',
	modified_time timestamp (3) null comment '最后一次修改时间',
	constraint sys_user_pk
		primary key (user_id)
)
comment '用户表';


create table sys_file(
	file_id int(10) auto_increment,
	file_name varchar(20) comment '文件名',
	file_suffix varchar (20) comment '文件后缀',
	file_type varchar (10) comment '文件类型',
	file_full_name varchar (50) comment '文件全名',
	for_module varchar (20) comment '所属模块',
	user_id int(10) comment '上传文件的用户',
	upload_time timestamp (3) null comment '上传时间',
	constraint sys_file_pk
		primary key (file_id)

)
comment '文件表';

create table user_friend(
  user_friend_id int(10) auto_increment,
  user_id int(10) comment '所属用户id',
  friend_id int(10) comment '该朋友id',
  friend_name varchar(20) comment '该朋友的名字',
  constraint user_friend_pk
   primary key(user_friend_id)
)
comment '用户好友表';

create table user_message(
  message_id int(10) auto_increment,
  sender_id int(10) comment '发送者id',
  receiver_id int(10) comment '接收者id',
  message_type varchar (10) comment '信息类型：分为文字，图片或其他文件',
  message_content varchar(1000) comment '消息正文',
  is_read int(2) comment '是否已读',
  message_file_name varchar (50) comment '文件名',
  message_file_id int(10) comment '文件id',
  message_time timestamp (3) null comment '消息发送时间',
  constraint user_message_pk
   primary key(message_id)
)
comment '消息表';

create table user_photo_album(
album_id int(10) auto_increment,
album_name varchar (50) comment '相册名',
album_cover int(10) comment '相册封面',
album_describe varchar (500) comment '相册描述',
user_id int(10) comment '创建者id',
create_time timestamp (3) null comment '相册创建时间',
modified_time timestamp (3) null comment '最后一次修改时间',
  constraint user_photo_album_pk
   primary key(album_id)
)
comment '用户相册表';

create table user_photo(
photo_id int(10) auto_increment,
album_id int(10) comment '相册id',
photo_name varchar (50) comment '图片名称',
photo_position varchar (400) comment '图片位置',
photo_describe varchar (500) comment '图片描述',
upload_time timestamp (3) null comment '上传时间',
user_id int(10) comment '上传者id',
for_module varchar (50) comment '所属模块',
  constraint user_photo_pk
   primary key(photo_id)
)
comment '用户照片表';

create table user_mood_record(
record_id int(10) auto_increment,
record_title varchar (50) comment '标题',
record_images varchar(200) comment '多张图片id，以逗号分割',
record_content varchar (4000) comment '正文',
user_id int(10) comment '上传者id',
create_time timestamp (3) null comment '记录时间',
is_hidden int(2) comment '是否隐藏',
visitor_number int(10) comment '访问数量',
comment_number int(10) comment '评论数量',
approver_number int(10) comment '获赞数量',
  constraint user_mood_record_pk
   primary key(record_id)
)
comment '心情记录表';

create table user_mood_comment(
comment_id int(10) auto_increment,
record_id int(10) comment '心情记录id',
comment_content varchar(1000) comment '正文',
user_id int(10) comment '评论人id',
comment_time timestamp (3) null comment '评论时间',
  constraint user_mood_comment_pk
   primary key(comment_id)
)
comment '心情记录评论表';

create table lovers_incident(
incident_id int(10) auto_increment,
incident_title varchar (50) comment '标题',
incident_content varchar (4000) comment '正文',
incident_time timestamp (3) null comment '事件发生时间',
incident_create_time timestamp (3) null comment '记录创建时间',
user_id_man int(10) comment '情侣中男id',
user_id_woman int(10) comment '情侣中女id',
user_id_create int(10) comment '创建人id',
incident_images varchar (100) comment '多张图片id',
  constraint lovers_incident_pk
   primary key(incident_id)
)
comment '情侣事件表';

create table lovers_space(
space_id int(10) auto_increment,
space_name varchar (50) comment '空间名称',
user_id_man int(10) comment '情侣中男id',
user_id_woman int(10) comment '情侣中女id',
space_background int(10) comment '背景图片id',
space_content varchar (1000) comment '正文',
create_time timestamp (3) null comment '空间创建时间',
  constraint lovers_space_pk
   primary key(space_id)
)
comment '情侣空间表';

create table workflow(
workflow_id int(10) auto_increment,
workflow_key varchar (50) comment '流程key',
workflow_name varchar (50) comment '流程名称',
workflow_describe varchar (500) comment '流程类型描述',
order_number int(4) comment '用于排序',
  constraint workflow_pk
   primary key(workflow_id)
)
comment '流程类型表';

create table workflow_node(
node_id int(10) auto_increment,
node_key varchar (50) comment '节点key',
workflow_id int(10),
node_name varchar (50) comment '节点名称',
  constraint workflow_node_pk
   primary key(node_id)
)
comment '流程节点表';

create table workflow_link(
link_id int(10) auto_increment,
workflow_id int(10),
link_name varchar (50) comment '流程线名称',
link_key  varchar (50) comment '流程线key',
link_pre_node int(10),
link_next_node int(10),
  constraint workflow_link_pk
   primary key(link_id)
)
comment '流程线表';

create table workflow_business(
business_id int(10) auto_increment,
workflow_id int(10),
data_id int(10),
create_time timestamp (3) null comment '创建时间',
create_user_id int(10),
create_user_name varchar(20) comment '用户昵称',
status int(2) comment '状态',
  constraint workflow_business_pk
   primary key(business_id)

)
comment '流程业务表';

create table workflow_task(
task_id int(10) auto_increment,
business_id int(10),
start_user_id int(10),
start_user_name varchar(20) comment '用户昵称',
start_time timestamp (3) null comment '任务开始时间',
end_user_id int(10),
end_user_name varchar(20) comment '用户昵称',
end_time timestamp (3) null comment '任务结束时间',
node_id int(10),
link_id int(10),
status int(2) comment '状态',
  constraint workflow_task_pk
   primary key(task_id)
)
comment '流程任务表';
