create table client (
  id bigint not null auto_increment,
  uuid varchar(40) not null,
  name varchar(100) not null,
  email varchar(100) not null,
  coin_balance bigint not null,
  last_purchase datetime null,  
  primary key (id),
  unique (email)
) engine=InnoDB default charset=utf8;

CREATE INDEX client_uuid ON client (uuid);