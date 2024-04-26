create table pallet
(
    palletid    varchar(100) not null
        primary key,
    return_date date         not null,
    number      int          not null,
    lorryid     varchar(100) not null
);

create table product
(
    serial_id varchar(255) not null
        primary key,
    name      varchar(255) null,
    category  varchar(255) null,
    palletid  varchar(100) not null,
    constraint product_pallet_FK
        foreign key (palletid) references pallet (palletid)
);

create table user
(
    user_id    varchar(100) not null
        primary key,
    name       varchar(100) not null,
    permission varchar(100) not null
);

create table returndetails
(
    return_id   varchar(100) not null
        primary key,
    userId      varchar(100) not null,
    return_type varchar(100) not null,
    return_date date         not null,
    serial_id   varchar(100) null,
    constraint ReturnDatails_product_FK
        foreign key (serial_id) references product (serial_id),
    constraint ReturnDatails_user_FK
        foreign key (userId) references user (user_id)
);

create definer = T14@`%` view statistics as
select 'Total'                                                                                  AS `name`,
       count(0)                                                                                 AS `totalreturned`,
       sum((case when (`csc8019`.`returndetails`.`return_type` = 'Repair') then 1 else 0 end))  AS `totalrepair`,
       sum((case when (`csc8019`.`returndetails`.`return_type` = 'Refund') then 1 else 0 end))  AS `totalrefund`,
       sum((case when (`csc8019`.`returndetails`.`return_type` = 'Recycle') then 1 else 0 end)) AS `totalrecycle`
from `csc8019`.`returndetails`;

create definer = T14@`%` view statistics_recycle as
select `p`.`name`         AS `name`,
       `p`.`serial_id`    AS `serial_id`,
       `rd`.`return_id`   AS `return_id`,
       `rd`.`return_date` AS `return_date`
from (`csc8019`.`product` `p` join `csc8019`.`returndetails` `rd` on ((`p`.`serial_id` = `rd`.`serial_id`)))
where (`rd`.`return_type` = 'Recycle');

create definer = T14@`%` view statistics_refund as
select `p`.`name`         AS `name`,
       `p`.`serial_id`    AS `serial_id`,
       `rd`.`return_id`   AS `return_id`,
       `rd`.`return_date` AS `return_date`
from (`csc8019`.`product` `p` join `csc8019`.`returndetails` `rd` on ((`p`.`serial_id` = `rd`.`serial_id`)))
where (`rd`.`return_type` = 'Refund');

create definer = T14@`%` view statistics_repair as
select `p`.`name`         AS `name`,
       `p`.`serial_id`    AS `serial_id`,
       `rd`.`return_id`   AS `return_id`,
       `rd`.`return_date` AS `return_date`
from (`csc8019`.`product` `p` join `csc8019`.`returndetails` `rd` on ((`p`.`serial_id` = `rd`.`serial_id`)))
where (`rd`.`return_type` = 'Repair');


