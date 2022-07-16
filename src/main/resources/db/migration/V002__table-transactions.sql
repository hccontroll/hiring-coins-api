create table transaction (
  id bigint not null auto_increment,
  uuid varchar(40) not null,
  client_id bigint not null,
  purchase_id varchar(100),
  purchase_value decimal(10,2),
  purchase_date datetime,
  type enum('CREDIT', 'DEBIT'),
  coins bigint not null,
  created_at datetime not null,
  primary key (id)
) engine=InnoDB default charset=utf8;

alter table transaction add constraint fk_transaction_client
foreign key (client_id) references client (id);

CREATE INDEX transaction_uuid ON transaction (uuid);